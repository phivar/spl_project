package spl.interpreter;

import org.antlr.v4.runtime.Token;
import spl.interpreter.errors.NameException;
import spl.interpreter.errors.TypeException;

import java.util.HashMap;


// Symbol tables are used by the ExecutingVisitor to store values of the variables declared in the current scope.
// Variable declarations of higher scopes are accessible via the member SymbolTable parent.
public class SymbolTable {

    // Type bounds can be attached to variables and parameters to dynamically type check them.
    // Notably the default typ bound is any; it matches any typ.
    public enum TypeBound {
        ANY,
        FLOAT,
        BOOL,
        STRING,
        LIST,
        FUNC;

        // Checks if a value typ satisfies the type bound.
        public boolean satisfiedBy(Value.Type type){
            return type == switch(this){
                case ANY -> type;
                case FLOAT -> Value.Type.FLOAT;
                case BOOL -> Value.Type.BOOL;
                case STRING -> Value.Type.STRING;
                case LIST -> Value.Type.LIST;
                case FUNC -> Value.Type.FUNC;
            };
        }
    }

    // Stores useful information about a declared variable.
    // Notably the typ bound, its current value and if it has ever been assigned a value.
    public static class TableEntry{
        public static final TableEntry EMPTY = new TableEntry(TypeBound.ANY);
        public Value value;
        public TypeBound bound;
        public boolean assigned;

        public TableEntry(TypeBound bound){
            this.assigned = false;
            this.bound = bound;
        }
        public void uncheckedAssign(Value val){
            value = val;
            assigned = true;
        }
    }

    private final HashMap<String,TableEntry> table = new HashMap<>();
    private SymbolTable parent; // parent scope

    public void setParent(SymbolTable parent) {
        this.parent = parent;
    }


    // Searches for a variable with the name stored in the token.
    // If the variable doesn't exist in this scope check in the parent scope.
    // If the variable hasn't been assigned a value error.
    // Takes a token in order to augment errors with the token location.
    public Value lookupToken(Token tok){
        String key = tok.getText();
        TableEntry entry = table.getOrDefault(key, TableEntry.EMPTY);
        if(entry == TableEntry.EMPTY) {
            if(parent == null)
                throw NameException.keyNotFoundFromToken(tok);
            return parent.lookupToken(tok);
        }
        if(!entry.assigned){
            throw NameException.keyNeverAssignedFromToken(tok);
        }
        return entry.value;
    }

    // Assigns the variable name stored in the token a new value.
    // Check if the variable has been declared and if ths vars type bound is satisfied.
    // If the var doesn't exist in current scope ask the parent scope.
    public void assignToken(Token ctx, Value val){
        if(val.type == Value.Type.VOID)
                throw TypeException.createAssignVoidFromToken(ctx);
        String key = ctx.getText();
        TableEntry curr = table.getOrDefault(key,TableEntry.EMPTY);
        if(curr == TableEntry.EMPTY){
            if(parent == null)
                throw NameException.keyNotFoundFromToken(ctx);
            parent.assignToken(ctx,val);
            return;
        }
        if(!curr.bound.satisfiedBy(val.type)){
            throw TypeException.typeBoundNotSatisfiedFromToken(ctx, val.type, curr.bound);
        }
        curr.uncheckedAssign(val);
    }
    // Declares a variable with a certain type bound.
    public void declareToken(Token ctx, TypeBound bound){
        String key = ctx.getText();
        TableEntry curr = table.getOrDefault(key,TableEntry.EMPTY);
        if(curr != TableEntry.EMPTY)
            throw NameException.keyAlreadyDeclaredFromToken(ctx);
        table.put(key,new TableEntry(bound));
    }

    // Unchecked lookup. We assume the caller knows what they are doing.
    public Value get(String key){
        if(table.containsKey(key)) return table.get(key).value;
        return parent.get(key);
    }
    // Unchecked declare and assign. We assume the caller knows what they are doing.
    public void put(String key, TypeBound bound, Value val){
        TableEntry entry = new TableEntry(bound);
        entry.uncheckedAssign(val);
        table.put(key, entry);
    }
}

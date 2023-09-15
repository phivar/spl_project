package spl.interpreter;

import java.util.ArrayList;

// Models computed results from expressions that can be stored in variables.
// Stores both a value and an annotated typ for typ checking.
// VOID is just a dummy typ, for e.g. functions that return nothing. It can't be assigned to a variable.
public class Value {
    public static final Value TRUE = new Value(true);
    public static final Value FALSE = new Value(false);
    public static final Value VOID = new Value();

    // Typs an expression/variable can assume (except VOID ofc).
    public enum Type {
        BOOL,
        VOID,
        FLOAT,
        STRING,
        LIST,
        FUNC,
    }

    public Type type;
    public Object value;

    // Constructors for different internal typs.
    public Value(){
        this.type = Type.VOID;
    }
    public Value(double x){
        this.type = Type.FLOAT;
        this.value = x;
    }
    public Value(String x){
        this.type = Type.STRING;
        this.value = x;
    }
    public Value(ArrayList<Value> x){
        this.type = Type.LIST;
        this.value = x;
    }
    public Value(FunctionRecord x){
        this.type = Type.FUNC;
        this.value = x;
    }
    private Value(boolean x){
        this.type = Type.BOOL;
        this.value = x;
    }
    public static Value fromBool(boolean x){
        if(x) return Value.TRUE;
        else return Value.FALSE;
    }

    // Utility functions to cast the internal value to a desired typ.
    public boolean forceBool(){
        return (boolean) value;
    }
    public double forceFloat(){
        return (double) value;
    }
    public String forceString(){
        return (String) value;
    }
    public ArrayList<Value> forceList(){return (ArrayList<Value>) value;}
    public FunctionRecord forceFunc(){return (FunctionRecord) value;}


    // Simple operations that the interpreter uses to operate on a value.
    // We assume the caller does the typ checking.
    public Value neg(){
        return new Value(-forceFloat());
    }
    public Value not(){
        return Value.fromBool(!forceBool());
    }
    public Value add(Value rhs){
        return new Value(forceFloat() + rhs.forceFloat());
    }
    public Value sub(Value rhs){
        return new Value(forceFloat() - rhs.forceFloat());
    }
    public Value mul(Value rhs){
        return new Value(forceFloat() * rhs.forceFloat());
    }
    public Value div(Value rhs){
        return new Value(forceFloat() / rhs.forceFloat());
    }
    public Value and(Value rhs){
        return Value.fromBool(forceBool() && rhs.forceBool());
    }
    public Value or(Value rhs){
        return Value.fromBool(forceBool() || rhs.forceBool());
    }
    public Value eq(Value rhs){
        return Value.fromBool(value.equals(rhs.value));
    }
    public Value neq(Value rhs){
        return eq(rhs).not();
    }

    // Useful methods for printing the value.
    public String debugString(){
        return String.format("Value(%s)", value.toString());
    }
    public String toString(){
        return switch (this.type){
            case LIST -> {
                ArrayList<String> strs = new ArrayList<>();
                for(Value val : this.forceList()){
                    strs.add(val.toString());
                }
                yield strs.toString();
            }
            case VOID -> "VOID";
            default -> this.value.toString();
        };
    }
}

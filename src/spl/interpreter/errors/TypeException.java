package spl.interpreter.errors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import spl.interpreter.SymbolTable;
import spl.interpreter.Value;

// Used to report type checking errors.

public class TypeException extends InterpreterException {
    public TypeException(String message) {
        super(message);
    }
    public static TypeException createAssignVoidFromToken(Token tok){
        TypeException ex = new TypeException(String.format("tried to assign VOID to variable %s; variables can't have type void!", tok.getText()));
        ex.setPositionWithToken(tok);
        return ex;
    }

    public static TypeException createTypeMismatchFromContext(ParserRuleContext ctx, SymbolTable.TypeBound bound, Value.Type got){
        TypeException ex  = new TypeException(String.format("type mismatch, type %s does not satisfy type bound %s in snippet \"%s\"!", got.name(), bound.name(), ctx.getText()));
        ex.setPositionWithContext(ctx);
        return ex;
    }

    public static TypeException createFuncArgCountFromContext(ParserRuleContext ctx, int need, int got){
        TypeException ex  = new TypeException(String.format("argument list has length %d expected %d!", got, need));
        ex.setPositionWithContext(ctx);
        return ex;
    }
    public static TypeException createParamTypeMismatchFromContext(ParserRuleContext ctx, int idx, String param, SymbolTable.TypeBound need, Value.Type got){
        TypeException ex  = new TypeException(String.format("expected argument %d for parameter <%s> to satisfy type bound <%s> found <%s>!", idx+1, param, need.name(), got.name()));
        ex.setPositionWithContext(ctx);
        return ex;
    }

    public static TypeException typeBoundNotSatisfiedFromToken(Token tok, Value.Type type, SymbolTable.TypeBound bound){
        TypeException ex  = new TypeException(String.format("type bound <%s> of variable <%s> not satisfied by type <%s>!", bound.name(), tok.getText(), type.name()));
        ex.setPositionWithToken(tok);
        return ex;
    }

    public static TypeException unequalTypesFromContext(ParserRuleContext ctx, Value.Type l, Value.Type r){
        TypeException ex  = new TypeException(String.format("for equality check both sites must have equal types, but found <%s> and <%s>!", l.name(), r.name()));
        ex.setPositionWithContext(ctx);
        return ex;
    }
}
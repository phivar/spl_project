package spl.interpreter.errors;

import org.antlr.v4.runtime.Token;

// Used for exceptions related to looking up variables in a scope.
public class NameException extends InterpreterException {
    public NameException(String message) {
        super(message);
    }

    public static NameException keyNotFoundFromToken(Token tok){
        NameException ex = new NameException(String.format("identifier <%s> not declared!", tok.getText()));
        ex.setPositionWithToken(tok);
        return ex;
    }
    public static NameException keyAlreadyDeclaredFromToken(Token tok){
        NameException ex = new NameException(String.format("identifier <%s> already declared in this scope!", tok.getText()));
        ex.setPositionWithToken(tok);
        return ex;
    }

    public static NameException keyNeverAssignedFromToken(Token tok){
        NameException ex = new NameException(String.format("identifier <%s> was never assigned a value!", tok.getText()));
        ex.setPositionWithToken(tok);
        return ex;
    }


}
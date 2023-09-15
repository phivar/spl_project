package spl.interpreter.errors;

// Syntax error detected while parsing.
public class SPLSyntaxError extends InterpreterException {
    public SPLSyntaxError(String message) {
        super(message);
    }

}

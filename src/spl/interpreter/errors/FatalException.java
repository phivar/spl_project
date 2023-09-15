package spl.interpreter.errors;

// Used for impossible exceptions, such as impossible parses or impossible switch statement branches.
public class FatalException extends InterpreterException {
    public FatalException(String message) {
        super(message);
    }

}

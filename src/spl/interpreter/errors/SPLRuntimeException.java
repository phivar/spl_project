package spl.interpreter.errors;


// Used for runtime exceptions in the SPL standard library functions (e.g. index our of bounds).
public class SPLRuntimeException extends InterpreterException {
    public SPLRuntimeException(String message) {
        super(message);
    }

}

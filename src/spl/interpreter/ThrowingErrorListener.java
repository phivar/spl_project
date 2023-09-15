package spl.interpreter;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import spl.interpreter.errors.SPLSyntaxError;


// We use this to catch ANTLR parsing errors and convert them to SPLSyntaxErrors. Use in Interpreter class.
public class ThrowingErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        SPLSyntaxError ex = new SPLSyntaxError(String.format("syntax error occurred, symbol: %s message: %s", offendingSymbol.toString(), msg));
        ex.setPosition(line,charPositionInLine, 0,0);
        throw ex;
    }
}
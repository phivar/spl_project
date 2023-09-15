package spl.interpreter.errors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

// Use for exceptions that can be augmented with a position (e.g. line number) in the code.
public class InterpreterException extends RuntimeException {
    public int line = 0;
    public int charOffset = 0;
    public int startIndex = 0;
    public int stopIndex = 0;

    public InterpreterException(String message) {
        super(message);
    }
    public void setPosition(int line, int offset, int startIndex, int stopIndex) {
        this.line = line;
        this.charOffset = offset;
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }
    public void setPositionWithToken(Token tok){
        setPosition(tok.getLine(), tok.getCharPositionInLine(), tok.getStartIndex(), tok.getStopIndex());
    }
    public void setPositionWithContext(ParserRuleContext ctx){
        setPosition(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.start.getStartIndex(), ctx.stop.getStopIndex());
    }
}
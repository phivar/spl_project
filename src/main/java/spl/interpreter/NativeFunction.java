package spl.interpreter;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;
import spl.interpreter.errors.SPLRuntimeException;

import java.util.ArrayList;
import java.util.function.Function;

// Wrapper to make a java function available in SPL.
public class NativeFunction extends FunctionRecord{
    private final Function<ArrayList<Value>, Value> func;

    // Typ checks the argument list and the passes it to the native java function.
    @Override
    public Value execute(ParserRuleContext ctx, ArrayList<Value> arguments) {
        typeCheckArgumentList(ctx, arguments);
        try{
            return func.apply(arguments);
        }
        catch(SPLRuntimeException ex){
            ex.setPositionWithContext(ctx);
            throw ex;
        }
    }

    public NativeFunction(ArrayList<Pair<String, SymbolTable.TypeBound>> paramList, Function<ArrayList<Value>, Value> func){
        this.parameterList = paramList;
        this.func = func;
    }
}



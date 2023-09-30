package spl.interpreter;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;
import spl.interpreter.errors.TypeException;

import java.util.ArrayList;

// Models a callable function.
public abstract class FunctionRecord {

    protected ArrayList<Pair<String, SymbolTable.TypeBound>> parameterList;

    // Checks length and typs of a provided argument list.
    protected void typeCheckArgumentList(ParserRuleContext ctx,ArrayList<Value> arguments){
        if(parameterList.size() != arguments.size())
                throw TypeException.createFuncArgCountFromContext(ctx, parameterList.size(), arguments.size());

        for (int i = 0; i < parameterList.size(); i++) {
            if (!parameterList.get(i).b.satisfiedBy(arguments.get(i).type))
                throw TypeException.createParamTypeMismatchFromContext(ctx, i, parameterList.get(i).a, parameterList.get(i).b, arguments.get(i).type);
        }
    }
    // Evaluate the function on a provided argument list. Implemented by NativeFunction and SPLFunction.
    public abstract Value execute(ParserRuleContext ctx, ArrayList<Value> arguments);
}

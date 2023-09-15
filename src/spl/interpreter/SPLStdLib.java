package spl.interpreter;

import org.antlr.v4.runtime.misc.Pair;
import spl.interpreter.errors.SPLRuntimeException;
import spl.interpreter.SymbolTable.TypeBound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// Methods to add standard library functions to a scope.
// These functions use the NativeFunction class to point to internal native java functions.
// Parameter typ checking is handled by FunctionRecord (the super class of NativeFunction).
public class SPLStdLib {


    // Registers the standard library functions as symbols in the passed scope.
    public static void registerSymbols(SymbolTable scope){
        Map<String, FunctionRecord> stdlib = Stream.of(new Object[][] {
                {"string_concat", new NativeFunction(new ArrayList<>(List.of(
                            new Pair<>("a",TypeBound.STRING),
                            new Pair<>("b",TypeBound.STRING))),
                        SPLStdLib::stringConcat)},
                {"string_length", new NativeFunction(new ArrayList<>(List.of(new Pair<>("str",TypeBound.STRING))), SPLStdLib::stringLength)},
                {"list_length", new NativeFunction(new ArrayList<>(List.of(new Pair<>("lst",TypeBound.LIST))), SPLStdLib::listLength)},
                {"list_append", new NativeFunction(new ArrayList<>(List.of(
                            new Pair<>("lst",TypeBound.LIST),
                            new Pair<>("value",TypeBound.ANY))),
                        SPLStdLib::listAppend)},
                {"list_get", new NativeFunction(new ArrayList<>(List.of(
                            new Pair<>("lst",TypeBound.LIST),
                            new Pair<>("index",TypeBound.FLOAT))),
                        SPLStdLib::listGet)},
                {"list_set", new NativeFunction(new ArrayList<>(List.of(
                            new Pair<>("lst",TypeBound.LIST),
                            new Pair<>("index",TypeBound.FLOAT),
                            new Pair<>("value",TypeBound.ANY))),
                        SPLStdLib::listSet)},
                {"float_sin", new NativeFunction(new ArrayList<>(List.of(new Pair<>("x",TypeBound.FLOAT))), SPLStdLib::floatSin)},
                {"float_cos", new NativeFunction(new ArrayList<>(List.of(new Pair<>("x",TypeBound.FLOAT))), SPLStdLib::floatCos)},
                {"to_string", new NativeFunction(new ArrayList<>(List.of(new Pair<>("x",TypeBound.ANY))), SPLStdLib::convertString)}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (FunctionRecord) data[1]));

        for(Map.Entry<String,FunctionRecord> entry : stdlib.entrySet()){
            scope.put(entry.getKey(), TypeBound.ANY,  new Value(entry.getValue()));
        }
    }
    // Below are the standard library functions. The names explain their functionality.
    // string_concat(a: string, b: string) -> string
    public static Value stringConcat(ArrayList<Value> arg){
        String a = arg.get(0).forceString();
        String b = arg.get(1).forceString();
        return new Value(a+b);
    }
    // string_length(x: string) -> number
    public static Value stringLength(ArrayList<Value> arg){
        Value val = arg.get(0);
        return new Value((double) val.forceString().length());
    }
    // list_append(lst: list) -> void
    public static Value listAppend(ArrayList<Value> arg){
        Value list = arg.get(0);
        Value val = arg.get(1);
        list.forceList().add(val);
        return Value.VOID;
    }
    // list_length(lst: list) -> number
    public static Value listLength(ArrayList<Value> arg){
        Value val = arg.get(0);
        return new Value((double) val.forceList().size());
    }
    // List indexing with bound checks.
    // If the passed index has a fractional part, it throws a runtime exception.
    // list_get(lst: list, index: number) -> any
    public static Value listGet(ArrayList<Value> arg){
        ArrayList<Value> list = arg.get(0).forceList();
        double val = arg.get(1).forceFloat();
        int idx = (int)Math.round(arg.get(1).forceFloat());
        if((double)idx != val) throw new SPLRuntimeException(String.format("can't use non-integer number <%f> as index!", val));
        if(idx < 0 || idx >= list.size()) throw new SPLRuntimeException(String.format("index <%d> out of bounds!", idx));
        return list.get(idx);
    }
    // list_set(lst: list, index: number, value: any) -> void
    public static Value listSet(ArrayList<Value> arg){
        ArrayList<Value> list = arg.get(0).forceList();
        double val = arg.get(1).forceFloat();
        Value target = arg.get(2);
        int idx = (int)Math.round(arg.get(1).forceFloat());
        if((double)idx != val) throw new SPLRuntimeException(String.format("can't use non-integer number <%f> as index!", val));
        if(idx < 0 || idx >= list.size()) throw new SPLRuntimeException(String.format("index <%d> out of bounds!", idx));
        list.set(idx,target);
        return Value.VOID;
    }
    // float_sin(x: number) -> number
    public static Value floatSin(ArrayList<Value> arg){
        Value val = arg.get(0);
        return new Value(Math.sin(val.forceFloat()));
    }
    // float_cos(x: number) -> number
    public static Value floatCos(ArrayList<Value> arg){
        Value val = arg.get(0);
        return new Value(Math.cos(val.forceFloat()));
    }
    // to_string(x: any) -> string
    public static Value convertString(ArrayList<Value> arg){
        Value val = arg.get(0);
        return new Value(val.toString());
    }
}

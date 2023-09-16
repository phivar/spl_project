package test;

import spl.interpreter.*;
import spl.interpreter.errors.InterpreterException;
import spl.interpreter.errors.NameException;
import spl.interpreter.errors.SPLRuntimeException;
import spl.interpreter.errors.TypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args){
        System.out.println("=== Testing...");
        testSimpleErrors();
        testSimpleExpressionValues();
        testSimpleStmts();
        testStdLib();
        testFunctions();
        testSorting();
    }

    public static boolean testError(int i,  Exception ex, String code){
        try {
            Interpreter inter = new Interpreter();
            inter.runVerbose(code);
        } catch (Exception exception){

            if(exception.getClass().equals(ex.getClass())){
                return true;
            }else{
                System.out.println(exception.getMessage());
                throw exception;
            }
        }
        return false;
    }
    public static final Exception NAME_ERROR = new NameException("");
    public static final Exception TYPE_ERROR = new TypeException("");
    public static final Exception RUNTIME_ERROR = new SPLRuntimeException("");

    public static  Map<String, Exception> simple_error_tests = Stream.of(new Object[][] {
            {"a = 10.0;", NAME_ERROR},
            {"a;", NAME_ERROR},
            {"var a; var a;", NAME_ERROR},
            {"var a; a;", NAME_ERROR},
            {"var a; {var a; a;} a;", NAME_ERROR},
            {"10.0 + \"test\";",TYPE_ERROR},
            {"false + \"test\";",TYPE_ERROR},
            {"!10.0;",TYPE_ERROR},
            {"-false;",TYPE_ERROR},
            {"var a = f();", NAME_ERROR},
            {"var f = func(){g();};f();", NAME_ERROR},
            {"var l = [0.0]; var out = list_set(l,0,1);", TYPE_ERROR},
            {"var l = []; var out = list_get(0);", TYPE_ERROR},
            {"var l = []; var out = list_get();", TYPE_ERROR},
            {"var l = []; var out = list_get(l,0);", RUNTIME_ERROR},
            {"var l : number = \"test\";", TYPE_ERROR},
            {"var l : list = \"test\";", TYPE_ERROR},
            {"var l : func = 1.0;", TYPE_ERROR},
            {"var l = func(x: number){}; l(\"asd\");", TYPE_ERROR},
            {"var l: list = func(x: number){};", TYPE_ERROR},
            {"var l: any = func(){return func(x:number){};}; l()([]);", TYPE_ERROR},
            {"var f = func(){return;}; var b = f();", TYPE_ERROR},
            {"var f = func(){}; var id = func(x){return x;}; id(f());", TYPE_ERROR},
            {"var empty = func(){}; var x: any = empty();", TYPE_ERROR},
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Exception) data[1]));
    public static void testSimpleErrors(){
        System.out.printf("=== Testing simple_error_tests\n");
        int i = 0;
        for(Map.Entry<String,Exception> entry : simple_error_tests.entrySet()){
            if(!testError(i, entry.getValue(), entry.getKey())){
                System.out.printf("Testcase FAILED! " + entry.getKey());
                return;
            }
            i++;
        }
        System.out.printf("=> Passed %d/%d\n", i, simple_error_tests.entrySet().size());
    }

    public static  Map<String, Value> expr_tests = Stream.of(new Object[][] {
            {"var out = true;", Value.TRUE },
            {"var out = false;", Value.FALSE },
            {"var out = true and true;", Value.TRUE},
            {"var out = true and false;", Value.FALSE},
            {"var out = false and false;", Value.FALSE},
            {"var out = false or true;", Value.TRUE},
            {"var out = false or false;", Value.FALSE},
            {"var out = 1.0 < 2.0;", Value.TRUE},
            {"var out = 1.0 < 1.0;", Value.FALSE},
            {"var out = 1.0 <= 2.0;", Value.TRUE},
            {"var out = 1.0 <= 1.0;", Value.TRUE},
            {"var out = 1.1 <= 1.0;", Value.FALSE},
            {"var out = 3.0 > 2.0;", Value.TRUE},
            {"var out = 3.0 > 3.0;", Value.FALSE},
            {"var out = 3.0 >= 2.0;", Value.TRUE},
            {"var out = 3.0 >= 3.0;", Value.TRUE},
            {"var out = 3.0 >= 3.5;", Value.FALSE},
            {"var out = 3.0 == 3.5;", Value.FALSE},
            {"var out = 3.0 == 3.0;", Value.TRUE},
            {"var out = 3.0 != 3.1;", Value.TRUE},
            {"var out = 3.0 != 3.0;", Value.FALSE},
            {"var out = 3.0 + 3.0;", new Value(6.0)},
            {"var out = 3.0 - 3.0;", new Value(0.0)},
            {"var out = 3.0 * 3.0;", new Value(9.0)},
            {"var out = 3.0 / 3.0;", new Value(1.0)},
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Value) data[1]));

    public static void testSimpleExpressionValues(){
        System.out.printf("=== Testing simple expression values\n");
        int i = 0;
        for(Map.Entry<String,Value> entry : expr_tests.entrySet()){
            if(!testValue(i, entry.getKey(), entry.getValue())){
                System.out.printf("Testcase FAILED!");
                return;
            }
            i++;
        }
        System.out.printf("=> Passed %d/%d\n", i, expr_tests.entrySet().size());
    }

    public static boolean testValue(int i, String code, Value val){
        try {
            Interpreter inter = new Interpreter();
            inter.run(code);
            Value out = inter.globalScope.get("out");
            if(!out.eq(val).forceBool()){
                System.out.printf("Failure: snippet %d with code %s resulted in %s expected %s\n", i, code, out.debugString(), val.debugString());
                return false;
            }
        } catch (Exception exception){
            System.out.printf("Failed due to unexpected exception in  snippet %d: %s\n", i, code );
            throw exception;
        }
        return true;
    }


    public static  Map<String, Value> stmt_tests = Stream.of(new Object[][] {
            {"var out; if(true) out = 1.0; else out = 2.0;", new Value(1.0)},
            {"var out; if(false) out = 1.0; else out = 2.0;", new Value(2.0)},
            {"var out = 0.0; if(true) out = 1.0;", new Value(1.0)},
            {"var out = 0.0; if(false) out = 1.0;", new Value(0.0)},
            {"var out = 0.0; while(out < 10.0) out = out + 1;", new Value(10.0)},
            {"var out = 0.0; while(out <= 10.0) out = out + 1;", new Value(11.0)},
            {"var out = 0.0; out = out + 1.0;", new Value(1.0)},
            {"var out = 1.0; out = out + 1.0;", new Value(2.0)},
            {"var out = 4.0; out = out - 2.0;", new Value(2.0)},
            {"var out = 1.0; out = out * 2.0;", new Value(2.0)},
            {"var out = 4.0; out = out / 2.0;", new Value(2.0)},
            {"var out = true; out = !out;", Value.FALSE},
            {"var out = true; out = out and out;", Value.TRUE},
            {"var a = 0.0; var out = 1.0; var i = 10; var t; while(i > 0){t = out; out = a + out; a = t; i = i -1;}", new Value(89.0)},
            {"var out = 1.0/0.0;", new Value(Double.parseDouble("Infinity"))},
            {"var out = 0.0/0.0;", new Value(Double.parseDouble("NaN"))}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Value) data[1]));

    public static void testSimpleStmts(){
        System.out.printf("=== Testing simple statements values\n");
        int i = 0;
        for(Map.Entry<String,Value> entry : stmt_tests.entrySet()){
            if(!testValue(i, entry.getKey(), entry.getValue())){
                System.out.printf("Testcase FAILED!");
                return;
            }
            i++;
        }
        System.out.printf("=> Passed %d/%d\n", i, stmt_tests.entrySet().size());
    }

    public static  Map<String, Value> std_lib_tests = Stream.of(new Object[][] {
            {"var out = \"aa\"; var b = \"bb\"; out = string_concat(out,b); ", new Value("aabb")},
            {"var out = 0.0; var b = \"bb\"; out = string_length(b); ", new Value(2.0)},
            {"var out = 0.0; var b = [1,2,3]; list_append(b,4); print b; out = 2.0; ", new Value(2.0)},
            {"var out = 0.0; var b = [1,2,\"asdf\",true]; list_append(b,4); print b; out = 2.0; ", new Value(2.0)},
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Value) data[1]));

    public static void testStdLib(){
        System.out.printf("=== Testing std lib functions \n");
        int i = 0;
        for(Map.Entry<String,Value> entry : std_lib_tests.entrySet()){
            if(!testValue(i, entry.getKey(), entry.getValue())){
                System.out.printf("Testcase FAILED!");
                return;
            }
            i++;
        }
        System.out.printf("=> Passed %d/%d\n", i, std_lib_tests.entrySet().size());
    }

    public static  Map<String, Value> func_tests = Stream.of(new Object[][] {
            {"var f = func(){return 1.0;}; var out = f();", new Value(1.0)},
            {"var f = func(x){return x;}; var out = f(1.0);", new Value(1.0)},
            {"var f = func(x,y){return x+y;}; var out = f(1.0,2.0);", new Value(3.0)},
            {"var fib = func(x){if(x == 1.0) return 1.0; return x*fib(x-1.0);}; var out = fib(3.0);", new Value(6.0)},
            {"var f = func(){return 1.0; return 2.0;}; var out = f();", new Value(1.0)},
            {"var f = func(){return func(){return 2.0;};}; var out = f()();", new Value(2.0)},
            {"var eval = func(f){return f();}; var out = eval(func(){return 3.0;});", new Value(3.0)},
            {"var f = func(x){if(x) return 1.0; else return 2.0;}; var out = f(true);", new Value(1.0)},
            {"var f = func(x){if(x) return 1.0; else return 2.0;}; var out = f(false);", new Value(2.0)},
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Value) data[1]));

    public static void testFunctions(){
        System.out.printf("=== Testing functions\n");
        int i = 0;
        for(Map.Entry<String,Value> entry : func_tests.entrySet()){
            if(!testValue(i, entry.getKey(), entry.getValue())){
                System.out.printf("Testcase FAILED!");
                return;
            }
            i++;
        }
        System.out.printf("=> Passed %d/%d\n", i, func_tests.entrySet().size());
    }

    public static final String sorting_test = """
            var sort = func(x){
                var i = 0;
                var n = list_length(x);
                while(i < n){
                    var min = i;
                    var j = i+1;
                    while(j < n){
                        if(list_get(x,j) < list_get(x,min)){
                            min = j;
                        }
                        j = j + 1;
                    }

                    var temp = list_get(x,i);
                    list_set(x,i,list_get(x,min));
                    list_set(x,min,temp);

                    i = i+1;
                }
            };
            """;
    public static  List<List<Double>> sorting_tests = List.of(List.of(), List.of(1.0), List.of(2.0,1.0), List.of(4.0,1.0,3.0,2.0));
    public static void testSorting(){
        System.out.printf("=== Testing sorting function\n");
        Interpreter inter = new Interpreter();
        inter.runVerbose(sorting_test);
        int i = 0;
        for(List<Double> lst : sorting_tests){
            ArrayList<Value> arr = new ArrayList<>();
            for(Double d : lst) arr.add(new Value(d.doubleValue()));
            inter.globalScope.put("out", SymbolTable.TypeBound.ANY, new Value(arr));
            inter.runVerbose("sort(out);");
            List<Double> sorted = lst.stream().sorted().collect(Collectors.toList());
            int j = 0;
            for(Double d : sorted){
                if(d.doubleValue() != arr.get(j).forceFloat()) {
                    System.out.println("" + i);
                    throw new InterpreterException("failed sorting");
                }
                j++;
            }
            i++;
        }
        System.out.printf("=> Passed %d/%d\n", i, sorting_tests.size());
    }

}

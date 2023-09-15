package spl.interpreter;

import org.antlr.v4.runtime.*;
import spl.interpreter.errors.InterpreterException;
import spl.parser.SPLLexer;
import spl.parser.SPLParser;


// Can parse and execute a piece of code in a scope populated with the SPL standard library functions.
public class Interpreter {
    public SymbolTable globalScope = new SymbolTable();
    private String code;

    public Interpreter(){
        SPLStdLib.registerSymbols(globalScope);
    }

    // Parses and runs a piece of code in the global scope.
    // Running this function multiple times is currently not supported
    // as it breaks the findLine method if an error occurs in a previously passed string.
    public void run(String code){
        this.code = code;
        CharStream stream = CharStreams.fromString(code);
        SPLLexer lexer = new SPLLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SPLParser parser = new SPLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ThrowingErrorListener());
        SPLParser.ProgramContext tree = parser.program();

        ExecutingVisitor visitor = new ExecutingVisitor(globalScope);
        visitor.visit(tree);
    }

    // Parses and runs a piece of code with pretty error printing.
    public void runVerbose(String code){
        try{
            run(code);
        }
        catch(InterpreterException ex){
            printError(ex);
            throw ex;
        }
    }

    // Pretty prints a InterpreterException; e.g. includes the line where the exception was thrown.
    public void printError(InterpreterException ex){
        StringBuilder builder = new StringBuilder();
        builder.append("INTERPRETER ERROR: ")
                .append(ex.getClass().getName())
                .append(String.format(": in line %d at char %d: ", ex.line, ex.charOffset))
                .append(ex.getMessage())
                .append("\n")
                .append(String.format("\n\t%s\n\t%s^\n", findLine(ex.line), " ".repeat(ex.charOffset)));
        System.out.println(builder);
        System.out.flush();
    }

    // Find a line string in the current code from the line number.
    public String findLine(int i){
        int begin = 0;
        int end = this.code.indexOf('\n');
        if(end == -1) return this.code.substring(begin);
        int j = 1;
        while(j < i && end != -1){
            begin = end+1;
            end = this.code.indexOf('\n', begin);
            j++;
        }
        if(end == -1) return this.code.substring(begin);
        return this.code.substring(begin,end);
    }
}

package spl;

import spl.interpreter.Interpreter;
import spl.interpreter.errors.FatalException;
import spl.interpreter.errors.InterpreterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    // Reads command line arguments, prints help if necessary,
    // otherwise loads file from path provided and launches interpreter.
    public static void main(String[] args) throws Exception {
        if(args.length == 0 || args[0].equals("-h")){
            printHelp();
            return;
        }
        Path path = Paths.get(args[0]);
        String code;
        try{
            code = Files.readString(path);
        } catch(IOException ex){
            System.out.println("ERROR: Couldn't open file " + path);
            return;
        }
        Interpreter inter = new Interpreter();
        try{
            inter.runVerbose(code);
        }
        catch(FatalException ex){
            throw new Exception(ex.getMessage());
        }
        catch(InterpreterException ex){
            // printing was handled by runVerbose.
        }
    }

    public static void printHelp(){
        System.out.println("""
                usage:
                java -jar spl.jar [spl-args] [<path>]
                
                spl-args:
                    -h\t : shows this help message
                """);
    }
}

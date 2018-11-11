package de.lab4inf.wrb;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class WRBScript implements Script{
    private WRBObserver Observer = new WRBObserver();

    @Override
    public double parse(String definition) {
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString(definition));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        ParseTree tree = parser.prog();
        
        return Observer.visit(tree);
        
    }

    @Override
    public double parse(InputStream defStream) throws IOException {
        return parse(IOUtils.toString(defStream, "UTF-8"));
    }

    @Override
    public Set<String> getFunctionNames() {
        return null;
    }


    @Override
    public Set<String> getVariableNames() {
        return Observer.memory.keySet();
    }

    @Override
    public void setFunction(String name, Function fct) {
    	
    }

    @Override
    public Function getFunction(String name) {
        return null;
    }

    @Override
    public double getVariable(String name) {
        try {
            return Observer.memory.get(name);
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void setVariable(String name, double value) {
        Observer.memory.put(name, value);
    }
}
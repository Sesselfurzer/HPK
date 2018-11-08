package de.lab4inf.wrb;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

public class WRBScript implements Script{
    private HashMap<String, Double> variables = new HashMap<String, Double>();
    private WRBObserver Observer = new WRBObserver();

    @Override
    public double parse(String definition) {
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString(definition));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
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
        return variables.keySet();
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
            return variables.get(name);
        } catch (NullPointerException exception) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void setVariable(String name, double value) {
        variables.put(name, value);
    }
}
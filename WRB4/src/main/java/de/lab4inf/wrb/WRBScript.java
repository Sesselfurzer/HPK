package de.lab4inf.wrb;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
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
        lexer.removeErrorListeners();
		lexer.addErrorListener(WRBConsoleErrorListener.INSTANCE);
        
		GrammarParser parser = new GrammarParser(tokens);
        parser.setTokenStream(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(WRBConsoleErrorListener.INSTANCE);
        
        ParseTree tree;
        Double ergebnis;
        
        try {
        	tree = parser.prog();
        	ergebnis = Observer.visit(tree);
		} catch (Exception e) {
			throw new IllegalArgumentException("Ungültige Eingabe!");
		}
        return ergebnis;
        
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
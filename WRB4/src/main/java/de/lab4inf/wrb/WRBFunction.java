package de.lab4inf.wrb;

import org.antlr.v4.runtime.tree.ParseTree;

public class WRBFunction implements Function{
	
	String Name;
	ParseTree ArgList;
	ParseTree Body;
	
	public WRBFunction(String fctName,ParseTree fctArgList,ParseTree fctBody) {
		Name = fctName;
		ArgList = fctArgList;
		Body = fctBody;
	}
	
	
	@Override
	public double eval(final double... args) {
		
		
		return 0;
	}
}
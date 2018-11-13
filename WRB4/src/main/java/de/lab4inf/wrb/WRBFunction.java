package de.lab4inf.wrb;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

public class WRBFunction implements Function{
	
	String Name;
	String[] ArgList;
	ParseTree Body;
	WRBObserver observer;
	Map<String, Double> tmpmemory;
	
	public WRBFunction(String fctName,String[] fctArgList,ParseTree fctBody, WRBObserver fctObserver) {
		Name = fctName;
		ArgList = fctArgList;
		Body = fctBody;
		observer = fctObserver;
	}
	
	
	@Override
	public double eval(final double... args) {
		double ergebnis=0;
		tmpmemory = new HashMap<String, Double>(observer.memory);
		if(args.length == ArgList.length) {
			for(int i=0; i<args.length;i++) {
				observer.memory.put(ArgList[i], args[i]);
			}
			ergebnis=observer.visit(Body);
		}
		observer.memory = tmpmemory;
		return ergebnis;
	}
}
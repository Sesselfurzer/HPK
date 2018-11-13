package de.lab4inf.wrb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;


public class WRBObserver extends GrammarBaseVisitor<Double>{
	/** "memory" for our calculator; variable/value pairs go here */
	Map<String, Double> memory = new HashMap<String, Double>();
	Map<String, WRBFunction> functionmemory = new HashMap<String, WRBFunction>(); 
	
	/** ID '=' expr ';'? */
	@Override
	public Double visitAssign(GrammarParser.AssignContext ctx) {
		String id = ctx.ID().getText(); //LETTER is left-hand side of '='
		double value = visit(ctx.expr());		//compute value of expression on right
		memory.put(id, value);				//store it in our memory
		return value;
	}
	/** expr ';' */
    @Override
    public Double visitPrintExpr(GrammarParser.PrintExprContext ctx) {
    	Double value = visit(ctx.expr()); // evaluate the expr child
        System.out.println(value);         // print the result
        return value;                          // return dummy value
    }

    /** number */
    @Override
    public Double visitFloat(GrammarParser.FloatContext ctx) {
        return Double.valueOf(ctx.newnumber().getText());
    }

    /** ID */
    @Override
    public Double visitId(GrammarParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        return (double) 0;
    }

    /** expr op=('*'|'/') expr */
    @Override
    public Double visitMulDiv(GrammarParser.MulDivContext ctx) {
        double left = visit(ctx.expr(0));  // get value of left subexpression
        double right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == GrammarParser.MUL ) return left * right;
        return left / right; // must be DIV
    }

    /** expr op=('+'|'-') expr */
    @Override
    public Double visitAddSub(GrammarParser.AddSubContext ctx) {
    	double left = visit(ctx.expr(0));  // get value of left subexpression
    	double right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == GrammarParser.ADD ) return left + right;
        return left - right; // must be SUB
    }
    
    /** expr op=('^'|'**') expr */
    @Override
    public Double visitPower(GrammarParser.PowerContext ctx) {
    	double left = visit(ctx.expr(0));  // get value of left subexpression
    	double right = visit(ctx.expr(1)); // get value of right subexpression
        return Math.pow(left, right); 
    }

    /** '(' expr ')' */
    @Override
    public Double visitParens(GrammarParser.ParensContext ctx) {
    	if(ctx.SUB()!=null)
    		return -1*visit(ctx.expr());
        return visit(ctx.expr()); // return child expr's value
    }
    
    /** ')' */
    @Override
    public Double visitWrongparens(GrammarParser.WrongparensContext ctx) {
    	throw new IllegalArgumentException("Ungültige Eingabe");
    }
    
    /** ID '(' expr (',' expr)* ')' */
    @Override
    public Double visitFunction(GrammarParser.FunctionContext ctx) {
    	String name = ctx.ID().getText();
    	int argCount = ctx.expr().size();
    	Double[] argList = new Double[argCount];
    	double[] argList2 = new double[argCount];
		for(int i=0;i<argCount;i++) {
			argList[i] = visit(ctx.expr(i));
			argList2[i] = argList[i];
		}
		
		if(functionmemory.containsKey(name))
    		return functionmemory.get(name).eval(argList2);

    	double ergebnis=0;
    	try {
			for (Method mathMethod : Class.forName("java.lang.Math").getMethods()) {
			    if (Arrays.stream(mathMethod.getParameterTypes()).allMatch(x -> x == double.class)) {
			    	if(mathMethod.getName().equals(name)) {	
			    		if(name.equals("min")) {
                            if(argCount<=1)throw new IllegalArgumentException("min benötigt mindestens 2 Parameter");
                            ergebnis = Math.min(argList[0], argList[1]);
                            for(int j=2;j<argCount;j++){
                                ergebnis = Math.min(ergebnis, argList[j]);
                            } 
			    		 } else if(name.equals("max")) {
	                        if(argList.length<=1)throw new IllegalArgumentException("max benötigt mindestens 2 Parameter");
	                        ergebnis = Math.max(argList[0], argList[1]);
	                        for(int j=2;j<argCount;j++){
	                            ergebnis = Math.max(ergebnis, argList[j]);
	                        } 
	                     }
	                     else {
	                    	 ergebnis=(Double) mathMethod.invoke(null, (Object[]) argList);
	                     }
			    		return ergebnis;
			    	}
			    }
			}
		} catch (SecurityException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
    	throw new IllegalArgumentException("Unbekannte Funktion!");
    }
    
    /** ID '(' ID (',' ID)* ')' '=' expr ';'? */
    @Override
    public Double visitFunctionassign(GrammarParser.FunctionassignContext ctx) {
    	String name = ctx.ID(0).getText();
    	int argCount = ctx.ID().size()-1;
    	String[] argList= new String[argCount];
    	for(int i=0;i<argCount;i++)
			argList[i] = ctx.ID(i+1).getText();
    	ParseTree body = ctx.expr();
    	WRBFunction function= new WRBFunction(name, argList, body, WRBObserver.this);
    	functionmemory.put(name, function);
    	return 0.0;
    }
    
    /** othermathfunction */
    @Override
    public Double visitMathfunc(GrammarParser.MathfuncContext ctx) {
    	if(ctx.othermathfunction().SIN()!=null)
    		return Math.sin(visit(ctx.othermathfunction().expr()));
    	else if(ctx.othermathfunction().LN()!=null) 
    		return Math.log(visit(ctx.othermathfunction().expr()));
    	else if(ctx.othermathfunction().LOG()!=null)
    		return Math.log10(visit(ctx.othermathfunction().expr()));
    	else if(ctx.othermathfunction().LOG2()!=null)
    		return Math.log(visit(ctx.othermathfunction().expr()))/Math.log(2);
    	return 0.0;
    }
	
}
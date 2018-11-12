package de.lab4inf.wrb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class WRBObserver extends GrammarBaseVisitor<Double>{
	/** "memory" for our calculator; variable/value pairs go here */
	Map<String, Double> memory = new HashMap<String, Double>();
	
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
    	double ergebnis=0;
    	try {
			for (Method mathMethod : Class.forName("java.lang.Math").getMethods()) {
			    if (Arrays.stream(mathMethod.getParameterTypes()).allMatch(x -> x == double.class)) {
			    	if(mathMethod.getName().equals(name)) {
			    		Double[] argList = new Double[argCount];
			    		for(int i=0;i<argCount;i++)
			    			argList[i] = visit(ctx.expr(i));
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
	                    	 ergebnis= (Double) mathMethod.invoke(null, (Object[]) argList);
	                     }
			    	}
			    }
			}
		} catch (SecurityException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
    	return ergebnis;
    }
    
    /** othermathfunction */
    @Override
    public Double visitMathfunc(GrammarParser.MathfuncContext ctx) {
    	if(ctx.othermathfunction().LN()!=null) 
    		return Math.log(visit(ctx.othermathfunction().expr()));
    	else if(ctx.othermathfunction().LOG()!=null)
    		return Math.log10(visit(ctx.othermathfunction().expr()));
    	else if(ctx.othermathfunction().LOG2()!=null)
    		return Math.log(visit(ctx.othermathfunction().expr()))/Math.log(2);
    	return 0.0;
    	//return Math.log(visit(ctx.expr()));
    }
	
}
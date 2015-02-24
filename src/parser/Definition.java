package parser;

import env.Env;
import lexer.Equal;

public class Definition extends AST {
	
	private Variable var;
	private Expression exp;
	private Equal equal;
	
	public Definition(Equal equal, Variable var, Expression exp) {
		this.var = var;
		this.exp = exp;
		this.equal = equal;
	}
	
	public String toString() {
		return "Definition(" + this.equal + " " + this.var + " " + this.exp + ")";
	}
	
	//returns the evaluation of a definition
	public int eval(Env<Integer> envVar) {
		envVar.bind(var.toString(), exp.eval(envVar));
		return exp.eval(envVar);
	}

}

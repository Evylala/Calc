package parser;

import env.Env;

public class UnaryMinus extends Expression {
	
	private Expression exp;
	
	public UnaryMinus(Expression exp) {
		this.exp = exp;
	}
	
	public String toString() {
		return "UnaryMinus( - " + this.exp.toString() + ")";
	}
	
	//returns the evaluation of a unary minus
	@Override
	public int eval(Env<Integer> envVar) {
		return Integer.parseInt(exp.toString()) * -1;
	}
}

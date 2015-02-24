package parser;

import env.Env;

public class ConditionalExpression extends Expression {

	private Expression exp_if;
	private Expression exp_then;
	private Expression exp_else;

	public ConditionalExpression(Expression exp1, Expression exp2,
			Expression exp3) {

		this.exp_if = exp1;
		this.exp_then = exp2;
		this.exp_else = exp3;
	}

	public String toString() {

		return "ConditionalExpression(if " + this.exp_if.toString() + " "
				+ this.exp_then.toString() + " " + this.exp_else.toString()
				+ ")";
	}
	
	//returns the evaluation of a conditional expression. 1 if true and 0 if false
	@Override
	public int eval(Env<Integer> envVar) {
		
			if (this.exp_if.eval(envVar) == 1
					|| (this.exp_if instanceof Literal && this.exp_if
							.eval(envVar) != 0)) {
				return exp_then.eval(envVar);
			} else {
				return exp_else.eval(envVar);
			}
	}

}

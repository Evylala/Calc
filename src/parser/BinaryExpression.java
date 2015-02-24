package parser;

import env.Env;
import lexer.OP;

public class BinaryExpression extends Expression {

	private Expression exp1;
	private Expression exp2;
	private OP op;

	public BinaryExpression(OP op, Expression exp1, Expression exp2) {
		this.op = op;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public String toString() {
		return "BinaryExpression(" + op.toString() + " " + exp1.toString() + " " + exp2.toString()
				+ ")";
	}
	
	//returns the evaluation of a binary expression
	public int eval(Env<Integer> envVar) {
		
		int val1 = this.exp1.eval(envVar);
		int val2 = this.exp2.eval(envVar);
		
		if (this.op.toString().equals("OP(-)")) {
			return val1 - val2;
		} else if (this.op.toString().equals("OP(+)")){
			return val1 + val2;
		} else if (this.op.toString().equals("OP(/)")) {
			if (val2 != 0) {
				return val1/val2;
			} else {
				throw new RuntimeException("Error : NaN, Cannot divide by 0");
			}
		} else if (this.op.toString().equals("OP(*)")) {
			return val1*val2;
		} else if (this.op.toString().equals("OP(==)")) {
			if (val1==val2) {
				return 1;
			} else {
				return 0;
			}
		} else if (this.op.toString().equals("OP(<)")) { // cas de "<"
			if (val1<val2) {
				return 1;
			} else {
				return 0;
			}
		} else {
			throw new RuntimeException("Error in binary expression");
		}
	}
}

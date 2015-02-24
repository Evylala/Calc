package parser;

import env.Env;

public class Literal extends Expression {
	
	private String value;
	
	public Literal(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
	
	//returns the evaluation of a literal
	@Override
	public int eval(Env<Integer> envVar) {
		return Integer.parseInt(this.value);
	}
}

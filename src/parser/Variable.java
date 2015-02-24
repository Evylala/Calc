package parser;

import env.Env;

public class Variable extends Expression {
	
	private String value;
	
	public Variable(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
	
	//returns the evaluation of a variable
	@Override
	public int eval(Env<Integer> envVar) {
		if (envVar.lookup(value) != null) {
			return envVar.lookup(this.value);
		} else {
			throw new RuntimeException("Error : Undefined Variable : " + this.toString());
		}
	}

}

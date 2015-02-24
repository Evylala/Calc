package parser;

import java.io.IOException;
import java.util.ArrayList;

import lexer.*;
import env.Env;

public class Body extends AST {

	public final ArrayList<Definition> listeDefs;
	public Expression exp;

	public Body() {
		listeDefs = new ArrayList<Definition>();
	}

	public int eval(Env<Integer> envVar) {
		for (Definition def : listeDefs) {
			def.eval(envVar);
		}
		return exp.eval(envVar);
	}
	
	//parses the body, its definitions if they exist and its expression
	public void parse() throws UnexpectedCharacter, IOException, SyntaxicError {

		boolean estDefinition = true;

		while (estDefinition) {
			Token firstToken = SLexer.getToken();

			if (firstToken instanceof LPar) {
				Token secondToken = SLexer.getToken();
				if (secondToken instanceof Equal) {
					Expression exp3 = Expression.parseExpression(SLexer
							.getToken());

					if (exp3 instanceof Variable) {//definition
						Expression exp4 = Expression.parseExpression(SLexer
								.getToken());
						listeDefs.add(new Definition((Equal) secondToken,
								(Variable) exp3, exp4));
						if (!(SLexer.getToken() instanceof RPar)) {
							throw new SyntaxicError(
									"missing closing parenthesis after " + exp4);
						}
					}
				} else { //Expression
						this.exp = Expression.secondParse(secondToken);
						if (!(SLexer.getToken() instanceof EOF)) {
							throw new RuntimeException ("Error : body with more than 2 expressions");
						}
						estDefinition = false;
					
				}
			} else { //Expression
				if (!(firstToken instanceof EOF)) {
					this.exp = Expression.parseExpression(firstToken);
					if (!(SLexer.getToken() instanceof EOF)) {
						throw new RuntimeException ("Error : body with more than 2 expressions");
					}
					estDefinition = false;
				} else {
					throw new RuntimeException("Error : body with no expression");
				}
			}
		}
	}

	@Override
	public String toString() {
		String body = "Body(";
		for (Definition def : listeDefs) {
			body += def.toString();
		}
		body += this.exp.toString() + ")";
		return body;
	}

}

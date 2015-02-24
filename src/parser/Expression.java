package parser;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.List;

import env.Env;
import lexer.*;

public abstract class Expression extends AST {
	
	public Expression() {
	}
	
	//returns the expression that has been parsed
	public static Expression parseExpression(Token firstToken)
			throws UnexpectedCharacter, IOException, SyntaxicError {
		

		if (firstToken instanceof lexer.Literal) {
			return new Literal(firstToken.toString());

		} else if (firstToken instanceof Identifier) {
			if (!(firstToken instanceof If) && !(firstToken instanceof Define)) {
				return new Variable(firstToken.toString());
			}

		} else if (firstToken instanceof EOF) {
			throw new SyntaxicError("empty file");
		} else if (!(firstToken instanceof LPar)) {
			throw new SyntaxicError("missing opening parenthesis before : "
					+ firstToken.toString());

		} else {
			return Expression.secondParse(SLexer.getToken());
		}

		return null;
	}
	
	//returns an expression that starts with a LPAR
	public static Expression secondParse(Token secondToken) throws UnexpectedCharacter, IOException, SyntaxicError {

		if (secondToken instanceof OP) {
			Expression exp3 = Expression.parseExpression(SLexer.getToken());
			Token fourthToken = SLexer.getToken();
			
			if (fourthToken instanceof RPar) { //UnaryMinus
				if (secondToken.toString().equals("OP(-)")
						&& fourthToken instanceof RPar) {
					return new UnaryMinus(exp3);
	
				} else {
					throw new SyntaxicError("wrong operator in a unary minus expression, expecting \"minus\" but : " + secondToken.toString());
				}
			}
			
			//BinaryExpression
			Expression exp4 = Expression.parseExpression(fourthToken);
			Expression exp = new BinaryExpression((OP) secondToken, exp3, exp4);

			if (!(SLexer.getToken() instanceof RPar)) {
				throw new SyntaxicError(
						"missing closing parenthesis after : " + exp4);
			}
			return exp;
			
		} else if (secondToken instanceof If) { //Conditional Expression
			Expression exp3 = Expression.parseExpression(SLexer.getToken());
			Expression exp4 = Expression.parseExpression(SLexer.getToken());
			Expression exp5 = Expression.parseExpression(SLexer.getToken());
			Expression exp = new ConditionalExpression(exp3, exp4, exp5);

			if (!(SLexer.getToken() instanceof RPar)) {
				throw new SyntaxicError(
						"missing closing parenthesis after " + exp5);
			}

			return exp;
		}  else {
			throw new SyntaxicError("unexpected expression after LPAR: "
					+ secondToken);
		}
	}

	public abstract int eval(Env<Integer> envVar);

}

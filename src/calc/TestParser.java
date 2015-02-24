package calc;

import env.Env;
import lexer.SLexer;
import parser.Body;
import parser.Expression;

public class TestParser {
	public static void main(String[] args) {

		try {
			
			Env<Integer> envVar = new Env<Integer>();
			SLexer.init(args[0]); // initialisation du "lexer"
			Expression exp = Expression.parseExpression(SLexer.getToken()); // reconnaissance
																			// d'une
																			// expression
			System.out.println(exp.eval(envVar)); // affichage de l'arbre de syntaxe
											// abstrait
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

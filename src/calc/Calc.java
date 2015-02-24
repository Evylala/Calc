package calc;

import java.util.List;

import parser.Body;
import env.Env;
import lexer.*;

public class Calc {
	/**
	 * @param args
	 *            - arg[0] is the filename of the file to interpret.
	 */
	public static void main(String[] args) {
		try {
			Env<Integer> envVar = new Env<Integer>();
			SLexer.init(args[0]); // initialisation du "lexer"
			//Expression exp = Expression.parseExpression(SLexer.getToken()); // reconnaissance
																			// d'une
																			// expression
			Body body = new Body();
			body.parse();
			System.out.println(body.eval(envVar)); // affichage de l'arbre de syntaxe
											// abstrait
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package calc;

import java.util.List;

import env.Env;
import parser.Expression;
import lexer.Lexer;
import lexer.SLexer;
import lexer.Token;

public class TestLexer {

	public static void main(String[] args) {
		List<Token> tokens;
		try {
			Lexer lexer = new Lexer(args[0]);
			tokens = lexer.lex();
			// output of the result
			for (Token token : tokens) {
				System.out.println(token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package lexer;

import java.io.File;
import java.io.IOException;

public class SLexer {
	private static Lexer lex;
	
	public static void init(String filename) throws UnexpectedCharacter, IOException {
		SLexer.lex = new Lexer(filename);
	}
	
	public static Token getToken() throws UnexpectedCharacter, IOException {
		return SLexer.lex.getToken();
		
	}
}

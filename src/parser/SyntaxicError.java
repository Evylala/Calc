package parser;

public class SyntaxicError extends Exception {
	public SyntaxicError(String s) {
		super("error: unexpected syntax : " + s );
	}
}

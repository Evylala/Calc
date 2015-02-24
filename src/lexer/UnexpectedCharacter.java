package lexer;

public class UnexpectedCharacter extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnexpectedCharacter(int i) {
		super("error: unexpected character : ascii " + i + " - " + (char) i);
	}

}

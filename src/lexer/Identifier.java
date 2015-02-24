package lexer;

class VIdentifier {
	private String s;

	public VIdentifier(String s) {
		this.s = s;
	}

	public String toString() {
		return s;
	}
};

public class Identifier extends Token {
	private VIdentifier value;

	public Identifier(VIdentifier value) {
		this.value = value;
	}

	public String toString() {
		return "IDENTIFIER(" + value.toString() + ")";
	}
}

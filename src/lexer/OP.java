package lexer;

class VOp {
	private String c;

	public VOp(String c) {
		this.c = c;
	}

	public VOp(int i) {
		this.c = Character.toString((char) i);
	}

	public String toString() {
		return c;
	}
};

public class OP extends Token {
	private VOp value;

	public OP(VOp value) {
		this.value = value;
	}

	public String toString() {
		return "OP(" + value.toString() + ")";
	}
}

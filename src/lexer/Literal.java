package lexer;

class VLiteral {
	private String l;

	public VLiteral(String l) {
		this.l = l;
	}

	public VLiteral(int i) {
		this.l = Character.toString((char) i);
	}

	public String toString() {
		return l;
	}
};

public class Literal extends Token {
	private VLiteral value;

	public Literal(VLiteral value) {
		this.value = value;
	}

	/*public String toString() {
		return "LITERAL(" + value.toString() + ")";
	}*/
	
	public String toString() {
		return ""+this.value;
	}
}

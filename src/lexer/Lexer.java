package lexer;

import java.util.*;
import java.io.*;

public class Lexer {
	private FileReader in;
	private int i; // Current ASCII character

	public Lexer(String filename) throws UnexpectedCharacter, IOException {
		File file = new File(filename);
		try {
			in = new FileReader(file);
			i=in.read();
		} catch (FileNotFoundException e) {
			System.err.println("error: file \"" + filename + "\" not found");
			throw e;
		} catch (IOException e) {
			in.close();
			throw e;
		}
	}

	// Return the list of tokens recorded in the file
	public List<Token> lex() throws UnexpectedCharacter, IOException {
		List<Token> tokens = new ArrayList<Token>();
		try {
			Token token = getToken();

			while (!(token instanceof EOF)) {
				tokens.add(token);
				token = getToken();
			}
			tokens.add(token); // token == EOF here
		} catch (UnexpectedCharacter e) {
			in.close();
			throw e;
		} catch (IOException e) {
			in.close();
			throw e;
		}
		return tokens;
	} 
	
	public Token getToken() throws UnexpectedCharacter, IOException {
		int value;
		
		switch (i) {
			case -1:
				in.close();
				return new EOF();
	
			case '(':
				i=in.read();
				return new LPar();
			case ')':
				i=in.read();
				return new RPar();
	
			case '+':
			case '-':
			case '/':
			case '*':
			case '<':
				value = i;
				i=in.read();
				return new OP(new VOp(value));

			case ' ':
			case '\n':
			case '\r':
			case '\t':
				i=in.read();
				return getToken();
				
			default:
				return gestionMots();
		}
	}
	
	//returns the token : identifier, literal or equal
	private Token gestionMots() throws UnexpectedCharacter, IOException {

		TypeToken type;
		String mot = "";

		if (i >= 'A' && i <= 'z') {
			type = TypeToken.IDENTIFIER;
		} else if (i >= '0' && i <= '9') {
			type = TypeToken.LITERAL; 
		} else if (i == '=') {
			type = TypeToken.EQUAL;
		} else {
			throw new UnexpectedCharacter(i);
		}
		Set<Integer> caracDeControle = new HashSet<Integer>(Arrays.asList((int) ' ',
				(int) '\n', (int) '\t', (int) '\r', -1));
		while (!caracDeControle.contains(i)) {
			if ((type == TypeToken.IDENTIFIER && ((i >= 'A' && i <= 'z') || (i >= '0' && i <= '9')))
					|| (type == TypeToken.LITERAL && (i >= '0' && i <= '9'))
					|| (type == TypeToken.EQUAL && i == '=' && mot.length() < 2)) {
				mot = mot + (char) i;
				i=in.read();
			} else {
				break;
			}
		}
		
		switch (type) {
			case IDENTIFIER:
				if (mot.equals("if")) {
					return new If();
				} else if (mot.equals("define")) {
					return new Define();
				} else {
					return new Identifier(new VIdentifier(mot));
				}
			case LITERAL:
				if (mot.charAt(0)!='0' || (mot.length()==1 && (mot.charAt(0) == '0'))) {
					return new Literal(new VLiteral(mot));
				} else {
					throw new UnexpectedCharacter(0);
				}
			case EQUAL:
				if (mot.equals("=")) {
					return new Equal();
				} else if (mot.equals("==")) {
					return new OP(new VOp("=="));
				}
			default:
				return null;
		}
	}
}

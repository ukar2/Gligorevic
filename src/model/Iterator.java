package model;

import java.util.*;

public class Iterator {
	private Hashtable<String, String> codeTable = new Hashtable<String, String>();

	public Iterator(BinTree tree) {
		processCodeTable(tree, new String(), new String());
	}

	private void processCodeTable(BinTree tree, String code, String kante) {
		StringBuilder letter_code = new StringBuilder(code);
		letter_code.append(kante);

		if (!tree.isEmpty()) {
			verarbeite(tree, letter_code.toString());
			processCodeTable(tree.getLeft(), letter_code.toString(), "0");
			processCodeTable(tree.getRight(), letter_code.toString(), "1");
		}

	}

	private void verarbeite(BinTree tree, String letter_code) {
		if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) {
			codeTable.put(tree.getRootLetter(), letter_code);
		}

	}

	public Hashtable<String, String> getCodeTable() {
		return this.codeTable;
	}

	public String getLetterCode(String letter) throws NoSuchElementException {
		if (codeTable.containsKey(letter)) {
			return codeTable.get(letter);
		} else {
			throw new NoSuchElementException("'" + letter + "'" + " is not known key.");
		}
	}

}
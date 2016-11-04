package controls;

import model.*;


public class HuffmanControl {
	
	public void control(){
		HuffmanTree htree = new HuffmanTree("Bananen");
		BinTree tree = htree.getHuffmanTree();
		Iterator iter = new Iterator(tree);
		
		System.out.println(iter.getLetterCode("e"));
	}

}

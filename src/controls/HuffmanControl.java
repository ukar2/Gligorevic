package controls;

import model.*;


public class HuffmanControl {
	Orb control = null;
	
	public HuffmanControl(Orb control){
		this.control = control;
	}
	
	public void control(){
		HuffmanTree htree = new HuffmanTree("Bananen");
		//BinTree tree = htree.getHuffmanTree();
		Iterator iter = new Iterator(htree.getHuffmanTree());
		
		System.out.println(iter.getLetterCode("e"));
	}

}

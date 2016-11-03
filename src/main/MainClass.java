package main;

import gui.*;
import controls.*;
import model.*;


public class MainClass {

	public static void main(String[] args) {
		//MainWorkingFrame mwf = new MainWorkingFrame();
		//mwf.setVisible(true);
		
		Huffmann hfmn = new Huffmann();
		BinTree tree;
		Iterator it = new Iterator();
		try{
		tree = hfmn.getHuffmannTree("Tecehetyrenadesjatnitca");
		it.findLetter(tree, "c");
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
	}

}

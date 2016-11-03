package model;

public class Iterator {
	
	public void findLetter(BinTree tree, String letter){
		if(tree.isEmpty()){
			System.out.println("The tree is empty.");
		}else{
			if(tree.getRootLetter().equals(letter)){
				System.out.println("Letter is find. " + tree.getRootLetter());
			}else{
				findLetter(tree.getLeft(), letter);
				findLetter(tree.getRight(), letter);
			}
		}
	}

}

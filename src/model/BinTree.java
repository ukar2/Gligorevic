package model;

public class BinTree {
	private Node root;
	
	public BinTree(){
		this.root = null;
	}
	
	public BinTree(Node node){
		this.root = node;
	}
	
	public Node traversieren(){
		getleft(root);
		getright(root);
		
		
		return null;
	}
	
	void getleft(Node iterator){
		if(iterator == iterator.getLeft()){
			//System.out.println(iterator.getLetter() + " " + iterator.getWeight());
		}else{
			iterator = iterator.getLeft();
			getleft(iterator);
			getright(iterator);
		}
	}
	
	void getright(Node iterator){
		if(iterator == iterator.getRight()){
			//System.out.println(iterator.getLetter() + " " + iterator.getWeight());
		}else{
			iterator = iterator.getRight();
			getleft(iterator);
			getright(iterator);
		}
	}

}

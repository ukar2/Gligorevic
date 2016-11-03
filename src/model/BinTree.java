package model;

import java.util.NoSuchElementException;

public class BinTree {
	private Node root;
	
	public BinTree(){
		this.root = null;
	}
	
	public BinTree(BinTree tree){
		this.root = tree.root;
	}
	
	public BinTree(BinTree left, String letter, Float weight, BinTree right){
		this.root = new Node(left.root, letter, weight, right.root);
	}
	
	public Float getRootWeight() throws NoSuchElementException{
		if(root == null){
			throw new NoSuchElementException("The root is empty and has no elements");
		}else{
			return this.root.getWeight();
		}
	}
	
	public String getRootLetter() throws NoSuchElementException{
		if(root == null){
			throw new NoSuchElementException("The root is empty. Empty root dont have any elemens");
		}else{
			return this.root.getLetter();
		}
	}
	
	public void countRootWeight() throws NoSuchElementException{
		if(root == null){
			throw new NoSuchElementException("The root is empty");
		}else{
			this.root.countWeight();
		}
	}
	
	public void setRootLetter(String letter){
		if(root == null){
			throw new NoSuchElementException("The root is empty. Setting letter is not posible");
		}else{
			this.root.setLetter(letter);
		}
	}
	
	public void setRootWeight(float weight){
		if(root == null){
			throw new NoSuchElementException("The root is empty. Setting weight is not posible");
		}else{
			this.root.setWeight(weight);
		}
	}
	
	
	public BinTree getLeft(){
		BinTree tree = new BinTree();
		tree.root = this.root.getLeft();
		return tree;
	}
	
	public BinTree getRight(){
		BinTree tree = new BinTree();
		tree.root = this.root.getRight();
		return tree;
	}
	
	public boolean isEmpty(){
		return this.root == null;
	}

}

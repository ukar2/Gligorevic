package model;

public class Node {
	private String letter;
	private Float weight;
	
	private Node left;
	private Node right;
	
	public Node(){
		this.left = null;
		this.letter = new String("");
		this.right = null;
		this.weight = 0.0f;
		
	}
	
	public Node(String letters, Float weight){
		this.letter = new String(letters);
		this.weight = weight;
		this.left = null;
		this.right = null;
		
	}
	
	public Node(Node left, Node right){
		this.left = left;
		this.right = right;
		this.letter = "";
		this.weight = 0.0f;
	}
	
	public Node(Node left, String letter, Float weight, Node right){
		this.left = left;
		this.letter = letter;
		this.right = right;
		this.weight = weight;
	}
	
	public String getLetter(){
		return this.letter;
	}
	
	public void setLetter(String letter){
		this.letter = letter;
	}
	
	public void countWeight(){
		this.weight++;
	}
	
	public Float getWeight(){
		return this.weight;
	}
	
	public void setWeight(float weight){
		this.weight = weight;
	}
	
	public Node getLeft(){
		return this.left;
	}
	
	public Node getRight(){
		return this.right;
	}
	
	
	@Override
	public Object clone(){
		return new Node(this.left, this.letter, this.weight, this.right);
	}
		

}

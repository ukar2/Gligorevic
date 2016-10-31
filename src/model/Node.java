package model;

public class Node {
	private String letter = "";
	private Float weight = 0.0f;
	
	private Node left = null;
	private Node right = null;
	
	public Node(String letters, Float weight){
		this.letter = letters;
		this.weight = weight;
		
	}
	
	public Node(Node left, Node right){
		this.left = left;
		this.right = right;
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

}

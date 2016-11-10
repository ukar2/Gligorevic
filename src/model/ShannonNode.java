package model;


public class ShannonNode {
	private Float weight;
	private Float kumWeight;
	private String letter;
	private Integer lenght;
	
	public ShannonNode(Float weight, String letter){
		this.weight = weight;
		this.letter = letter;
		
	}
	
	public void incrementWeight(){
		this.weight++;
	}
	
	public Float getWeight(){
		return this.weight;
	}
	
	public Float getKumWeight(){
		return this.kumWeight;
	}
	
	public Integer getLenght(){
		return this.lenght;
	}
	
	public String getLetter(){
		return this.letter;
	}
	
	@Override
	public String toString(){
		return this.letter + " = " + this.weight;
	}
	
}

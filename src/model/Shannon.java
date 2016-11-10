package model;

import java.util.*;


public class Shannon {
	
	public List<ShannonNode> getListOfBillets(String input){
		char[] ch_input = input.toCharArray();
		List<ShannonNode> billets = new ArrayList<ShannonNode>();
		
		for(int i = 0; i < ch_input.length; i++){
			if(!increaseWeightOfMultipleOccur(billets, ch_input[i], billets.size())){
				Character temp = ch_input[i];
				billets.add(new ShannonNode(1.0f, temp.toString()));
			}
		}
		return billets;
	}
	
	
	private boolean increaseWeightOfMultipleOccur(List<ShannonNode> billets, Character letter, int size){
		for(int i = 0; i < size; i++){
			ShannonNode temp = billets.get(i);
			if(temp.getLetter().equals(letter.toString())){
				billets.get(i).incrementWeight();
				return true;
			}
		}
		
		return false;
	}
	
	void probe(String input){
		float temp;
		float rest;
		int echter_temp;
		String bin = "";
		float dez = 0.85f;
		
		
		
		
		for(int i = 0; i < 3; i++){
			temp = dez * 2;
			rest = temp % 1;
			dez = rest;
			echter_temp = (int)temp;
			bin = bin + echter_temp;
			
		}
		
		System.out.println(bin);
	}

}

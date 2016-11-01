package controls;

import java.util.*;
import model.*;

public class Huffmann {
	private Float size = 0.0f;
	//List<Node> billets = new ArrayList<Node>();

	/**
	 * zerlegt den Text in Buchstaben, zaehlt deren Haufigket und fügt diese
	 * Daten in die Liste
	 * 
	 * */
	private List<Node> getBilletsForTree(String user_input) {
		Character letter = null;
		String letters = new String("");
		char[] ch_user_input = user_input.toCharArray();
		List<Node> billets = new ArrayList<Node>();

		size = (float) ch_user_input.length;

		for (int j = 0; j < ch_user_input.length; j++) {
			letter = ch_user_input[j];
			letters = letter.toString();

			if (!suche_letter_in_Liste_und_erhohe_gewicht_wenn_gefunden(billets,
					letters, billets.size())) {
				billets.add(new Node(letters, 1.0f));
			}

		}
		
		return billets;

	}

	private boolean suche_letter_in_Liste_und_erhohe_gewicht_wenn_gefunden(List<Node> billets,
			String letters, int billet_size) {
		for (int i = 0; i < billet_size; i++) {
			if (billets.get(i).getLetter().equals(letters)) {
				billets.get(i).countWeight();
				return true;
			}
		}

		return false;

	}

	private void calculate_statistics(int billet_size, List<Node> billets) {
		Float weight = 1.0f;

		for (int i = 0; i < billet_size; i++) {
			weight = billets.get(i).getWeight() / size;
			billets.get(i).setWeight(weight);

		}

	}
	
	
	private List<Node> getSortedBillets(List<Node> unsorted_billets, int size){
		List<Node> sorted_billets = new ArrayList<Node>();
		
		for(Node node : unsorted_billets){
			sorted_billets.add((Node)node.clone());
		}
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < (size - 1); j++){
				if(sorted_billets.get(j).getWeight() > sorted_billets.get(j+1).getWeight()){
					Node node = sorted_billets.remove(j);
					sorted_billets.add(j + 1, node);
					
				}
			}
		}
		
		return sorted_billets;
		
	}
	
	
	List<Node> getStepToTree(List<Node> sorted_billets){
		
		Node n1 = null;
		Node n2 = null;
		Node wurzel = null;
		List<Node> unsorted_billets = new ArrayList<Node>();
		
		n1 = sorted_billets.remove(0);
		n2 = sorted_billets.remove(0);
		
		wurzel = new Node(n1, n2);
		wurzel.setLetter(n1.getLetter() + n2.getLetter());
		wurzel.setWeight(n1.getWeight() + n2.getWeight());
		
		sorted_billets.add(wurzel);
		
		for(Node node : sorted_billets){
			unsorted_billets.add((Node)node.clone());
		}
		
		
		return unsorted_billets;
	}
	

	public void dieFunktion(String input) throws IndexOutOfBoundsException{
		Node n = null;
		BinTree tree = null;
		List<Node> unsorted_billets = null;
		List<Node> sorted_billets = null;
		
		
		unsorted_billets = getBilletsForTree(input);
		calculate_statistics(unsorted_billets.size(), unsorted_billets);
		sorted_billets = getSortedBillets(unsorted_billets, unsorted_billets.size());
		
		while(sorted_billets.size() > 1){
			unsorted_billets.clear();
			unsorted_billets = getStepToTree(sorted_billets);
			
			sorted_billets.clear();
			sorted_billets = getSortedBillets(unsorted_billets, unsorted_billets.size());
		}
		
		tree = new BinTree(sorted_billets.get(0));
		
		System.out.println("sorted");
		for (int i = 0; i < sorted_billets.size(); i++) {
			n = sorted_billets.get(i);
			System.out.println(n.getLetter() + " = " + n.getWeight());

		}

		System.out.println(sorted_billets.size());

	}

}

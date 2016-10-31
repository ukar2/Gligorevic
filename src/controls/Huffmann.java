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
	
	
	private List<Node> getSortedBillets(int billet_size, List<Node> unsorted){
		Float weight = 0.0f;
		String letter = "";
		
		for(int i = 0; i < billet_size; i++){
			for(int j = 0; j < (billet_size - 1); j++){
				if(unsorted.get(j).getWeight() > unsorted.get(j+1).getWeight()){
					letter = unsorted.get(j).getLetter();
					weight = unsorted.get(j).getWeight();
					
					unsorted.get(j).setLetter(unsorted.get(j+1).getLetter());
					unsorted.get(j).setWeight(unsorted.get(j+1).getWeight());
					
					unsorted.get(j+1).setLetter(letter);
					unsorted.get(j+1).setWeight(weight);
				}
			}
		}
		
		return unsorted;
		
	}
	
	
	List<Node> mache_baum(List<Node> billets) throws IndexOutOfBoundsException{
		Node added = null;
		Node first = billets.get(0);
		Node second = billets.get(1);
		
		if(first.getWeight() < second.getWeight()){
			added = new Node(first, second);
			added.setLetter(first.getLetter() + second.getLetter());
		}else{
			added = new Node(second, first);
			added.setLetter(second.getLetter() + first.getLetter());
		}
		
		added.setWeight(first.getWeight() + second.getWeight());
		
		
			billets.remove(0);
			billets.remove(0);
			billets.add(added);
		
		
		
		return billets;
		
	}
	

	public void dieFunktion(String input) throws IndexOutOfBoundsException{
		Node n = null;
		List<Node> unsorted = null;
		List<Node> sorted = null;
		BinTree tree = null;

		unsorted = getBilletsForTree(input);
		calculate_statistics(unsorted.size(), unsorted);
		sorted = getSortedBillets(unsorted.size(), unsorted);
		
		// jetzt darf ich Baum bauen
		while(unsorted.size() >= 2){
			
			
		}
		
		unsorted = mache_baum(sorted);
		
		//tree = new BinTree(unsorted.get(0));
		//unsorted.clear();
		//sorted.clear();
		
		// Baum trewersieren
		//tree.traversieren();
		
		for (int i = 0; i < unsorted.size(); i++) {
			n = unsorted.get(i);
			System.out.println(n.getLetter() + " = " + n.getWeight());

		}

		System.out.println(sorted.size());

	}

}

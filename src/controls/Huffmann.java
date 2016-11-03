package controls;

import java.util.*;
import model.*;

public class Huffmann {
	private Float size = 0.0f;
	//List<Node> billets = new ArrayList<Node>();

	/**
	 * zerlegt den Text in Buchstaben, zaehlt deren Haufigket und f�gt diese
	 * Daten in die Liste
	 * 
	 * */
	private List<BinTree> getBilletsForTree(String user_input) {
		Character letter = null;
		String letters = new String("");
		char[] ch_user_input = user_input.toCharArray();
		List<BinTree> billets = new ArrayList<BinTree>();

		size = (float) ch_user_input.length;

		for (int j = 0; j < ch_user_input.length; j++) {
			letter = ch_user_input[j];
			letters = letter.toString();

			if (!suche_letter_in_Liste_und_erhohe_gewicht_wenn_gefunden(billets, letters, billets.size())) {
				billets.add(new BinTree(new BinTree(), letters, 1.0f, new BinTree()));
			}

		}
		
		return billets;

	}

	private boolean suche_letter_in_Liste_und_erhohe_gewicht_wenn_gefunden(List<BinTree> billets,
			String letters, int billet_size) {
		for (int i = 0; i < billet_size; i++) {
			if (billets.get(i).getRootLetter().equals(letters)) {
				billets.get(i).countRootWeight();
				return true;
			}
		}

		return false;

	}

	private void calculate_statistics(int billet_size, List<BinTree> billets) {
		Float weight = 1.0f;

		for (int i = 0; i < billet_size; i++) {
			weight = billets.get(i).getRootWeight() / size;
			billets.get(i).setRootWeight(weight);

		}

	}
	
	
	private List<BinTree> getSortedBillets(List<BinTree> unsorted_billets, int size){
		List<BinTree> sorted_billets = new ArrayList<BinTree>();
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < (size - 1); j++){
				if(unsorted_billets.get(j).getRootWeight() > unsorted_billets.get(j+1).getRootWeight()){
					BinTree temp = unsorted_billets.remove(j);
					unsorted_billets.add(j + 1, temp);
					
				}
			}
		}
		
		while(!unsorted_billets.isEmpty()){
			sorted_billets.add(unsorted_billets.remove(0));
		}
		
		return sorted_billets;
		
	}
	
	
	List<BinTree> getStepToTree(List<BinTree> sorted_billets){
		
		BinTree t1 = sorted_billets.remove(0);
		BinTree t2 = sorted_billets.remove(0);
		BinTree tree = new BinTree(t1, t1.getRootLetter() + t2.getRootLetter(),
				t1.getRootWeight() + t2.getRootWeight(), t2);
		List<BinTree> unsorted_billets = new ArrayList<BinTree>();
		
		
		sorted_billets.add(tree);
		
		while(!sorted_billets.isEmpty()){
			unsorted_billets.add(sorted_billets.remove(0));
		}
		
		
		return unsorted_billets;
	}
	

	public BinTree getHuffmannTree(String input) throws IndexOutOfBoundsException{
		
		BinTree tree = null;
		List<BinTree> unsorted_billets = null;
		List<BinTree> sorted_billets = null;
		
		
		unsorted_billets = getBilletsForTree(input);
		calculate_statistics(unsorted_billets.size(), unsorted_billets);
		sorted_billets = getSortedBillets(unsorted_billets, unsorted_billets.size());
		
		while(sorted_billets.size() > 1){
			// unsorted_billets.clear();
			unsorted_billets = getStepToTree(sorted_billets);
			
			// sorted_billets.clear();
			sorted_billets = getSortedBillets(unsorted_billets, unsorted_billets.size());
		}
		
		tree = new BinTree(sorted_billets.remove(0));
		
		return tree;

	}

}

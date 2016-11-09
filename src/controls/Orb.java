package controls;

import gui.*;
import model.*;
import java.util.Hashtable;
import java.awt.event.*;

/*
 * TODO:
 * 1. Andere Arten von Komprimiren emplementieren
 * 2. im menu oben, das Verhalten auswahlbar machen (dazu hier Interfaces?)
 */
public class Orb {
	StringBuilder output = new StringBuilder();
	MainWorkingFrame frame = new MainWorkingFrame(this);
	HuffmanControl comp = new HuffmanControl(this);
	String input = "";
	char[] ch_input = null;
	Hashtable<Integer, String> ascii = new Hashtable<Integer, String>();
	
	public Orb(){
		initializeASCIIcodeTable();
	}
	
	void initializeASCIIcodeTable(){
		ascii.put(33, "00100001");
		ascii.put(34, "00100010");
		ascii.put(35, "00100011");
		ascii.put(36, "00100100");
		ascii.put(37, "00100101");
		ascii.put(38, "00100110");
		ascii.put(39, "00100111");
		ascii.put(40, "00101000");
		ascii.put(41, "00101001");
		ascii.put(42, "00101010");
		ascii.put(43, "00101011");
		ascii.put(44, "00101100");
		ascii.put(45, "00101101");
		ascii.put(46, "00101110");
		ascii.put(47, "00101111");
		ascii.put(48, "00110000");
		ascii.put(49, "00110001");
		ascii.put(50, "00110010");
		ascii.put(51, "00110011");
		ascii.put(52, "00110100");
		ascii.put(53, "00110101");
		ascii.put(54, "00110110");
		ascii.put(55, "00110111");
		ascii.put(56, "00111000");
		ascii.put(57, "00111001");
		ascii.put(58, "00111010");
		ascii.put(59, "00111011");
		ascii.put(60, "00111100");
		ascii.put(61, "00111101");
		ascii.put(62, "00111110");
		ascii.put(63, "00111111");
		ascii.put(64, "01000000");
		ascii.put(65, "01000001");
		ascii.put(66, "01000010");
		ascii.put(67, "01000011");
		ascii.put(68, "01000100");
		ascii.put(69, "01000101");
		ascii.put(70, "01000110");
		ascii.put(71, "01000111");
		ascii.put(72, "01001000");
		ascii.put(73, "01001001");
		ascii.put(74, "01001010");
		ascii.put(75, "01001011");
		ascii.put(76, "01001100");
		ascii.put(77, "01001101");
		ascii.put(78, "01001110");
		ascii.put(79, "01001111");
		ascii.put(80, "01010000");
		ascii.put(81, "01010001");
		ascii.put(82, "01010010");
		ascii.put(83, "01010011");
		ascii.put(84, "01010100");
		ascii.put(85, "01010101");
		ascii.put(86, "01010110");
		ascii.put(87, "01010111");
		ascii.put(88, "01011000");
		ascii.put(89, "01011001");
		ascii.put(90, "01011010");
		ascii.put(91, "01011011");
		ascii.put(92, "01011100");
		ascii.put(93, "01011101");
		ascii.put(94, "01011110");
		ascii.put(95, "01011111");
		ascii.put(96, "01100000");
		ascii.put(97, "01100001");
		ascii.put(98, "01100010");
		ascii.put(99, "01100011");
		ascii.put(100, "01100100");
		ascii.put(101, "01100101");
		ascii.put(102, "01100110");
		ascii.put(103, "01100111");
		ascii.put(104, "01101000");
		ascii.put(105, "0110001");
		ascii.put(106, "01101010");
		ascii.put(107, "01101011");
		ascii.put(108, "01101100");
		ascii.put(109, "01101101");
		ascii.put(110, "01101110");
		ascii.put(111, "01101111");
		ascii.put(112, "01110000");
		ascii.put(113, "01110001");
		ascii.put(114, "01110010");
		ascii.put(115, "01110011");
		ascii.put(116, "01110100");
		ascii.put(117, "01110101");
		ascii.put(118, "01110110");
		ascii.put(119, "01110111");
		ascii.put(120, "01111000");
		ascii.put(121, "01111001");
		ascii.put(122, "01111010");
		ascii.put(123, "01111011");
		ascii.put(124, "01111100");
		ascii.put(125, "01111101");
	}
	
	public void start(){
		frame.setVisible(true);
	}
	
	public void takeInputToControl(String input){
		this.input = input;
		this.ch_input = this.input.toCharArray();
		
	}
	
	public String getASCIIText(){
		StringBuilder ascii_string = new StringBuilder();
		
		for(char c : ch_input){
			int idx = (int)c;
			ascii_string.append(ascii.get(idx));
		}
		return ascii_string.toString();
	}
	
	public String getHuffmanCode(){
		HuffmanTree htree = new HuffmanTree(input);
		Iterator iter = new Iterator(htree.getHuffmanTree());
		Hashtable<String, String> table = iter.getCodeTable();
		Character[] ch = new Character[ch_input.length];
		for(int i = 0; i < ch_input.length; i++){
			ch[i] = ch_input[i];
			output.append(table.get(ch[i].toString()));
		}
		return output.toString();
	}
	
	
	public void setMenuItemActionEvent(ActionEvent e){
		if(e.getActionCommand() == "Huffman"){
			System.out.println("Huffman gewaehlt");
		}else if(e.getActionCommand() == "Hoffmann"){
			System.out.println("Hoffmann gewaehlt");
		}else if(e.getActionCommand() == "Hoffmann"){
			System.out.println("Hoffmann gewaehlt");
		}else{
			System.out.println("null gewaehlt");
		}
	}

}

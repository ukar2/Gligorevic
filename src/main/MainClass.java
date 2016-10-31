package main;

import gui.*;
import controls.*;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		//MainWorkingFrame mwf = new MainWorkingFrame();
		//mwf.setVisible(true);
		
		Huffmann hfmn = new Huffmann();
		try{
		hfmn.dieFunktion("Tecehetyrenadesjatnitca");
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		
	}

}

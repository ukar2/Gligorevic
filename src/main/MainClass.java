package main;

import controls.*;
import model.*;

public class MainClass {

	public static void main(String[] args) {
		//Orb control = new Orb();
		//control.start();
		
		Shannon sh = new Shannon();
		System.out.println(sh.getListOfBillets("Bananen"));

	}

}

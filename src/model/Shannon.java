package model;

public class Shannon {
	
	void probe(){
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

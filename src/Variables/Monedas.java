package Variables;

import java.util.ArrayList;

public enum Monedas {
	dólar(18.11,"$"), euros(19.26, "€"), libra(21.73, "£"), yen(0.13, "¥"), won(0.014, "₩");
	
	ArrayList<String> prueba = new ArrayList<>();
	
	public double enPesos;
	public String simbolo;
	
	Monedas(double p, String s) {
		enPesos = p;
		simbolo = s;
	}
	
	
	public String[] getMenuDivisas() {
		if(prueba.size() < Monedas.values().length*2) {
			for(int size = 0; size < Monedas.values().length*2;size++) {
				
				if(size < Monedas.values().length) {
					if(Monedas.values()[size].name() == "libra") {
						prueba.add(" - Convertir pesos mxn a libras esterlinas");
					}else {
						prueba.add(" - Convertir pesos mxn a " + Monedas.values()[size]);
					}
				}else {
				
					if(Monedas.values()[size - Monedas.values().length].name() == "libra") {
						prueba.add(" - Convertir libras esterlinas a pesos mxn");
					}else {
						prueba.add(" - Convertir " + Monedas.values()[size - Monedas.values().length] + " a pesos mxn");
					}
				}
				//System.out.println(prueba.get(size));			
			}
		}
		
		String[] finalMenu = prueba.toArray(new String[0]);
		return finalMenu;
	}
	
	

}

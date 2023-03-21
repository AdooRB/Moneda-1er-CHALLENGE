package Variables;

import java.util.ArrayList;

public enum Temperaturas {
	Celsius,Kelvin,Fahrenheit;
	
	ArrayList<String> menu = new ArrayList<>();
	String[] menuFinal;
	
	public String[] getMenuTemp() {
		if(menu.size() < (Temperaturas.values().length*Temperaturas.values().length)-Temperaturas.values().length) {
			int indexPrincipal = 0;
			for(int index = 0; index < Temperaturas.values().length; index++) {
				
				if( indexPrincipal != index) {
					menu.add("-  Convertir " + Temperaturas.values()[indexPrincipal] + " a " + Temperaturas.values()[index] + ".");
				}
				
				if(index == Temperaturas.values().length-1 && indexPrincipal != index) {
					indexPrincipal++;
					index = -1;
				}
			}
			menuFinal = menu.toArray(new String[0]);
		}
		
		//System.out.println(menu);
		return menuFinal;
	}
}

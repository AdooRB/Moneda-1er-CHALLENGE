package Variables;
import java.util.ArrayList;

public enum Medidas {
	metro(1," m."), pies(0.3048," ft."), pulgada(0.0254," in."), yarda(0.9144," yd."), milla(1609.34," mi.");

	public String unidad;
	public double enMetros;
	
	ArrayList<String> menu = new ArrayList<>();
	String[] menuFinal;
	
	Medidas(double m, String u){
		unidad = u;
		enMetros = m;
	}
	
	public String[] getMenuMedidas() {
		if(menu.size() < (Medidas.values().length-1)*2) {

			for(int index = 1; index <= (Medidas.values().length - 1) * 2; index++) {
				
				if(index <= Medidas.values().length - 1) {
					menu.add("-  Convertir " + Medidas.values()[0] + " a " + Medidas.values()[index] + ".");
				
				}else {
					menu.add("-  Convertir " + Medidas.values()[index - Medidas.values().length + 1] + " a " + Medidas.values()[0] + ".");
				}

				//System.out.println(menu);
				//System.out.println("index = "+index);
				//System.out.println(menu.size());
			}
			//System.out.println(menu);
			menuFinal = menu.toArray(new String[0]);
		}
		return menuFinal;
	}
}

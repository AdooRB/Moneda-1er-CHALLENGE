import javax.swing.JOptionPane;

import Variables.Medidas;

public class menuMedidas extends conTipo {
	
	private String[] menuMed = Medidas.metro.getMenuMedidas();
	private int indexBreak;
	
	menuMedidas(String conversion) {
		super(conversion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void iniciarInterfaz() {
		this.opcionSeleccionado = (String) JOptionPane.showInputDialog(null,"Elije la medición a convertir","Menu de mediciones",JOptionPane.PLAIN_MESSAGE,null,menuMed,menuMed[0]);
				
		if(this.opcionSeleccionado != null) {
			
			iniciarCalculo();
			
			ingresarDatos interfazInpDatos = new ingresarDatos(this.getTipo());
			
			interfazInpDatos.iniciarInterfaz();
			
			
			new Calculos(this.indexBreak, interfazInpDatos.getIngreso(),this.getTipo());
			
		}else {
			String mensaje = "Regresando al Menú de Conversiones";
			new anuncio(mensaje,"anuncio");
			new menuInicial();
			
			//String mensaje = "Ha elegido salir del programa";
			//new anuncio(mensaje,"error");
		}
		
		
	}
	
	private void iniciarCalculo() {
		
		for(int index = 0;index < menuMed.length;index++) {
			if(this.opcionSeleccionado == menuMed[index]) {
				indexBreak = index;
				break;
			}
		}
		//System.out.println(indexBreak);
	}

}

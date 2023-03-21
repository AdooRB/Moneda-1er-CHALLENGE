import javax.swing.JOptionPane;

import Variables.Temperaturas;

public class menuTemperaturas extends conTipo {

	private String[] menuTemp = Temperaturas.Celsius.getMenuTemp();
	private int indexBreak;
	
	menuTemperaturas(String conversion) {
		super(conversion);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void iniciarInterfaz() {
		this.opcionSeleccionado = (String) JOptionPane.showInputDialog(null,"Elije la temperatura a la que deseas convertir","Menu",JOptionPane.PLAIN_MESSAGE,null,menuTemp,menuTemp[0]);
		
		if(this.opcionSeleccionado != null) {
			iniciarCalculo();
			
			ingresarDatos interfazInpDatos = new ingresarDatos(this.getTipo());
			interfazInpDatos.iniciarInterfaz();
			
			new Calculos(this.indexBreak, interfazInpDatos.getIngreso(),this.getTipo());
		}else {
			String mensaje = "Ha elegido regresar al Menú de Conversiones";
			new anuncio(mensaje,"anuncio");
			new menuInicial();
			
			//String mensaje = "Ha elegido salir del programa";
			//new anuncio(mensaje,"error");
		}
		
	}
	
	private void iniciarCalculo() {
		for(int index = 0;index < menuTemp.length;index++) {
			if(this.opcionSeleccionado == menuTemp[index]) {
				indexBreak = index;
				break;
			}
		}
		//System.out.println(indexBreak);
	}
	
	public int getIndex() {
		return this.indexBreak;
	}
}

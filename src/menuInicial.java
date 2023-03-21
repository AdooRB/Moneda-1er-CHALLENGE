import javax.swing.JOptionPane;

public class menuInicial extends seleccionable {
	
	private final String[] opcionesConvercion = {"Conversión de Moneda","Conversión de Temperatura","Conversión de Medidas"};	
	
	menuInicial(){
		this.iniciarInterfaz();
	}
	
	public void iniciarInterfaz(){
		//System.out.println(opcionesConvercion);
		this.opcionSeleccionado = (String) JOptionPane.showInputDialog(null,"Seleccione una opción de conversión","Menu",JOptionPane.PLAIN_MESSAGE,null,opcionesConvercion,opcionesConvercion[0]);
		//System.out.println(this.opcionSeleccionado);
		
		//seleccion();
		try {
			seleccion();
		} catch (NullPointerException e) {
			//e.printStackTrace();
			String mensaje = "Ha elegido salir del programa";
			new anuncio(mensaje,"error");
		}
		
		
	}
	
	private void seleccion() {
		
		switch(this.opcionSeleccionado) {
		case "Conversión de Moneda":
			//System.out.println("MONEDA");
			new menuDivisas("moneda").iniciarInterfaz();
			break;
		
		case "Conversión de Temperatura":
			//System.out.println("TEMPEARTURA");
			new menuTemperaturas("temperatura").iniciarInterfaz();
			break;
			
		case "Conversión de Medidas":
			//System.out.println("MEDIDAS");
			new menuMedidas("medida").iniciarInterfaz();
			break;
			
		}
		
	}
}


import javax.swing.JOptionPane;

import Variables.Monedas;

public class menuDivisas extends conTipo implements AutoCloseable{

	private String[] menuDiv = Monedas.euros.getMenuDivisas();
	private String inicial;
	
	menuDivisas(String conversion) {
		super(conversion);
	}
	
	@Override
	public void iniciarInterfaz() {
		this.opcionSeleccionado = (String) JOptionPane.showInputDialog(null,"Elije la moneda a la que desas convertir","Menu",JOptionPane.PLAIN_MESSAGE,null,menuDiv,menuDiv[0]);
		//System.setOut(null);
		try {
			inicialConversion();
			
			ingresarDatos interfazInpDatos = new ingresarDatos(this.getTipo());
			interfazInpDatos.iniciarInterfaz();
			
			//new CalculoDivisas(inicial, interfazInpDatos.getIngreso());
			new Calculos(inicial, interfazInpDatos.getIngreso(), this.getTipo());
			
		}catch(java.lang.NullPointerException e) {
			//e.printStackTrace();
			String mensaje = "Ha elegido regresar al Menú de Conversiones";
			new anuncio(mensaje,"anuncio");
			new menuInicial();
		}
		
		
		//System.out.println("El Resultado es: " + CalDiv.getResutado());
	}
	
	private void inicialConversion() {
		
		if(opcionSeleccionado.charAt(13) == 'p') {
			inicial = "/" + opcionSeleccionado.charAt(25);
		}else {
			inicial = "*" + opcionSeleccionado.charAt(13);
		}
		//System.out.println(inicial);
	}

	@Override
	public void close() throws Exception {
		
	}
}

	

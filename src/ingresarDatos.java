import javax.swing.JOptionPane;

public class ingresarDatos {
	
	private String ingreso;
	private String mensaje;
	
	ingresarDatos(String conversion){
		switch(conversion) {
		case "moneda":
			mensaje = "Ingresa la cantidad de dinero que deseas convertir: ";
			break;
		case "temperatura":
			mensaje = "Ingresa la temperatura que deseas convertir: ";
			break;
		}
	}
	public void iniciarInterfaz(){
		
		ingreso = (String) JOptionPane.showInputDialog(null,mensaje,"Input",JOptionPane.QUESTION_MESSAGE);
		
	}
	
	public String getIngreso() {
		return ingreso;
	}
}

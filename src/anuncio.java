import javax.swing.JOptionPane;

public class anuncio {
	
	private String mensaje;
	
	anuncio(double resultado, String legenda, String simbolo) {
		mensaje = "Tienes "+ simbolo + (double)Math.floor(resultado * 100d)/100d + legenda;
		JOptionPane.showMessageDialog(null,mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
		finalizar(true);
	}
	
	anuncio(double resultado, String parametro){
		mensaje = "Tienes "+ (double)Math.floor(resultado * 1000d)/1000d + parametro;		
		JOptionPane.showMessageDialog(null,mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
		finalizar(true);
	}
	
	anuncio(String mensajeError, String tipo){
		JOptionPane.showMessageDialog(null,mensajeError, "Resultado", JOptionPane.INFORMATION_MESSAGE);
		if(tipo == "error")
			finalizar(false);
	}
	
	private void finalizar(boolean repetir){
		int opcion;
		if(repetir == false) {
			JOptionPane.showMessageDialog(null, "Programa Terminado.", "Mensaje", 0);
		}else {
			opcion = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otra conversión?");
			if(opcion == 0){
				new menuInicial();
			}else {
				finalizar(false);
			}
		}
	}

}

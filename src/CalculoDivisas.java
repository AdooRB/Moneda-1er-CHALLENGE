import Variables.Monedas;

public class CalculoDivisas {

	private double resultado;
	
	CalculoDivisas(String iniciales, String datoIngresado) {		
		int indeXBreak = 0;
		char inicial = iniciales.charAt(1);
		String parametro;
		String simbolo;
		for(int i = 0; i < Monedas.values().length; i++) {
			if(inicial == Monedas.values()[i].name().charAt(0) ) {
				indeXBreak = i;
				break;
			}
			//System.out.println(i +"-" + indeXBreak + " " + monedasOpciones.values()[i].name());
		}
		System.out.println(indeXBreak + " " + Monedas.values()[indeXBreak].name());
		
		inicial = iniciales.charAt(0);
		
		try {
			double datoIngr = Double.parseDouble(datoIngresado);
			if(inicial == '*') {
				resultado = datoIngr * Monedas.values()[indeXBreak].enPesos;
				System.out.println("resultado " + iniciales + " = " + resultado + " pesos.");
				parametro = " mxn.";
				simbolo = "$ ";
			}else {
				resultado = datoIngr / Monedas.values()[indeXBreak].enPesos;
				System.out.println("resultado " + iniciales + " = " + resultado + " de " + Monedas.values()[indeXBreak].name());
				parametro = " .";
				if(Monedas.values()[indeXBreak].toString() == "dólar")
					parametro = " usd.";
				simbolo = Monedas.values()[indeXBreak].simbolo + " ";
			}
			
			new anuncio(resultado, parametro, simbolo);
		}catch(NullPointerException | NumberFormatException e) {
			
			int name = e.getClass().getName().substring(10).compareTo("NullPointerException");
			String mensaje;
			if(name != 0) {
				mensaje = "Error al introducir el dato.\nVuelva a incializar el programa \n e intreduce el valor numérico correctamente.";
			}else {
				mensaje = "Vuelva a iniciar el programa.";
			}
			System.out.println("DATO INGRESADO:" + datoIngresado + ".  -  " + e.getClass().getName());
			new anuncio(mensaje,"error");
		}
		
		
	}
	

}

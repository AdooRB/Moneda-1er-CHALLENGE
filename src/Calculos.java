import Variables.Medidas;
import Variables.Monedas;

public class Calculos {
	
	private double resultado;
	private String parametro = "";
	
	Calculos(int index, String datoIngresado,String tipo){
		
		try {
			double dato = Double.parseDouble(datoIngresado);
			
			if(tipo == "temperatura") {
				paraTemp(index,dato);
			}else{
				paraMedida(index,dato);
			}
			
			new anuncio(resultado, parametro);
	
		}catch(NumberFormatException | NullPointerException exp) {
			errorControl(exp,tipo);			
		}
		
		
	}
	
	Calculos(String iniciales, String datoIngresado,String tipo){
		try {
			paraDivisa(iniciales,datoIngresado);
		}catch(NumberFormatException | NullPointerException exp) {
			errorControl(exp,tipo);
		}
	}
	
	private void paraTemp(int index,double dato) {
		switch(index) {
		case 0:		// °C -> °K
			resultado = dato + 273.15;
			//System.out.println("°C -> °K = " + resultado);
			parametro = " k.";
			break;
		case 1:		// °C -> °F
			resultado = (9.0/5)*dato + 32;
			//System.out.println("°C -> °F = " + resultado);
			parametro = " °F.";
			break;
		case 2:		// °K -> °C
			resultado = dato - 273.15;
			//System.out.println("°K -> °C = " + resultado);
			parametro = " °C.";
			break;
		case 3:		// °K -> °F
			resultado = (9.0/5)*(dato - 273.15) + 32 ;
			//System.out.println("°K -> °F = " + resultado);
			parametro = " °F.";
			break;
		case 4:		// °F -> °C
			resultado = (5.0/9)*(dato - 32);
			//System.out.println("°F -> °C = " + resultado);
			parametro = " °C.";
			break;
		case 5:		// °F -> °K
			resultado = (5.0/9)*(dato - 32) + 273.15 ;
			//System.out.println("°F -> °K = " + resultado);
			parametro = " k.";
			break;
		}
	}
	
	private void paraMedida(int index,double dato) {
		switch(index) {
		case 0:		// m -> in
			resultado = dato / Medidas.pies.enMetros;
			//System.out.println("m. -> ft. = " + resultado);
			parametro = Medidas.pies.unidad;
			break;
		case 1:		// m. -> in.
			resultado = dato / Medidas.pulgada.enMetros;
			//System.out.println("m. -> in. = " + resultado);
			parametro = Medidas.pulgada.unidad;
			break;
		case 2:		// m. -> yd.
			resultado = dato / Medidas.yarda.enMetros;
			//System.out.println("m. -> yd. = " + resultado);
			parametro = Medidas.yarda.unidad;
			break;
		case 3:		// m. -> mi.
			resultado = dato / Medidas.milla.enMetros;
			//System.out.println("m. -> mi. = " + resultado);
			parametro = Medidas.milla.unidad;
			break;
		case 4:		// ft. -> m.
			resultado = dato * Medidas.pies.enMetros;
			//System.out.println("ft. -> m. = " + resultado);
			parametro = Medidas.metro.unidad;
			break;
		case 5:		// in. -> in.
			resultado = dato * Medidas.pulgada.enMetros;
			//System.out.println("in. -> m. = " + resultado);
			parametro = Medidas.metro.unidad;
			break;
		case 6:		// yd. -> m.
			resultado = dato * Medidas.yarda.enMetros;
			//System.out.println("yd. -> m. = " + resultado);
			parametro = Medidas.metro.unidad;
			break;
		case 7:		// mi. -> m.
			resultado = dato * Medidas.milla.enMetros;
			//System.out.println("mi. -> m. = " + resultado);
			parametro = Medidas.metro.unidad;
			break;
		}
	}
	
	private void paraDivisa(String iniciales, String datoIngresado) {
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
		//System.out.println(indeXBreak + " " + Monedas.values()[indeXBreak].name());
		
		inicial = iniciales.charAt(0);
		
		double datoIngr = Double.parseDouble(datoIngresado);
		if(inicial == '*') {
			resultado = datoIngr * Monedas.values()[indeXBreak].enPesos;
			//System.out.println("resultado " + iniciales + " = " + resultado + " pesos.");
			parametro = " mxn.";
			simbolo = "$ ";
		}else {
			resultado = datoIngr / Monedas.values()[indeXBreak].enPesos;
			//System.out.println("resultado " + iniciales + " = " + resultado + " de " + Monedas.values()[indeXBreak].name());
			parametro = " .";
			if(Monedas.values()[indeXBreak].toString() == "dólar")
				parametro = " usd.";
			simbolo = Monedas.values()[indeXBreak].simbolo + " ";
		}
		
		new anuncio(resultado, parametro, simbolo);
	}
	
	@SuppressWarnings("resource")
	private void regresarA(String tipo) {
		
		if(tipo == "temperatura") {
			new menuTemperaturas(tipo).iniciarInterfaz();;
		}else if(tipo == "medida") {
			new menuMedidas(tipo).iniciarInterfaz();
		}else {
			new menuDivisas(tipo).iniciarInterfaz();
		}
	}
	
	private void errorControl(Exception exp,String tipo) {
		int name = exp.getClass().getName().substring(10).compareTo("NullPointerException");
		String mensaje;
		
		if(name != 0) {
			mensaje = "Error al introducir el dato.\nVuelva a incializar el programa \n e intreduce el valor numérico correctamente.";
			new anuncio(mensaje,"error");
		}else {
			mensaje = "Regresando al menú principal";
			new anuncio(mensaje,"anuncio");
			regresarA(tipo);
		}
		//System.out.println("DATO INGRESADO:" + datoIngresado + ".  -  " + exp.getClass().getName());
	}
}

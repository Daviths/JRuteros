package junits;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class CorrerJUnits {

	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		
		Result result_actividad = junit.run(ActividadTest.class);		
		Result result_ruta = junit.run(RutaTest.class);
		Result result_usuario = junit.run(UsuarioTest.class);		
		
		String resultado = (result_actividad.wasSuccessful()) ? "OK!" : "SE ENCONTRARON ERRORES";
		System.out.println("ActividadTest - " + resultado);
		
		resultado = (result_ruta.wasSuccessful()) ? "OK!" : "SE ENCONTRARON ERRORES";
		System.out.println("RutaTest - " + resultado);
		
		resultado = (result_usuario.wasSuccessful()) ? "OK!" : "SE ENCONTRARON ERRORES";
		System.out.println("UsuarioTest - " + resultado);		
	}

}

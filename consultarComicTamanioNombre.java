package com.hbt.semillero.dto;

/**
 * <b>Descripción:<b> Clase que determina el tamaño del nombre
 * <b>Caso de Uso:<b> 
 * @author Santiago Jiménez
 * @version 1.0
 */

public class consultarComicTamanioNombre extends ResultadoDTO {
	
	// Se usa un dato tipo short como parametro
	public consultarComicTamanioNombre(short exitoso, String mensajeEjecucion"Comics procesados exitosamente") {
		super(exitoso, mensajeEjecucion);
		// TODO Auto-generated constructor stub
		
	}
	private static final long serialVersionUID = 1L;
	private String nombre;
	
	//Se traen los nombres de la base de datos Comic
	
	s1 = select.namefromComic;
	
	//Se itera la lista de Comic hasta que se supera el numero 15 
	
	short s2 = new Short((short)15); //Casting
	short s1 = new Short("15"); //Constructor
	
	System.out.println("Se evalua s1 = " + S1);
	System.out.println("Se evalua s2 = " + S2);
	
	System.out.println("Se compara s1 con s2");
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

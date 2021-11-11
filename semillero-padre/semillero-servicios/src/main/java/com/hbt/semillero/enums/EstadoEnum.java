/**
 * EstadoEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina el estado del Enum
 * <b>Caso de Uso:<b> 
 * @author Santiago Jiménez
 * @version 1.0
 */
public enum EstadoEnum {
	
	ACTIVO("enum.estado.activo"),  
	INACTIVO("enum.estado.inactivo");
	
	/**
	 * Atributo que contiene la clave del mensaje para la internacionalizacion
	 */
	private String codigoMensaje;

	/**
	 * Constructor que recibe como parametro el codigo del mensaje
	 * 
	 * @param codigoMensaje, Clave del mensaje para para internacionalizacion
	 */
	EstadoEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo que retorna el valor del atributo
	 * 
	 * @return cadena con el codigo del mensaje
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo que establece el valor del atributo
	 *
	 * @param codigoMensaje
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

}
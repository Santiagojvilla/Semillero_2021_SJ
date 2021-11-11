package com.hbt.semillero.dto;

import java.math.BigDecimal;

import com.hbt.semillero.enums.TematicaEnum;

public class ConsultarComicsDTO extends ResultadoDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Creación variables consultarComicsDTO
	private String nombre;
	private String Editorial;
	private TematicaEnum tematicaEnum;
	private String coleccion;
	private Integer numeroPaginas;
	private BigDecimal precio;
	private String autores;
	private Boolean color;
	
	public ConsultarComicsDTO() {
		//Constructor vacio
	}
	
	//Se crean Get y Sets
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEditorial() {
		return Editorial;
	}
	public void setEditorial(String editorial) {
		Editorial = editorial;
	}
	public TematicaEnum getTematicaEnum() {
		return tematicaEnum;
	}
	public void setTematicaEnum(TematicaEnum tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}
	public String getColeccion() {
		return coleccion;
	}
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public Boolean getColor() {
		return color;
	}
	public void setColor(Boolean color) {
		this.color = color;
	}
}

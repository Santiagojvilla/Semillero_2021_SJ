/**
 * CreacionComic.java
 */
package com.hbt.semillero.rest;

import org.hibernate.mapping.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina la creación de un servicio que debe devolver un commit DTO, metodo que crea un COMIC
 * <b>Caso de Uso:<b> Semillero 2021
 * @author Santiago Jiménez		
 * @version 1.1
 */


public class CreacionComicTest {
	
	// Metodo privado que verifica que los comics se encuentran activos
	private static final EstadoEnum ACTIVO = null;
	
	// Metodo privado que verifica que los comics se encuentran inactivos
	private static final EstadoEnum INACTIVO = null;

	public static void main(String[] args) {
		
		//Se crea el objeto Comic_1 con estado ACTIVO
		Comic comic_1 = new Comic();
		comic_1.setEstadoEnum(ACTIVO);
		
		//Se crea el objeto Comic_2 con estado INACTIVO
		Comic comic_2 = new Comic();
		comic_2.setEstadoEnum(INACTIVO);
		
		//Se crea el objeto Comic_3 con estado ACTIVO
		Comic comic_3 = new Comic();
		comic_3.setEstadoEnum(ACTIVO);
		
		//Se crea el objeto Comic_4 con estado INACTIVO
		Comic comic_4 = new Comic();
		comic_4.setEstadoEnum(INACTIVO);
		
		//Se crea el objeto Comic_5 con estado ACTIVO
		Comic comic_5 = new Comic();
		comic_5.setEstadoEnum(ACTIVO);
		
		//Se crea el objeto Comic_6 con estado INACTIVO
		Comic comic_6 = new Comic();
		comic_6.setEstadoEnum(INACTIVO);
		
		//Se crea el objeto Comic_7 con estado ACTIVO
		Comic comic_7 = new Comic();
		comic_7.setEstadoEnum(ACTIVO);
		
		//Se crea el objeto Comic_8 con estado INACTIVO
		Comic comic_8 = new Comic();
		comic_8.setEstadoEnum(INACTIVO);
		
		//Se crea el objeto Comic_9 con estado ACTIVO
		Comic comic_9 = new Comic();
		comic_9.setEstadoEnum(ACTIVO);
		
		//Se crea el objeto Comic_10 con estado INACTIVO
		Comic comic_10 = new Comic();
		comic_10.setEstadoEnum(INACTIVO);
		
	}
	
	public ComicDTO CreacionComic(ComicDTO comicDTO){
		ComicDTO comicDTOCreado = new ComicDTO();
		return comicDTO;
	}
	
	
}

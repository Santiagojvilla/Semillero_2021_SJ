package com.hbt.semillero.pruebaFinal.ejb;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.GestionarComicBean;
import com.hbt.semillero.enums.EstadoEnum;

/**
 * @author Santiago Villamarin
 */
public class GestionarCompraComicBean implements IGestionarCompraComicLocal{

	@PersistenceContext
	public EntityManager em;
	
	/**
	 * 
	 * Metodo encargado de validar el estado del comic para la compra.
	 * 
	 * @author Santiago Villamarin
	 * 
	 * @param idComic
	 * @throws Exception
	 */
	private void validarEstadoComic(Long idComic, Long cantidad) throws Exception {
		// Creo el objeto de la clase
		GestionarComicBean gestionComic = new GestionarComicBean();
		// Consulto el comic en base de datos
		ComicDTO comicSeleccionado =  gestionComic.consultarComic(idComic);
		// Se valida e estado el comic
		if(comicSeleccionado.getEstadoEnum().equals(EstadoEnum.INACTIVO)) {
			throw new Exception("El comic seleccionado no cuenta con stock en bodega.");
		}
	}
	
	/**
	 * 
	 * Metodo encargado de validar la cantidad de comics para la compra.
	 * 
	 * @author Santiago Villamarin
	 * 
	 * @param idComic
	 * @throws Exception
	 */
	private void validarCantidadComic(Long idComic, Long cantidad) throws Exception {
		if(cantidad <= 0) {
			throw new Exception("El valor a ingresar debe ser mayor a 0.");
		}
		// Creo el objeto de la clase
		GestionarComicBean gestionComic = new GestionarComicBean();
		// Consulto el comic en base de datos
		ComicDTO comicSeleccionado =  gestionComic.consultarComic(idComic);
		// Se valida la cantidad de base de datos con la ingresada
		if(comicSeleccionado.getCantidad()<cantidad) {
			throw new Exception("La cantidad existente del comic es: "+comicSeleccionado.getCantidad()+", y es inferior a la ingresada.");
		}
	}
	
	/**
	 * Metodo encargado de ejecutar las validaciones de la compra.
	 * 
	 * @author Santiago Villamarin
	 * 
	 * @param idComic
	 * @param cantidad
	 * @throws Exception 
	 */
	public ResultadoDTO ejecutarCompraComic(Long idComic, Long cantidad) throws Exception {
		validarEstadoComic(idComic, cantidad);
		validarCantidadComic(idComic, cantidad);
		// Validamos si la cantidad comprada es igual a la cantidad en inventario
		// Creo el objeto de la clase
		GestionarComicBean gestionComic = new GestionarComicBean();
		// Consulto el comic en base de datos
		ComicDTO comicSeleccionado = gestionComic.consultarComic(idComic);
		if(comicSeleccionado.getCantidad()==cantidad) {
			gestionComic.actualizarComic(idComic, 0L, LocalDate.now(), EstadoEnum.INACTIVO);
		}else {
			gestionComic.actualizarComic(idComic, comicSeleccionado.getCantidad()-cantidad, LocalDate.now(), EstadoEnum.ACTIVO);
		}
		comicSeleccionado.setExitoso(true);
		comicSeleccionado.setMensajeEjecucion("La compra del comic "+comicSeleccionado.getNombre()+"fue exitosa");
		return comicSeleccionado;
	}
}

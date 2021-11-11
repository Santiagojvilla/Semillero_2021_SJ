package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	@PersistenceContext
	public EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		String consulta = "SELECT new com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO(c.nombre, c.precio)  "
						+ " FROM Comic c WHERE c.id = :idComic";
		ConsultaNombrePrecioComicDTO consultaNombrePrecioDTO = new ConsultaNombrePrecioComicDTO();
		try {
			Query consultaNativa = em.createQuery(consulta);
			consultaNativa.setParameter("idComic", idComic);
			consultaNombrePrecioDTO = (ConsultaNombrePrecioComicDTO) consultaNativa.getSingleResult();
			consultaNombrePrecioDTO.setExitoso(true);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta");	
		} catch (Exception e) {
			consultaNombrePrecioDTO.setExitoso(false);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");
		}

		return consultaNombrePrecioDTO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception {
		
		if(comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}
		
		ComicDTO comicDTOResult = null;
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);
		comicDTOResult = this.convertirComicToComicDTO(comic);
		comicDTOResult.setExitoso(true);
		comicDTOResult.setMensajeEjecucion("El comic ha sido creado exitosamente");
		return comicDTOResult;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<ComicDTO> consultarComics() {
		String consulta = "SELECT new com.hbt.semillero.dto.ComicDTO(c.nombre, c.tematica, c.precio, c.color, c.cantidad)  "
				+ " FROM Comic";
		List<ComicDTO> consultaNombrePrecioDTO = new ArrayList<ComicDTO>();
		try {
			Query consultaNativa = em.createQuery(consulta);
			consultaNombrePrecioDTO = (List<ComicDTO>) consultaNativa.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultaNombrePrecioDTO;
	}
	
	/**
	 * Metodo encargado de consultar el comic en base de datos para el taller final.
	 * 
	 * @author Santiago Villamarin
	 * 
	 * @param idComic
	 * @return
	 */
	public ComicDTO consultarComic(Long idComic) {
		String consulta = "SELECT new com.hbt.semillero.dto.ComicDTO(c.estadoEnum, c.cantidad, c.nombre)  "
				+ " FROM Comic c WHERE c.id = :idComic";
		ComicDTO comicDTO = new ComicDTO();
		try {
			Query consultaNativa = em.createQuery(consulta);
			consultaNativa.setParameter("idComic", idComic);
			comicDTO = (ComicDTO) consultaNativa.getSingleResult();
			comicDTO.setExitoso(true);
			comicDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta");
		} catch (Exception e) {
			comicDTO.setExitoso(false);
			comicDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");
		}
		return comicDTO;
	}

	/**
	 * Metodo encargado de actualizar el registro del comic para el taller final.
	 * 
	 * @author Santiago Villamarin
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO actualizarComic(Long idComic, Long cantidad, LocalDate fechaVenta, EstadoEnum estado) {
		ComicDTO comicDTOResult = null;
		try {
			Comic comic = em.find(Comic.class, idComic);
			comic.setCantidad(cantidad);
			comic.setFechaVenta(fechaVenta);
			comic.setEstadoEnum(estado);
			em.merge(comic);
			comicDTOResult = this.convertirComicToComicDTO(comic);
			comicDTOResult.setExitoso(true);
			comicDTOResult.setMensajeEjecucion("El comic ha sido creado exitosamente");
		} catch (Exception e) {
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");
		}
		return comicDTOResult;
	}

	@Override
	public ResultadoDTO eliminarComic(Long idComic) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId(comic.getId());
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un comic
	 * 
	 * @param comic
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

	@Override
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(String idComic) {
		// TODO Auto-generated method stub
		return null;
	}
}

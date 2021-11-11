package com.hbt.semillero.pruebaFinal.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;
import com.hbt.semillero.pruebaFinal.ejb.IGestionarCompraComicLocal;

@Path("/gestionarCompraComic")
public class GestionarCompraComicRest {

	@EJB
	private IGestionarComicLocal gestionarComicLocal;
	@EJB
	private IGestionarCompraComicLocal gestionarCompraComicLocal;
	
	@POST
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO crearComic(Long idComic, Long cantidad) {
		ComicDTO comicDTOResult = new ComicDTO();
		try {
			comicDTOResult = (ComicDTO) gestionarCompraComicLocal.ejecutarCompraComic(idComic, cantidad);
		}  catch (Exception e) {
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico, causa: " + e.getMessage());
		}
		return comicDTOResult;
	} 
	
}

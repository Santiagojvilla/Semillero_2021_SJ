package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.enums.EstadoEnum;

@Local
public interface IGestionarComicLocal {
	
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(String idComic);

	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception;
	
	public ResultadoDTO eliminarComic(Long idComic);
	
	public List<ComicDTO> consultarComics();

	ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);

	public ResultadoDTO actualizarComic(Long idComic, Long cantidad, LocalDate fechaVenta, EstadoEnum estado);
}

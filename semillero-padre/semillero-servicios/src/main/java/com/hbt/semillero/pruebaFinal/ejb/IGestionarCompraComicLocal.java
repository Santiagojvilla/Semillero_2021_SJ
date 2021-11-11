package com.hbt.semillero.pruebaFinal.ejb;

import javax.ejb.Local;

import com.hbt.semillero.dto.ResultadoDTO;

@Local
public interface IGestionarCompraComicLocal{

	public ResultadoDTO ejecutarCompraComic(Long idComic, Long cantidad) throws Exception;
	
}

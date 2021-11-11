/**
 * EstadoComicsTest.java
 */
package semillero.pruebasUnitarias;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.GestionarComicBean;

import junit.framework.Assert;

/**
 * <b>Descripción:<b> Clase que determina la prueba unitaria de el estado de los comics
 * <b>Caso de Uso:<b> Semillero 2021
 * @author Santiago Jiménez
 * @version 1.2
 */
public class EstadoComicsTest {
	
	/**
	 * Constante que contendra el log de la clase EstadoComicsTest
	 */
	private final static Logger log = Logger.getLogger(EstadoComicsTest.class);
	private static final String INACTIVO = null;
	private static final String ACTIVO = null;
	
	@BeforeTest
	public void inicializar() {
		BasicConfigurator.configure(); // Inicializa el logger con una configuracion basica
		log.info(":::::::::::::::::::::::::::: INICIAN PRUEBAS UNITARIAS :::::::::::::::::::::::::::: ");
	}
	
	/**
	 * 
	 * Metodo para comprobar el estado del comic
	 * @author Santiago Jiménez
	 *
	 */

	@Test 
	public void validarResultadoEstadoActivo() {
		log.info("Inicia ejecucion del metodo validarResultadoEstadoActivo()");		
		String resultado_noEsperado = INACTIVO;
		String resultado = ACTIVO;
		Assert.assertEquals(resultado, resultado_noEsperado);
		log.info("Finaliza la ejecucion del metodo validarResultadoEstad()");	
	}
	
	@Test
	public void consultarlistaComic() {
		log.info("Inicia ejecucion del metodo consultarlistaComic()");		
		try {
			GestionarComicBean gestionComic = new GestionarComicBean();
			List<ComicDTO> lista = (ArrayList<ComicDTO>) gestionComic.consultarComics();
			for (int i = 0; i < lista.size()-1; i++) {
				log.debug("Comic: "+lista.get(i).getNombre());
			}
		} catch (Exception e) {
			log.error("ERROR REALIZANDO A CONSULTA");
			e.printStackTrace();
		}
		log.info("Finaliza la ejecucion del metodo consultarlistaComic()");	
	}
		
	@AfterTest
	public void finalizaPruebasUnitarias() {
		log.info(":::::::::::::::::::::::::::: FINALIZAN PRUEBAS UNITARIAS :::::::::::::::::::::::::::: ");
	}

}
package co.com.aplication.AplicacionActivosFijos.dao.interfaz;

import java.io.IOException;
import java.util.List;

import co.com.aplication.AplicacionActivosFijos.dao.vo.ActivoFijoVO;
import co.com.aplication.AplicacionActivosFijos.dao.vo.PersonaVO;

public interface PersonaInterfaz {
	
	public PersonaVO insertar(PersonaVO persona) throws Exception;
	public int actualiza(String query, String where) throws Exception;
	public List<PersonaVO> consultar(String where) throws Exception;
	public int eliminar(String where) throws Exception;
}

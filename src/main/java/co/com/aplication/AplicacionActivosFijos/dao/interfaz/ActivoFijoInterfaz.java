package co.com.aplication.AplicacionActivosFijos.dao.interfaz;

import java.util.List;

import co.com.aplication.AplicacionActivosFijos.dao.vo.ActivoFijoVO;

public interface ActivoFijoInterfaz {
	
	public ActivoFijoVO insertar(ActivoFijoVO objeto) throws Exception;
	public int actualizar(ActivoFijoVO objeto) throws Exception;
	public List<ActivoFijoVO> consultar(String where) throws Exception;
	public int eliminar(ActivoFijoVO object) throws Exception;

	
}

package co.com.aplication.AplicacionActivosFijos.dao.interfaz;

import java.util.List;

import co.com.aplication.AplicacionActivosFijos.dao.vo.AreaVO;

public interface AreaInterfaz {
	
	public AreaVO insertar(AreaVO areaVO) throws Exception;
	public int actualiza(String query, String where) throws Exception;
	public List<AreaVO> consultar(String where) throws Exception;
	public int eliminar(String where) throws Exception;
}

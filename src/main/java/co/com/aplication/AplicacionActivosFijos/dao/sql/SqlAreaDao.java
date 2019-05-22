package co.com.aplication.AplicacionActivosFijos.dao.sql;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.com.aplication.AplicacionActivosFijos.conection.Conection;
import co.com.aplication.AplicacionActivosFijos.dao.interfaz.AreaInterfaz;
import co.com.aplication.AplicacionActivosFijos.dao.interfaz.PersonaInterfaz;
import co.com.aplication.AplicacionActivosFijos.dao.vo.ActivoFijoVO;
import co.com.aplication.AplicacionActivosFijos.dao.vo.AreaVO;
import co.com.aplication.AplicacionActivosFijos.dao.vo.PersonaVO;

public class SqlAreaDao extends Conection implements AreaInterfaz {
	
	@Override
	public AreaVO insertar(AreaVO vo) throws Exception {
		return null;
	}
	
	
	@Override
	public int actualiza(String query, String where) throws Exception {
		return 0;
	}
	
	@Override
	public List<AreaVO> consultar(String where) throws Exception {
		PreparedStatement statement = null;

		ResultSet query = null;

		AreaVO elem = null;
		String sql = "";
		
		String sqlAll = "select IdArea,"+
						"		NombreArea "+
						"from	area";
		
		if(where.equals("") || where == null)
		{
			sql = sqlAll;
		}
		else
		{
			sql = sqlAll + " WHERE " + where;
		}
		
		List<AreaVO> elemSete = new ArrayList<AreaVO>(); 

		try {

			this.conectar();

			statement = this.instancia.prepareStatement(sql);

			query = statement.executeQuery();

			while (query.next()) {
				elem = new AreaVO();

				elem.setIdArea(query.getBigDecimal("IdArea"));
				elem.setNombreArea(query.getString("NombreArea"));
				
				elemSete.add(elem);
			}
			return elemSete;
		} catch (Exception e) {
			throw e;
		} catch (Throwable e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				this.desconectar();
				if (query != null)
					query.close();

			} catch (Throwable ef) {
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Throwable ef) {
			}
		}
	}
	
	
	@Override
	public int eliminar(String where) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private BigDecimal ultimoRegistro(Connection conn)
	{
		return null;
	}
	

}

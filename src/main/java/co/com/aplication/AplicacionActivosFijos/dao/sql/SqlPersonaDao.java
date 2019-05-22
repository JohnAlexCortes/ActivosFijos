package co.com.aplication.AplicacionActivosFijos.dao.sql;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.com.aplication.AplicacionActivosFijos.conection.Conection;
import co.com.aplication.AplicacionActivosFijos.dao.interfaz.PersonaInterfaz;
import co.com.aplication.AplicacionActivosFijos.dao.vo.PersonaVO;

public class SqlPersonaDao extends Conection implements PersonaInterfaz {
	
	@Override
	public PersonaVO insertar(PersonaVO vo) throws Exception {
		PersonaVO retornar;
		
		try {
			retornar = vo;
			
			this.conectar();
			
		    PreparedStatement st = 	this.instancia.prepareStatement("INSERT INTO `activosfijos`.`persona` (`IdPersona`, `TipoPersona`, `IdTipoIdentificacion`, `NumeroIdentificacion`, `PrimerNombre`, `SegundoNombre`, `PrimerApellido`, `SegundoApellido`, `Genero`, `FechaNacimiento`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		    
		    retornar.setIdPersona(ultimoRegistro(instancia));
		    
		    st.setBigDecimal(1, retornar.getIdPersona());
		    st.setString(2, vo.getTipoPersona());
		    st.setBigDecimal(3, vo.getIdTipoIdentificacion());
		    st.setString(4, vo.getNumeroIdentificacion());
		    st.setString(5, vo.getPrimerNombre());
		    st.setString(6, vo.getSegundoNombre());
		    st.setString(7, vo.getPrimerApellido());
		    st.setString(8, vo.getSegundoApellido());
		    st.setString(9, vo.getGenero());
		    st.setDate(10,  vo.getFechaNaciminto());
		    
		    st.executeUpdate();
		    
		    return retornar;
			
		} catch (Exception e) {
			// TODO: handle exception
		  	throw e;
		}finally {
			this.desconectar();
		}
	}
	
	
	@Override
	public int actualiza(String query, String where) throws Exception {
		
		
		
		
		return 0;
	}
	
	@Override
	public List<PersonaVO> consultar(String where) throws Exception {
		PreparedStatement statement = null;

		ResultSet query = null;

		PersonaVO elem = null;
		String sql = "";
		

		String sqlAll = "select IdPersona,"+
						"		TipoPersona,"+
						"		IdTipoIdentificacion,"+
						"		NumeroIdentificacion,"+
						"		PrimerNombre,"+
						"		SegundoNombre,"+
						"		PrimerApellido,"+
						"		SegundoApellido,"+
						"		Genero,"+
						"		FechaNacimiento "+
						"from	persona";
		
		if(where.equals("") || where == null)
		{
			sql = sqlAll;
		}
		else
		{
			sql = sqlAll + " WHERE " + where;
		}
		
		List<PersonaVO> elemSete = new ArrayList<PersonaVO>(); 

		try {

			this.conectar();

			statement = this.instancia.prepareStatement(sql);

			query = statement.executeQuery();

			while (query.next()) {
				elem = new PersonaVO();

				elem.setIdPersona(query.getBigDecimal("IdPersona"));
				elem.setTipoPersona(query.getString("TipoPersona"));
				elem.setIdTipoIdentificacion(query.getBigDecimal("IdTipoIdentificacion"));
				elem.setNumeroIdentificacion(query.getString("NumeroIdentificacion"));
				elem.setPrimerNombre(query.getString("PrimerNombre"));
				elem.setSegundoNombre(query.getString("SegundoNombre"));
				elem.setPrimerApellido(query.getString("PrimerApellido"));
				elem.setSegundoApellido(query.getString("SegundoApellido"));
				elem.setGenero(query.getString("Genero"));
				elem.setFechaNaciminto(query.getDate("FechaNacimiento"));

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
		try {
			
			//Resultset donde vamos a buscar el resultado que genera el query
			  ResultSet rs = null;
			
			 //Objeto que utilizaremos para lanzar un query a la base de datos
			  PreparedStatement ps = null;
			
			
			//Armamos el prepared statement con el query a realizar
		   ps = conn.prepareStatement("SELECT (max(IdPersona)+1) ID FROM activosfijos.persona");
		   
		   //Ejecutamos el query
		   rs = ps.executeQuery();
		     
		   //Obtenemos el resultado
		   if (rs.next()){
		    return rs.getBigDecimal("ID");
		   }
		   
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
	

}

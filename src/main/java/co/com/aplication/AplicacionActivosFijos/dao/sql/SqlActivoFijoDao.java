package co.com.aplication.AplicacionActivosFijos.dao.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.com.aplication.AplicacionActivosFijos.conection.Conection;
import co.com.aplication.AplicacionActivosFijos.dao.interfaz.ActivoFijoInterfaz;
import co.com.aplication.AplicacionActivosFijos.dao.vo.ActivoFijoVO;

public class SqlActivoFijoDao extends Conection implements ActivoFijoInterfaz {

	@Override
	public ActivoFijoVO insertar(ActivoFijoVO objeto) throws Exception {
		ActivoFijoVO retornar;

		try {
			retornar = objeto;

			this.conectar();

			String sql = "INSERT INTO `activosfijos`.`activo_fijo` (`IdActivoFijo`, `Nombre`, `Descripcion`, `IdTipoActivoFijo`, `Serial`, `NumInteInventario`, `Peso`, `Alto`, `Ancho`, `Largo`, `ValorCompra`, `FechaCompra`, `FechaDeBaja`, `IdEstadoDelActivo`, `IdColor`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement st = this.instancia.prepareStatement(sql);

			retornar.setIdActivoFijo(ultimoRegistro(instancia));

			st.setBigDecimal(1, retornar.getIdActivoFijo());
			st.setString(2, objeto.getNombre());
			st.setString(3, objeto.getDescripcion());
			st.setBigDecimal(4, objeto.getIdTipoActivoFijo());
			st.setString(5, objeto.getSerial());
			st.setString(6, objeto.getNumInteInventario());
			st.setBigDecimal(7, objeto.getPeso());
			st.setBigDecimal(8, objeto.getAlto());
			st.setBigDecimal(9, objeto.getAncho());
			st.setBigDecimal(10, objeto.getLargo());
			st.setBigDecimal(11, objeto.getValorCompra());
			st.setDate(12, objeto.getFechaCompra());
			st.setDate(13, objeto.getFechaDeBaja());
			st.setBigDecimal(14, objeto.getIdEstadoDelActivo());
			st.setBigDecimal(15, objeto.getIdColor());

			st.executeUpdate();

			return retornar;

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public int actualizar(ActivoFijoVO object) throws Exception {

		PreparedStatement statement = null;
		int values = 0;
		
		try {
			this.conectar();

			String sql = "UPDATE `activosfijos`.`activo_fijo` SET `Nombre` = ?, `Descripcion` = ?, `IdTipoActivoFijo` = ?, `Serial` = ?, `NumInteInventario` = ?, `Peso` = ?, `Alto` = ?, `Ancho` = ?, `Largo` = ?, `ValorCompra` = ?, `FechaCompra` = ?, `FechaDeBaja` = ?, `IdEstadoDelActivo` = ?, `IdColor` = ? WHERE (`IdActivoFijo` = ?)";

			statement = this.instancia.prepareStatement(sql);

			if (object.getNombre() != null) {
				statement.setString(1, object.getNombre());
			} else {
				statement.setNull(1, java.sql.Types.VARCHAR);
			}

			if (object.getDescripcion() != null) {
				statement.setString(2, object.getDescripcion());
			} else {
				statement.setNull(2, java.sql.Types.VARCHAR);
			}

			if (object.getIdTipoActivoFijo() != null) {
				statement.setBigDecimal(3, object.getIdTipoActivoFijo());
			} else {
				statement.setNull(3, java.sql.Types.NUMERIC);
			}

			if (object.getSerial() != null) {
				statement.setString(4, object.getSerial());
			} else {
				statement.setNull(4, java.sql.Types.VARCHAR);
			}

			if (object.getNumInteInventario() != null) {
				statement.setString(5, object.getNumInteInventario());
			} else {
				statement.setNull(5, java.sql.Types.VARCHAR);
			}

			if (object.getPeso() != null) {
				statement.setBigDecimal(6, object.getPeso());
			} else {
				statement.setNull(6, java.sql.Types.NUMERIC);
			}

			if (object.getAlto() != null) {
				statement.setBigDecimal(7, object.getAlto());
			} else {
				statement.setNull(7, java.sql.Types.NUMERIC);
			}

			if (object.getAncho() != null) {
				statement.setBigDecimal(8, object.getAncho());
			} else {
				statement.setNull(8, java.sql.Types.NUMERIC);
			}

			if (object.getLargo() != null) {
				statement.setBigDecimal(9, object.getLargo());
			} else {
				statement.setNull(9, java.sql.Types.NUMERIC);
			}

			if (object.getValorCompra() != null) {
				statement.setBigDecimal(10, object.getValorCompra());
			} else {
				statement.setNull(10, java.sql.Types.NUMERIC);
			}

			if (object.getFechaCompra() != null) {
				statement.setTimestamp(11, new java.sql.Timestamp(object.getFechaCompra().getTime()));
			} else {
				statement.setNull(11, java.sql.Types.DATE);
			}

			if (object.getFechaDeBaja() != null) {
				statement.setTimestamp(12, new java.sql.Timestamp(object.getFechaDeBaja().getTime()));
			} else {
				statement.setNull(12, java.sql.Types.DATE);
			}

			if (object.getIdEstadoDelActivo() != null) {
				statement.setBigDecimal(13, object.getIdEstadoDelActivo());
			} else {
				statement.setNull(13, java.sql.Types.NUMERIC);
			}

			if (object.getIdColor() != null) {
				statement.setBigDecimal(14, object.getIdColor());
			} else {
				statement.setNull(14, java.sql.Types.NUMERIC);
			}

			if (object.getIdActivoFijo() != null) {
				statement.setBigDecimal(15, object.getIdActivoFijo());
			} else {
				statement.setNull(15, java.sql.Types.NUMERIC);
			}

			           
			values = statement.executeUpdate();
			
			return values;
            
			
		} catch (Exception e) {
			throw e;
		} catch (Throwable e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
				this.desconectar();
			} catch (Throwable ef) {
			}
		}
	}

	@Override
	public List<ActivoFijoVO> consultar(String where) throws SQLException {

		PreparedStatement statement = null;

		ResultSet query = null;

		ActivoFijoVO elem = null;
		String sql = "";
		

		String sqlAll = "SELECT IdActivoFijo, "+
						"		Nombre, "+
						"		Descripcion, "+
						"		IdTipoActivoFijo, "+
						"		Serial, "+
						"		NumInteInventario, "+
						"		Peso, "+
						"		Alto, "+
						"		Ancho, "+
						"		Largo, "+
						"		ValorCompra, "+
						"		FechaCompra, "+
						"		FechaDeBaja, "+
						"		IdEstadoDelActivo, "+
						"		IdColor "+
						"FROM activosfijos.activo_fijo";
		
		if(where.equals("") || where == null)
		{
			sql = sqlAll;
		}
		else
		{
			sql = sqlAll + " WHERE " + where;
		}
		

		ArrayList elemSet = new ArrayList();
		List<ActivoFijoVO> elemSete = new ArrayList<ActivoFijoVO>(); 

		try {

			this.conectar();

			statement = this.instancia.prepareStatement(sql);

			query = statement.executeQuery();
			
			while (query.next()) {
				elem = new ActivoFijoVO();

				elem.setIdActivoFijo(query.getBigDecimal("IdActivoFijo"));
				elem.setNombre(query.getString("Nombre"));
				elem.setDescripcion(query.getString("Descripcion"));
				elem.setIdTipoActivoFijo(query.getBigDecimal("IdTipoActivoFijo"));
				elem.setSerial(query.getString("Serial"));
				elem.setNumInteInventario(query.getString("NumInteInventario"));
				elem.setPeso(query.getBigDecimal("Peso"));
				elem.setAlto(query.getBigDecimal("Alto"));
				elem.setAncho(query.getBigDecimal("Ancho"));
				elem.setLargo(query.getBigDecimal("Largo"));
				elem.setValorCompra(query.getBigDecimal("ValorCompra"));
				elem.setFechaCompra(query.getDate("FechaCompra"));
				elem.setFechaDeBaja(query.getDate("FechaDeBaja"));
				elem.setIdEstadoDelActivo(query.getBigDecimal("IdEstadoDelActivo"));
				elem.setIdColor(query.getBigDecimal("IdColor"));

				elemSet.add(elem);
				elemSete.add(elem);
			}
			
			if(elemSete.size() == 0)
				throw new SQLException("NO existen datos con los filtros seleccionados", "404", 404);
			
			return elemSete;
		} catch (SQLException e) {
			throw e;
		} catch (Throwable e) {
			throw new SQLException(e.getMessage());
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
	public int eliminar(ActivoFijoVO object) throws Exception {

		PreparedStatement statement = null;
		int values = 0;

		try {
			this.conectar();

			String sql = "DELETE FROM `activosfijos`.`activo_fijo` WHERE (`IdActivoFijo` = ?)";

			statement = this.instancia.prepareStatement(sql);

			if (object.getIdActivoFijo() != null) {
				statement.setBigDecimal(1, object.getIdActivoFijo());
			} else {
				statement.setNull(1, java.sql.Types.NUMERIC);
			}

			values = statement.executeUpdate();
			
			return values;

		} catch (Exception e) {
			throw e;
		} catch (Throwable e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
				this.desconectar();
			} catch (Throwable ef) {
			}
		}

	}

	private BigDecimal ultimoRegistro(Connection conn) {
		try {

			// Resultset donde vamos a buscar el resultado que genera el query
			ResultSet rs = null;

			// Objeto que utilizaremos para lanzar un query a la base de datos
			PreparedStatement ps = null;

			// Armamos el prepared statement con el query a realizar
			ps = conn.prepareStatement("SELECT (max(IdActivoFijo)+1) ID FROM activosfijos.activo_fijo");

			// Ejecutamos el query
			rs = ps.executeQuery();

			// Obtenemos el resultado
			if (rs.next()) {
				return rs.getBigDecimal("ID");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}

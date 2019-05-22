package co.com.aplication.AplicacionActivosFijos.conection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import co.com.aplication.AplicacionActivosFijos.conection.interfaz.ConetionInterfaz;

public class Conection implements ConetionInterfaz {

	
	public static Connection instancia;
	
	public Conection()
	{
		this.instancia = null;
	}
	
	
	@Override
	public void conectar() throws IOException
	{
		  //Objeto de propiedades donde vamos a cargar las propiedades del archivo
		  Properties props = new Properties();
		  
		  //Input Stream donde leemos el recurso donde está el archivo de propiedades
		  InputStream is = Conection.class.getClassLoader().getResourceAsStream("app.properties");
		  
		  //Cargamos las propiedades que vienene del archivo
		  props.load(is);
		  
		  //Cerramos el recurso
		  is.close();
		  
		  //Abrimos try para controlar cualquier excepción de SQL que ocurra
		  try
		  {
			  //Abrimos conexión a base de datos
			  instancia = DriverManager.getConnection(props.getProperty("url"), props);
		   
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	}
	
	
	@Override
	public void desconectar() throws IOException {
		try 
		{
			instancia.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
	}
}

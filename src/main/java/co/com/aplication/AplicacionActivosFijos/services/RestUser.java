package co.com.aplication.AplicacionActivosFijos.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.aplication.AplicacionActivosFijos.conection.Conection;
import co.com.aplication.AplicacionActivosFijos.dao.sql.SqlPersonaDao;
import co.com.aplication.AplicacionActivosFijos.dao.vo.PersonaVO;
import co.com.aplication.AplicacionActivosFijos.vo.VOUser;

@RestController
@RequestMapping(path = "/servicesConection/AF")
public class RestUser {

	@RequestMapping(method = RequestMethod.POST, 
					path = "/validateUser", 
					consumes = "application/json", 
					produces = "application/json")
	public @ResponseBody VOUser validateUser(@RequestBody VOUser user) throws Exception 
	{
		VOUser response = new VOUser();
		response.setFind(false);
		
		PersonaVO personaVO;
		
		System.out.println("User: " + user.getUser());
		System.out.println("Password: " + user.getPassword());
		
		try 
		{
			
			Conection conexion = new Conection();
			if (user.getUser().equals("admin") && user.getPassword().equals("admin")) 
			{
				response.setUser(user.getUser());
				response.setFind(true);
				
				java.util.Date date = new Date();
				SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");

				
				java.sql.Date fechaActual = new java.sql.Date(date.getTime());
				String tiempo = formatofecha.format(fechaActual);
				

				personaVO = new PersonaVO();
				
				personaVO.setTipoPersona("N");
				personaVO.setIdTipoIdentificacion(new BigDecimal("2"));
				personaVO.setNumeroIdentificacion("11221");
				personaVO.setPrimerNombre("Ana");
				personaVO.setSegundoNombre("Maria");
				personaVO.setPrimerApellido("Contreras");
				personaVO.setSegundoApellido("Jorge");
				personaVO.setGenero("F");
				personaVO.setFechaNaciminto(fechaActual);
				
				SqlPersonaDao sqlPersonaDao = new SqlPersonaDao();
				personaVO = sqlPersonaDao.insertar(personaVO);
				
			}
			else
			{
				conexion.desconectar();
			}
			return response;
		} 
		catch (Exception ex) 
		{
			System.out.println("Se presenta error ejecutando el serivio");
			throw ex;
			//return response;
		}
	}
}

package co.com.aplication.AplicacionActivosFijos.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.aplication.AplicacionActivosFijos.dao.sql.SqlActivoFijoDao;
import co.com.aplication.AplicacionActivosFijos.dao.sql.SqlPersonaDao;
import co.com.aplication.AplicacionActivosFijos.dao.vo.ActivoFijoVO;
import co.com.aplication.AplicacionActivosFijos.dao.vo.PersonaVO;
import co.com.aplication.AplicacionActivosFijos.vo.ResponseVO;

@RestController
@RequestMapping(path = "/serviciosPersona")
public class RestPersona {
	private String armarWhere = "";

		
	@RequestMapping(method = RequestMethod.GET, 
			path = "/consultarPersonas", 
			produces = "application/json")
	public @ResponseBody List<PersonaVO> consultarActivo() throws Exception 
	{
		ResponseVO response = new ResponseVO();
		SqlPersonaDao sqlPersonaDao = new SqlPersonaDao();
		
		List<PersonaVO> lista = new ArrayList<PersonaVO>();
		
		int i = 0;
		
		this.armarWhere = "";
		
		
		try 
		{
			lista = sqlPersonaDao.consultar("");
			
			if(i == 0)
			{
				// Aqui el proceso no actualizó ningun registro
				response.setCodigoRespuesta("404");
				response.setTextoRespuesta("No se encontro ningun registro con las condiciones ingresadas");
			}
			else
			{
				response.setCodigoRespuesta("200");
				response.setTextoRespuesta("Operacion exitosa");
			}
			
			return lista;
			
		}catch(	Exception ex)
		{
			System.out.println("Se presenta error ejecutando el servicio de Consulta");
			throw ex;
			// return response;
		}
	}
	
	

}

package co.com.aplication.AplicacionActivosFijos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.aplication.AplicacionActivosFijos.dao.sql.SqlAreaDao;
import co.com.aplication.AplicacionActivosFijos.dao.sql.SqlPersonaDao;
import co.com.aplication.AplicacionActivosFijos.dao.vo.AreaVO;
import co.com.aplication.AplicacionActivosFijos.dao.vo.PersonaVO;
import co.com.aplication.AplicacionActivosFijos.vo.ResponseVO;

@RestController
@RequestMapping(path = "/serviciosArea")
public class RestArea {
	private String armarWhere = "";

		
	@RequestMapping(method = RequestMethod.GET, 
			path = "/consultarArea", 
			produces = "application/json")
	public @ResponseBody List<AreaVO> consultarActivo() throws Exception 
	{
		ResponseVO response = new ResponseVO();
		SqlAreaDao sqlAreaDao = new SqlAreaDao();
		
		List<AreaVO> lista = new ArrayList<AreaVO>();
		
		int i = 0;
		
		this.armarWhere = "";
		
		try 
		{
			lista = sqlAreaDao.consultar("");
			
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

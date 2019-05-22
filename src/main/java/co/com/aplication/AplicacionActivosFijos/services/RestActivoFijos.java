package co.com.aplication.AplicacionActivosFijos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.aplication.AplicacionActivosFijos.dao.sql.SqlActivoFijoDao;
import co.com.aplication.AplicacionActivosFijos.dao.vo.ActivoFijoVO;
import co.com.aplication.AplicacionActivosFijos.vo.ResponseVO;

@RestController
@RequestMapping(path = "/serviciosActivoFijo")
public class RestActivoFijos {
	private String armarWhere = "";

	@RequestMapping(method = RequestMethod.POST, 
					path = "/insetarActivo", 
					consumes = "application/json", 
					produces = "application/json")
	public @ResponseBody ResponseVO insertarActivo(@RequestBody ActivoFijoVO activoFijoVO) throws Exception 
	{
		String validaCampos;
		
		ResponseVO response = new ResponseVO();
		SqlActivoFijoDao sqlActivoFijoDao = new SqlActivoFijoDao();
		
		try 
		{
			validaCampos = validaCampoObligatorios(activoFijoVO);
			
			if(validaCampos != "")
			{
				response.setCodigoRespuesta("400");
				response.setTextoRespuesta(validaCampos);
				return response;
			}
				
			sqlActivoFijoDao.insertar(activoFijoVO);
			
			response.setCodigoRespuesta("200");
			response.setTextoRespuesta("Operacion exitosa");
			
			return response;
			
		}catch(	Exception ex)
		{
			System.out.println("Se presenta error ejecutando el servicio de Insertar");
			throw ex;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, 
			path = "/actualizarActivo", 
			consumes = "application/json", 
			produces = "application/json")
	public @ResponseBody ResponseVO actualizarActivo(@RequestBody ActivoFijoVO activoFijoVO) throws Exception 
	{
		String validaCampos;
		
		ResponseVO response = new ResponseVO();
		SqlActivoFijoDao sqlActivoFijoDao = new SqlActivoFijoDao();
		
		int i = 0;
		
		try 
		{
			validaCampos = validaCampoObligatorios(activoFijoVO);
			
			if(validaCampos != "")
			{
				response.setCodigoRespuesta("400");
				response.setTextoRespuesta(validaCampos);
			}
			else
			{
				response.setCodigoRespuesta("200");
				response.setTextoRespuesta("Operacion exitosa");
			}
			
			i = sqlActivoFijoDao.actualizar(activoFijoVO);
			
			if(i == 0)
			{
				// Aqui el proceso no actualizó ningun registro
				response.setCodigoRespuesta("404");
				response.setTextoRespuesta("No se actualizo ningun registro");
			}
			
			
			return response;
			
		}catch(	Exception ex)
		{
			System.out.println("Se presenta error ejecutando el servicio de Actualizar");
			throw ex;
			// return response;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, 
			path = "/eliminarActivo", 
			consumes = "application/json", 
			produces = "application/json")
	public @ResponseBody ResponseVO eliminarActivo(@RequestBody ActivoFijoVO activoFijoVO) throws Exception 
	{
		ResponseVO response = new ResponseVO();
		SqlActivoFijoDao sqlActivoFijoDao = new SqlActivoFijoDao();
		
		int i = 0;
		
		try 
		{
			i = sqlActivoFijoDao.eliminar(activoFijoVO);
			
			if(i == 0)
			{
				// Aqui el proceso no actualizó ningun registro
				response.setCodigoRespuesta("404");
				response.setTextoRespuesta("No se elimino ningun registro");
			}
			else
			{
				response.setCodigoRespuesta("200");
				response.setTextoRespuesta("Operacion exitosa");
			}
			
			return response;
			
		}catch(	Exception ex)
		{
			System.out.println("Se presenta error ejecutando el servicio de Eliminación");
			throw ex;
			// return response;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, 
			path = "/consultarActivo", 
			consumes = "application/json", 
			produces = "application/json")
	public @ResponseBody List<ActivoFijoVO> consultarActivo(@RequestBody ActivoFijoVO activoFijoVO) throws Exception 
	{
		ResponseVO response = new ResponseVO();
		SqlActivoFijoDao sqlActivoFijoDao = new SqlActivoFijoDao();
		
		String where = "";
		
		List<ActivoFijoVO> lista = new ArrayList<ActivoFijoVO>();
		
		int i = 0;
		
		this.armarWhere = "";
		
		
		try 
		{
			where = armaWhereConsulta(activoFijoVO);
			
			lista = sqlActivoFijoDao.consultar(where);
			
			if(i == 0)
			{
				// Aqui el proceso no actualizó ningun registro
				response.setCodigoRespuesta("404");
				response.setTextoRespuesta("No se encontro ningun registro con las condiciones ingresdas");
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
	
	public String validaCampoObligatorios(ActivoFijoVO activoFijoVO )
	{
		String mensajeError = "";
		
		try 
		{
			// Se hacen las validaciones de campos obligatorios
			if (activoFijoVO.getNombre().equals("") || activoFijoVO.getNombre() == null) 
			{
				mensajeError += "Se debe ingresar el Nombre";
			}
			if (activoFijoVO.getIdTipoActivoFijo().equals("") || activoFijoVO.getIdTipoActivoFijo() == null) 
			{
				mensajeError += " - Se debe ingresar el Tipo de Activo Fijo";
			}
			if (activoFijoVO.getSerial().equals("") || activoFijoVO.getSerial() == null) 
			{
				mensajeError += " - Se debe ingresar el Serial";
			}
			if (activoFijoVO.getNumInteInventario().equals("") || activoFijoVO.getNumInteInventario() == null) 
			{
				mensajeError += " - Se debe ingresar el Número Interno del inventario";
			}
			if (activoFijoVO.getIdEstadoDelActivo().equals("") || activoFijoVO.getIdEstadoDelActivo() == null) 
			{
				mensajeError += " - Se debe ingresar el Estado del Activo Fijo";
			}
			if (activoFijoVO.getIdColor().equals("") || activoFijoVO.getIdColor() == null) 
			{
				mensajeError += " - Se debe ingresar el Color";
			}
			
			if (activoFijoVO.getFechaCompra() != null && activoFijoVO.getFechaDeBaja() != null) 
			{
				if (activoFijoVO.getFechaCompra().getTime() > activoFijoVO.getFechaDeBaja().getTime()) 
				{
					mensajeError += " - Por favor valide las fechas. La fecha de compra no puede ser mayo a la fecha de Baja";
				}
			}
			else
			{
				if (activoFijoVO.getFechaCompra() == null && activoFijoVO.getFechaDeBaja() != null)
				{
					mensajeError += " - Por favor valide las fechas. La Fecha de Compra no puede estar nula cuando ingresa Fecha de Baja";
				}
			}
			
			return mensajeError;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "Se presenta error tecnico: "+ e.getMessage();
		}
	}
	
	public String armaWhereConsulta(ActivoFijoVO activoFijoVO )
	{
		String retornaWhere = "";
		
		try 
		{
			if (activoFijoVO.getIdActivoFijo() != null) {
				retornaWhere += agregaCondicion("IdActivoFijo="+agregaComillas(activoFijoVO.getIdActivoFijo().toString()));
			}
			
			if (activoFijoVO.getNombre() != null) {
				retornaWhere += agregaCondicion("Nombre="+agregaComillas(activoFijoVO.getNombre()));
			} 

			if (activoFijoVO.getDescripcion() != null) {
				retornaWhere += agregaCondicion("Descripcion="+agregaComillas(activoFijoVO.getDescripcion()));
			} 

			if (activoFijoVO.getIdTipoActivoFijo() != null) {
				retornaWhere += agregaCondicion("IdTipoActivoFijo="+agregaComillas(activoFijoVO.getIdTipoActivoFijo().toString()));
			} 

			if (activoFijoVO.getSerial() != null) {
				retornaWhere += agregaCondicion("Serial="+agregaComillas(activoFijoVO.getSerial()));
			} 

			if (activoFijoVO.getNumInteInventario() != null) {
				retornaWhere += agregaCondicion("NumInteInventario="+agregaComillas(activoFijoVO.getNumInteInventario()));
			} 

			if (activoFijoVO.getPeso() != null) {
				retornaWhere += agregaCondicion("Peso="+agregaComillas(activoFijoVO.getPeso().toString()));
			} 

			if (activoFijoVO.getAlto() != null) {
				retornaWhere += agregaCondicion("Alto="+agregaComillas(activoFijoVO.getAlto().toString()));
			} 

			if (activoFijoVO.getAncho() != null) {
				retornaWhere += agregaCondicion("Ancho="+agregaComillas(activoFijoVO.getAncho().toString()));
			} 

			if (activoFijoVO.getLargo() != null) {
				retornaWhere += agregaCondicion("Largo="+agregaComillas(activoFijoVO.getLargo().toString()));
			} 

			if (activoFijoVO.getValorCompra() != null) {
				retornaWhere += agregaCondicion("ValorCompra="+agregaComillas(activoFijoVO.getValorCompra().toString()));
			} 

			if (activoFijoVO.getFechaCompra() != null) {
				retornaWhere += agregaCondicion("FechaCompra="+agregaComillas(activoFijoVO.getFechaCompra().toString()));
			} 

			if (activoFijoVO.getFechaDeBaja() != null) {
				retornaWhere += agregaCondicion("FechaDeBaja="+agregaComillas(activoFijoVO.getFechaDeBaja().toString()));
			} 

			if (activoFijoVO.getIdEstadoDelActivo() != null) {
				retornaWhere += agregaCondicion("IdEstadoDelActivo="+agregaComillas(activoFijoVO.getIdEstadoDelActivo().toString()));
			} 

			if (activoFijoVO.getIdColor() != null) {
				retornaWhere += agregaCondicion("IdColor="+activoFijoVO.getIdColor());
			} 
			
			return retornaWhere;
			
		} catch (Exception e) {
			// TODO: handle exception
			return "Se presenta error tecnico: "+ e.getMessage();
		}
	}
	
	public String agregaComillas(String where)
	{
		String retornar = "";
		
		retornar = "'"+where+"'";
		
		return retornar;
		
	}
	
	public String agregaCondicion(String where)
	{
		String retornar = "";
		if(armarWhere.equals("") || armarWhere == null)
		{
			retornar += where;
			armarWhere = retornar;
		}
		else
		{
			retornar += " and " + where;
			armarWhere = retornar;
		}
		
		return retornar;
		
	}

}

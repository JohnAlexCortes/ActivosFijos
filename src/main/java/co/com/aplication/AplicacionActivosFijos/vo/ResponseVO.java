package co.com.aplication.AplicacionActivosFijos.vo;

import java.io.Serializable;

public class ResponseVO implements Serializable {
	
	private static final long serialVersionUID = 3560972546182458142L;
	private String codigoRespuesta;
	private String textoRespuesta;
	
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getTextoRespuesta() {
		return textoRespuesta;
	}
	public void setTextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}
	
}

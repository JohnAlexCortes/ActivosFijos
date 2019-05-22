package co.com.aplication.AplicacionActivosFijos.dao.vo;

import java.math.BigDecimal;
import java.sql.Date;

public class AreaVO {
	
	private BigDecimal  idArea;
	private String 		nombreArea;
	
	
	public BigDecimal getIdArea() {
		return idArea;
	}
	public void setIdArea(BigDecimal idArea) {
		this.idArea = idArea;
	}
	public String getNombreArea() {
		return nombreArea;
	}
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	
	
	
}
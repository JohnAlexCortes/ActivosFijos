package co.com.aplication.AplicacionActivosFijos.dao.vo;

import java.math.BigDecimal;
import java.sql.Date;

public class PersonaVO {
	
	private BigDecimal  idPersona;
	private String 		tipoPersona;
	private BigDecimal 	idTipoIdentificacion;
	private String 		numeroIdentificacion;
	private String		primerNombre;
	private String 		segundoNombre;
	private String		primerApellido;
	private String 		segundoApellido;
	private String 		genero;
	private Date 		fechaNaciminto;
	
	
	public BigDecimal getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(BigDecimal idPersona) {
		this.idPersona = idPersona;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public BigDecimal getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}
	public void setIdTipoIdentificacion(BigDecimal idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFechaNaciminto() {
		return fechaNaciminto;
	}
	public void setFechaNaciminto(Date fechaNaciminto) {
		this.fechaNaciminto = fechaNaciminto;
	}

}

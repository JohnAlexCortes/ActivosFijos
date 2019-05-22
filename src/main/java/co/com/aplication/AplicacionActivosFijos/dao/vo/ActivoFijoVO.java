package co.com.aplication.AplicacionActivosFijos.dao.vo;

import java.math.BigDecimal;
import java.sql.Date;

public class ActivoFijoVO {
	
	private BigDecimal  idActivoFijo;
	private String 		nombre;
	private String 		descripcion;
	private BigDecimal 	idTipoActivoFijo;
	private String		serial;
	private String 		numInteInventario;
	private BigDecimal	peso;
	private BigDecimal	alto;
	private BigDecimal	ancho;
	private BigDecimal	largo;
	private BigDecimal 	valorCompra;
	private Date 		fechaCompra;
	private Date 		fechaDeBaja;
	private BigDecimal 	idEstadoDelActivo;
	private BigDecimal 	idColor;
	public BigDecimal getIdActivoFijo() {
		return idActivoFijo;
	}
	public void setIdActivoFijo(BigDecimal idActivoFijo) {
		this.idActivoFijo = idActivoFijo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getIdTipoActivoFijo() {
		return idTipoActivoFijo;
	}
	public void setIdTipoActivoFijo(BigDecimal idTipoActivoFijo) {
		this.idTipoActivoFijo = idTipoActivoFijo;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getNumInteInventario() {
		return numInteInventario;
	}
	public void setNumInteInventario(String numInteInventario) {
		this.numInteInventario = numInteInventario;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public BigDecimal getAlto() {
		return alto;
	}
	public void setAlto(BigDecimal alto) {
		this.alto = alto;
	}
	public BigDecimal getAncho() {
		return ancho;
	}
	public void setAncho(BigDecimal ancho) {
		this.ancho = ancho;
	}
	public BigDecimal getLargo() {
		return largo;
	}
	public void setLargo(BigDecimal largo) {
		this.largo = largo;
	}
	public BigDecimal getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public Date getFechaDeBaja() {
		return fechaDeBaja;
	}
	public void setFechaDeBaja(Date fechaDeBaja) {
		this.fechaDeBaja = fechaDeBaja;
	}
	public BigDecimal getIdEstadoDelActivo() {
		return idEstadoDelActivo;
	}
	public void setIdEstadoDelActivo(BigDecimal idEstadoDelActivo) {
		this.idEstadoDelActivo = idEstadoDelActivo;
	}
	public BigDecimal getIdColor() {
		return idColor;
	}
	public void setIdColor(BigDecimal idColor) {
		this.idColor = idColor;
	}
	
	
	
	
	
	

}

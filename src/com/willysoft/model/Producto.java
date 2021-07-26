package com.willysoft.model;

import java.sql.Date;

public class Producto {
	
	/*id, codigo, nombre, precio, existencia, fecha_crear, fecha_actualizar*/
	
	private int id;
	private String codigo;
	private String nombre;
	private double precio;
	private int existencia;
	private Date fecha_crear;
	private Date fecha_actualizar;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(int id, String codigo, String nombre, double precio, int existencia, Date fecha_crear,
			Date fecha_actualizar) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.existencia = existencia;
		this.fecha_crear = fecha_crear;
		this.fecha_actualizar = fecha_actualizar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public Date getFecha_crear() {
		return fecha_crear;
	}

	public void setFecha_crear(Date fecha_crear) {
		this.fecha_crear = fecha_crear;
	}

	public Date getFecha_actualizar() {
		return fecha_actualizar;
	}

	public void setFecha_actualizar(Date fecha_actualizar) {
		this.fecha_actualizar = fecha_actualizar;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio
				+ ", existencia=" + existencia + ", fecha_crear=" + fecha_crear + ", fecha_actualizar="
				+ fecha_actualizar + "]";
	}
	

}

package com.imss.qro.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insumos")
public class Insumos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "insumo_id")
	private Integer insumo_id;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "cantidad", nullable = false, length = 100)
	private int cantidad;
	
	@Column(name = "categoria", nullable = false, length = 100)
	private String categoria;
	
	@Column(name = "fecha_caducidad", nullable = false)
	private LocalDate fecha_caducidad;
	
	@Column(name = "proveedor", length = 100)
	private String proveedor;
	
	@Column(name = "ubicacion", length = 100)
	private String ubicacion;
	
	@Column(name = "fecha_registro", length = 100)
	private LocalDateTime fecha_registro;
	
	// Getters y Setters
	
	public Integer getInsumo_id() {
		return insumo_id;
	}
	public void setInsumo_id(Integer insumo_id) {
		this.insumo_id = insumo_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDate getFecha_caducidad() {
		return fecha_caducidad;
	}
	public void setFecha_caducidad(LocalDate fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public LocalDateTime getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(LocalDateTime fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
}

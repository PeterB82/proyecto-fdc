package com.example.demo.model;

/*
 * Nombre Clase: FakeEmployee.java
 * Descripcion: Clase que representa a los trabajadores ficticios de la empresa 
 * Fecha: 16/05/2021
 * Version: 1.0
 * Autor: Jin  **/
public class FakeEmployee {

	// Atributos

	private int id;
	private String nombre;
	private String apellidos;
	private String resumen;
	private String foto;
	private String cargo;

	public FakeEmployee() {
		super();
	}

	public FakeEmployee(int id, String nombre, String apellidos, String resumen, String foto, String cargo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.resumen = resumen;
		this.foto = foto;
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "FakeEmployee [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", resumen=" + resumen
				+ ", foto=" + foto + ", cargo=" + cargo + "]";
	}

}
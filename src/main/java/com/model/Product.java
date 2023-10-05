package com.model;

public class Product {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Float peso;
    private Integer stock;

	public Product() {

	}

	public Product(String nombre, String descripcion, Float peso, Integer stock) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
	}

	public Product(Integer id, String nombre, String descripcion, Float peso, Integer stock) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}




}
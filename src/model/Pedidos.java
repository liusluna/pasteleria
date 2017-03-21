package model;

//https://coderanch.com/t/304851/databases/Java-date-MySQL-date-conversion
public class Pedidos {
	private java.util.Date fechapedio;
	private java.util.Date fechaentrega;
	private String nombre;
	private int entregasId;

	public Pedidos() {
		// TODO Auto-generated constructor stub
	}

	public java.util.Date getFechapedio() {
		return fechapedio;
	}

	public void setFechapedio(java.util.Date fechapedio) {
		this.fechapedio = fechapedio;
	}

	public java.util.Date getFechaentrega() {
		return fechaentrega;
	}

	public void setFechaentrega(java.util.Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEntregasId() {
		return entregasId;
	}

	public void setEntregasId(int entregasId) {
		this.entregasId = entregasId;
	}
    
	
}

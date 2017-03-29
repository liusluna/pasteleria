package model;



//https://coderanch.com/t/304851/databases/Java-date-MySQL-date-conversion
public class Pedidos {
	private java.util.Date fechapedio;
	private java.util.Date fechaentrega;
	private String descripcion;
	private int pedidosId;
	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getpedidosId() {
		return pedidosId;
	}

	public void setpedidosId(int pedidosId) {
		this.pedidosId = pedidosId;
	}
    
	
}

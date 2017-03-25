package model;

public class Producto {
	private String nombre;
	private Double costo;
	private Double venta; 
	private String descripcion;
	private int productosId;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getProductosId() {
		return productosId;
	}

	public void setProductosId(int productosId) {
		this.productosId = productosId;
	}

	public Double getVenta() {
		return venta;
	}

	public void setVenta(Double venta) {
		this.venta = venta;
	}

	
	
}

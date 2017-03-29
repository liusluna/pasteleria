package model;

public class Cliproped {
	private int cliproped_id; 
    private Productos producto;
    private Cliente cliente;
    private Pedidos pedido;
    
	public int getCliproped_id() {
		return cliproped_id;
	}
	public void setCliproped_id(int cliproped_id) {
		this.cliproped_id = cliproped_id;
	}
	
	public Productos getProducto() {
		return producto;
	}
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Pedidos getPedido() {
		return pedido;
	}
	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}
   
}
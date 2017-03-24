package model;

public class Cliproped {
	private int cliproped_id; 
    private int producto_id;
	private int pedido_id; 
    private int cliente_id;
	public int getCliproped_id() {
		return cliproped_id;
	}
	public void setCliproped_id(int cliproped_id) {
		this.cliproped_id = cliproped_id;
	}
	public int getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}
	public int getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	@Override
	public String toString() {
		return "Cliproped [cliproped_id=" + cliproped_id + ", producto_id=" + producto_id + ", pedido_id=" + pedido_id
				+ ", cliente_id=" + cliente_id + "]";
	}
   
}
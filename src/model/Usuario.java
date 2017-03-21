package model;


//Tabla "USUARIOS")

public class Usuario {
	private String user;
	private String pass;
	private int usuariosId;
	
	public Usuario(){

	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getUsuariosId() {
		return usuariosId;
	}

	public void setUsuariosId(int usuariosId) {
		this.usuariosId = usuariosId;
	}
	
	
}

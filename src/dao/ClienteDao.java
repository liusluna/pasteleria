package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import singleton.dbConexion;

public class ClienteDao {
	static Connection currentCon = null; 
	static ResultSet rs = null; 
	 
	public ClienteDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Cliente> getAll() {
		List<Cliente> lista = new ArrayList<Cliente>(); 
		Statement stmt = null; 
		String searchQuery = "select CLIENTE_ID, APPATERNO,APMATERNO,NOMBRE,RAZON,RFC,DIRECCION,COLONIA,MUNICIPIO,ESTADO from CLIENTES;";
		
		
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			stmt=currentCon.createStatement(); 
			rs = stmt.executeQuery(searchQuery); 
			//boolean more = rs.next();
			if (rs==null) 
				return lista;
			while (rs.next()) {
				//System.out.println("- " +rs.getString(1)+ rs.getString(2));
				Cliente cliente = new Cliente();
				cliente.setClientesId(Integer.parseInt(rs.getString(1)));
				cliente.setApmaterno(rs.getString(2));
				cliente.setAppaterno(rs.getString(3));
				cliente.setNombre(rs.getString(4));
				cliente.setRazon(rs.getString(5));
				cliente.setRfc(rs.getString(6));
				cliente.setDireccion(rs.getString(7));
				cliente.setColonia(rs.getString(8));
				cliente.setMunicipio(rs.getString(9));
				cliente.setEstado(rs.getString(10));
				lista.add(cliente);
			}
			
		 } catch (Exception ex) { 
			 System.out.println("Cliente dao: An Exception has occurred! " + ex); 
			 return (lista);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println("Cliente dao: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Cliente dao: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	
		
	    return lista;
	}

}

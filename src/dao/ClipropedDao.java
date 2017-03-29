package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Cliproped;
import singleton.dbConexion;

public class ClipropedDao {
	static Connection currentCon = null; 
	static ResultSet rs = null; 
	 
	public ClipropedDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Cliproped> getAll() {
		List<Cliproped> lista = new ArrayList<Cliproped>(); 
		Statement stmt = null; 
		String searchQuery = "select CLIPROPED_ID, PRODUCTO_ID, PEDIDO_ID, CLIENTE_ID from CLIPROPED;";
		
		
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			stmt=currentCon.createStatement(); 
			rs = stmt.executeQuery(searchQuery); 
			//boolean more = rs.next();
			if (rs==null) 
				return lista;
			while (rs.next()) {
				//System.out.println("- " +rs.getString(1)+ rs.getString(2));
				Cliproped cliproped = new Cliproped();
				cliproped.setCliproped_id(Integer.parseInt(rs.getString(1)));
				ClienteDao cdao = new ClienteDao();
				ProductoDao pdao = new ProductoDao();
				PedidoDao pedao =  new PedidoDao();
				
				cliproped.setCliente( cdao.getOne(Integer.parseInt(rs.getString(2))));
				cliproped.setPedido(pedao.getOne(Integer.parseInt(rs.getString(3))));
				cliproped.setProducto(pdao.getOne(Integer.parseInt(rs.getString(4))));
				//cliproped.setProducto_id(Integer.parseInt(rs.getString(2)));
				//cliproped.setPedido_id(Integer.parseInt(rs.getString(3)));
				//cliproped.setCliente_id(Integer.parseInt(rs.getString(4)));
				lista.add(cliproped);
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
					System.out.println("Clientes proveedores pedidos dao: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Clientes proveedores pedidos dao: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	
		
	    return lista;
	}
	
	//  Tipo: 1 cliente.  2 pedidos, 3 productos
	public Boolean dropCascadeClient(int id, int tipo){
		Statement stmt = null; 
		/*
		if (this.getOne(id).equals(null)){
			return false;
		}
		*/
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			//stmt=currentCon.createStatement(); 
			//rs = stmt.executeQuery(searchQuery); 
			
					
			String deleteSQL = "DELETE FROM CLIENTES WHERE CLIENTE_ID = ? ;";
			PreparedStatement preparedStatement = (PreparedStatement) currentCon.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
				System.err.println("SQLError: " + e.getSQLState() + "\n"+e.getStackTrace());
				return (false);
		} catch (Exception ex) { 
			 System.out.println("Cliente dao borra: An Exception has occurred! " + ex); 
			 return (false);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println("Cliente dao borra: An Exception has occurred! " + e);
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
		
		return true;
	}
}
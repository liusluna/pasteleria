package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;


import model.Productos;
import singleton.dbConexion;

public class ProductoDao {
	static Connection currentCon = null; 
	static ResultSet rs = null;
	
	public ProductoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public Productos getOne(int id){
		Productos producto = new Productos();
		Statement stmt = null; 
		
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			//stmt=currentCon.createStatement(); 
			//rs = stmt.executeQuery(searchQuery); 
			String selectSQL = "select PRODUCTO_ID,NOMBRE,COSTO,VENTA,DESCRIPCION from PRODUCTOS where PRODCUTO_ID = ? ;";
			PreparedStatement preparedStatement = (PreparedStatement) currentCon.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			//ResultSet rs = preparedStatement.executeQuery(selectSQL);
			rs = preparedStatement.executeQuery();
			
			//boolean more = rs.next();
			if (rs==null) 
				return producto;
			if (dbConexion.getResultSetRowCount(rs) ==0) 
				return producto;
			while (rs.next()) {
				producto.setProductosId(Integer.parseInt(rs.getString(1)));
				producto.setNombre(rs.getString(2));
				producto.setCosto(Double.parseDouble(rs.getString(3)));
				producto.setVenta(Double.parseDouble(rs.getString(4)));
				producto.setDescripcion(rs.getString(5));
			}
		}catch (SQLException e) {
			System.err.println("SQLError: " + e.getSQLState() + "\n"+e.getStackTrace());	
		 } catch (Exception ex) { 
			 System.out.println("Cliente dao getOne: An Exception has occurred! " + ex); 
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println("Cliente dao getOne: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Cliente dao getOne: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	
		return producto;
	}
	
	
	public List<Productos> getAll() {
		List<Productos> lista = new ArrayList<Productos>(); 
		Statement stmt = null; 
		String searchQuery = "select PRODUCTO_ID,NOMBRE,COSTO,VENTA,DESCRIPCION from PRODUCTOS;";
			
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			stmt=currentCon.createStatement(); 
			rs = stmt.executeQuery(searchQuery); 
			//boolean more = rs.next();
			if (rs==null) 
				return lista;
			while (rs.next()) {
				//System.out.println("- " +rs.getString(1)+ rs.getString(2));
				Productos producto = new Productos();
				producto.setProductosId(Integer.parseInt(rs.getString(1)));
				producto.setNombre(rs.getString(2));
				producto.setCosto(Double.parseDouble(rs.getString(3)));
				producto.setVenta(Double.parseDouble(rs.getString(4)));
				producto.setDescripcion(rs.getString(5));
				lista.add(producto);
			}
		}catch(SQLException ex){
			System.err.println(" Productos dao SQLError: " + ex.getSQLState() + "\n"+ex.getStackTrace());	
		 } catch (Exception ex) { 
			 System.out.println("Productos dao: An Exception has occurred! " + ex); 
			 return (lista);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				    
				} catch (Exception e) {
					System.out.println("Productos dao: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Productos dao: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	
		
	    return lista;
	}

	public Boolean borra(int id) {
		Statement stmt = null;  
		
		if (this.getOne(id).equals(null)){
			return false;
		}
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			//stmt=currentCon.createStatement(); 
			//rs = stmt.executeQuery(searchQuery); 
			
					
			String deleteSQL = "DELETE FROM PRODUCTOS WHERE PRODUCTO_ID = ? ;";
			PreparedStatement preparedStatement = (PreparedStatement) currentCon.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
				System.err.println("Productos Dao SQLError: " + e.getSQLState() + "\n"+e.getStackTrace());
				return (false);
		} catch (Exception ex) { 
			 System.out.println("Productos dao borra: An Exception has occurred! " + ex); 
			 return (false);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println("Productos dao borra: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Productos dao borra: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	
		
		
		
		return true;
	}
	
	public Boolean agrega(Productos producto) {
		Statement stmt = null; 
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 

					
			String insertSQL = "insert into PRODUCTOS(NOMBRE,COSTO,VENTA,DESCRIPCION)  values(?,?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) currentCon.prepareStatement(insertSQL);
			preparedStatement.setString(1,producto.getNombre());
			preparedStatement.setDouble(2,producto.getCosto());
			preparedStatement.setDouble(3,producto.getVenta());
			preparedStatement.setString(4,producto.getDescripcion());
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
				System.err.println("Productos dao SQLError: " + e.getSQLState() + "\n"+e.getStackTrace());
				return (false);
		} catch (Exception ex) { 
			 System.out.println("Productos dao add: An Exception has occurred! " + ex); 
			 return (false);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println("Productos dao add: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Productos dao add: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}
		return true;
	}
}



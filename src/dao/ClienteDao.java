package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Cliente;
import singleton.dbConexion;

public class ClienteDao {
	static Connection currentCon = null; 
	static ResultSet rs = null; 
	 
	public ClienteDao() {
		// TODO Auto-generated constructor stub
	}
	

	public Cliente getOne(String rfc){
		Cliente cliente = new Cliente();
		Statement stmt = null; 
		//String searchQuery = "select CLIENTE_ID, APPATERNO,APMATERNO,NOMBRE,RAZON,RFC,DIRECCION,COLONIA,MUNICIPIO,ESTADO from CLIENTES where CLIEENTE_ID;";
		
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			//stmt=currentCon.createStatement(); 
			//rs = stmt.executeQuery(searchQuery); 
			String selectSQL = "select CLIENTE_ID, APPATERNO,APMATERNO,NOMBRE,RAZON,RFC,DIRECCION,COLONIA,MUNICIPIO,ESTADO from CLIENTES where RFC = ?  LIMIT 1;";
			PreparedStatement preparedStatement = (PreparedStatement) currentCon.prepareStatement(selectSQL);
			preparedStatement.setString(1,rfc);
			 //rs = preparedStatement.executeQuery(selectSQL);
			rs = preparedStatement.executeQuery();
			//boolean more = rs.next();
			if (rs==null) 
				return cliente;
			if (dbConexion.getResultSetRowCount(rs) ==0) 
				return cliente;
			while (rs.next()) {
				//System.out.println("- " +rs.getString(1)+ rs.getString(2));
				
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
		return cliente;
	}
	
	public Cliente getOne(int id){
		Cliente cliente = new Cliente();
		Statement stmt = null; 
		//String searchQuery = "select CLIENTE_ID, APPATERNO,APMATERNO,NOMBRE,RAZON,RFC,DIRECCION,COLONIA,MUNICIPIO,ESTADO from CLIENTES where CLIEENTE_ID;";
		
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			//stmt=currentCon.createStatement(); 
			//rs = stmt.executeQuery(searchQuery); 
			String selectSQL = "select CLIENTE_ID, APPATERNO,APMATERNO,NOMBRE,RAZON,RFC,DIRECCION,COLONIA,MUNICIPIO,ESTADO from CLIENTES where CLIENTE_ID = ? ;";
			PreparedStatement preparedStatement = (PreparedStatement) currentCon.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			//ResultSet rs = preparedStatement.executeQuery(selectSQL);
			rs = preparedStatement.executeQuery();
			
			//boolean more = rs.next();
			if (rs==null) 
				return cliente;
			if (dbConexion.getResultSetRowCount(rs) ==0) 
				return cliente;
			while (rs.next()) {
				//System.out.println("- " +rs.getString(1)+ rs.getString(2));
				
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
		return cliente;
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
			 System.out.println("Cliente dao getall: An Exception has occurred! " + ex); 
			 return (lista);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println("Cliente dao getall: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Cliente dao getall: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	
		
	    return lista;
	}
	
	public Boolean borra(int id) {
		//List<Cliente> lista = new ArrayList<Cliente>(); 
		Statement stmt = null; 
	
		if (this.getOne(id).equals(null)){
			return false;
		}
		
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
	
	
	public Boolean agrega(Cliente cliente) {
		//List<Cliente> lista = new ArrayList<Cliente>(); 
		Statement stmt = null; 
		//Cliente cliente2=this.getOne(cliente.getRfc());
		if (this.getOne(cliente.getRfc()).getRfc()==null){
			
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
		
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			//stmt=currentCon.createStatement(); 
			//rs = stmt.executeQuery(searchQuery); 
			
			/*
			 * http://alvinalexander.com/java/java-mysql-insert-example-preparedstatement
			 * 
			String insertTableSQL = "INSERT INTO DBUSER"
					+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
					+ "(?,?,?,?)";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, 11);
			preparedStatement.setString(2, "mkyong");
			preparedStatement.setString(3, "system");
			preparedStatement.setTimestamp(4, getCurrentTimeStamp());
			// execute insert SQL stetement
			preparedStatement .executeUpdate();
			*/
					
			String insertSQL = "insert into CLIENTES(APPATERNO,APMATERNO,NOMBRE,RAZON,RFC,DIRECCION,COLONIA,MUNICIPIO,ESTADO) VALUES(?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) currentCon.prepareStatement(insertSQL);
			preparedStatement.setString(1,cliente.getAppaterno());
			preparedStatement.setString(2,cliente.getApmaterno());
			preparedStatement.setString(3,cliente.getNombre());
			preparedStatement.setString(4,cliente.getRazon());
			preparedStatement.setString(5,cliente.getRfc());
			preparedStatement.setString(6,cliente.getDireccion());
			preparedStatement.setString(7,cliente.getColonia());
			preparedStatement.setString(8,cliente.getMunicipio());
			preparedStatement.setString(9,cliente.getEstado());
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
				System.err.println("SQLError: " + e.getSQLState() + "\n"+e.getStackTrace());
				return (false);
		} catch (Exception ex) { 
			 System.out.println("Cliente dao: An Exception has occurred! " + ex); 
			 return (false);
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
		}
		else
			return false;
		
	    return true;
	}

}

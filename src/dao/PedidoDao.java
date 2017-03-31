package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Pedidos;
//import model.Productos;
import singleton.dbConexion;

public class PedidoDao {
	static Connection currentCon = null; 
	static ResultSet rs = null; 
	
	public PedidoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Pedidos> getAll() {
		List<Pedidos> lista = new ArrayList<Pedidos>(); 
		Statement stmt = null; 
		String searchQuery = "select PEDIDO_ID, FECHA_PEDIDO,FECHA_ENTREGA,DESCRIPCION,ESTATUS from PEDIDOS;";
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			stmt=currentCon.createStatement(); 
			rs = stmt.executeQuery(searchQuery); 
			//boolean more = rs.next();
			if (rs==null) 
				return lista;
			while (rs.next()) {
				//System.out.println("- " +rs.getString(1)+ rs.getString(2));
				Pedidos pedido = new Pedidos();
				
				pedido.setPedidosId(Integer.parseInt(rs.getString(1)));
				
				SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
				pedido.setFechapedio(formato.parse(rs.getString(2)));
				pedido.setFechaentrega(formato.parse(rs.getString(3)));
				pedido.setDescripcion(rs.getString(4));
				pedido.setEstatus(Boolean.parseBoolean(rs.getString(5)));
				

				
				/*producto.setProductosId(Integer.parseInt(rs.getString(1)));
				producto.setNombre(rs.getString(2));
				producto.setCosto(Double.parseDouble(rs.getString(3)));
				producto.setVenta(Double.parseDouble(rs.getString(4)));
				producto.setDescripcion(rs.getString(5)); */
				lista.add(pedido);
			}
		}catch(SQLException ex){
			System.err.println(" Pedidos dao SQLError: " + ex.getSQLState() + "\n"+ex.getStackTrace());	
		 } catch (Exception ex) { 
			 System.out.println("Pedidos dao: An Exception has occurred! " + ex); 
			 return (lista);
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				    
				} catch (Exception e) {
					System.out.println("Pedidos dao: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Pedidos dao: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	
		
	    return lista;
	}
		
	
	public Pedidos getOne(int id){
		Pedidos pedido = new Pedidos();
		//insert into PEDIDOS(FECHA_PEDIDO,FECHA_ENTREGA,DESCRIPCION) values (NOW(),STR_TO_DATE('30-03-2017 13:35:00','%d-%m-%Y %H:%i:%s'),'Pedido con pastele como cars');
		Statement stmt = null; 
		try { //connect to DB 
			currentCon = dbConexion.getConnection(); 
			//stmt=currentCon.createStatement(); 
			//rs = stmt.executeQuery(searchQuery); 
			String selectSQL = "select PEDIDO_ID, FECHA_PEDIDO,FECHA_ENTREGA,DESCRIPCION, ESTATUS from PEDIDOS where PEDIDO_ID = ? ;";
			PreparedStatement preparedStatement = (PreparedStatement) currentCon.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			//ResultSet rs = preparedStatement.executeQuery(selectSQL);
			rs = preparedStatement.executeQuery();
			
			//boolean more = rs.next();
			if (rs==null) 
				return pedido;
			if (dbConexion.getResultSetRowCount(rs) ==0) 
				return pedido;
			while (rs.next()) {
				//System.out.println("- " +rs.getString(1)+ rs.getString(2));
				
				pedido.setPedidosId(Integer.parseInt(rs.getString(1)));
				SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
				pedido.setFechapedio( formato.parse(rs.getString(2))) ;
				pedido.setFechaentrega(formato.parse(rs.getString(3)));
				pedido.setDescripcion(rs.getString(4));
				pedido.setEstatus((Integer.parseInt(rs.getString(5))!=0));
				//System.out.println("Pedido dao ! " +pedido.getDescripcion() +" Estado:"+ pedido.getEstatus() +" get "+ (Integer.parseInt(rs.getString(5))!=0) );
				 
			}
		}catch (SQLException e) {
			System.err.println("Pedido dao getOne: SQLError: " + e.getSQLState() + "\n"+e.getStackTrace());	
		 } catch (Exception ex) { 
			 System.out.println("Pedido dao getOne: An Exception has occurred! " + ex); 
		 } 
			
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println("Pedido dao getOne: An Exception has occurred! " + e);
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println("Pedido dao getOne: An Exception has occurred! " + e);
				}
				stmt = null;
			}
		}	

		return pedido;
	}
	

}

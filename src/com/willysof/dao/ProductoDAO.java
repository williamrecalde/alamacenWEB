package com.willysof.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.willysof.conexion.Conexion;
import com.willysoft.model.Producto;

public class ProductoDAO {
	
	private Connection conexion;
	private PreparedStatement pst;
	//private ResultSet rs;
	private boolean estado;
	
	
	public boolean guardar( Producto producto) throws SQLException {
		/*id, codigo, nombre, precio, existencia, fecha_crear, fecha_actualizar*/
		estado = false;
		String sql = "INSERT INTO productos(codigo, nombre, precio, existencia,fecha_crear, fecha_actualizar) VALUES(?,?,?,?,?,?)";
		conexion = getConexion();
		
		try {
			conexion.setAutoCommit(false);
			
			pst = conexion.prepareStatement(sql);
			pst.setString(1,producto.getCodigo());
			pst.setString(2,producto.getNombre());
			pst.setDouble(3,producto.getPrecio());
			pst.setInt(4,producto.getExistencia());
			pst.setDate(5,producto.getFecha_crear());
			pst.setDate(6,producto.getFecha_actualizar());
			
			estado = pst.executeUpdate() >0;
			
			conexion.commit();
			pst.close();
			conexion.close();
		} catch (SQLException e) {
			conexion.rollback();
			e.printStackTrace();
		}
		
		return estado;
	}
	
	public boolean editar( Producto producto)  throws SQLException {
		estado = false;
		String sql = "UPDATE productos set codigo=?,nombre=?, precio=?, existencia=?, fecha_actualizar=? WHERE id=?";
		conexion = getConexion();
		try {
			conexion.setAutoCommit(false);
			
			pst = conexion.prepareStatement(sql);
			pst.setString(1,producto.getCodigo());
			pst.setString(2,producto.getNombre());
			pst.setDouble(3,producto.getPrecio());
			pst.setInt(4,producto.getExistencia());			
			pst.setDate(5,producto.getFecha_actualizar());
			pst.setInt(6,producto.getId());
			
			estado = pst.executeUpdate() >0;
			
			conexion.commit();
			pst.close();
			conexion.close();
		} catch (SQLException e) {
			conexion.rollback();
			e.printStackTrace();
		}
		
		return estado;
	}
	
	public boolean eliminar( int id) throws SQLException {
		estado = false;
		String sql = "DELETE FROM productos  WHERE id=?";
		conexion = getConexion();
		try {
			conexion.setAutoCommit(false);			
			pst = conexion.prepareStatement(sql);
			pst.setInt(1,id);	
			estado = pst.executeUpdate() >0;
			conexion.commit();
			pst.close();
			conexion.close();
		} catch (SQLException e) {
			conexion.rollback();
			e.printStackTrace();
		}
		
		return estado;
	}
	
	public List<Producto> obtenerProductos() throws SQLException{
		/*id, codigo, nombre, precio, existencia, fecha_crear, fecha_actualizar*/
		List<Producto> listado = new ArrayList<>();
		ResultSet rs = null;
		estado = false;
		String sql = "SELECT * FROM productos";
		conexion = getConexion();
		
		try {
			pst = conexion.prepareStatement(sql);
			rs = pst.executeQuery() ;
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt(1));
				producto.setCodigo(rs.getString(2));
				producto.setNombre(rs.getString(3));
				producto.setPrecio(rs.getDouble(4));
				producto.setExistencia(rs.getInt(5));
				producto.setFecha_crear(rs.getDate(6));
				producto.setFecha_actualizar(rs.getDate(7));
				listado.add(producto);
			}
			
			pst.close();
			conexion.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listado;
	}
	
	public List<Producto> obtenerProductosNombre(String nombre) throws SQLException{
		/*id, codigo, nombre, precio, existencia, fecha_crear, fecha_actualizar*/
		List<Producto> listado = new ArrayList<>();
		ResultSet rs = null;
		estado = false;
		String sql = "SELECT * FROM productos WHERE nombre LIKE('%"+nombre+"%')";
		conexion = getConexion();
		
		try {
			pst = conexion.prepareStatement(sql);
			rs = pst.executeQuery() ;
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt(1));
				producto.setCodigo(rs.getString(2));
				producto.setNombre(rs.getString(3));
				producto.setPrecio(rs.getDouble(4));
				producto.setExistencia(rs.getInt(5));
				producto.setFecha_crear(rs.getDate(6));
				producto.setFecha_actualizar(rs.getDate(7));
				listado.add(producto);
			}
			
			pst.close();
			conexion.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listado;
	}
	
	public Producto obtenerProducto(int id) throws SQLException{
		/*id, codigo, nombre, precio, existencia, fecha_crear, fecha_actualizar*/
		
		ResultSet rs = null;
		estado = false;
		Producto producto = new Producto();
		String sql = "SELECT * FROM productos WHERE id=?";
		conexion = getConexion();
		
		try {
			pst = conexion.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery() ;
			if(rs.next()) {
				
				producto.setId(rs.getInt(1));
				producto.setCodigo(rs.getString(2));
				producto.setNombre(rs.getString(3));
				producto.setPrecio(rs.getDouble(4));
				producto.setExistencia(rs.getInt(5));
				producto.setFecha_crear(rs.getDate(6));
				producto.setFecha_actualizar(rs.getDate(7));
				
			}
			
			pst.close();
			conexion.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return producto;
	}
	
	private Connection getConexion() throws SQLException {
		return Conexion.getConnection();
	}
	

}

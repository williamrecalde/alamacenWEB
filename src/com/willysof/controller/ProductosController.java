package com.willysof.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willysof.dao.ProductoDAO;
import com.willysoft.model.Producto;

/**
 * Servlet implementation class ProductosController
 */
@WebServlet(description = "Administra tabla productos", urlPatterns = { "/productos" })
public class ProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		if(opcion.equals("crear")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/crear.jsp");
			dispatcher.forward(request, response);
		}else if(opcion.equals("listar")) {
			ProductoDAO productoDAO = new ProductoDAO();
			try {
				List<Producto> lista= productoDAO.obtenerProductos();
				/*for (Producto producto : lista) {
					System.out.println(producto);
				}*/
				request.setAttribute("lista", lista);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/listar.jsp");			
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opcion.equals("actualizar")) {
			int id = Integer.parseInt( request.getParameter("id")) ;
			ProductoDAO productoDAO = new ProductoDAO();
			try {
				Producto producto = new Producto();
				producto = productoDAO.obtenerProducto(id);
				request.setAttribute("producto", producto);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/editar.jsp");			
				dispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//fin de actualizar
		else if(opcion.equals("eliminar")) {
			int id = Integer.parseInt( request.getParameter("id")) ;
			ProductoDAO productoDAO = new ProductoDAO();
			try {
				
				productoDAO.eliminar(id);				
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");			
				dispatcher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//fin de eliminar
		
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		Date fechaActual = new Date();
		long time = fechaActual.getTime();
		java.sql.Date fechaBD = new java.sql.Date(time);
		
		
		if(opcion.equals("guardar")) {
			try {
				ProductoDAO productoDAO = new ProductoDAO();
				Producto producto = new Producto();
				
				producto.setCodigo(request.getParameter("codigo"));
				producto.setNombre(request.getParameter("nombre"));
				producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
				producto.setExistencia(Integer.parseInt(request.getParameter("existencia")));
				producto.setFecha_crear(fechaBD);
				producto.setFecha_actualizar(fechaBD);
				productoDAO.guardar(producto);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion.equals("editar")) {
			
			try {
				ProductoDAO productoDAO = new ProductoDAO();
				Producto producto = new Producto();
				
				producto.setId(Integer.parseInt( request.getParameter("id")) );
				producto.setCodigo(request.getParameter("codigo"));
				producto.setNombre(request.getParameter("nombre"));
				producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
				producto.setExistencia(Integer.parseInt(request.getParameter("existencia")));
				//producto.setFecha_crear(fechaBD);
				producto.setFecha_actualizar(fechaBD);
				productoDAO.editar(producto);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}

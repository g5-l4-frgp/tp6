package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.commons.xmlutil.Converter;

import DAO.DAO_seguro;
import Entidad.Tipo_seguro;
import Entidad.Contratacion;
import Entidad.Seguro;
/**
 * Servlet implementation class servletsSeguro
 */
@WebServlet("/servletsSeguro")
public class servletsSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletsSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(request.getParameter("Param1")!=null)
		{
			int id = 0;
			Seguro seguro =new Seguro();
			//Entra por haber echo click en el hyperlink mostrar usuarios
		    DAO_seguro sdao = new DAO_seguro(); 
		    ArrayList<Tipo_seguro> lista = sdao.obtenerTipoSeguro();
			request.setAttribute("listaT", lista);
			ArrayList<Seguro> listaSeguro = sdao.obtenerSeguros();
			seguro =listaSeguro.get(listaSeguro.size() -1 );
			id = seguro.getId_seguro()+1;
			
			request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("/Pantalla_agregar_seguro.jsp");   
	        rd.forward(request, response);
			
		}
		

		 if(request.getParameter("Param2")!=null)
		{
			//Entra por haber echo click en el hyperlink mostrar usuarios
		    DAO_seguro sdao = new DAO_seguro(); 
		    ArrayList<Tipo_seguro> lista = sdao.obtenerTipoSeguro();
		    ArrayList<Seguro> listaSeguro = sdao.obtenerSeguros();
			request.setAttribute("listaT", lista);
			request.setAttribute("listaSeguro", listaSeguro);
			RequestDispatcher rd = request.getRequestDispatcher("/Pantalla_listar_seguros.jsp");   
	        rd.forward(request, response);
	       
			
		}
		 
		if(request.getParameter("btnFiltrar")!=null) {
				int id = Integer.parseInt(request.getParameter("ddl_tipo_seguro"));
			    DAO_seguro sdao = new DAO_seguro(); 
			    ArrayList<Tipo_seguro> lista = sdao.obtenerTipoSeguro();
			    ArrayList<Seguro> listaSeguro = sdao.obtenerSegurosFiltrados(id);
				request.setAttribute("listaT", lista);
				request.setAttribute("listaSeguro", listaSeguro);
				RequestDispatcher rd = request.getRequestDispatcher("/Pantalla_listar_seguros.jsp");   
		        rd.forward(request, response);
				
			}		 
		

		
		int idTipo;
		Seguro seguro = new Seguro();
		Seguro idSeguro = new Seguro();
		DAO_seguro DaoSeguro = new DAO_seguro();
		Tipo_seguro tipoS = new Tipo_seguro();
		if(request.getParameter("btnAceptar")!=null)
		{
		idTipo = Integer.parseInt(request.getParameter("ddl_tipo_seguro"));
		tipoS.setId(idTipo);
		seguro.setTipo(tipoS);
		seguro.setDescripcion(request.getParameter("txt_Descripcion"));
		seguro.setCosto_asegurado(Double.parseDouble(request.getParameter("txt_cost_max_asignado")));
		seguro.setCosto_contratacion(Double.parseDouble(request.getParameter("txt_cost_contratacion")));
		
		 int filas =DaoSeguro.agregarSeguro(seguro);
			ArrayList<Seguro> listaSeguro = DaoSeguro.obtenerSeguros();
			idSeguro =listaSeguro.get(listaSeguro.size() -1 );
			int id = idSeguro.getId_seguro()+1;
			ArrayList<Tipo_seguro> lista = DaoSeguro.obtenerTipoSeguro();
			request.setAttribute("listaT", lista);
			request.setAttribute("id", id);
			//REQUESTDISPATCHER
			request.setAttribute("cantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/Pantalla_agregar_seguro.jsp");   
	        rd.forward(request, response);   
			 
		 }
		//request.setAttribute("idTipo", idTipo);
		//RequestDispatcher rd = request.getRequestDispatcher("/Pantalla_agregar_seguro.jsp");
		// rd.forward(request, response);
			
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		

	}

}

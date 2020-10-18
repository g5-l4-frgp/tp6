package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entidad.Seguro;
import Entidad.Tipo_seguro;

public class DAO_seguro {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "ROOT";
	private String dbName = "segurosgroup";
	
	public int agregarSeguro(Seguro seguro)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "Insert into seguros(descripcion,idTipo,costoAsegurado,costoContratacion) values ('"+seguro.getDescripcion()+"','"+seguro.getTipoId()+"','"+seguro.getCosto_asegurado()+"','"+seguro.getCosto_contratacion()+"')";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public ArrayList<Tipo_seguro> obtenerTipoSeguro() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Tipo_seguro> lista = new ArrayList<Tipo_seguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select idTipo,descripcion from tiposeguros");
			
			while(rs.next()){
				
				Tipo_seguro tipoSeguro = new Tipo_seguro();
				tipoSeguro.setId(rs.getInt("idTipo"));
				tipoSeguro.setDescripcion(rs.getString("descripcion"));
				
				lista.add(tipoSeguro);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}

		return lista;
	}
	
	
	public ArrayList<Seguro> obtenerSegurosFiltrados(int id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select s.idSeguro, s.descripcion, t.descripcion, t.idTipo, s.costoContratacion, s.costoAsegurado  from seguros as s inner join tiposeguros as t on t.idTipo = s.idTipo where s.idTipo ="+id);
			
			while(rs.next()){
				Tipo_seguro tipoSeguro = new Tipo_seguro();
				Seguro seguro = new Seguro();
				seguro.setId_seguro(rs.getInt("s.idSeguro"));
				seguro.setDescripcion(rs.getString("s.descripcion"));
				tipoSeguro.setDescripcion(rs.getString("t.descripcion"));
				tipoSeguro.setId(rs.getInt("t.idTipo"));
				seguro.setCosto_contratacion(rs.getDouble("s.costoContratacion"));
				seguro.setCosto_asegurado(rs.getDouble("s.costoAsegurado"));
				
				seguro.setTipo(tipoSeguro);
				
				
				lista.add(seguro);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}

		return lista;
	}
	
	public ArrayList<Seguro> obtenerSeguros() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select s.idSeguro, s.descripcion, t.descripcion, t.idTipo, s.costoContratacion, s.costoAsegurado  from seguros as s inner join tiposeguros as t on t.idTipo = s.idTipo");
			
			while(rs.next()){
				Tipo_seguro tipoSeguro = new Tipo_seguro();
				Seguro seguro = new Seguro();
				seguro.setId_seguro(rs.getInt("s.idSeguro"));
				seguro.setDescripcion(rs.getString("s.descripcion"));
				tipoSeguro.setDescripcion(rs.getString("t.descripcion"));
				tipoSeguro.setId(rs.getInt("t.idTipo"));
				seguro.setCosto_contratacion(rs.getDouble("s.costoContratacion"));
				seguro.setCosto_asegurado(rs.getDouble("s.costoAsegurado"));
				
				seguro.setTipo(tipoSeguro);
				
				
				lista.add(seguro);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}

		return lista;
	}



}


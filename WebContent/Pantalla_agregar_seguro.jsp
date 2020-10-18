<%@page import="Entidad.Contratacion"%>
<%@page import="Entidad.Tipo_seguro"%>
<%@page import="DAO.DAO_seguro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

		    
	<a href="Pantalla_Inicio.jsp"> Inicio </a>
	<a href="servletsSeguro?Param1=1"> Agregar seguro </a>
	<a href="servletsSeguro?Param2=2"> Listar seguros </a>
	
	<br><br>
	<h2> <b> Agregar seguros </b> </h2>
	<br><br>

	<form action="servletsSeguro" method="get" >
				<%int id = 0; 
		id = Integer.parseInt(request.getAttribute("id").toString());%>
		Id: <%=id%><br>
		
		Descripcion <input type="text" name="txt_Descripcion" style="width: 171px; ">  <br>
		
		
		Tipo de seguro  <select name = "ddl_tipo_seguro" style="width: 153px; ">
	
	 <%
		 	ArrayList<Tipo_seguro> listaTipo =  new ArrayList<Tipo_seguro>();
		listaTipo = (ArrayList<Tipo_seguro>)request.getAttribute("listaT");
		
		 if(listaTipo!=null)
		 for(Tipo_seguro e : listaTipo)
		{
		
		
	%>	
	<option value="<%=e.getId()%>"><%=e.getDescripcion()%></option>
		<%  } %>
		
		
		</select> <br>

		Costo contratacion <input type="text" name="txt_cost_contratacion"> <br>
		Costo maximo asignado <input type="text" name="txt_cost_max_asignado"> <br>
		<input type="submit" value="Aceptar" name="btnAceptar">
	

	</form>
<%
	int filas=0;
	if(request.getAttribute("cantFilas")!=null)
		filas= (int)request.getAttribute("cantFilas");
	//	filas=  Integer.parseInt(request.getAttribute("cantFilas").toString());;	

%>
<% if(filas==1) 
	{
%>
		Usuario agregado con Exito
<%}%>

</body>
</html>
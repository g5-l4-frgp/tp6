<%@page import="Entidad.Contratacion"%>
<%@page import="Entidad.Tipo_seguro"%>
<%@page import="Entidad.Seguro"%>
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
	<h2> <b> Tipo de seguros de la base de datos </b> </h2>
	<br><br>
	
	<form action="servletsSeguro" method="get">
	
	<h3>Busqueda por tipo de seguros: </h3><select name = "ddl_tipo_seguro" style="width: 153px; ">

		
	 <%
		 	ArrayList<Tipo_seguro> listaTipo =  new ArrayList<Tipo_seguro>();
		listaTipo = (ArrayList<Tipo_seguro>)request.getAttribute("listaT");
		

		 if(listaTipo!=null)
		 for(Tipo_seguro e : listaTipo)
		{
	
		
	%>	
	<option value="<%=e.getId()%>"><%=e.getDescripcion()%></option>
		<%  } %>
		
		<%
		ArrayList<Seguro> listaSeguro =  new ArrayList<Seguro>();
		listaSeguro = (ArrayList<Seguro>)request.getAttribute("listaSeguro");
		

		%>
		</select>

<input type="submit" value="Filtrar" name="btnFiltrar">

	</form>
<table id="table_id" border="1" class="display">
    <thead>
        <tr>
            <th>ID seguro</th>
            <th>Descripcion</th> 
            <th>Descripcion tipo de seguro</th>
            <th>Costo contratacion</th>
            <th>Costo Asignado</th>
            
            
        </tr>
       
    </thead>
    <tbody>
       <%  if(listaSeguro!=null)
  		 for(Seguro e : listaSeguro)
		{
%>
		<tr>  
		    
				<td><%=e.getId_seguro() %>  </td> 
				<td><%=e.getDescripcion() %></td>   
				<td><%=e.getTipoDescripcion() %></td>
		  		<td><%=e.getCosto_contratacion() %></td>
				<td><%=e.getCosto_asegurado() %></td>		
		
		</tr>
		
	<%  } %>	 
    </tbody>
    
</table>

</body>
</html>
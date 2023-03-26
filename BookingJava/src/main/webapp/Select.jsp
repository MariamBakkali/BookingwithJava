<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busque la ciudad</title>
</head>
<body>
	
  <%@ page import="com.welcome.Ciudades" %>
    <form action="Ciudades" method="get">
        <table>
            <tr>
                <td>Elija la ciudad:</td>
                <td><input type="text" name="NombreCiudad" maxlength="16" size="17" /></td>
            </tr>
            
  
        </table>
        <br /> <input type="submit" value="Ver Resultado">
    </form>
    <br />
    <input type="button" value="Vuelva a Inicio"
        onclick="window.location.href='Home.jsp'" />
  
</body>
  
</html>
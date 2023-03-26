<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalles de la búsqueda</title>
</head>
<body>
  
    <h2>Su Ciudad</h2>
  
    <form>
        <input type="hidden" name="NombreCiudad"
            value="<%=request.getParameter("NombreCiudad")%>">
        <input type="hidden" name="idCiudad"
            value="<%=request.getParameter("idCiudad")%>">    
  
        <table>
            <tr>
                <td>Ciudad:</td>
                <td><%=request.getParameter("NombreCiudad")%></td>
            </tr>
            
            
            <tr />
        </table>
        <br />
    </form>
    <br />
    <input type="button" value="Update data" onclick="update()" />
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
  
</body>
  
<script language="javascript" type="text/javascript">
    function update() {
        var NombreCiudad = document.forms[0].elements['NombreCiudad'].value;
        window.location.href = "Update.jsp?NombreCiudad=" + sid;
    }
    function update() {
        var idCiudad = document.forms[0].elements['idCiudad'].value;
        window.location.href = "Update.jsp?idCiudad=" + sid;
    }
</script>
</html>
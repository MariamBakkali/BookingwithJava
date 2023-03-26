<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Details</title>
</head>
<body>
  
    
    <%@ page import="com.welcome.ServletAñadirUsuario" %>
    <form action="ServletAñadirUsuario" method="post">
    <h2>Modificar</h2>
        <table>
         
            <tr>
                <td>ID:</td>
                <td><input type="text" name="idUsuario" maxlength="30" size="25"/></td>
            </tr>
            <tr>
                <td>Teléfono:</td>
                <td><input type="text" name="TelefonoUsu" maxlength="30" size="25" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="MailUsu" maxlength="40" size="35" /></td>
            </tr>
            <tr>
                <td>Contraseña:</td>
                <td><input type="text" name="PasswordUsu" maxlength="10" size="11" /></td>
            </tr>
            <tr />
        </table>
        
        
        <input type="hidden" name="Origen" value="Update" />
        
        <br /> <input type="submit" value="Update Data" />
    </form>
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
  
</body>
</html>
package com.welcome;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Servlet implementation class ServletAñadirUsuario
 */
public class ServletAñadirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletAñadirUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
	
		
		String origen;
		
        origen = request.getParameter("Origen");
		
		switch(origen){
		case "Insert":
			usuario.setNombreUsu(request.getParameter("NombreUsu"));
			usuario.setApellidoUsu(request.getParameter("ApellidoUsu"));
	        usuario.setTelefonoUsu(request.getParameter("TelefonoUsu"));
	        usuario.setMailUsu(request.getParameter("MailUsu"));
	        usuario.setPasswordUsu(request.getParameter("PasswordUsu"));
	        usuario.setIdDescuento(Integer.valueOf(request.getParameter("idDescuento")));

	        if(usuarioDAO.add(usuario)!=0) {
	        	// Llamar a otra página de errores, similar a la de 'Succes'
	        	System.out.println("ERROR!!!!!");
	        } else {
	            response.sendRedirect("Success.jsp?msg=Insert");
	        }
			break;
			
		case "Update": 
			
			if(usuarioDAO.update(Integer.valueOf(request.getParameter("idUsuario")),request.getParameter("TelefonoUsu"),request.getParameter("MailUsu"),request.getParameter("PasswordUsu"))) {
				response.sendRedirect("Success.jsp?msg=Insert");
	        	
			} else {System.out.println("ERROR!!!!!");
				
			}
			/*
							
		            Class.forName(DBUtil.CONTROLADOR);
		        } catch (ClassNotFoundException e) {
		            System.out.println("Class not found " + e);
		        }
		        try {
		            Connection conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USUARIO, DBUtil.CLAVE);
		            System.out.println("connection successful");
		            PreparedStatement st = conn
		                    .prepareStatement("update usuario set nom=?, email=?, phonenum=? where stuid=?");
		  
		            st.setString(1, request.getParameter("name"));
		            st.setString(2, request.getParameter("email"));
		            st.setString(3, request.getParameter("phnum"));
		            st.setInt(4, Integer.valueOf(request.getParameter("id")));
		  
		            st.executeUpdate();
		  
		            st.close();
		            conn.close();
		  
		            response.sendRedirect("Success.jsp?msg=Update");
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        */
	    	break;
	} 
		
		
		
		
		
		
		

        


	}
		
		
		 
		
		/*
		// Jdbc Connection
        try {
            Class.forName(DBUtil.CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
            Connection conn = DriverManager.getConnection( DBUtil.URL, DBUtil.USUARIO, DBUtil.CLAVE);
            System.out.println("connection successful");
              
              // Query/statement to insert the values
            PreparedStatement st = conn.prepareStatement("insert into usuario values(?, ?, ?, ?, ?, ?, ?)");
  
            // set values into the query

            st.setInt(1, Integer.valueOf(request.getParameter("idUsuario")));
            st.setString(2, request.getParameter("NombreUsu"));
            st.setString(3, request.getParameter("ApellidoUsu"));
            st.setString(4, request.getParameter("TelefonoUsu"));
            st.setString(5, request.getParameter("MailUsu"));
            st.setString(6, request.getParameter("PasswordUsu"));
            st.setInt(7, Integer.valueOf(request.getParameter("idDescuento")));
  
            // Execute the query
            st.executeUpdate();
  
            st.close();
            conn.close();
  
            // Redirect the response to success page
            response.sendRedirect("Success.jsp?msg=Insert");
        } catch (Exception e) {
            e.printStackTrace();
        }
*/


}

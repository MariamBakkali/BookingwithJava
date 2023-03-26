package com.welcome;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class InsertDetails
 */
public class InsertDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
            PreparedStatement st = conn.prepareStatement("insert into usuarios values(?, ?, ?, ?)");
  
            // set values into the query
            st.setInt(1, Integer.valueOf(request.getParameter("id")));
            st.setString(2, request.getParameter("name"));
            st.setString(3, request.getParameter("email"));
            st.setString(4, request.getParameter("phnum"));
  
            // Execute the query
            st.executeUpdate();
  
            st.close();
            conn.close();
  
            // Redirect the response to success page
            response.sendRedirect("Success.jsp?msg=Insert");
        } catch (Exception e) {
            e.printStackTrace();
        }
}

	}


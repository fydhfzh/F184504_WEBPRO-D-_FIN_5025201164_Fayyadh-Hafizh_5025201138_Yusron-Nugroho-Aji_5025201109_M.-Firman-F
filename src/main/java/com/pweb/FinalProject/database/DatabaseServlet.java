package com.pweb.FinalProject.database;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class DatabaseServlet
 */
public class DatabaseServlet extends HttpServlet {
	
	
    public static Connection initConnection() throws ServletException {
    	Connection conn = null;
    	try {
    		final long serialVersionUID = 1L;
    	    final String URL = "jdbc:postgresql://127.0.0.1:5432/pweb";
    	    final String USER = "postgres";
    	    final String PASSWORD = "postgres";
    	    final String DRIVER = "org.postgresql.Driver";
    		
    		Class.forName(DRIVER);
    		conn = DriverManager.getConnection(URL, USER, PASSWORD);	
    		if(conn != null) {
    			System.out.println("Connection Established");
    		}else {
    			System.out.println("Connection Failed");
    		}
    	}catch(ClassNotFoundException | SQLException e){
    		e.printStackTrace();
    	}
    	return conn;
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<html><body>");
			
			Connection conn = DatabaseServlet.initConnection();
			
			Statement stmt = conn.createStatement();
			String sql = "select * from public.users;";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
//				String text = rs.getString("text");
				
				out.println("<h4>Text " + id + "</h4>");
			}
			
			out.println("</body></html>");
			
			rs.close();
			stmt.close();
			out.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


}

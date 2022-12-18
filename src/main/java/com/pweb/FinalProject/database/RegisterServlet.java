package com.pweb.FinalProject.database;

import jakarta.servlet.RequestDispatcher;


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

import com.pweb.FinalProject.database.DatabaseServlet;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/insertUser")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Connection conn = DatabaseServlet.initConnection();
			Statement stmt = conn.createStatement();
			String sql = "insert into public.users (name, email, password) values ('" + name + "', '" + email + "', '" + password + "')";
			stmt.executeUpdate(sql);
			
			RequestDispatcher rd = request.getRequestDispatcher("/FinalProject/login.jsp");
			rd.forward(request, response);
		
			stmt.close();
			out.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();		
		}
	}

}

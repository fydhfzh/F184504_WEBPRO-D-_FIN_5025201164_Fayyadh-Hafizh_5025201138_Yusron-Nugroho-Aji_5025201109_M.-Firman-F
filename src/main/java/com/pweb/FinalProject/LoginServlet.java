package com.pweb.FinalProject;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pweb.FinalProject.database.DatabaseServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(request.getCookies() == null) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Connection conn = DatabaseServlet.initConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from public.users where email = '" + email + "' and password = '" + password + "';";
			ResultSet rs = stmt.executeQuery(sql);
			
			RequestDispatcher rd;
			if(rs.next() == false) {
				rd = request.getRequestDispatcher("/FinalProject/login.jsp");
				rd.forward(request, response);
			}else {
				Cookie nameCookie = new Cookie("name", rs.getString("name"));
				Cookie emailCookie = new Cookie("email", rs.getString("email"));
				
				nameCookie.setMaxAge(60*60*24*365);
				emailCookie.setMaxAge(60*60*24*365);
				
				response.addCookie(emailCookie);
				
				rd = request.getRequestDispatcher("/FinalProject/index.jsp");
				rd.forward(request, response);
			}
			
			rs.close();
			stmt.close();
			out.close();
			conn.close();
			}else {
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("/FinalProject/index.jsp");
				rd.forward(request, response);
			}
		}catch(SQLException e) {
			e.printStackTrace();		
		}
	}

}

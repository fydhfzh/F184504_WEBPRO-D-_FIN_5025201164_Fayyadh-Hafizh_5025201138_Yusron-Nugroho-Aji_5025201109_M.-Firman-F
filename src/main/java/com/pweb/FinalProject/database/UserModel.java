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

import java.util.ArrayList;
import java.util.List;
import com.pweb.FinalProject.model.User;

public class UserModel {
	public static ArrayList<User> all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<User> users = new ArrayList<User>();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Connection conn = DatabaseServlet.initConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from public.Users";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password")));
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		
			rs.close();
			stmt.close();
			out.close();
			conn.close();
			
			return users;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}

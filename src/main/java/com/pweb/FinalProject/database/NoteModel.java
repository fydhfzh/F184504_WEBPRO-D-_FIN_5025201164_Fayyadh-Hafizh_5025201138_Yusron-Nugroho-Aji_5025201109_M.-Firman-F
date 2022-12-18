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
import com.pweb.FinalProject.model.Note;


public class NoteModel {
	public static ArrayList<Note> all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Note> notes = new ArrayList<Note>();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
			Connection conn = DatabaseServlet.initConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from public.notes";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				notes.add(new Note(rs.getInt("id"), rs.getString("text")));
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		
			rs.close();
			stmt.close();
			out.close();
			conn.close();
			
			return notes;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}

package com.blogcice.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AgragarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement pstm = null;
	private Connection cont = null;
	private String user = "root";
	private String pass = "root";
	private String url = "jdbc:mysql://localhost:3306/blog"; 
	private String noticia, titulo; 
       
    
    public AgragarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			cont = DriverManager.getConnection(url, user, pass);
			String insertQueryStatement = "INSERT INTO `noticias` (`titulo`, `noticia`) VALUES (?,?)";		
		    pstm = cont.prepareStatement(insertQueryStatement);
			pstm.setString(1, titulo);
			pstm.setString(2, noticia);
			pstm.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.initialServlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String url ="jdbc:mysql://localhost:3306/mediplan?useSSL=false";
    private static final String username="root";
    private static final String password="1234";
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//We need  write to respond to the web so we need to give respond.get Writer()
				//To print something in web we need a write object which calls Writer (getWriter) to write anything by its object
				//PrintWriter printWriter = response.getWriter();
				//printWriter.print("this is doPost method of register Page");
				
				//As we have to accept the incomming from web it will come as request to get respond so we will use request also getParameter is the method of java class httpSession
				
				String email = request.getParameter("username");
				String upassword = request.getParameter("pass") ;
				HttpSession session = request.getSession();
				RequestDispatcher dispatcher = null;
				//Validation From servlet side
				if (email==null || email.equals("")) {
					request.setAttribute("status", "Please Fill The Email");				
					//WRONG : response.sendRedirect("login.jsp"); -> as i need to send from one servlet to other
					dispatcher= request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
				if (upassword==null || upassword.equals("")) {
					request.setAttribute("status", "Please Fill The Password");				
					//WRONG : response.sendRedirect("login.jsp"); -> as i need to send from one servlet to other
					dispatcher= request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
				//Now code to connect JDBC
			
				//Step 1: connect to IDE : as i copied jar file of mysql to webinf->lib
				//Step-2:load neccessory Drivers: 
				Connection connection=null;
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Loaded neccessory Drivers as com.mysql.cj is the package name and jdbc.Driver is my thing to include
					
					//STEP 3:Creting Connection with ide to mysql usinf driver while doing connection we need url ,password ,username
					connection = DriverManager.getConnection(url,username,password);
					
					//Step 4: To write query We use prepared Statement					
					PreparedStatement pst = connection.prepareStatement("select * from user where email = (?) and password = (?)");
					pst.setString(1,email);
					pst.setString(2,upassword);
					
					ResultSet set = pst.executeQuery();
					if(set.next()) {
						session.setAttribute("name", set.getString("Patient_Name"));
						dispatcher= request.getRequestDispatcher("welcome.jsp");
					}else {
						request.setAttribute("status", "Failed");
						dispatcher= request.getRequestDispatcher("login.jsp");
					}
					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	}

}

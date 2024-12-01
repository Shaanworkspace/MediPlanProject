package com.initialServlets;

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
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/registration") //this value should be same as the value is in jsp form tag action ="register"
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String url ="jdbc:mysql://localhost:3306/mediplan?useSSL=false";
    private static final String username="root";
    private static final String password="1234";
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//We need  write to respond to the web so we need to give respond.get Writer()
		//To print something in web we need a write object which calls Writer (getWriter) to write anything by its object
		PrintWriter printWriter = response.getWriter();
		//printWriter.print("this is doPost method of register Page");
		
		//As we have to accept the incomming from web it will come as request to get respond so we will use request also getParameter is the method of java class httpSession
		String patient_Name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("contact");
		String tpassword = request.getParameter("pass") ;
		//printWriter.println(patient_Name+" "+email+" Come successfully ");
		
		//Now code to connect JDBC
		
		//Step 1: connect to IDE : as i copied jar file of mysql to webinf->lib
		//Step-2:load neccessory Drivers: 
		Connection connection=null;
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Loaded neccessory Drivers as com.mysql.cj is the package name and jdbc.Driver is my thing to include
			
			//STEP 3:Creting Connection with ide to mysql usinf driver while doing connection we need url ,password ,username
			connection = DriverManager.getConnection(url,username,password);
			
			//Step 4: To write query We use prepared Statement
			String query="insert into user(Patient_Name,email,phone,password) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			//We can directly do as: PreparedStatement ps = connection.prepareStatement("insert into users(Patient_Name,email,phone,password) values(?,?,?,?)");
			ps.setString(1, patient_Name);
			ps.setString(2, email);
			ps.setString(3,phone);
			ps.setString(4,tpassword);
			
			int rowAffected = ps.executeUpdate();
			dispatcher= request.getRequestDispatcher("registration.jsp");
			if(rowAffected>0) {
				//means we have saved the email pasword now we have to go to the login.jsp page using Disspacherequest as we are moving from one servlet to another
				//we have request.setAttribute
				request.setAttribute("status", "Success");
			}else {
				request.setAttribute("status", "Failed");
			}
			dispatcher.forward(request, response);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}

package com.devops.capstone.controllerWithoutDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devops.capstone.model.User;
import com.devops.capstone.service.UserService;

public class UserRegisterController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  String fname = request.getParameter("firstname");
		  String lname = request.getParameter("lastname");
		  String pass = request.getParameter("pass");
		  String confirmpass = request.getParameter("confirmpass");
		  String email = request.getParameter("email");
		 

		  if (fname.isEmpty() || lname.isEmpty() || pass.isEmpty() || confirmpass.isEmpty() || email.isEmpty()) {
			   RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			   out.println("<font color=red>Please fill all the fields</font>");
			   rd.include(request, response);
		  } 
		  else {
			   PrintWriter pout= response.getWriter();
			   if(pass.equals(confirmpass)) {

			  User portalNewUser=new User(fname,lname,pass,email);
			
			    if(new UserService().doRegistration(portalNewUser)){   
				    pout.write("Successfuly registered...");
				    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				    rd.forward(request, response);
			    }
			    else
			    {
			  	  RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			  	  out.println("<font color=red>Registration fail</font>");
			  	  rd.include(request, response);
			    }
			    
			  }
			  
			  else
			  {
				  out.println("<font color=red>Password and Confirm Password doen't matches</font>");
				  RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				  rd.include(request, response);
			  }
		 }
		 }
}

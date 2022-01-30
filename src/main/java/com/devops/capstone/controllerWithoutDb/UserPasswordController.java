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

public class UserPasswordController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String newpass = request.getParameter("newpassword");
		String confirmpass = request.getParameter("confirmpassword");
		String email = request.getParameter("email");

		if (newpass.isEmpty() || confirmpass.isEmpty() || email.isEmpty()) {
			out.println("<font color=red>Please fill all the fields</font>");
		} else {
			if (newpass.equals(confirmpass)) {

				User updatePwd = new User("", "", newpass, email);

				if (new UserService().updatePassword(updatePwd)) {
					System.out.println("successfuly updated");

					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					out.write("password updated");
					rd.forward(request, response);
				}

			}

			else {
				out.println("<font color=red>Password and Confirm Password doen't matches</font>");
			}
		}
	}
}

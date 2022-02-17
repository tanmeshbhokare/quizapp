package com.devops.capstone.controllerWithoutDb;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.devops.capstone.controllerWithoutDb.UserLoginController;


public class LoginTest extends Mockito{
	@Mock
	 HttpServletRequest request;
	 @Mock
	 HttpServletResponse response;
	 @Mock
	 RequestDispatcher rd;
	 @Before
	 public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	 }

    @Test
    public void testLoginSuccess() throws Exception {
        when(request.getParameter("email")).thenReturn("tanmesh@wipro.com");
        when(request.getParameter("password")).thenReturn("1234");
        when(request.getRequestDispatcher("/success.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserLoginController().doPost(request, response);
     
        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("Login successfull...", result);
      
    }
    
    //@Test
    public void testLoginFail() throws Exception {
        when(request.getParameter("email")).thenReturn("tanmesh@wipro.com");
        when(request.getParameter("password")).thenReturn("12345");
        when(request.getRequestDispatcher("/fail.jsp")).thenReturn(rd);            
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        new UserLoginController().doPost(request, response);
     
        verify(rd).forward(request, response);
        
        String result = stringWriter.getBuffer().toString().trim();
        assertEquals("Login fail...", result);
      
    }
}

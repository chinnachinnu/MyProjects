

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Example1 extends HttpServlet {
	
public void destroy() {
	System.out.println("Inside Destroy");
	
}

public ServletConfig getServletConfig(){
	return null;
}
public String getServletInfo() {
	return null;
}
public void init(ServletConfig arg0)throws ServletException {
	System.out.println("nagendra");
	
}
public void service(ServletRequest arg0, ServletResponse arg1)throws ServletException,  IOException {
System.out.println("Inside service");	
}



}
	

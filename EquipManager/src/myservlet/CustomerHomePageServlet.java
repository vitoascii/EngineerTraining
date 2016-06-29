package myservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerHomePageServlet extends HttpServlet {

	public CustomerHomePageServlet() {
		super();
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException{
		String reqtype=req.getParameter("submit");
		String address="/jsp/customer_homepage.jsp";
		String title="";
		
		req.setAttribute("people", null);
		req.setAttribute("title", title);
		
		RequestDispatcher dis=req.getRequestDispatcher(address);
		dis.forward(req, res);
		
	}

}

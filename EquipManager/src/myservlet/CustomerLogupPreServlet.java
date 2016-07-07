package myservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import value.CustomerType;
import value.CustomerType.Type;

@SuppressWarnings("serial")
public class CustomerLogupPreServlet extends HttpServlet{

	public CustomerLogupPreServlet() {
		super();
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String address="/jsp/logup_customer.jsp";
		
		ArrayList<Type> alt=CustomerType.getInstance().getList();
		
		req.setAttribute("alt", alt);
		req.setAttribute("failed", "1");
		
		RequestDispatcher dis=req.getRequestDispatcher(address);	
		dis.forward(req, res);
	}

}

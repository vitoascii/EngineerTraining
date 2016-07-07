package myservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.Customer;

public class RepairRegisterPreServlet extends HttpServlet {

	public RepairRegisterPreServlet() {
		// TODO Auto-generated constructor stub
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		String address="/jsp/repair_register.jsp";
		
		Customer c=Customer.getCustomerById(id);
		
		req.setAttribute("customer", c);
		req.getRequestDispatcher(address).forward(req, res);		
	}

}

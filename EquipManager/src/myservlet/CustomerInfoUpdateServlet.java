package myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.Customer;

public class CustomerInfoUpdateServlet extends HttpServlet {

	public CustomerInfoUpdateServlet() {
		super();
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String targetAddress="/jsp/customer_homepage.jsp";
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String password=req.getParameter("password2");
		String address=req.getParameter("address");
		String postNum=req.getParameter("postnum");
		String idcard=req.getParameter("idcard");
		String extraInfoValue=req.getParameter("extrainfo");
		String email=req.getParameter("email");
		int type=Integer.parseInt(req.getParameter("type"));
		Customer c=new Customer(id,name,password,phone,address,postNum,email,idcard,type,
			extraInfoValue);
		Customer.update(c);
		
		
		
		
		
		
		req.setAttribute("customer", c);
		req.getRequestDispatcher(targetAddress).forward(req, res);		
	}

}

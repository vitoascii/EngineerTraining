package myservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.Customer;

public class CustomerLogupServlet extends HttpServlet {

	public CustomerLogupServlet() {
		super();
	}

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{

		String address1="/jsp/customer_homepage.jsp";
		String address2="/jsp/logup_customer.jsp";
		RequestDispatcher dis;
		
		String name=req.getParameter("name");
		String pswd=req.getParameter("password");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		int type=Integer.parseInt(req.getParameter("type"));
		String postNum=req.getParameter("postnum");
		String email=req.getParameter("email");
		String idcard=req.getParameter("idcard");
		String extraInfoValue=req.getParameter("extraInfo"+type);
		
		Customer c = null;	
		try{
			c=Customer.register(name, pswd, phone, address, postNum, email, 
					idcard, type, extraInfoValue);
		}catch(Exception e){
			e.printStackTrace();
		}

		if(c==null){
			dis=req.getRequestDispatcher(address2);
			req.setAttribute("failed","0");
		}else{
			req.setAttribute("customer", c);
			dis=req.getRequestDispatcher(address1);	
			System.out.print(c.detail());
		}
		dis.forward(req, res);
	}
	
}

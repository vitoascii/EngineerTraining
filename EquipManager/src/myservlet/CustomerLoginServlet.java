package myservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.Customer;

@SuppressWarnings("serial")
public class CustomerLoginServlet extends HttpServlet {

	public CustomerLoginServlet() {
		super();
	}

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		//String reqtype=req.getParameter("submit");
		//ArrayList<Person> people=new ArrayList<Person>();
		String address1="/jsp/customer_homepage.jsp";
		String address2="/jsp/login_customer.jsp";
		RequestDispatcher dis;
		
		int id=Integer.parseInt(req.getParameter("id"));
		String pswd=req.getParameter("password");
		Customer c = null;
		System.out.println(id+"  "+pswd);
	
		try{
			c=Customer.getCustomerById(id);			
		}catch(Exception e){
			e.printStackTrace();
		}

		boolean isRight=((c!=null)&&(c.getPassword().equals(pswd)));
		if(!isRight){
			dis=req.getRequestDispatcher(address2);
		}else{
			req.setAttribute("customer", c);
			dis=req.getRequestDispatcher(address1);		
		}
		dis.forward(req, res);
	}
	
}

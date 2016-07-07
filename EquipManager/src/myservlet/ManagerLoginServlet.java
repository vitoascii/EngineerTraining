package myservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.Bill;
import pd.Storage;

@SuppressWarnings("serial")
public class ManagerLoginServlet extends HttpServlet {
	

	
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String address1="../jsp/store_manager.jsp";
		String address2="../jsp/finance_manager.jsp";
		
		String address="../home_page.html";
		
		int type=Integer.parseInt(req.getParameter("type"));
		String password=req.getParameter("password");
		
		if(type==0){
			if(password.equals("1234")){
				address=address1;
				int[][] a=Storage.getInfo();
				req.setAttribute("num", a);				
			}
		}else if(type==1){
			if(password.equals("5678")){
				address=address2;
				ArrayList<Bill> b=Bill.getInfo();
				req.setAttribute("info", b);	
			}
		}
		
		req.getRequestDispatcher(address).forward(req, res);		
		

	}
}

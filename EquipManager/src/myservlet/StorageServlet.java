package myservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.Storage;

@SuppressWarnings("serial")
public class StorageServlet extends HttpServlet {
	
	
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String address="../home_page.html";
		
		int element=Integer.parseInt(req.getParameter("element"));
		int type=Integer.parseInt(req.getParameter("type"));
		int number=Integer.parseInt(req.getParameter("number"));
		
		//System.out.print(""+req.getParameter("element")+"  "+req.getParameter("type")+"  "+req.getParameter("number"));
		Storage.store(element, type, number, "manager");
	
		RequestDispatcher dis=req.getRequestDispatcher(address);	
		dis.forward(req, res);
	}
	
	
	

}

package myservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.Customer;
import pd.CustomerRepairRecord;

public class RepairRegisterServlet extends HttpServlet {

	public RepairRegisterServlet() {
		// TODO Auto-generated constructor stub
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		//int id=Integer.parseInt(req.getParameter("id"));
		//String address="/home_page.html";
		String address="/jsp/repair_print.jsp";
		int customerId=Integer.parseInt(req.getParameter("id"));
		Calendar calendar=Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		String date=(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)).format(calendar.getTime());
		int type=Integer.parseInt(req.getParameter("type"));
		String brand=req.getParameter("brand");
		String version=req.getParameter("version");
		String serial=req.getParameter("serial");
		String phenomenon=req.getParameter("phenomenon");
		int bug=Integer.parseInt(req.getParameter("bug"));
		
		String appearance=req.getParameter("appearance");
		String msg=req.getParameter("important_msg");
		String hdd=req.getParameter("hdd");
		String command=req.getParameter("command");
		String memory=req.getParameter("memory");
		String pccard=req.getParameter("pccard");
		String adapter=req.getParameter("adapter");
		String battery=req.getParameter("battery");
		String cd=req.getParameter("cd");
		String floppy=req.getParameter("floppy");
		String other=req.getParameter("other");
		
		CustomerRepairRecord crr=CustomerRepairRecord
				.build(customerId, date, type, brand, version, serial, phenomenon, bug);
		crr.setExtraInfo(appearance, msg, command, hdd, memory, pccard, adapter, battery, cd, floppy, other);
		CustomerRepairRecord.register(crr);
		
		Customer c=new Customer();
		c.setId(Integer.parseInt(req.getParameter("id")));
		c.setPassword(req.getParameter("password"));
		req.setAttribute("customer", c);
		req.setAttribute("record", crr);
		req.getRequestDispatcher(address).forward(req, res);		
	}
	
	
	

}

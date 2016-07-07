package myservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.CustomerRepairRecord;
import pd.Engineer;

public class EngineerLoginServlet extends HttpServlet {

	public EngineerLoginServlet() {
		// TODO Auto-generated constructor stub
	}
	
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		
		//String reqtype=req.getParameter("submit");
		//ArrayList<Person> people=new ArrayList<Person>();
		String address1="/jsp/engineer_homepage.jsp";
		String address2="/jsp/login_engineer.html";
		RequestDispatcher dis;
		
		int id=Integer.parseInt(req.getParameter("id"));
		String pswd=req.getParameter("password");
		System.out.print("engineer receive");
		Engineer eng = null;
		CustomerRepairRecord crr=null;
	
		try{
			eng=Engineer.getEngineerById(id);			
		}catch(Exception e){
			e.printStackTrace();
		}

		boolean isRight=((eng!=null)&&(eng.getPassword().equals(pswd)));
		if(!isRight){
			dis=req.getRequestDispatcher(address2);
		}else{
			if(eng.getCond()==1){
				crr=CustomerRepairRecord.getRecordById(eng.getTaskId());	
			}else{
				crr=CustomerRepairRecord.getAvailableRecord();
				if(crr!=null){
					eng.accept(crr.getId());
				}
			}
					
			req.setAttribute("engineer",eng);
			req.setAttribute("task", crr);
			dis=req.getRequestDispatcher(address1);		
		}
		dis.forward(req, res);
	}

}

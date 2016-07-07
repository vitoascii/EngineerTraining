package myservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pd.Bill;
import pd.CustomerRepairRecord;
import pd.Engineer;
import pd.Storage;

public class RepairServlet extends HttpServlet {
	/*
	 * 0-HDD 1-内存 2-外置PC卡 3-AC适配器 4-电池 5-外接光驱 6-外接软驱
	 * 
	 * 
	 */
	String[] elements=new String[]{"HDD","内存","外置PC卡","AC适配器","电池","外接光驱","外接软驱"};
	

	public RepairServlet() {
		// TODO Auto-generated constructor stub
	}
	
	private int getNumber(String s){
		if(s.length()==0){
			return 0;
		}else{
			return Integer.parseInt(s);
		}
	}

	private int getElementsBill(int[][] a){
		int bill=0;
		for(int i=0;i<7;i++){
			for(int j=0;j<5;j++){
				bill+=(i*j*a[i][j]);
			}
		}
		return bill;
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		Calendar calendar=Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		String date=(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)).format(calendar.getTime());
		
		int id=Integer.parseInt(req.getParameter("id"));
		String paswd=req.getParameter("password");
		
		Engineer eng=Engineer.getEngineerById(id);
		CustomerRepairRecord crr=CustomerRepairRecord.getRecordById(eng.getTaskId());
		
		int[][] nums=new int[7][5];	
		String address1="/jsp/login_engineer.html";

		for(int i=0;i<7;i++){
			int type=getNumber(req.getParameter("type"+i));
			int num=getNumber(req.getParameter("num"+i));
			if(num!=0){
				nums[i][type]=num;
			}
		}
	
		if(Storage.expenses(nums, id+"号工程师")){
			int a=getElementsBill(nums);
			Bill b=new Bill(crr.getId(),id,crr.getCustomerId(),date,a,10);
			crr.complete();
			eng.complete();
			
			Bill.insert(b);
			
		}
	RequestDispatcher dis=req.getRequestDispatcher(address1);		
	
	dis.forward(req, res);
	}
	
	
	
}

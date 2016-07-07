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
	 * 0-HDD 1-�ڴ� 2-����PC�� 3-AC������ 4-��� 5-��ӹ��� 6-�������
	 * 
	 * 
	 */
	String[] elements=new String[]{"HDD","�ڴ�","����PC��","AC������","���","��ӹ���","�������"};
	

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
	
		if(Storage.expenses(nums, id+"�Ź���ʦ")){
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

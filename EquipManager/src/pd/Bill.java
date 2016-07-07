package pd;

import java.util.ArrayList;

import dbhelper.BillHelper;

public class Bill {
	public int id;
	public int customerId;
	public int engineerId;
	public String date;
	public int element;
	public int manual;

	public Bill() {
		
	}
	
	public Bill(int id,int customerId,int engineerId,String date,int element,int manual){
		this.id=id;
		this.customerId=customerId;
		this.engineerId=engineerId;
		this.date=date;
		this.element=element;
		this.manual=manual;
		
	}
	
	public static void insert(Bill b){
		BillHelper.init();
		BillHelper.insert(b);
		BillHelper.terminate();
	}

	public static ArrayList<Bill> getInfo() {
		BillHelper.init();
		ArrayList<Bill> c=BillHelper.getInfo();
		BillHelper.terminate();
		return c;
	}

}

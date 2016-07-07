package dbhelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pd.Bill;

public class BillHelper {
	
	private static Statement stm;	
	
	private static String tableName="bill";

	
	public static void init(){
		MainHelper.init();
		stm=MainHelper.getStm();
	}
	public static void terminate(){MainHelper.terminate();}

	public BillHelper() {}
	
	
	public static void insert(Bill b){
		String istSQL="insert into "+tableName+" values("+b.id+","+b.customerId+","
				+b.engineerId+",'"+b.date+"',"+b.element+","+b.manual+")";
		try{
			stm.executeUpdate(istSQL);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static ArrayList<Bill> getInfo() {
		String s="select * from bill";
		ArrayList<Bill> a=new ArrayList<>();
		try{
			ResultSet rs=stm.executeQuery(s);
			for(int i=0;i<4;i++){
				if(rs.next()){
					Bill b=new Bill(rs.getInt(1),rs.getInt(3),rs.getInt(3),
							rs.getString(4),rs.getInt(5),rs.getInt(6));	
					a.add(b);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}

package dbhelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pd.Customer;
import pd.CustomerRepairRecord;
import value.RepairValue;

public class CustomerRapairHelper {

	/*
	 * table: customer_repair
	 * ---------------------------------------------------------------------------
	 *  id cond customerid startdate type brand version serial phenomenon bug extrainfo
	 * ------------------------------------------------------------------------------
	 *  
	 */
	
	private static CustomerRapairHelper crr=null;

	private static Statement stm;	
	
	private static String tableName="customer_repair";
/*---------------------------------------------------------------*/
	
	public static void init(){
		MainHelper.init();
		stm=MainHelper.getStm();
	}
	public static void terminate(){
		MainHelper.terminate();
	}
	
/*---------------------------------------------------------------*/

	public static void insert(CustomerRepairRecord crr){
		
		String inSQL="insert into "+tableName+" values(NULL,"+ RepairValue.WAIT_FOR_REPAIR+","
				+crr.getCustomerId()+",'"+crr.getDate()+"',"+crr.getType()+",'"
				+crr.getBrand()+"','"+crr.getVersion()+"','"+crr.getSerial()+"','"
				+crr.getPhenomenon()+"',"+crr.getBug()+",'"+crr.getExtraInfo()+"')";
		
		//System.out.println(inSQL);
		try{
			stm.executeUpdate(inSQL);	
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//id cond customerid startdate type brand version serial phenomenon bug extrainfo
	public static CustomerRepairRecord selectById(int id) {
		CustomerRepairRecord crr=null;
		String sql_select_id="select * from "+tableName+" where id = "+id;
		try{
			ResultSet rs=stm.executeQuery(sql_select_id);
			if(rs.next()){
				crr=new CustomerRepairRecord();
				crr.setId(rs.getInt(1));	
				crr.setCondition(rs.getInt(2));
				crr.setCustomerId(rs.getInt(3));
				crr.setDate(rs.getString(4));
				crr.setType(rs.getInt(5));
				crr.setBrand(rs.getString(6));
				crr.setVersion(rs.getString(7));
				crr.setSerial(rs.getString(8));
				crr.setPhenomenon(rs.getString(9));
				crr.setBug(rs.getInt(10));
				crr.setExtraInfo(rs.getString(11));			
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return crr;
	}
	
	public static CustomerRepairRecord getAvailableRecord(){
		CustomerRepairRecord crr=null;
		String sql1="select * from "+tableName+" where cond = "+RepairValue.WAIT_FOR_REPAIR;
		try{
			ResultSet rs=stm.executeQuery(sql1);
			if(rs.next()){
				crr=new CustomerRepairRecord();
				crr.setId(rs.getInt(1));	
				crr.setCondition(rs.getInt(2));
				crr.setCustomerId(rs.getInt(3));
				crr.setDate(rs.getString(4));
				crr.setType(rs.getInt(5));
				crr.setBrand(rs.getString(6));
				crr.setVersion(rs.getString(7));
				crr.setSerial(rs.getString(8));
				crr.setPhenomenon(rs.getString(9));
				crr.setBug(rs.getInt(10));
				crr.setExtraInfo(rs.getString(11));			
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		if(crr!=null){
			String sql2="update "+tableName+" set cond = "+RepairValue.REPAIRING
				+" where id = "+crr.getId();
			try{
				stm.executeUpdate(sql2);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return crr;
	}
	public static void complete(int id) {
		String sql2="update "+tableName+" set cond = "+RepairValue.REPAIRED
				+" where id = "+id;
			try{
				stm.executeUpdate(sql2);
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	
	
}

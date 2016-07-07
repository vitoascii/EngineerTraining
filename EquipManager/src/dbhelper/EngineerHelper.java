package dbhelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pd.Customer;
import pd.Engineer;
import value.RepairValue;

public class EngineerHelper {
	
/*
 * table:engineer
 * id  password cond taskid * 
 * 
 */

	private static CustomerHelper cth=null;

	private static Statement stm;	
	
	private static String tableName="engineer";
	
	public EngineerHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public static void init(){
		MainHelper.init();
		stm=MainHelper.getStm();
	}
	public static void terminate(){
		MainHelper.terminate();
	}
	
	
/*---------------------------------------------------------------*/
	public static Engineer selectById(int id){
		Engineer eng=null;
		String sql_select_id="select * from "+tableName+" where id = "+id;
		try{
			ResultSet rs=stm.executeQuery(sql_select_id);
			if(rs.next()){
				eng=new Engineer();
				eng.setId(rs.getInt(1));
				eng.setPassword(rs.getString(2));
				eng.setCond(rs.getInt(3));
				eng.setTaskId(rs.getInt(4));		
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return eng;
	}
	
	public static void update(int id,int taskId){
		String sql="update "+tableName+" set taskId = "+taskId+",cond = 1 "
				+" where id = "+id;
			try{
				stm.executeUpdate(sql);
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	
	public static void initTable(){
		for(int i=1;i<11;i++){
			String sql_insert="insert into "+tableName+" values("+i+",'111',0,null)";
		try{
			stm.executeUpdate(sql_insert);
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
		
	}

	public static void complete(int id) {
		String sql="update "+tableName+" set cond = 0"
				+" where id = "+id;
		try{
				stm.executeUpdate(sql);
		}catch(SQLException e){
				e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

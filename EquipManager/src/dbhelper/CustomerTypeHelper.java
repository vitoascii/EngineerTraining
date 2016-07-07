package dbhelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import value.CustomerType.Type;

public class CustomerTypeHelper {
	/*
	 * table: customer_type
	 *  id(key) int,name char(20),info char(20)
	 *  eg:
	 *  1   家庭用户  座机 
	 */
	
	private static CustomerTypeHelper cth=null;

	private Statement stm;	
	
	private static String tableName="customer_type";
/*---------------------------------------------------------------*/
	private CustomerTypeHelper() {}	
	public static CustomerTypeHelper getInstance(){
		if(cth==null){
			cth=new CustomerTypeHelper();
			cth.init();
		}
		return cth;
	}
	
	private void init(){
		MainHelper.init();
		stm=MainHelper.getStm();
	}
	public void terminate(){
		MainHelper.terminate();
		
	}
	
/*---------------------------------------------------------------*/
	
	public ArrayList<Type> searchAll(){
		String sql_select_type="select * from customer_type";
		ArrayList<Type> types=new ArrayList<>();
		try{
			ResultSet rs=stm.executeQuery(sql_select_type);
			while(rs.next()){
				Type p=new Type(rs.getInt(1),rs.getString(2),rs.getString(3));						
				types.add(p);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return types;
	}

}

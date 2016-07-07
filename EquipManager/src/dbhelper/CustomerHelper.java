package dbhelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pd.Customer;

public class CustomerHelper {
	/*
	 * table: customer
	 * ---------------------------------------------------------------------------
	 *  id(key) int,name char(20),password char(20),phone char(16),address char(20),
	 *  	postNum char(6),email char(20),idcard char(18),type int,typename char(20),
	 *  	typeinfoname char(20),typeinfovalue char(20)
	 * ------------------------------------------------------------------------------
	 *  eg:
	 *  1 Jack password 13312345678 hust-16#111 100000 122aa@123.com 40000019990101234x 
	 *  1 家庭用户 座机 0333-1234567
	 */
	
	private static CustomerHelper cth=null;

	private static Statement stm;	
	
	private static String tableName="customer";
/*---------------------------------------------------------------*/
	
	public static void init(){
		MainHelper.init();
		stm=MainHelper.getStm();
	}
	public static void terminate(){
		MainHelper.terminate();
	}
	
/*---------------------------------------------------------------*/
	public static void test(){
		String sql_insert="insert into "+tableName+" values(NULL,'测试用户1','password',"
				+ "'13434567899','huake','430000','123test@123.com','12000019990101123x',"
				+ "1,'家庭用户','座机','0333-3456789')";
		
		try{
			stm.executeUpdate(sql_insert);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<Customer> searchAll(){
		String sql_select_all="select * from "+tableName;
		ArrayList<Customer> alc=new ArrayList<>();
		try{
			ResultSet rs=stm.executeQuery(sql_select_all);
			while(rs.next()){
				Customer c;
				c=new Customer();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setPhone(rs.getString(4));
				c.setAddress(rs.getString(5));
				c.setPostNum(rs.getString(6));
				c.setEmail(rs.getString(7));
				c.setIdcard(rs.getString(8));
				c.setType(rs.getInt(9));
				c.setExtraInfoValue(rs.getString(12));
				alc.add(c);
			}		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return alc;
	}

	public static Customer selectById(int id){
		Customer c=null;
		String sql_select_id="select * from "+tableName+" where id = "+id;
		try{
			ResultSet rs=stm.executeQuery(sql_select_id);
			if(rs.next()){
				c=new Customer();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setPhone(rs.getString(4));
				c.setAddress(rs.getString(5));
				c.setPostNum(rs.getString(6));
				c.setEmail(rs.getString(7));
				c.setIdcard(rs.getString(8));
				c.setType(rs.getInt(9));
				c.setExtraInfoValue(rs.getString(12));			
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		return c;
	}

	public static Customer insert(Customer c){
		//检测身份证号是否已被注册
		String sltSQL="select * from "+tableName+" where idcard = '"
				+c.getIdcard()+"'";
		try{
			ResultSet rs=stm.executeQuery(sltSQL);
			if(rs.next()){
				return null;		
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		String inSQL="insert into "+tableName+" values(NULL,'"+c.getName()+"','"
				+ c.getPassword()+"','"+c.getPhone()+"','"+c.getAddress()+"','"
				+c.getPostNum()+"','"+c.getEmail()+"','"+c.getIdcard()+"',"
				+c.getType()+",'"+c.getTypeName()+"','"+c.getExtraInfoName()+"','"
				+c.getExtraInfoValue()+"')";
		
		//System.out.println(inSQL);
		
		try{
			stm.executeUpdate(inSQL);
			ResultSet rs=stm.executeQuery(sltSQL);
			if(rs.next()){
				c.setId(rs.getInt(1));
				return c;
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
		
	public static void updateById(Customer c){
		String updateSQL="update "+tableName+" set name='"+c.getName()+"',password='"
				+c.getPassword()+"',phone='"+c.getPhone()+"',address='"
				+c.getAddress()+"',postNum='"+c.getPostNum()+"',email='"
				+c.getEmail()+"',idcard='"+c.getIdcard()+"',type="+c.getType()
				+",typename='"+c.getTypeName()+"',typeinfoname='"
				+c.getExtraInfoName()+"',typeinfovalue='"+c.getExtraInfoValue()
				+"' where id="+c.getId();
		try{
			stm.executeUpdate(updateSQL);
		}catch(SQLException e){
			e.printStackTrace();
		}
	
	
	
	}

	
}

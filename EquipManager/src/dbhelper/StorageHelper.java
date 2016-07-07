package dbhelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class StorageHelper {

	private static Statement stm;	
	
	private static String tableName1="storage";
	private static String tableName2="storage_record";
	private static String[] elements=new String[]{"HDD","内存","外置PC卡","AC适配器",
		"电池","外接光驱","外接软驱"};
	
	
	public static void init(){
		MainHelper.init();
		stm=MainHelper.getStm();
	}
	public static void terminate(){MainHelper.terminate();}

	public StorageHelper() {}
	
	
	
	
	public static void test(){
		init();
		for(int i=0;i<7;i++){
			for(int j=0;j<5;j++){
				String s="insert into storage values(NULL,"+i+","+j+",30)";
				try {
					stm.executeUpdate(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		terminate();
		
		
	}
	
	
	
	public static void store(int element,int type,int a,String user){
		Calendar calendar=Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		String date=(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)).format(calendar.getTime());
		
		String sltSQL1="select * from "+tableName1+" where element="+element
				+" and type="+type;
		try {
			ResultSet rs=stm.executeQuery(sltSQL1);
			if(rs.next()){
				int id=rs.getInt(1);
				int num=rs.getInt(4)+a;
				String updateSQL1="update "+tableName1+" set number="+num
						+" where id="+id;
				stm.executeUpdate(updateSQL1);
				String detail=elements[element]+type+"x"+a;
				String updateSQL2="insert into "+tableName2+" values(NULL,'"
						+user+"',0,'"+date+"','"+detail+"')";
					stm.executeUpdate(updateSQL2);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
	}
	
	
	public static boolean expenses(int[][] a,String user){
		Calendar calendar=Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
		String date=(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)).format(calendar.getTime());
		String detail="";
		
		for(int i=0;i<7;i++){
			for(int j=0;j<5;j++){
				if(a[i][j]!=0){
					String sltSQL="select * from "+tableName1+" where element="
				+i+" and type="+j;
					try{
						ResultSet rs=stm.executeQuery(sltSQL);
						if(rs.next()){
							int num=rs.getInt(4);
							if(num<a[i][j]){
								return false;
							}
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
				}	
			}
		}
		for(int i=0;i<7;i++){
			for(int j=0;j<5;j++){
				if(a[i][j]!=0){
					String sltSQL="select * from "+tableName1+" where element="
				+i+" and type="+j;
					try{
						ResultSet rs=stm.executeQuery(sltSQL);
						if(rs.next()){
							int id=rs.getInt(1);
							int num=rs.getInt(4)-a[i][j];
							String updateSQL1="update "+tableName1+"set number="
									+num+" where id="+id;
							stm.executeUpdate(updateSQL1);
							detail=detail+elements[i]+j+"型"+a[i][j]+"个   ";		
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
				}	
			}
		}
		
		String updateSQL2="insert into "+tableName2+" values(NULL,'"
				+user+"',1,'"+date+"','"+detail+"')";
		try {
			stm.executeUpdate(updateSQL2);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return true;
	}
	public static int[][] getInfo() {
		int[][] a=new int[7][5];
		for(int i=0;i<7;i++){
			for(int j=0;j<5;j++){
				String s="select * from storage where element="+i+" and type="+j; 
				try{
					ResultSet rs=stm.executeQuery(s);
					if(rs.next()){
						a[i][j]=rs.getInt(4);	
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return a;
	}
	
	

}

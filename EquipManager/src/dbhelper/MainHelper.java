package dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainHelper {
	
	private static String url="jdbc:mysql://localhost:3306/equipmanager";
	private static Connection conn;
	private static Statement stm=null;;
	private static String user="root";
	private static String password="hust123";
	
	static void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			stm=conn.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void terminate(){
		/*try{
			stm.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}*/
	}
/*------------------------------------------------------------*/	
	static Statement getStm(){
		if(stm==null){
			init();
		}
		return stm;
	}
}

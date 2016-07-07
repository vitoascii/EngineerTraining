package pd;

import dbhelper.StorageHelper;

public class Storage {

	public Storage() {
		
	}
	
	public static void store(int element,int type,int num,String user){
		StorageHelper.init();
		StorageHelper.store(element,type,num, user);
		StorageHelper.terminate();
	}
	
	public static boolean expenses(int[][] numbers,String user){
		boolean b=true;
		
		StorageHelper.init();
		b=StorageHelper.expenses(numbers, user);
		StorageHelper.terminate();

		return b;
	}

	public static int[][] getInfo() {
		int[][] a;
		StorageHelper.init();
		a=StorageHelper.getInfo();
		StorageHelper.terminate();
		return a;
	}

}

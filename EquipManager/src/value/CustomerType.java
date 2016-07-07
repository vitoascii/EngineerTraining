package value;

import java.util.ArrayList;

import dbhelper.CustomerTypeHelper;

public class CustomerType {
	
	private static CustomerType ct;
	private ArrayList<Type> typeList;
	CustomerTypeHelper cth;
	
/*---------------------------------------------------------------*/	
	private CustomerType(){}
	
	public static CustomerType getInstance(){
		if(ct==null){
			ct=new CustomerType();
			ct.init();
		}
		return ct;
	}
	
	private void init(){
		cth=CustomerTypeHelper.getInstance();
		typeList=cth.searchAll();
	}
	
	public void terminate(){
		cth.terminate();
		ct=null;
	}
	
/*---------------------------------------------------------------*/	
	public void test(){
		for(int i=0;i<typeList.size();i++){
		System.out.print(typeList.get(i).id+"\n");
		}
	}
	
	public String getTypeName(int typeId){
		Type temp=null;
		for(int i=0;i<typeList.size();i++){
			temp=typeList.get(i);
			if(temp.id==typeId){
				break;
			}
		}
		return temp.typeName;
	}
	
	public String getTypeInfoName(int typeId){
		Type temp=null;
		for(int i=0;i<typeList.size();i++){
			temp=typeList.get(i);
			if(temp.id==typeId){
				break;
			}
		}
		return temp.typeInfoName;
	}
	
	
	public ArrayList<Type> getList(){
		return typeList;
	}
	
//--------------------------------------------------------------	
	
	public static class Type{
		public int id;
		public String typeName;
		public String typeInfoName;
		
		public Type(int id,String typeName,String typeInfoName){
			this.id=id;
			this.typeName=typeName;
			this.typeInfoName=typeInfoName;
		}
	}
	
	
	

}

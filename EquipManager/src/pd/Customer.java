package pd;

import dbhelper.CustomerHelper;
import value.CustomerType;

public class Customer {
	private int id;
	private String name;
	private String password;
	private String phone;
	private String address;
	private String postNum;
	private String email;
	private String idcard;
	private int type;
	private String typeName;
	private String extraInfoName;
	private String extraInfoValue;
	
	
	public Customer() {}
	
	public Customer(int id,String name,String password,String phone,String address,
			String postNum,String email,String idcard,int type,String extraInfoValue){
		this.id=id;
		this.name=name;
		this.password=password;
		this.phone=phone;
		this.address=address;
		this.postNum=postNum;
		this.email=email;
		this.idcard=idcard;
		setType(type);
		this.extraInfoValue=extraInfoValue;
	}
	
	public static Customer getCustomerById(int id){
		CustomerHelper.init();
		Customer c=CustomerHelper.selectById(id);
		CustomerHelper.terminate();		
		return c;
	}
	
	public static Customer register(String name,String password,String phone,String address,
			String postNum,String email,String idcard,int type,String extraInfoValue){
		//cId>0:注册成功
		//cId<0:身份证号已被注册
		Customer c=new Customer(-1,name,password,phone,address,postNum,email,idcard,type,
			extraInfoValue);
		CustomerHelper.init();
		c=CustomerHelper.insert(c);
		CustomerHelper.terminate();	
		return c;
	}
	
	public static void update(Customer c){
		CustomerHelper.init();
		CustomerHelper.updateById(c);
		CustomerHelper.terminate();	
	}
	
	
	
	
	public String detail(){
		String s=id+" "+name+" "+password+" "+phone+" "+address+" "+postNum+" "+email
				+" "+idcard+" "+type+" "+typeName+" "+extraInfoName+" "+extraInfoValue;
		return s;
	}

	
	public void setIdcard(String idcard){
		this.idcard=idcard;
	}
	public void setExtraInfoValue(String extraInfoValue) {
		this.extraInfoValue = extraInfoValue;
	}
	public void setEmail(String email) {this.email = email;}
	public void setPostNum(String postNum) {this.postNum = postNum;}
	public void setAddress(String address) {this.address = address;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setPassword(String password) {this.password = password;}
	public void setName(String name) {this.name = name;}
	public void setId(int id) {this.id = id;}
	public void setType(int type) {
		CustomerType ct=CustomerType.getInstance();
		this.type = type;
		this.typeName=ct.getTypeName(type);
		this.extraInfoName=ct.getTypeInfoName(type);
		ct.terminate();
	}
	public String getTypeName() {return typeName;}
	public String getExtraInfoName() {return extraInfoName;}
	public String getExtraInfoValue() {return extraInfoValue;}
	public String getIdcard() {return idcard;}
	public String getEmail() {return email;}
	public String getPostNum() {return postNum;}
	public String getAddress() {return address;}
	public String getPhone() {return phone;}
	public String getPassword() {return password;}
	public String getName() {return name;}
	public int getId() {return id;}
	public int getType() {return type;}
}

package pd;

import dbhelper.CustomerRapairHelper;

public class CustomerRepairRecord {
	
	private int id;
	private int customerId;
	private String date;
	private int type;
	private String brand;
	private String version;
	private String serial;
	private String phenomenon;
	private int bug;
	private int condition;
	
	private String extraInfo;
	
	
	
	

	public CustomerRepairRecord() {
		// TODO Auto-generated constructor stub
	}
	
	public static CustomerRepairRecord build(int customerId,String date,int type,String brand,
			String version,String serial,String phenomenon,int bug){
		CustomerRepairRecord crr=new CustomerRepairRecord();
		crr.customerId=customerId;
		crr.date=date;
		crr.type=type;
		crr.brand=brand;
		crr.version=version;
		crr.serial=serial;
		crr.phenomenon=phenomenon;
		crr.bug=bug;

		return crr;
	}

	public void setExtraInfo(String appearance,String msg,String command,
			String hdd,	String memory,String pccard,String adapter,String battery,
			String cd,String floppy,String other){
		String s="";
		if(appearance.length()>0){
			s=s+" 机器外观检查："+appearance;
		}
		if(msg.length()>0){
			s=s+" 重要资料："+msg;
		}
		if(command.length()>0){
			s=s+" 开机指令："+command;
		}
		if(hdd.length()>0){
			s=s+" HDD："+hdd;
		}
		if(memory.length()>0){
			s=s+"内存："+memory;
		}
		if(pccard.length()>0){
			s=s+" PC卡:"+pccard;
		}
		if(adapter.length()>0){
			s=s+" AC适配器:"+adapter;
		}
		if(battery.length()>0){
			s=s+"电池:"+battery;
		}
		if(cd.length()>0){
			s=s+" 外接光驱:"+cd;
		}
		if(floppy.length()>0){
			s=s+" 外接软驱:"+floppy;
		}
		if(other.length()>0){
			s=s+" 其他:"+other;
		}		
		this.extraInfo=s;
	}
	
	public static void register(CustomerRepairRecord crr){
		CustomerRapairHelper.init();
		CustomerRapairHelper.insert(crr);
		CustomerRapairHelper.terminate();
		
	}
	
	public static CustomerRepairRecord getRecordById(int taskId) {
		CustomerRepairRecord crr;
		CustomerRapairHelper.init();
		crr=CustomerRapairHelper.selectById(taskId);
		CustomerRapairHelper.terminate();
		return crr;
	}
	
	public static CustomerRepairRecord getAvailableRecord() {
		CustomerRepairRecord crr;
		CustomerRapairHelper.init();
		crr=CustomerRapairHelper.getAvailableRecord();
		CustomerRapairHelper.terminate();
		return crr;
	}
	
	public void complete() {

		CustomerRapairHelper.init();
		CustomerRapairHelper.complete(id);
		CustomerRapairHelper.terminate();
	
	}

	
	
	
	
	
	
	

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getCustomerId() {return customerId;}
	public void setCustomerId(int customerId) {this.customerId = customerId;}
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	public int getType() {return type;}
	public void setType(int type) {this.type = type;}
	public String getBrand() {return brand;}
	public void setBrand(String brand) {this.brand = brand;}
	public String getVersion() {return version;}
	public void setVersion(String version) {this.version = version;}
	public String getSerial() {return serial;}
	public void setSerial(String serial) {this.serial = serial;}
	public String getPhenomenon() {return phenomenon;}
	public void setPhenomenon(String phenomenon) {this.phenomenon = phenomenon;}
	public int getBug() {return bug;}
	public void setBug(int bug) {this.bug = bug;}
	public int getCondition() {return condition;}
	public void setCondition(int condition) {this.condition = condition;}
	public String getExtraInfo() {return extraInfo;}
	public void setExtraInfo(String extraInfo) {this.extraInfo = extraInfo;}

	
	

}

package pd;

import dbhelper.EngineerHelper;

public class Engineer {
/*
 * cond=0:free
 * cond=1:working
 */
	
	
	private int id;
	private String password;
	private int cond;
	private int taskId;

	public Engineer() {
		// TODO Auto-generated constructor stub
	}

	
	public static Engineer getEngineerById(int id){
		EngineerHelper.init();
		Engineer eng=EngineerHelper.selectById(id);
		EngineerHelper.terminate();		
		return eng;
			
	}
	
	public void accept(int taskId){
		this.taskId=taskId;
		this.cond=1;
		EngineerHelper.init();
		EngineerHelper.update(id,taskId);
		EngineerHelper.terminate();		
	}
	
	public void complete() {
		EngineerHelper.init();
		EngineerHelper.complete(id);
		EngineerHelper.terminate();		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public int getCond() {return cond;}
	public void setCond(int cond) {this.cond = cond;}
	public int getTaskId() {return taskId;}
	public void setTaskId(int taskId) {this.taskId = taskId;}


	

}

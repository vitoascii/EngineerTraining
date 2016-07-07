package value;

public class RepairValue {
	public static int WAIT_FOR_REPAIR=0;
	public static int REPAIRING=1;
	public static int REPAIRED=2;
	

	private static String PC="台式机";
	private static String LAPTOP="笔记本";
	private static String PROJECTOR="投影仪";
	private static String PRINTER="打印机";
	private static String OTHER="其他";
	
	public static String[] Types=new String[]{PC,LAPTOP,PROJECTOR,PRINTER,OTHER};
	
	public static String[] BugTypes=new String[]{"固定性故障","间隙性故障"};
}

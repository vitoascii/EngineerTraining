package value;

public class RepairValue {
	public static int WAIT_FOR_REPAIR=0;
	public static int REPAIRING=1;
	public static int REPAIRED=2;
	

	private static String PC="̨ʽ��";
	private static String LAPTOP="�ʼǱ�";
	private static String PROJECTOR="ͶӰ��";
	private static String PRINTER="��ӡ��";
	private static String OTHER="����";
	
	public static String[] Types=new String[]{PC,LAPTOP,PROJECTOR,PRINTER,OTHER};
	
	public static String[] BugTypes=new String[]{"�̶��Թ���","��϶�Թ���"};
}

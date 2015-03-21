package BusinessLogic.BLService;

public class BLServiceDriver {
	public static void main(String[] args){
		BLService bl=new BLServiceController();
		bl.init();
		System.out.println(bl.getAllPlayers().get(450).getName());
	}
	
}

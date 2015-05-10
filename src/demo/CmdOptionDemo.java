package demo;

import de.tototec.cmdoption.*;

public class CmdOptionDemo {
	public static void main(String[] args) {
		Config config = new Config();
		Player player = new Player();
		CmdlineParser cp = new CmdlineParser(new Object[] { config, player });
		String cmdStr = "--help -total -n 5";
		String[] cmdArr = cmdStr.split("\\s"); //
		String str = "-c --help fuckZhouzhou" ;
		String[] strs = str.split(" ") ;
		try {
			cp.parse(strs);
//			cp.parse(cmdArr[0]);
//			cp.parse(cmdArr[1]);
//			cp.parse(new String[] { cmdArr[2], cmdArr[3] });
		} catch (CmdlineParserException e) {
			e.printStackTrace();
		}
		if (config.help) {
			System.out.println("-------help---------");
		}
		if (player.isShowTotal()) {
			System.out.println("------total---------");
		}
		System.out.println("the number of player is " + player.getNum());
	}

}

@CmdCommand(names = {"-c"},description = "inter Config")
class Config {
	@CmdOption(names = { "--help", "-h", "-?" },args={"field"}, description = "show help")
	public void isHelp(String field){
		System.out.println(field);
	}
	public boolean help;
}

class Player {
	private boolean showTotal = false;
	private int num = 0;

	public boolean isShowTotal() {
		return showTotal;
	}

	@CmdOption(names = { "-total" }, description = "show total", maxCount = 1, minCount = 0)
	public void setShowTotal() {
		this.showTotal = true;
		System.out.println("要孟州傻逼");
	}

	public int getNum() {
		return num;
	}

	@CmdOption(names = { "-n" }, args = { "filed" }, maxCount = 1, minCount = 0)
	public void setNum(String filed) {
		this.num = Integer.parseInt(filed);
	}

}

package demo;

import de.tototec.cmdoption.*;

public class CmdOptionDemo {
	public static void main(String[] args) {
		Config config = new Config();
		Player player = new Player();
		CmdlineParser cp = new CmdlineParser(new Object[] { config, player });
		String cmdStr = "--help -total -n 5";
		String[] cmdArr = cmdStr.split("\\s"); //
		try {
			cp.parse(cmdArr[0]);
			cp.parse(cmdArr[1]);
			cp.parse(new String[] { cmdArr[2], cmdArr[3] });
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

class Config {
	@CmdOption(names = { "--help", "-h", "-?" }, description = "show help", isHelp = true)
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
	}

	public int getNum() {
		return num;
	}

	@CmdOption(names = { "-n" }, args = { "filed" }, maxCount = 1, minCount = 0)
	public void setNum(String filed) {
		this.num = Integer.parseInt(filed);
	}

}

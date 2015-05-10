package com.kmno4.presentation;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BusinessLogic.BLService.BLService;
import BusinessLogic.BLService.BLServiceController;
import PO.MatchPO;
import PO.PlayerPO;
import PO.TeamPO;

import com.alee.laf.WebLookAndFeel;
import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	//panel统一从右边进入
	private ContentPanel contentPane;
	
	public static MainFrame mainFrame; //mainframe自身的静态引用
	public  PlayerSelectionPanel playerSelectionPanel;
	public  TopTabPanel topTabPanel;
	public  PageInfoPanel pageInfoPanel;
	public  TeamSelectionPanel teamSelectionPanel;
	public 	HotSelectionPanel hotSelectionPanel;
	public MatchSelectionPanel matchSelectionPanel;
	public  BLService bl;
	public ArrayList<PlayerPO> players;
	public ArrayList<TeamPO> teams;
	public ArrayList<MatchPO> matches;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		 // 装载可选择的主题  
//        WebLookAndFeel.install();
//		MainFrame frame = new MainFrame();
//		frame.setLayout(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
//
//		frame.setSize(Config.UI_WIDTH+frame.getInsets().left*2, Config.UI_HEIGHT+frame.getInsets().top+frame.getInsets().bottom);
//		frame.setLocationRelativeTo(null);
//		MainFrame.mainFrame.playerSelectionPanel.setBounds(0,
//				Config.TOP_TAB_HEIGHT + Config.INTRODUCTION_WHITE,
//				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
//		frame.setVisible(true);
//		
//	}
		

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		mainFrame = this; //
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Config.MAIN_FRAME_X,Config.MAIN_FRAME_Y, 
				Config.UI_WIDTH, Config.UI_HEIGHT);
		
		((JPanel)mainFrame.getContentPane()).setOpaque(false);
		JLabel l = new JLabel(Config.PLAYERGROUND);
		l.setBounds(0, 0, Config.UI_WIDTH, Config.UI_HEIGHT);
//		l.setBounds(0, 0, Config.FRAME_BACKGROUND.getIconWidth(), Config.FRAME_BACKGROUND.getIconHeight());
		mainFrame.getLayeredPane().setLayout(null);
		mainFrame.getLayeredPane().add(l, new Integer(Integer.MIN_VALUE));
		
		this.initBL();
		this.initPanel();
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
	}
	

	public void initPanel(){		
		topTabPanel=new TopTabPanel();
		this.add(topTabPanel);
		playerSelectionPanel=new PlayerSelectionPanel();
		this.add(playerSelectionPanel);
		teamSelectionPanel=new TeamSelectionPanel();
		this.add(teamSelectionPanel);
		matchSelectionPanel=new MatchSelectionPanel();
		this.add(matchSelectionPanel);
		hotSelectionPanel=new HotSelectionPanel();
		this.add(hotSelectionPanel);	
		pageInfoPanel=new PageInfoPanel("球员");
		this.add(pageInfoPanel);
		topTabPanel.ini();
	}
	
	public void initBL(){
		bl=new BLServiceController("E:/Data");
		bl.init();
		players=bl.getAllPlayers();
		teams=bl.getAllTeams();
	}
	
	public void refreshPlayerTable(){
		
	}

	

	

}

package com.kmno4.presentation;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.BLService.BLService;
import BusinessLogic.BLService.BLServiceController;
import PO.MatchPO;
import PO.PlayerPO;
import PO.TeamPO;

import com.kmno4.common.Config;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements MouseListener{

	//panel统一从右边进入
	private JPanel contentPane;
	
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {}
		

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		mainFrame = this; //
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Config.MAIN_FRAME_X,Config.MAIN_FRAME_Y, 
				Config.UI_WIDTH, Config.UI_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);	
		
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
		bl=new BLServiceController();
		bl.init();
		players=bl.getAllPlayers();
		teams=bl.getAllTeams();
	}
	
	public void refreshPlayerTable(){
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//如果点击球员tab
//		if(e.getSource()==topTabPanel.player){
//			
//		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}

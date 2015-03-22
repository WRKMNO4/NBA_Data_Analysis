package com.kmno4.presentation;

import java.awt.Dimension;
import java.awt.Toolkit;
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
	public  SelectionPanel playerSelectionPanel;
	public  TopTabPanel topTabPanel;
	public  PageInfoPanel pageInfoPanel;
	public  TeamSelectionPanel teamSelectionPanel;
	public  BLService bl;
	public ArrayList<PlayerPO> players;
	public ArrayList<TeamPO> teams;
	public ArrayList<MatchPO> matches;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Thread splash=new Thread(new Runnable(){
			@Override
			public void run() {
				long begin_time=System.currentTimeMillis();
				JFrame GFrame = new JFrame();	//创建窗口
				SplashPanel DPanel = new SplashPanel();	//创建画板
				/*设置JFrame*/
				GFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GFrame.setUndecorated(true);
				Toolkit kit=Toolkit.getDefaultToolkit();
				Dimension screensize=kit.getScreenSize();
				int screenheight=screensize.height;
				int screenwidth=screensize.width;
				GFrame.setLocation(screenwidth/8,screenheight/8);
				GFrame.setSize(Config.UI_WIDTH, Config.UI_HEIGHT);
				GFrame.setVisible(true);
				GFrame.add(DPanel);	//在JFrame中加入DPanel
				DPanel.launch();					
				while(true){
					if(System.currentTimeMillis()-begin_time>7000){
						GFrame.dispose();
						break;
					}				
				}				
			}			
		});
		
		Thread mainUI=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long begin_time=System.currentTimeMillis();
				
				MainFrame frame = new MainFrame();
				frame.setLayout(null);
				frame.setResizable(false);
				//获取屏幕宽高
				Toolkit kit=Toolkit.getDefaultToolkit();
				Dimension screensize=kit.getScreenSize();
				int screenheight=screensize.height;
				int screenwidth=screensize.width;
				
				frame.setSize(Config.UI_WIDTH,Config.UI_HEIGHT);
				frame.setLocation(screenwidth/8,screenheight/8);				
				mainFrame.playerSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
			Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				
				while(true){
					if((System.currentTimeMillis()-begin_time)>7000){
						frame.setVisible(true);
						break;
					}
				}
			}			
		});
		
		mainUI.start();
//		splash.start();

	}

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
		
		MoveOfFrame m = new MoveOfFrame(this);
	}

	public void initPanel(){
		pageInfoPanel=new PageInfoPanel("球员");
		this.add(pageInfoPanel);
		topTabPanel=new TopTabPanel();
		this.add(topTabPanel);
		playerSelectionPanel=new SelectionPanel();
		this.add(playerSelectionPanel);
		teamSelectionPanel=new TeamSelectionPanel();
		this.add(teamSelectionPanel);
	}
	
	public void initBL(){
		bl=new BLServiceController();
		bl.init();
		players=bl.getAllPlayers();
		teams=bl.getAllTeamsOf13_14();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package com.kmno4.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kmno4.common.Config;

public class MainFrame extends JFrame implements MouseListener{

	//panel统一从右边进入
	private JPanel contentPane;
	
	public static MainFrame mainFrame; //mainframe自身的静态引用
	public static SelectionPanel playerSelectionPanel;
	public static TopTabPanel topTabPanel;
	public static PageInfoPanel pageInfoPanel;
	public static TeamSelectionPanel teamSelectionPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
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
					//添加panel
//					topTabPanel.setLayout(null);
//					frame.add(topTabPanel);
//					
//
//					//以下是需要跳转的Panel
//					playerSelectionPanel.setLayout(null);
//					frame.add(playerSelectionPanel);
					
					playerSelectionPanel.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
					
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		mainFrame = this; //
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Config.MAIN_FRAME_X,Config.MAIN_FRAME_Y, 
				Config.UI_WIDTH, Config.UI_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);	
		
		this.initPanel();

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

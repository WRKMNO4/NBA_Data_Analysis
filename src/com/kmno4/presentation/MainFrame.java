package com.kmno4.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kmno4.common.Config;

public class MainFrame extends JFrame {

	private JPanel contentPane;

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
					SelectionPanel selection=new SelectionPanel();
					selection.setLayout(null);
					TopTabPanel top=new TopTabPanel();
					top.setLayout(null);
					frame.add(top);
					frame.add(selection);
					
					selection.setBounds(0, Config.TOP_TAB_HEIGHT+Config.INTRODUCTION_WHITE, 
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);		
		
	}

}

package com.kmno4.presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kmno4.common.Config;

public class SplashFrame extends JFrame {

	private JPanel contentPane;
	private JLabel bg;
	private int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SplashPanel splash=new SplashPanel();
//					SplashFrame frame = new SplashFrame();
//					frame.add(splash);
//					splash.launch();
//					
////					new Runner(frame.contentPane).start();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public SplashFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Config.UI_WIDTH,Config.UI_HEIGHT);
		this.setVisible(true);
//		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		setContentPane(contentPane);

	}
	

}

class Runner extends Thread {  
    private Graphics g;  
    private JPanel panel;
      
    public Runner(JPanel panel) {  
        this.panel=panel;
        this.g = panel.getGraphics();
    }  
  
    @Override  
    public void run() {  
    	int i=0;
    	while(true){
    		if(i==99){
    			i=0;
    		}
    		try {
    			System.out.println(i);
				panel.repaint();
				g.drawImage(Config.getLoadingMotions().get(i).getImage(), 400, 300, 
						Config.getLoadingMotions().get(i).getIconWidth(), 
						Config.getLoadingMotions().get(i).getIconHeight(), 
						panel);				
				sleep(110);
				i++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

    }  
  
} 

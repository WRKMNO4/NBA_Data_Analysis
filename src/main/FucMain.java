package main;

import javax.swing.JFrame;

import com.kmno4.common.Config;
import com.kmno4.presentation.SplashPanel;

public class FucMain {
	
	class SplashPaneThread extends Thread{
		@Override
		public void run() {
		// TODO Auto-generated method stub
			//执行5秒
			long begin_time=System.currentTimeMillis();
			
				try {
					JFrame GFrame = new JFrame();	//创建窗口
					SplashPanel DPanel = new SplashPanel();	//创建画板
					/*设置JFrame*/
					GFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					GFrame.setLocation(100, 100);
					GFrame.setSize(Config.UI_WIDTH, Config.UI_HEIGHT);
					GFrame.setVisible(true);
					GFrame.add(DPanel);	//在JFrame中加入DPanel
					DPanel.launch();
					
					while(true){
						if(System.currentTimeMillis()-begin_time>3000){
							break;
						}
					}
					
					stop();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}

	public static void main(String[] args){
		JFrame GFrame = new JFrame();	//创建窗口
		SplashPanel DPanel = new SplashPanel();	//创建画板
		/*设置JFrame*/
		GFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GFrame.setLocation(100, 100);
		GFrame.setSize(Config.UI_WIDTH, Config.UI_HEIGHT);
		GFrame.setVisible(true);
		GFrame.add(DPanel);	//在JFrame中加入DPanel
		DPanel.launch();
	}
}

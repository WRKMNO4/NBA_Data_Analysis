package main;

import javax.swing.JFrame;
import javax.swing.plaf.FontUIResource;

import com.alee.laf.WebLookAndFeel;
import com.kmno4.common.Config;
import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.SplashPanel;
import com.kmno4.presentation2.PUtil;

public class FucMain {

	public static void main(String[] args) {
		// 组件
		 WebLookAndFeel.globalControlFont  = new FontUIResource("黑体",0, 15);
		 WebLookAndFeel.install();
		
		 PUtil.setCache();
		// look$feel——————second choice
		// JFrame.setDefaultLookAndFeelDecorated(true);
		// JDialog.setDefaultLookAndFeelDecorated(true);
		// try {
		// UIManager.setLookAndFeel(new SubstanceLookAndFeel());
		// JFrame.setDefaultLookAndFeelDecorated(true);
		// JDialog.setDefaultLookAndFeelDecorated(true);
		// SubstanceLookAndFeel
		// .setCurrentTheme(new SubstanceTerracottaTheme());
		// SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
		// SubstanceLookAndFeel
		// .setCurrentButtonShaper(new ClassicButtonShaper());
		// SubstanceLookAndFeel
		// .setCurrentWatermark(new SubstanceBubblesWatermark());
		// SubstanceLookAndFeel
		// .setCurrentBorderPainter(new StandardBorderPainter());
		// SubstanceLookAndFeel
		// .setCurrentGradientPainter(new StandardGradientPainter());
		// SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());
		// } catch (Exception e) {
		// System.err.println("Something went wrong!");
		// }
		Thread splash = new Thread(new Runnable() {
			@Override
			public void run() {
				long begin_time = System.currentTimeMillis();
				JFrame GFrame = new JFrame(); // 创建窗口
				SplashPanel DPanel = new SplashPanel(); // 创建画板
				/* 设置JFrame */
				GFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GFrame.setUndecorated(true);
				//Toolkit kit = Toolkit.getDefaultToolkit();
				//Dimension screensize = kit.getScreenSize();
				//int screenheight = screensize.height;
				//int screenwidth = screensize.width;
				//GFrame.setLocation(screenwidth / 8, screenheight / 8);
				GFrame.setSize(Config.UI_WIDTH, Config.UI_HEIGHT);
				GFrame.setLocationRelativeTo(null);
				GFrame.setVisible(true);
				GFrame.add(DPanel); // 在JFrame中加入DPanel
				DPanel.launch();
				while (true) {
					if (System.currentTimeMillis() - begin_time > 3000) {
						GFrame.dispose();
						break;
					}
				}
			}
		});

		Thread mainUI = new Thread(new Runnable() {

			@Override
			public void run() {
				long begin_time = System.currentTimeMillis();

				MainFrame frame = new MainFrame();
				frame.setLayout(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				// 获取屏幕宽高
				//Toolkit kit = Toolkit.getDefaultToolkit();
				//Dimension screensize = kit.getScreenSize();
				//int screenheight = screensize.height;
				//int screenwidth = screensize.width;

				frame.setSize(Config.UI_WIDTH, Config.UI_HEIGHT);
				//frame.setLocation(screenwidth / 8, screenheight / 8);
				frame.setLocationRelativeTo(null);
				MainFrame.mainFrame.hotSelectionPanel.setBounds(0,
						Config.TOP_TAB_HEIGHT + Config.INTRODUCTION_WHITE,
						Config.UI_WIDTH, Config.SELECTION_HEIGHT);
				frame.setVisible(true);
//				while (true) {
//					if ((System.currentTimeMillis() - begin_time) > 3000) {
//						frame.setVisible(true);
//						break;
//					}
//				}
			}
		});

		mainUI.start();
//		splash.start();
	}
}

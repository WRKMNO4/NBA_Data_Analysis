package com.kmno4.presentation2;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

import PO.PlayerPO;
/**
 * 球员对比分析界面
 * 包含了一大堆功能
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerComparisonAnalysisPanel extends JPanel {
	private PlayerComparisonAnalysisPanel playerComparisonAnalysisPanel;
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO;
	public static final int 
    	PADDING = PlayerDataAnalysisPanel.PADDING,
        PLAYER_PANEL_WIDTH = 400,
        PLAYER_PANEL_HEIGHT = 300;
	private PlayerPanel player1, player2;
	private InfoPanel info;
	private InputPanel input;
	
	
	public PlayerComparisonAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerComparisonAnalysisPanel = this;
		this.playerPO = playerPO;
		setBounds(
				PADDING,
				PADDING * 2 + PlayerDataAnalysisPanel.SELECT_PANEL_HEIGHT + PlayerDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING,
				PlayerDataAnalysisPanel.PANEL_HEIGHT);
		setLayout(null);

		
		input = new InputPanel();
		add(input);
	    comp(null);
		
	}
	/**
	 * 展示球员简略信息的一个panel
	 * @author hutao
	 *
	 */
	class PlayerPanel extends JPanel {
		JLabel player, name, value;
		public PlayerPanel(PlayerPO p) {
			setBounds(0, 0, PLAYER_PANEL_WIDTH, PLAYER_PANEL_HEIGHT);
			
		}
		public PlayerPanel(String name) {
			setBounds(playerComparisonAnalysisPanel.getWidth() - PLAYER_PANEL_WIDTH,
	                playerComparisonAnalysisPanel.getHeight() - PLAYER_PANEL_HEIGHT,
	                PLAYER_PANEL_WIDTH, PLAYER_PANEL_HEIGHT);
			
			//images/nba_logo.png
		}
		
	}
	/**
	 * 显示比对后信息的panel
	 * @author hutao
	 *
	 */
	class InfoPanel extends JPanel {
        JLabel infoLabel1, infoLabel2;
		public InfoPanel(String info1, String info2) {
            
        }
		
	}
	/**
	 * 进行查询输入的panel
	 * @author hutao
	 *
	 */
	class InputPanel extends JPanel {
		public InputPanel() {}
	}
	/**
	 * 输入完毕后进行查询，并输出结果
	 */
	private void comp(String name) {
		if(player1 == null) {
			player1 = new PlayerPanel(playerPO);
			add(player1);
		}
		if(player2 != null) {
			player2.setVisible(false);
			remove(player2);
		}
		player2 = new PlayerPanel(name);
		add(player2);
		if(info != null) {
			info.setVisible(false);
			remove(info);
		}
		info = new InfoPanel(null, null);
		add(info);
	}

}

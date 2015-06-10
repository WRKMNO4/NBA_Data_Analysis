package com.kmno4.presentation2;

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
    	PADDING = PlayerDataAnalysisPanel.PADDING;
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
		
		player1 = new PlayerPanel(playerPO);
		add(player1);
		player2 = new PlayerPanel(null);
		add(player2);
		info = new InfoPanel();
		add(info);
		input = new InputPanel();
		add(input);
		
	}
	/**
	 * 展示球员简略信息的一个panel
	 * @author hutao
	 *
	 */
	class PlayerPanel extends JPanel {
		public PlayerPanel(PlayerPO p) {
//			if(p == null) setBounds(x, y, width, height);
//			else setBounds(x, y, width, height);
			
		}
	}
	/**
	 * 显示比对后信息的panel
	 * @author hutao
	 *
	 */
	class InfoPanel extends JPanel {
		public InfoPanel() {}
		
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
	private void comp() {
		
	}

}

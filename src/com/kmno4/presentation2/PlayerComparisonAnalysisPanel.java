package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
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
        PLAYER_PANEL_WIDTH = 420,
        PLAYER_PANEL_HEIGHT = 420,
        OTHER_PANEL_WIDHT = PLAYER_PANEL_WIDTH,
        OTHER_PANEL_HEIGHT = PlayerDataAnalysisPanel.PANEL_HEIGHT - PADDING - PLAYER_PANEL_HEIGHT;
	private PlayerPanel player1, player2;
	private InfoPanel info;
	private InputPanel input;
	private JLabel v, s;
	
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
		setOpaque(false);
		
		Font font = new Font("default", 2, 80);
		int len =  getWidth() - 2 * PLAYER_PANEL_WIDTH;
		int wid = len * 2 / 3;
		v = new JLabel("V", JLabel.CENTER);
		v.setBounds(PLAYER_PANEL_WIDTH, getHeight() / 2 - wid + len / 6, wid, wid);
		PUtil.setFontandColor(v, font, Color.white);
		s = new JLabel("S", JLabel.CENTER);
		s.setBounds(PLAYER_PANEL_WIDTH + len / 3, getHeight() / 2 - len / 6, wid, wid);
		PUtil.setFontandColor(s, font, Color.white);
		add(v);
		add(s);
		
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
			ini();
		}
		public PlayerPanel(String name) {
			setBounds(playerComparisonAnalysisPanel.getWidth() - PLAYER_PANEL_WIDTH,
	                playerComparisonAnalysisPanel.getHeight() - PLAYER_PANEL_HEIGHT,
	                PLAYER_PANEL_WIDTH, PLAYER_PANEL_HEIGHT);
			ini();
			//images/nba_logo.png
		}
		private void ini() {
			setLayout(null);
			setBackground(new Color(0, 255, 255, 80));
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
			setLayout(null);
			setBounds(0, PLAYER_PANEL_HEIGHT + PADDING, OTHER_PANEL_WIDHT, OTHER_PANEL_HEIGHT);
			setBackground(Color.black);
        }
		
	}
	/**
	 * 进行查询输入的panel
	 * @author hutao
	 *
	 */
	class InputPanel extends JPanel {
		JComboBox<String> conditions, name;
		public InputPanel() {
			setLayout(null);
			setBounds(playerComparisonAnalysisPanel.getWidth() - PLAYER_PANEL_WIDTH,
					0,
					OTHER_PANEL_WIDHT, OTHER_PANEL_HEIGHT);
			setBackground(Color.black);
		}
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

package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.PlayerDetailFrame;
import com.kmno4.presentation.button.LMouseAdapter;

import PO.PlayerPO;
/**
 * 球员数据分析界面
 * 内含球员综合能力分析界面{@link PlayerPerformAnalysisPanel}，
 * 球员对比分析界面{@link PlayerComparisonAnalysisPanel}，TODO
 * 球员演变分析界面{@link PlayerEvolutionAnalysisPanel}
 * 三个模块
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerDataAnalysisPanel extends JPanel {
//	private PlayerDataAnalysisPanel playerDataAnalysisPanel;
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	public static final int 
	    PADDING = 10,
	    LABEL_HEIGHT = 45,
	    LABEL_WIDTH = 300,
	    SELECT_PANEL_HEIGHT = 45,
	    PANEL_HEIGHT = Config.UI_HEIGHT - 2 * PADDING - LABEL_HEIGHT - SELECT_PANEL_HEIGHT,
	    SELECT_LABEL_WIDTH = 120;
	
	private JLabel playerLabel;
	private SelectPanel selectPanel;
	
	private JPanel current_panel;
	private PlayerPerformAnalysisPanel playerPerformAnalysisPanel;
	private PlayerComparisonAnalysisPanel playerComparisonAnalysisPanel;
	private PlayerEvolutionAnalysisPanel playerEvolutionAnalysisPanel;
	private PlayerPO playerPO;
	
	public PlayerDataAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerPO = playerPO;
//		this.playerDataAnalysisPanel = this;
		setLayout(null);
		setBounds(0, 0, f.getWidth(), f.getHeight());
		
		playerLabel = new JLabel(playerPO.getName(), JLabel.LEFT);
		playerLabel.setBounds(PADDING, PADDING, LABEL_WIDTH, LABEL_HEIGHT);
		playerLabel.setForeground(Color.white);
		playerLabel.setFont(new Font("default", 2, 30));
		playerLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				returnToDetailFrame();
			}
		});
		add(playerLabel);
		
		selectPanel = new SelectPanel();
		add(selectPanel);
		
		add(current_panel = (playerPerformAnalysisPanel = new PlayerPerformAnalysisPanel(playerPO, playerDataAnalysisFrame)));
		
	}
	
	class SelectPanel extends JPanel {
		JLabel perform, compare, evolu;
		public SelectPanel() {
			setBounds(PADDING, PADDING + LABEL_HEIGHT,
					Config.UI_WIDTH - 2 * PADDING, SELECT_PANEL_HEIGHT);
			setLayout(null);
			setBackground(new Color(20, 79, 139, 150));
			perform = new JLabel("综合能力分析", JLabel.LEFT);
			perform.setBounds(0, 0, SELECT_LABEL_WIDTH, SELECT_PANEL_HEIGHT);
			perform.setForeground(Color.white);
			perform.setFont(new Font("default", 0, 15));
			add(perform);
			compare = new JLabel("球员对比分析", JLabel.LEFT);
			compare.setBounds(SELECT_LABEL_WIDTH, 0, SELECT_LABEL_WIDTH, SELECT_PANEL_HEIGHT);
			compare.setForeground(Color.white);
			compare.setFont(new Font("default", 0, 15));
			add(compare);
			evolu = new JLabel("球员演变分析", JLabel.LEFT);
			evolu.setBounds(SELECT_LABEL_WIDTH * 2, 0, SELECT_LABEL_WIDTH, SELECT_PANEL_HEIGHT);
			evolu.setForeground(Color.white);
			evolu.setFont(new Font("default", 0, 15));
			add(evolu);
			perform.addMouseListener(new LMouseAdapter(playerDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toPerformAnalysis();
				}
			});
			compare.addMouseListener(new LMouseAdapter(playerDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toComparisonAnalysis();
				}
			});
			evolu.addMouseListener(new LMouseAdapter(playerDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toEvolutionAnalysis();
				}
			});
			
		}
		
	}
	
	
	
	/**
	 * 切换到球员综合能力分析
	 */
	public void toPerformAnalysis() {
		remove(current_panel);
		playerPerformAnalysisPanel = new PlayerPerformAnalysisPanel(playerPO, playerDataAnalysisFrame);
		add(current_panel = playerPerformAnalysisPanel);
		playerDataAnalysisFrame.repaint();
	}
	/**
	 * 切换到球员对比
	 */
	public void toComparisonAnalysis() {
		remove(current_panel);
		playerComparisonAnalysisPanel = new PlayerComparisonAnalysisPanel(playerPO, playerDataAnalysisFrame);
		add(current_panel = playerComparisonAnalysisPanel);
		playerDataAnalysisFrame.repaint();
	}
	/**
	 * 切换到球员演变分析
	 */
	public void toEvolutionAnalysis() {
		remove(current_panel);
		playerEvolutionAnalysisPanel = new PlayerEvolutionAnalysisPanel(playerPO, playerDataAnalysisFrame);
		add(current_panel = playerEvolutionAnalysisPanel);
		playerDataAnalysisFrame.repaint();
	}
	/**
	 * 切换到playerDetailFrame界面
	 */
	public void returnToDetailFrame() {
		new PlayerDetailFrame(playerPO, playerDataAnalysisFrame.getLocation());
		playerDataAnalysisFrame.setVisible(false);
		playerDataAnalysisFrame.dispose();
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(Config.DETAIL_BG.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
//	public static void main(String[] args) {
//		new PlayerDataAnalysisFrame(null);
//	}
}

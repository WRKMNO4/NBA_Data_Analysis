package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.TeamDetailFrame;
import com.kmno4.presentation.button.LMouseAdapter;

import PO.TeamPO;
/**
 * 球队单个分析界面
 * 内含球员分析{@link TeamPlayerAnalysisPanel}，TODO
 * 球队排名演变分析{@link TeamEvolutionAnalysisPanel} 
 * 两个模块
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TeamDataAnalysisPanel extends JPanel {
	public static final int 
	    PADDING = 10,
	    TEAM_LABEL_HEIGHT = 60,
	    TEAM_LABEL_WIDTH = 300,
	    SELECT_PART_HEIGHT = 45,
	    PANEL_HEIGHT = Config.UI_HEIGHT - PADDING * 3 - TEAM_LABEL_HEIGHT - SELECT_PART_HEIGHT,
	    SELECT_LABEL_WIDTH = 75;
	
	private JLabel teamLabel;
	private SelectPanel selectPanel;
	
	private JPanel current_panel;
	private TeamPlayerAnalysisPanel teamPlayerAnalysisPanel;
	private TeamEvolutionAnalysisPanel teamEvolutionAnalysisPanel;
	private TeamPO teamPO;
	private TeamDataAnalysisFrame teamDataAnalysisFrame;
	
	public TeamDataAnalysisPanel(TeamDataAnalysisFrame f, TeamPO teamPO) {
		teamDataAnalysisFrame = f;
		this.teamPO = teamPO;
		setBounds(0, 0, f.getWidth(), f.getHeight());
		setLayout(null);
		
		teamLabel = new JLabel(teamPO.getFullName(), JLabel.LEFT);
		teamLabel.setForeground(Color.white);
		teamLabel.setFont(new Font("default", 2, 30));
		teamLabel.setBounds(PADDING, PADDING, TEAM_LABEL_WIDTH, TEAM_LABEL_HEIGHT);
		teamLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				returnToDetailFrame();
			}
		});
		add(teamLabel);
		
		selectPanel = new SelectPanel();
		add(selectPanel);
		add(current_panel = (teamPlayerAnalysisPanel = new TeamPlayerAnalysisPanel(teamPO, teamDataAnalysisFrame)));
	}
	
	
	class SelectPanel extends JPanel {
		JLabel player, evolu;
		public SelectPanel() {
			setBounds(PADDING, PADDING + TEAM_LABEL_HEIGHT, Config.UI_WIDTH - PADDING * 2, SELECT_PART_HEIGHT);
			setLayout(null);
			setBackground(new Color(20, 79, 139, 150));
			player = new JLabel("球员分析", JLabel.CENTER);
			player.setBounds(0, 0, SELECT_LABEL_WIDTH, SELECT_PART_HEIGHT);
			player.setForeground(Color.white);
			player.setFont(new Font("default", 0, 15));
			evolu = new JLabel("排名分析", JLabel.CENTER);
			evolu.setBounds(SELECT_LABEL_WIDTH, 0, SELECT_LABEL_WIDTH, SELECT_PART_HEIGHT);
			evolu.setForeground(Color.white);
			evolu.setFont(new Font("default", 0, 15));
			player.addMouseListener(new LMouseAdapter(teamDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toPlayerAnalysis();
				}
			});
			evolu.addMouseListener(new LMouseAdapter(teamDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toEvolutionAnalysis();
				}
			});
			add(player);
			add(evolu);
			
		}
	}
	
	/**
	 * 切换到球队球员分析
	 */
	private void toPlayerAnalysis() {
		remove(current_panel);
		teamPlayerAnalysisPanel = new TeamPlayerAnalysisPanel(teamPO, teamDataAnalysisFrame);
		add(current_panel = teamPlayerAnalysisPanel);
		teamDataAnalysisFrame.repaint();
	}
	/**
	 * 切换到球队排名演变分析
	 */
	private void toEvolutionAnalysis() {
		remove(current_panel);
		teamEvolutionAnalysisPanel = new TeamEvolutionAnalysisPanel(teamPO, teamDataAnalysisFrame);
		add(current_panel = teamEvolutionAnalysisPanel);
		teamDataAnalysisFrame.repaint();
	}
	/**
	 * 切换到teamDetailFrame界面
	 */
	private void returnToDetailFrame() {
		new TeamDetailFrame(teamPO, teamDataAnalysisFrame.getLocation());
		teamDataAnalysisFrame.setVisible(false);
		teamDataAnalysisFrame.dispose();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(Config.DETAIL_BG.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
	public static void main(String[] args) {
		new TeamDataAnalysisFrame(null);
	}
	
}

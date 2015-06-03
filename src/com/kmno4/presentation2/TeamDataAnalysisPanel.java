package com.kmno4.presentation2;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.TeamDetailFrame;
import com.kmno4.presentation.button.LMouseAdapter;

import PO.TeamPO;
/**
 * 球队单个分析界面
 * 内含球员分析{@link TeamPlayerAnalysisPanel}，
 * 球队全比赛分析{@link TeamMatchAnalysisPanel}，
 * 球队排名演变分析{@link TeamEvolutionAnalysisPanel}
 * 三个模块
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TeamDataAnalysisPanel extends JPanel {
	public static final int 
	    PADDING = 10,
	    TEAM_LABEL_HEIGHT = 60,
	    SELECT_PART_HEIGHT = 60,
	    PANEL_HEIGHT = Config.UI_HEIGHT - PADDING * 3 - TEAM_LABEL_HEIGHT - SELECT_PART_HEIGHT,
	    SELECT_LABEL_WIDTH = 100;
	
	private JLabel teamLabel;
	private SelectPanel selectPanel;
	
	private JPanel current_panel;
	private TeamMatchAnalysisPanel teamMatchAnalysisPanel;
	private TeamPlayerAnalysisPanel teamPlayerAnalysisPanel;
	private TeamEvolutionAnalysisPanel teamEvolutionAnalysisPanel;
	private TeamPO teamPO;
	private TeamDataAnalysisFrame teamDataAnalysisFrame;
	
	public TeamDataAnalysisPanel(TeamDataAnalysisFrame f, TeamPO teamPO) {
		teamDataAnalysisFrame = f;
		this.teamPO = teamPO;
		setBounds(0, 0, f.getWidth(), f.getHeight());
		setLayout(null);
		
		teamLabel = new JLabel(/*teamPO.getFullName()*/"某球队", JLabel.LEFT);
		teamLabel.setBounds(PADDING, PADDING, Config.UI_WIDTH - PADDING * 2, TEAM_LABEL_HEIGHT);
		teamLabel.addMouseListener(new LMouseAdapter(teamDataAnalysisFrame) {
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
		JLabel player, match, evolu;
		public SelectPanel() {
			setBounds(PADDING, PADDING + TEAM_LABEL_HEIGHT, Config.UI_WIDTH - PADDING * 2, SELECT_PART_HEIGHT);
			setLayout(null);
			player = new JLabel("球员分析", JLabel.CENTER);
			player.setBounds(0, 0, SELECT_LABEL_WIDTH, SELECT_PART_HEIGHT);
			match = new JLabel("比赛分析", JLabel.CENTER);
			match.setBounds(SELECT_LABEL_WIDTH, 0, SELECT_LABEL_WIDTH, SELECT_PART_HEIGHT);
			evolu = new JLabel("排名分析", JLabel.CENTER);
			evolu.setBounds(SELECT_LABEL_WIDTH * 2, 0, SELECT_LABEL_WIDTH, SELECT_PART_HEIGHT);
			player.addMouseListener(new LMouseAdapter(teamDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toPlayerAnalysis();
				}
			});
			match.addMouseListener(new LMouseAdapter(teamDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toMatchAnalysis();
				}
			});
			evolu.addMouseListener(new LMouseAdapter(teamDataAnalysisFrame) {
				public void mouseClicked(MouseEvent e) {
					toEvolutionAnalysis();
				}
			});
			add(player);
			add(match);
			add(evolu);
			
		}
	}
	
	/**
	 * 切换到球队比赛部分
	 */
	private void toMatchAnalysis() {
		remove(current_panel);
		add(current_panel = (teamMatchAnalysisPanel = new TeamMatchAnalysisPanel(teamPO, teamDataAnalysisFrame)));
		teamDataAnalysisFrame.repaint();
	}
	/**
	 * 切换到球队球员分析
	 */
	private void toPlayerAnalysis() {
		remove(current_panel);
		add(current_panel = (teamPlayerAnalysisPanel = new TeamPlayerAnalysisPanel(teamPO, teamDataAnalysisFrame)));
		teamDataAnalysisFrame.repaint();
	}
	/**
	 * 切换到球队排名演变分析
	 */
	private void toEvolutionAnalysis() {
		remove(current_panel);
		add(current_panel = (teamEvolutionAnalysisPanel = new TeamEvolutionAnalysisPanel(teamPO, teamDataAnalysisFrame)));
		teamDataAnalysisFrame.repaint();
	}
	/**
	 * 切换到teamDetailFrame界面
	 */
	private void returnToDetailFrame() {
		new TeamDetailFrame(teamPO, this.getLocation());
		teamDataAnalysisFrame.setVisible(false);
		teamDataAnalysisFrame.dispose();
	}
	
	
	public static void main(String[] args) {
		new TeamDataAnalysisFrame(null);
	}
	
}

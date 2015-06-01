package com.kmno4.presentation2;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.kmno4.common.Config;

import PO.TeamPO;
/**
 * 球员展示分析，
 * 并按照条件进行排名
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TeamPlayerAnalysisPanel extends JPanel {
	private TeamPlayerAnalysisPanel teamPlayerAnalysisPanel;
	private TeamDataAnalysisFrame teamDataAnalysisFrame;
	private TeamPO teamPO;
	
	private JComboBox<String> conditions;
	private MainPlayerPanel mainPlayerPanel;
	private OtherPlayerPanel otherPlayerPanel;
	
	public TeamPlayerAnalysisPanel(TeamPO teamPO, TeamDataAnalysisFrame f) {
		this.teamPO = teamPO;
		this.teamDataAnalysisFrame = f;
		this.teamPlayerAnalysisPanel = this;
		setLayout(null);
		setBounds(TeamDataAnalysisPanel.PADDING,
				2 * TeamDataAnalysisPanel.PADDING + TeamDataAnalysisPanel.SELECT_PART_HEIGHT + TeamDataAnalysisPanel.TEAM_LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * TeamDataAnalysisPanel.PADDING,
				TeamDataAnalysisPanel.PANEL_HEIGHT);
		
		
	}
	
	class MainPlayerPanel extends JPanel {}
	class OtherPlayerPanel extends JPanel {}
}

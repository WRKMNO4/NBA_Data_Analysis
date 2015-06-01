package com.kmno4.presentation2;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableGroup;

import PO.TeamPO;
/**
 * 球队全比赛数据部分，根据年份可以获取球队该年份的全比赛数据
 * 并且可以按照表头排序
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class TeamMatchAnalysisPanel extends JPanel {
	private TeamMatchAnalysisPanel teamSeasonAnalysisPanel;
	private TeamDataAnalysisFrame teamDataAnalysisFrame;
	private TeamPO teamPO;
	private JComboBox<String> seasonBox;
	private JLabel seasonLabel;
	private TableGroup tg;
	
	public TeamMatchAnalysisPanel(TeamPO teamPO, TeamDataAnalysisFrame f) {
		this.teamPO = teamPO;
		this.teamSeasonAnalysisPanel = this;
		this.teamDataAnalysisFrame = f;
		setLayout(null);
		setBounds(TeamDataAnalysisPanel.PADDING,
				2 * TeamDataAnalysisPanel.PADDING + TeamDataAnalysisPanel.SELECT_PART_HEIGHT + TeamDataAnalysisPanel.TEAM_LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * TeamDataAnalysisPanel.PADDING,
				TeamDataAnalysisPanel.PANEL_HEIGHT);
		
		seasonBox = new JComboBox<String>(Config.Seasons);
		
		seasonLabel = new JLabel("常规赛数据", JLabel.LEFT);
		
		tg = new TableGroup();
	}

}

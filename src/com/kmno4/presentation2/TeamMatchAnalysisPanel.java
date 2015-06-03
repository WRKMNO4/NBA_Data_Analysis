package com.kmno4.presentation2;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableFactory;
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
	
	String[][] example = {
			{"date", "name", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l"},
			{"1-1", "aaaaa", "as", "b", "c", "ds", "e", "f", "gs", "h", "is", "j", "k", "l"},
			{"", "bbbbb", "as", "b", "c", "ds", "e", "f", "gs", "h", "is", "j", "k", "l"},
			{"1-2", "aaaaa", "as", "b", "c", "ds", "e", "f", "gs", "h", "is", "j", "k", "l"},
			{"", "bbbbb", "as", "b", "c", "ds", "e", "f", "gs", "h", "is", "j", "k", "l"},
			{"1-3", "aaaaa", "as", "b", "c", "ds", "e", "f", "gs", "h", "is", "j", "k", "l"},
			{"", "bbbbb", "as", "b", "c", "ds", "e", "f", "gs", "h", "is", "j", "k", "l"},
			{"1-4", "aaaaa", "as", "b", "c", "ds", "e", "f", "gs", "h", "is", "j", "k", "l"},
			{"", "bbbbb", "as", "b", "c", "ds", "e", "f", "gs", "h", "is", "j", "k", "l"},};
	private static final int
	    LABEL_HEIGHT = 30,
	    LABEL_WIDTH = 200;
	
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
		seasonBox.setBounds(0, 0, LABEL_WIDTH, LABEL_HEIGHT);
		add(seasonBox);
		seasonLabel = new JLabel("常规赛数据", JLabel.LEFT);
		seasonLabel.setBounds(LABEL_WIDTH, 0, LABEL_WIDTH, LABEL_HEIGHT);
		add(seasonLabel);
		
		tg = new TableGroup();
		TableFactory.createTable(tg, this, example,
				getWidth(), getHeight() - LABEL_HEIGHT,
				0, LABEL_HEIGHT);
	}

}

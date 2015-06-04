package com.kmno4.presentation2;

import javax.swing.JPanel;

import com.kmno4.common.Config;
/**
 * 全球队信息的最近10场比赛数据分析界面
 * 与联盟排名一览界面结构大体相同
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamRecentMatchAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
	private AllTeamRecentMatchAnalysisPanel allTeamRecentMatchAnalysisPanel;
	
	public AllTeamRecentMatchAnalysisPanel(AllTeamDataAnalysisFrame f) {
		this.allTeamDataAnalysisFrame = f;
		this.allTeamRecentMatchAnalysisPanel = this;
		setLayout(null);
		setBounds(AllTeamDataAnalysisPanel.PADDING,
				2 * AllTeamDataAnalysisPanel.PADDING + AllTeamDataAnalysisPanel.SELECT_PANEL_HEIGHT + AllTeamDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * AllTeamDataAnalysisPanel.PADDING,
				AllTeamDataAnalysisPanel.PANEL_HEIGHT);
	}
}

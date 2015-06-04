package com.kmno4.presentation2;

import javax.swing.JPanel;

import com.kmno4.common.Config;
/**
 * 全球队的攻防数据分析界面
 * 用柱状图分列所有球队的攻防数据
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamOffenAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
	private AllTeamOffenAnalysisPanel allTeamOffenAnalysisPanel;
	
	
	public AllTeamOffenAnalysisPanel(AllTeamDataAnalysisFrame f) {
		this.allTeamDataAnalysisFrame = f;
		this.allTeamOffenAnalysisPanel = this;
		setLayout(null);
		setBounds(AllTeamDataAnalysisPanel.PADDING,
				2 * AllTeamDataAnalysisPanel.PADDING + AllTeamDataAnalysisPanel.SELECT_PANEL_HEIGHT + AllTeamDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * AllTeamDataAnalysisPanel.PADDING,
				AllTeamDataAnalysisPanel.PANEL_HEIGHT);
	}

	
	private void createChart() {
		
	}
	
	
}

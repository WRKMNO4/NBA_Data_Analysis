package com.kmno4.presentation2;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.kmno4.common.Config;

import PO.TeamPO;
/**
 * 球员展示分析，
 * 并按照条件进行排名
 * 着重展示第一名，并有柱状图的对比
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
	//柱状图 显示数据值
	
	public TeamPlayerAnalysisPanel(TeamPO teamPO, TeamDataAnalysisFrame f) {
		this.teamPO = teamPO;
		this.teamDataAnalysisFrame = f;
		this.teamPlayerAnalysisPanel = this;
		setLayout(null);
		setBounds(TeamDataAnalysisPanel.PADDING,
				2 * TeamDataAnalysisPanel.PADDING + TeamDataAnalysisPanel.SELECT_PART_HEIGHT + TeamDataAnalysisPanel.TEAM_LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * TeamDataAnalysisPanel.PADDING,
				TeamDataAnalysisPanel.PANEL_HEIGHT);
		
		conditions = new JComboBox<String>();
		add(conditions);
		
		setPanel();
	}
	
	
	/**
	 * 初始化以及combobox的响应事件
	 */
	private void setPanel() {
		if(mainPlayerPanel != null) remove(mainPlayerPanel);
		if(otherPlayerPanel != null) remove(otherPlayerPanel);
 	}
	
	/**
	 * 排名第一球员展示Panel
	 * @author hutao
	 *
	 */
	class MainPlayerPanel extends JPanel {}
	/**
	 * 剩余球员列表展示Panel
	 * @author hutao
	 *
	 */
	class OtherPlayerPanel extends JPanel {}
}

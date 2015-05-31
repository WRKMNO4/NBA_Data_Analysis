package com.kmno4.presentation2;

import javax.swing.JPanel;
/**
 * 
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamDataAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
	
	private AllTeamRankingAnalysisPanel allTeamRankingAnalysisPanel;
	private AllTeamOffenAnalysisPanel allTeamOffenAnalysisPanel;
	private AllTeamRecentMatchAnalysisPanel allTeamRecentMatchAnalysisPanel;
	
	public AllTeamDataAnalysisPanel(AllTeamDataAnalysisFrame f) {
		allTeamDataAnalysisFrame = f;
	}

	
	
	/**
	 * 切换为联盟排名一览
	 */
	private void toRanking() {}
	/**
	 * 切换为最近10场分析
	 */
	private void toRecentMatchAna() {}
	/**
	 * 切换为攻防数据分析
	 */
	private void toOffenAna() {}
}

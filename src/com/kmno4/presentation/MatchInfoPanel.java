package com.kmno4.presentation;

import javax.swing.JPanel;

import com.kmno4.common.Config;
import javax.swing.JLabel;

public class MatchInfoPanel extends JPanel {

	public JLabel label_teamA_icon = new JLabel("TeamA_icon");
	public JLabel label_teamB_icon = new JLabel("TeamB_icon");
	public JLabel label_TeamA_name = new JLabel("TeamA_name");
	public JLabel lblVs = new JLabel("VS");
	public JLabel label_teamB_name = new JLabel("TeamB_name");
	public JLabel lblTime = new JLabel("TIME");
	public JLabel time = new JLabel("12.23");
	public JLabel label_place = new JLabel("PLACE");
	public JLabel place = new JLabel("America");

	/**
	 * Create the panel.
	 */
	public MatchInfoPanel() {
		
		this.setBounds(0, Config.TOP_TAB_HEIGHT+Config.PAGE_INTRO_HEIGHT,Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		this.setLayout(null);
		
		label_teamA_icon.setBounds(5, 5, Config.MATCH_INFO_TEAM_ICON_WIDTH, Config.MATCH_INFO_TEAM_ICON_HEIGHT);
		add(label_teamA_icon);
		
		label_teamB_icon.setBounds(147, 6, Config.MATCH_INFO_TEAM_ICON_WIDTH, Config.MATCH_INFO_TEAM_ICON_HEIGHT);
		add(label_teamB_icon);
		
		label_TeamA_name.setBounds(6, 98, Config.MATCH_INFO_TEAM_NAME_WIDTH,Config.MATCH_INFO_TEAM_NAME_HEIGHT);
		add(label_TeamA_name);
		
		lblVs.setBounds(105, 98, Config.MATCH_INFO_VS_WIDTH,Config.MATCH_INFO_VS_HEIGHT);
		add(lblVs);
		
		label_teamB_name.setBounds(148, 98, Config.MATCH_INFO_TEAM_NAME_WIDTH,Config.MATCH_INFO_TEAM_NAME_HEIGHT);
		add(label_teamB_name);
		
		lblTime.setBounds(267, 29,Config.MATCH_INFO_TIME_PLACE_WIDTH,Config.MATCH_INFO_TIME_PLACE_HEIGHT);
		add(lblTime);
		
		time.setBounds(360, 29,Config.MATCH_INFO_TIME_PLACE_WIDTH,Config.MATCH_INFO_TIME_PLACE_HEIGHT);
		add(time);
		
		label_place.setBounds(554, 29, Config.MATCH_INFO_TIME_PLACE_WIDTH,Config.MATCH_INFO_TIME_PLACE_HEIGHT);
		add(label_place);
		
		place.setBounds(659, 29,Config.MATCH_INFO_TIME_PLACE_WIDTH,Config.MATCH_INFO_TIME_PLACE_HEIGHT);
		add(place);
	}

}

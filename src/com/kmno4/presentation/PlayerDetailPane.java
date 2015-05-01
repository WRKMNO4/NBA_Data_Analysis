package com.kmno4.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.TableGroup;

import PO.PlayerPO;

@SuppressWarnings("serial")
public class PlayerDetailPane extends JPanel {
	private PlayerDetailPane playerDetailPanel;
	private PlayerDetailFrame playerDetailFrame;
	private DataPanel dataPanel;
	private TableGroup seasonData, recentData;
	private JLabel seasonLabel, recentLabel;
	private PlayerPO playerPO;
	
	private static final int PADDING = 5;
	private static final int 
	    DATA_PANEL_HEIGHT = 200,
	    SEASON_DATA_TABLE_HEIGHT = 200,
	    RECENT_DATA_TABLE_HEIGHT = 230,
	    SEASON_LABEL_HEIGHT = 50,
	    RECENT_LABEL_HEIGHT = 50;
	
	public PlayerDetailPane(PlayerPO p, PlayerDetailFrame f) {
		playerPO = p;
		playerDetailFrame = f;
		playerDetailPanel = this;
		
		dataPanel = new DataPanel(playerPO);
		dataPanel.setBounds(PADDING, PADDING, Config.UI_WIDTH - PADDING * 2, DATA_PANEL_HEIGHT);
		
		seasonLabel = new JLabel();
		seasonLabel.setBounds(
				PADDING, dataPanel.getY() + dataPanel.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, SEASON_LABEL_HEIGHT);
		
		seasonData = new TableGroup();
		
		recentLabel= new JLabel();
		recentLabel.setBounds(
				PADDING, seasonData.jsp.getY() + seasonData.jsp.getHeight() + PADDING,
				Config.UI_WIDTH - PADDING * 2, RECENT_LABEL_HEIGHT);
		
		recentData = new TableGroup();
		
	}

	class DataPanel extends JPanel {
		public DataPanel(PlayerPO p) {
			
		}
	}
}

package com.kmno4.presentation;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.SmallTable;

import PO.MatchPO;
import PO.PlayerPO;
import PO.TeamPO;

@SuppressWarnings("serial")
public class LastestGamePanel extends JPanel {
	
	private TeamPO teamPO;
	private PlayerPO playerPO;
	private ArrayList<MatchPO> matches;
	
	private SmallTable table;
	
	public LastestGamePanel(TeamPO t, LastestGameFrame frame) {
		teamPO = t;
		ini(t);
		iniFrameSize(frame);
	}
	public LastestGamePanel(PlayerPO p, LastestGameFrame frame) {
		playerPO = p;
		ini(p);
		iniFrameSize(frame);
	}
	
	private void iniFrameSize(LastestGameFrame frame) {
		frame.setSize(Config.LASTEST_GAME_FRAME_WIDTH, Config.LASTEST_GAME_FRAME_UNIT_HEIGHT * matches.size());
	}
	
	private void ini(Object o) {
		if(o instanceof TeamPO) {
			matches = MainFrame.mainFrame.bl.getLatest5MatchesForTeam((TeamPO) o);
		}
		else if(o instanceof PlayerPO) {
			matches = MainFrame.mainFrame.bl.getLatest5MatchesForPlayer((PlayerPO) o);
		}
		else return;
		String[] head = new String[]{"日期", "队伍", "", "比分", "", "", "", "", ""};
		String[][] body = new String[matches.size()][9];
		
		
		table = new SmallTable(
				    new String[]{"11", "11", "11", "11"},
				    new String[][] {
				    		{"11", "11", "11", "11"},
				    		{"11", "11", "11", "11"},
				    		{"11", "11", "11", "11"},
				    		{"11", "11", "11", "11"}});
		table.head.setVisible(false);
		table.remove(table.head);
		table.setLayout(new GridLayout(table.getRowNum(), 1));
		
		addLink();
	}
	
	private void addLink() {
		for(int i = 0; i < table.getRowNum(); i ++) {
			table.body[0][i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//TODO
				}
			});
		}
	}
}

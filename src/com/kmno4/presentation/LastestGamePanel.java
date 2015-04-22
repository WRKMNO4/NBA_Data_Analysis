package com.kmno4.presentation;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.SmallTable;
import com.kmno4.presentation.table.TableList;

import Enum.Season;
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
		ini(teamPO);
		iniFrameSize(frame);
	}
	public LastestGamePanel(PlayerPO p, LastestGameFrame frame) {
		playerPO = p;
		ini(playerPO);
		iniFrameSize(frame);
	}
	
	private void iniFrameSize(LastestGameFrame frame) {
		frame.setSize(Config.LASTEST_GAME_FRAME_WIDTH, Config.LASTEST_GAME_FRAME_UNIT_HEIGHT * matches.size());
		setSize(frame.getWidth(), frame.getHeight());
	}
	
	private void ini(Object o) {
		setLayout(new FlowLayout());
		if(o instanceof TeamPO) {
			matches = MainFrame.mainFrame.bl.getLatest5MatchesForTeam((TeamPO) o);
		}
		else if(o instanceof PlayerPO) {
			matches = MainFrame.mainFrame.bl.getLatest5MatchesForPlayer((PlayerPO) o);
		}
		else return;
		String[] head = new String[]{"赛季","日期", "队伍", "", "比分", ""};
		String[][] body = new String[matches.size()][6];
		for(int i = 0; i < matches.size(); i ++) {
			MatchPO m = matches.get(i);
			body[i][0] = m.getSeason().toString();
			body[i][1] = m.getDate();
			body[i][2] = m.getFirstTeam();
			body[i][3] = m.getSecondTeam();
			body[i][4] = Integer.toString(m.getFinalScore().getFirstScore());
			body[i][5] = Integer.toString(m.getFinalScore().getSecondScore());
		}
		
		table = new SmallTable(head, body);
		table.setFont(new Font("default", Font.PLAIN, 15), new Font("default", Font.PLAIN, 15));
		//table.head.setVisible(false);
		//table.remove(table.head);
		//table.setLayout(new GridLayout(table.getRowNum(), 1));
		addLink();
		add(table);
		
	}
	
	private void addLink() {
		for(int i = 0; i < table.getRowNum(); i ++) {
			final int j = i;
			table.body[0][j].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					TableList t = table.body[0][j];			
					Season s = Season.season12_13;
					switch(t.elements[0].getText()) {
					case "season12_13" : s = Season.season12_13; break;
					case "season13_14" : s = Season.season13_14; break;
					case "season14_15" : s = Season.season14_15; break;
					default:
					}
					
					MatchInfoDetailFrame m = new MatchInfoDetailFrame(
							MainFrame.mainFrame.bl.findMatch(
									s,
									t.elements[1].getText(),
									t.elements[2].getText() + "-" + t.elements[3].getText()));
					
				}
			});
		}
	}
}

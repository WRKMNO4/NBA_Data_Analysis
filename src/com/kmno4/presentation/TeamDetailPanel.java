package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.Table;

@SuppressWarnings("serial")
public class TeamDetailPanel extends JPanel {
	private TeamDetailPanel teamDetailPanel = this;
	private JLabel
	    team_icon,
	    team_name,
	    team_coach,
	    team_achi,
	    avg,
	    sum;
	private Table
	    mainInfo,
	    sumInfo,
	    avgInfo;
	private GridBagLayout layout;
	private GridBagConstraints c;
	
	private TeamPO teamPO;
	public TeamDetailPanel(TeamPO t) {
		teamPO = t;
		setBounds(0, 0,
				Config.PLAYER_DETAIL_UI_WIDTH,Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setBackground(new Color(255, 255, 255, 50));
		layout = new GridBagLayout();
		setLayout(layout);
		c = new GridBagConstraints();
		
		team_icon = new JLabel("队伍头像", JLabel.CENTER);
		team_icon.setFont(new Font("default", Font.PLAIN, 40));
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 3;
		c.weightx = 4;
		c.weighty = 4;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team_icon, c);
		add(team_icon);
		
		team_name = new JLabel("高锰酸钾队", JLabel.LEFT);
		team_name.setFont(new Font("default", Font.BOLD, 35));
		team_name.setForeground(new Color(0, 0, 0, 100));
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 3;
		c.weighty = 2;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team_name, c);
		add(team_name);
		
		team_coach = new JLabel("PA:姚锰舟", JLabel.LEFT);
		team_coach.setFont(new Font("default", Font.ITALIC, 18));
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 3;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team_coach, c);
		add(team_coach);
		
		team_achi = new JLabel("10胜|20负", JLabel.CENTER);
		team_achi.setFont(new Font("default", Font.BOLD, 25));
		team_achi.setForeground(Color.black);
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 3;
		c.weighty = 2;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team_achi, c);
		add(team_achi);
		
		sum = new JLabel("总计", JLabel.CENTER);
		sum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!sum.isEnabled()) return;
				sum.setEnabled(false);
				avg.setEnabled(true);
				sumInfo.setVisible(true);
				avgInfo.setVisible(false);
				layout.setConstraints(sumInfo, c);
				teamDetailPanel.remove(avgInfo);
				teamDetailPanel.add(sumInfo);
				teamDetailPanel.repaint();
			}
		});
		sum.setFont(new Font("default", Font.BOLD, 15));
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(sum, c);
		add(sum);
		sum.setEnabled(false);
		
		avg = new JLabel("平均", JLabel.CENTER);
		avg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!avg.isEnabled()) return;
				avg.setEnabled(false);
				sum.setEnabled(true);
				avgInfo.setVisible(true);
				sumInfo.setVisible(false);
				layout.setConstraints(avgInfo, c);
				teamDetailPanel.remove(sumInfo);
				teamDetailPanel.add(avgInfo);
				teamDetailPanel.repaint();
			}
		});
		avg.setFont(new Font("default", Font.BOLD, 15));
		c.gridx = 5;
		layout.setConstraints(avg, c);
		add(avg);
		
		mainInfo = new Table(
				new String[]{"场均得分", "场均助攻", "场均篮板", "对手得分"},
				new String[][]{{"1th", "1th", "1th", "1th"}},
				true);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 6;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(mainInfo, c);
		add(mainInfo);
		
		sumInfo = new Table(
				new String[]{"l", "l", "l", "l", "l", "l", "l"},
				new String[][]{
						{"l", "l", "l", "l", "l", "l", "l"},
						{"l", "l", "l", "l", "l", "l", "l"}},
				true);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 6;
		c.gridheight = 1;
		c.weightx = 12;
		c.weighty = 3;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(sumInfo, c);
		add(sumInfo);
		
		avgInfo = new Table(
				new String[]{"b", "b", "b", "b", "b", "b", "b"},
				new String[][]{
						{"b", "b", "b", "b", "b", "b", "b"},
						{"b", "b", "b", "b", "b", "b", "b"}},
				true);
		layout.setConstraints(avgInfo, c);
		//add(avgInfo);
		
	}
	
	
	
	
	
}

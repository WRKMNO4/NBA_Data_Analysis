package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;

import PO.TeamListPO;
import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.PlayerDetailPanel;
import com.kmno4.presentation.TableContentTransfer;
import com.kmno4.presentation.TeamDetailFrame;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;
/**
 * 全球队信息的最近10场比赛数据分析界面
 * 与联盟排名一览界面结构大体相同
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamRecentMatchAnalysisPanel extends JPanel {
	private AllTeamDataAnalysisFrame allTeamDataAnalysisFrame;
//	private AllTeamRecentMatchAnalysisPanel allTeamRecentMatchAnalysisPanel;
	private static final int 
		LABEL_HEIGHT = 40,
		TABLE_HEIGHT = (AllTeamDataAnalysisPanel.PANEL_HEIGHT - 2 * LABEL_HEIGHT) / 2;
	private JLabel eastLabel, westLabel;
	private TableGroup eastTg, westTg;

	public AllTeamRecentMatchAnalysisPanel(AllTeamDataAnalysisFrame f) {
		this.allTeamDataAnalysisFrame = f;
//		this.allTeamRecentMatchAnalysisPanel = this;
		setLayout(null);
		setOpaque(false);
		setBounds(AllTeamDataAnalysisPanel.PADDING,
				2 * AllTeamDataAnalysisPanel.PADDING + AllTeamDataAnalysisPanel.SELECT_PANEL_HEIGHT + AllTeamDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * AllTeamDataAnalysisPanel.PADDING,
				AllTeamDataAnalysisPanel.PANEL_HEIGHT);
		
		eastLabel = new JLabel("东部联盟");
		eastLabel.setBounds(0, 0, getWidth(), LABEL_HEIGHT);
		eastLabel.setOpaque(true);
		eastLabel.setBackground(new Color(128, 128, 128, 150));
		eastLabel.setForeground(Color.white);
		eastLabel.setFont(new Font("default", 0, 15));
		add(eastLabel);
		eastTg = new TableGroup();
		TableFactory.createTable(eastTg, this,
				TableContentTransfer.transferAnalysisOfLatest10Matches(TeamListPO.getAllEastTeams()),
				getWidth(), TABLE_HEIGHT,
				0, LABEL_HEIGHT, 0, 0, 96);
		TableColumnModel tm = eastTg.table.getColumnModel();
		for(int i = 5; i <= 7; i ++) tm.getColumn(i).setMinWidth(123);
		eastTg.jsp.setHorizontalScrollBar(null);
		PlayerDetailPanel.paintTable(eastTg.table);

		westLabel = new JLabel("西部联盟");
		westLabel.setBounds(0, LABEL_HEIGHT + TABLE_HEIGHT, getWidth(), LABEL_HEIGHT);
		westLabel.setOpaque(true);
		westLabel.setBackground(new Color(128, 128, 128, 150));
		westLabel.setForeground(Color.white);
		westLabel.setFont(new Font("default", 0, 15));
		add(westLabel);
		westTg = new TableGroup();
		TableFactory.createTable(westTg, this, 
				TableContentTransfer.transferAnalysisOfLatest10Matches(TeamListPO.getAllWestTeams()),
				getWidth(), TABLE_HEIGHT,
				0, LABEL_HEIGHT * 2 + TABLE_HEIGHT, 0, 0, 96);
		tm = westTg.table.getColumnModel();
		for(int i = 5; i <= 7; i ++) tm.getColumn(i).setMinWidth(123);
		westTg.jsp.setHorizontalScrollBar(null);
		PlayerDetailPanel.paintTable(westTg.table);
		
		addLinks();
	}
	
	private void addLinks() {
		addLink(westTg);
		addLink(eastTg);
	}
	private TableGroup tg;
	private void addLink(TableGroup t) {
		tg = t;
		tg.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int 
				    row = tg.table.rowAtPoint(e.getPoint()),
					col = tg.table.columnAtPoint(e.getPoint());
				if(row == 0 || col != 0) return;
				String name = tg.table.getValueAt(row, col).toString();
				TeamPO t = TeamListPO.findTeamByShortName(name);
				new TeamDetailFrame(t, allTeamDataAnalysisFrame.getLocation());
			}
		});
	}
}

package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.kmno4.common.Config;
import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.PlayerDetailPanel;
import com.kmno4.presentation.TableContentTransfer;
import com.kmno4.presentation.table.OtherSet;
import com.kmno4.presentation.table.SortModel;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;

import PO.PlayerPO;
import PO.TeamListPO;
/**
 * 球员综合能力分析
 * 显示全球员的大表数据
 * 并且能直观显示单球员的数据，并且显示在某排序下的排名
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerPerformAnalysisPanel extends JPanel {
	private PlayerPerformAnalysisPanel playerPerformAnalysisPanel;
//	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO;
	public static final int 
    	PADDING = PlayerDataAnalysisPanel.PADDING,
    	PANEL_HEIGHT = 60,
    	TABLE_HEGIHT = PlayerDataAnalysisPanel.PANEL_HEIGHT - PANEL_HEIGHT - PADDING;
	
	
	private TableGroup tg;
	private PlayerFieldPanel pfp;
	
	public PlayerPerformAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
//		this.playerDataAnalysisFrame = f;
		this.playerPerformAnalysisPanel = this;
		this.playerPO = playerPO;
		setBounds(
				PADDING,
				PADDING * 2 + PlayerDataAnalysisPanel.SELECT_PANEL_HEIGHT + PlayerDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING,
				PlayerDataAnalysisPanel.PANEL_HEIGHT);
		setLayout(null);
		setOpaque(false);
		String[][] info = TableContentTransfer.transferPlayerHighInfo(MainFrame.mainFrame.bl.getPlayerHighInfo());
		pfp = new PlayerFieldPanel(info);
		add(pfp);
		
		tg = new TableGroup();
		TableFactory.createSortTable(tg, this,
				info,
				new SortModel(2, 7), new PlayerPerformSet(),
				getWidth(), TABLE_HEGIHT,
				0, PADDING + PANEL_HEIGHT,
				0, 0, 120);
		PlayerDetailPanel.paintTable(tg.table);
//		tg.table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				System.out.println(tg.jsp.getVerticalScrollBar().getValue());
//			}
//		});
	}
	class PlayerPerformSet implements OtherSet {
		JTable table;
		JScrollPane jsp;
		public void reset() {
			table.setRowHeight(0, TableFactory.DEFAULT_TABLE_HEAD_ROW_HEIGHT);
			table.getColumnModel().getColumn(0).setPreferredWidth(150);
			table.getColumnModel().getColumn(1).setMaxWidth(105);
			table.getColumnModel().getColumn(2).setMaxWidth(85);
			if(jsp.getHorizontalScrollBar() != null) jsp.setHorizontalScrollBar(null);
		}
		public void setTableGroup(TableGroup tg) { 
			table = tg.table;
			jsp = tg.jsp;
		}
	}
	
	class PlayerFieldPanel extends JPanel {
		JLabel player, team, info1, info2, info3, info4, info5, info6;
		public PlayerFieldPanel(String[][] info) {
			setLayout(null);
			setBounds(0, 0, playerPerformAnalysisPanel.getWidth(), PANEL_HEIGHT);
			setBackground(new Color(0, 255, 255, 40));
			String[] pInfo = null;
			String pName = playerPO.getName();
			for(int i = 0; i < info.length; i ++) {
				if(info[i][0].equals(pName)) {
					pInfo = info[i];
					break;
				}
			}
			Color color = Color.white;
			Font font = new Font("default", 0, 25);
			String url = playerPO.getPortraitURL();
			player = new JLabel();
			player.setBounds(0, 0, 150, PANEL_HEIGHT);
			PlayerDetailPanel.fillLabel(url, player, PANEL_HEIGHT * 230 / 185, PANEL_HEIGHT);
			
			url = TeamListPO.findTeamByShortName(playerPO.getTeam(Config.LASTEST_SEASON)).getTeamLogoURL();
			team = new JLabel();
			team.setBounds(player.getWidth() + player.getX(), 0, 120, PANEL_HEIGHT);
			PlayerDetailPanel.fillLabel(url, team, PANEL_HEIGHT, PANEL_HEIGHT);
			
			info1 = new JLabel(pInfo[2]);
			info1.setBounds(team.getWidth() + team.getX(), 0, 85, PANEL_HEIGHT);
			info1.setForeground(color);
			info1.setFont(font);
			
			info2 = new JLabel(pInfo[3]);
			info2.setBounds(info1.getWidth() + info1.getX(), 0, 120, PANEL_HEIGHT);
			info2.setForeground(color);
			info2.setFont(font);
			
			info3 = new JLabel(pInfo[4]);
			info3.setBounds(info2.getWidth() + info2.getX(), 0, 120, PANEL_HEIGHT);
			info3.setForeground(color);
			info3.setFont(font);
			
			info4 = new JLabel(pInfo[5]);
			info4.setBounds(info3.getWidth() + info3.getX(), 0, 120, PANEL_HEIGHT);
			info4.setForeground(color);
			info4.setFont(font);
			
			info5 = new JLabel(pInfo[6]);
			info5.setBounds(info4.getWidth() + info4.getX(), 0, 120, PANEL_HEIGHT);
			info5.setForeground(color);
			info5.setFont(font);
			
			info6 = new JLabel(pInfo[7]);
			info6.setBounds(info5.getWidth() + info5.getX(), 0, 120, PANEL_HEIGHT);
			info6.setForeground(color);
			info6.setFont(font);
			
			add(player);
			add(team);
			add(info1);
			add(info2);
			add(info3);
			add(info4);
			add(info5);
			add(info6);
			
			
		}
	}
}

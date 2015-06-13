package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import com.kmno4.common.Config;
import com.kmno4.presentation.PlayerDetailFrame;
import com.kmno4.presentation.PlayerDetailPanel;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;

import Enum.PlayerData;
import PO.PlayerPO;
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
//	private TeamPlayerAnalysisPanel teamPlayerAnalysisPanel;
	private TeamDataAnalysisFrame teamDataAnalysisFrame;
	private TeamPO teamPO;
	public static final int 
	    PADDING = TeamDataAnalysisPanel.PADDING,
	    COMBOBOX_HEIGHT = 30,
	    COMBOBOX_WIDHT = 150,
	    MAIN_PLAYER_PANEL_WIDTH = 550,
	    MAIN_PLAYER_PANEL_HEIGHT = 320,
	    OTHER_PLAYER_PANEL_WIDTH = Config.UI_WIDTH - 3 * PADDING - MAIN_PLAYER_PANEL_WIDTH,
	    OTHER_PLAYER_PANEL_HEIGHT = MAIN_PLAYER_PANEL_HEIGHT + COMBOBOX_HEIGHT + PADDING,
	    CHART_WIDTH = Config.UI_WIDTH - 2 * PADDING,
	    CHART_HEIGHT = TeamDataAnalysisPanel.PANEL_HEIGHT - 2 * PADDING - OTHER_PLAYER_PANEL_HEIGHT;
	    
	private JComboBox<String> conditions;
	private MainPlayerPanel mainPlayerPanel;
	private OtherPlayerPanel otherPlayerPanel;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	
	private Object[][] data; 
	public TeamPlayerAnalysisPanel(TeamPO teamPO, TeamDataAnalysisFrame f) {
		this.teamPO = teamPO;
		this.teamDataAnalysisFrame = f;
//		this.teamPlayerAnalysisPanel = this;
		setLayout(null);
		setOpaque(false);
		setBounds(TeamDataAnalysisPanel.PADDING,
				2 * TeamDataAnalysisPanel.PADDING + TeamDataAnalysisPanel.SELECT_PART_HEIGHT + TeamDataAnalysisPanel.TEAM_LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * TeamDataAnalysisPanel.PADDING,
				TeamDataAnalysisPanel.PANEL_HEIGHT);
		
		conditions = new JComboBox<String>(Config.TEAM_LEADERS);
		conditions.setBounds(0, 0, COMBOBOX_WIDHT, COMBOBOX_HEIGHT);
		conditions.setFont(new Font("default", 0, 15)); 
		conditions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				act();
			}
		});
		add(conditions);
		act();
		
	}
	
	private void act() {
		PlayerData p;
		switch(conditions.getSelectedIndex()) {
		case 0 : p = PlayerData.score; break;
		case 1 : p = PlayerData.numberOfRebound; break;
		case 2 : p = PlayerData.numberOfAssist; break;
		case 3 : p = PlayerData.numberOfSteal; break;
		case 4 : p = PlayerData.numberOfBlock; break;
		case 5 : p = PlayerData.percentageOfShooting; break;
		case 6 : p = PlayerData.percentageOf3_Point; break;
		default : p = PlayerData.score;
		}
		data = teamPO.getTeamLeaders(Config.LASTEST_SEASON, p);
		setPanel();
		createChart();
	}
	
	/**
	 * 初始化以及combobox的响应事件
	 */
	private void setPanel() {
		if(mainPlayerPanel != null) {
			mainPlayerPanel.setVisible(false);
			remove(mainPlayerPanel);
		}
		if(otherPlayerPanel != null) {
			otherPlayerPanel.setVisible(false);
			remove(otherPlayerPanel);
		}
		mainPlayerPanel = new MainPlayerPanel();
		add(mainPlayerPanel);
		otherPlayerPanel = new OtherPlayerPanel();
		add(otherPlayerPanel);
 	}
	/**
	 * 初始化以及响应combobox改变图表
	 */
	private void createChart() {
		if(chartPanel != null) {
			chartPanel.setVisible(false);
			remove(chartPanel);
		}
		double[][] d = new double[1][data[0].length];
		String[] n = new String[data[0].length];
		for(int i = 0; i < n.length; i ++) {
			d[0][i] = (double)data[1][i];
			n[i] = (i + 1) + ""; 
		}
		CategoryDataset data = DatasetUtilities.createCategoryDataset(new String[]{""}, n, d);
		chart = ChartFactory.createBarChart("", "", "", data);
		chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(0, OTHER_PLAYER_PANEL_HEIGHT + PADDING, getWidth(), CHART_HEIGHT);
		add(chartPanel);
	}
	
	/**
	 * 排名第一球员展示Panel
	 * @author hutao
	 *
	 */
	class MainPlayerPanel extends JPanel {
		JLabel pic;
		JLabel info1, info2, info3, info4;
		public MainPlayerPanel() {
			setBounds(0, COMBOBOX_HEIGHT + PADDING, MAIN_PLAYER_PANEL_WIDTH, MAIN_PLAYER_PANEL_HEIGHT);
			setLayout(null);
			setBackground(new Color(0, 255, 255, 80));
			PlayerPO playerPO = (PlayerPO)data[0][0];
			
			pic = new JLabel();
			pic.setBounds(0, 0, MAIN_PLAYER_PANEL_HEIGHT * 440 / 700, MAIN_PLAYER_PANEL_HEIGHT);
			PlayerDetailPanel.fillLabel(playerPO.getActionURL(), pic, pic.getWidth(), pic.getHeight());
			add(pic);
			
			info1 = new JLabel(playerPO.getName());
			info1.setBounds(300, 120, 400, 40);
			PUtil.setFontandColor(info1, 25, Color.black);
			
			info2 = new JLabel(playerPO.getNumber());
			info2.setBounds(240, 100, 60, 60);
			PUtil.setFontandColor(info2, 50, Color.red);
			
			info3 = new JLabel("Team Leader");
			info3.setBounds(240, 20, 400, 60);
			PUtil.setFontandColor(info3, new Font("default", 2, 35), Color.black);
			
			info4 = new JLabel(conditions.getSelectedItem().toString() + " : " + String.format("%.2f", data[1][0]));
			info4.setBounds(240, 250, 300, 40);
			PUtil.setFontandColor(info4, 20, Color.black);
			add(info1);
			add(info2);
			add(info3);
			add(info4);
			
			addLink();
		}
		
		private void addLink() {
			MouseAdapter m = new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					new PlayerDetailFrame((PlayerPO)data[0][0], teamDataAnalysisFrame.getLocation());
				}
			};
			info1.addMouseListener(m);
			pic.addMouseListener(m);
		}
	}
	/**
	 * 剩余球员列表展示Panel
	 * @author hutao
	 *
	 */
	class OtherPlayerPanel extends JPanel {
		TableGroup tg;
		public OtherPlayerPanel() {
			setBounds(MAIN_PLAYER_PANEL_WIDTH + PADDING, 0, OTHER_PLAYER_PANEL_WIDTH, OTHER_PLAYER_PANEL_HEIGHT);
			setLayout(null);
			setOpaque(false);
			
			String[][] body = new String[data[0].length][4];
			body[0] = new String[]{"排名", "名字", "球号",  conditions.getSelectedItem().toString()};
			for(int i = 1; i < body.length; i ++) {
				PlayerPO p = (PlayerPO) data[0][i];
				body[i][0] = (i + 1) + "";
				body[i][1] = p.getName();
				body[i][2] = p.getNumber();
				body[i][3] = String.format("%.2f", data[1][i]);
			}
			tg = new TableGroup();
			TableFactory.createTable(tg, this, body,
					OTHER_PLAYER_PANEL_WIDTH, OTHER_PLAYER_PANEL_HEIGHT,
					0, 0,
					0, 0, 0);
			PlayerDetailPanel.paintTable(tg.table);
			tg.jsp.setHorizontalScrollBar(null);
			TableColumnModel t = tg.table.getColumnModel();
			t.getColumn(0).setPreferredWidth(50);
			t.getColumn(1).setPreferredWidth(200);
			t.getColumn(2).setPreferredWidth(70);
			t.getColumn(3).setPreferredWidth(100);
			addLinks();
		}
		
		private void addLinks() {
			tg.table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int row = tg.table.rowAtPoint(e.getPoint()),
						col = tg.table.columnAtPoint(e.getPoint());
					if(row == 0 || col != 1) return;
					new PlayerDetailFrame((PlayerPO)data[0][row], teamDataAnalysisFrame.getLocation());
				}
			});
		}
	}
}

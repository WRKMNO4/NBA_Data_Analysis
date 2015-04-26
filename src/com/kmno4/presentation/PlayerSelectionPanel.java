package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BusinessLogic.SortHelper.TransferSortHelper;
import Enum.PlayerData;
import Enum.Season;
import Enum.Zone;
import PO.PlayerPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.LMouseAdapter;

@SuppressWarnings("serial")
public class PlayerSelectionPanel extends JPanel implements MouseListener,
		ActionListener {
	public List<JLabel> avg_sort_list;
	private TextField tf_search;
	boolean isPickup = true;
	boolean isAvg = true;
	// 方位
	public int location_x;
	public int location_y;

	JLabel title = new JLabel("球员");
	JLabel lb_search = new JLabel("搜索");

	JLabel lb_percent = new JLabel("标准");
	JLabel lb_efficiency = new JLabel("类型");
	JLabel lb_location = new JLabel("位置");
	JLabel lb_place = new JLabel("分区");
	JLabel lb_season = new JLabel("赛季");
	JLabel lb_sort_season = new JLabel("赛季");

	JComboBox<String> 
	    cb_position, 
	    cb_district, 
	    cb_type,
	    cb_standard,
	    cb_season,
	    cb_sort_season,
	    cb_avg_sort_data,
	    cb_total_sort_data;
	
	private JButton submit = new JButton("提交");

	JLabel pickup = new JLabel("筛选");
	JLabel sort = new JLabel("排序");
	JLabel avg_sort = new JLabel("场均数据");
	JLabel total_sort = new JLabel("总数据");


	/**
	 * Create the panel.
	 */
	public PlayerSelectionPanel() {

		this.setBounds(0, Config.TOP_TAB_HEIGHT + Config.INTRODUCTION_WHITE,
				Config.UI_WIDTH, Config.SELECTION_HEIGHT);
		// this.setBackground(Color.GRAY);
		setLayout(null);
		
		cb_position = new JComboBox<String>(
				Config.PICKUP_POSITION);
		cb_district = new JComboBox<String>(
				Config.PICKUP_DISTRICT);
		cb_type = new JComboBox<String>(Config.PICKUP_TYPE);
		cb_standard = new JComboBox<String>(
				Config.PICKUP_STANDARD);
		cb_season = new JComboBox<String>(Config.Seasons);
		cb_sort_season = new JComboBox<String>(Config.Seasons);
		cb_avg_sort_data = new JComboBox<String>(
				Config.PLAYER_AVERAGE_INFO);
		cb_total_sort_data = new JComboBox<String>(
				Config.PLAYER_TOTAL_INFO);

		cb_position.setFont(new Font("default", Font.PLAIN, 13));
		cb_district.setFont(new Font("default", Font.PLAIN, 13));
		cb_type.setFont(new Font("default", Font.PLAIN, 13));
		cb_standard.setFont(new Font("default", Font.PLAIN, 13));
		cb_season.setFont(new Font("default", Font.PLAIN, 13));
		cb_sort_season.setFont(new Font("default", Font.PLAIN, 13));
		cb_avg_sort_data.setFont(new Font("default", Font.PLAIN, 13));
		cb_total_sort_data.setFont(new Font("default", Font.PLAIN, 13));
		
		
		// 第一行
		lb_search.setBounds(606, 11, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_search);

		tf_search = new TextField();
		// tf_search.setText("输入关键字");
		tf_search.setBounds(650, 11, Config.SELECTION_SEARCH_WIDTH,
				Config.SELECTION_SEARCH_HEIGHT);
		tf_search.setBackground(Color.GRAY);
		add(tf_search);

		title.setBounds(15, 11, 30, 30);
		title.setBackground(Color.WHITE);
		add(title);

		//
		pickup.setBounds(69, 18, 35, 16);
		add(pickup);

		sort.setBounds(119, 18, 35, 16);
		add(sort);
		
		initPickupBounds();
		initSortBounds();
		showPickup();
		setLabelColor();

		pickup.addMouseListener(this);
		cb_position.addMouseListener(this);
		cb_district.addMouseListener(this);
		cb_type.addMouseListener(this);
		cb_standard.addMouseListener(this);
		submit.addMouseListener(this);
		sort.addMouseListener(this);
		avg_sort.addMouseListener(this);
		total_sort.addMouseListener(this);
		cb_avg_sort_data.addMouseListener(this);
		cb_total_sort_data.addMouseListener(this);
		cb_avg_sort_data.addActionListener(this);
		cb_total_sort_data.addActionListener(this);
		cb_sort_season.addMouseListener(this);
		add(avg_sort);
		add(total_sort);
		add(cb_avg_sort_data);
		add(cb_total_sort_data);
		add(lb_sort_season);
		add(cb_sort_season);
		// 初始化默认不显示排序
		avg_sort.setVisible(false);
		total_sort.setVisible(false);
		cb_avg_sort_data.setVisible(false);
		cb_total_sort_data.setVisible(false);

	}

	// 画背景
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isPickup) {
			g.drawImage(Config.PLAYER_SELECTION_BACKGROUND.getImage(), 0, 0,
					Config.UI_WIDTH, Config.SELECTION_HEIGHT, this);
			repaint();
		} else {
			g.drawImage(Config.PLAYER_SELECTION_SORT_BACKGROUND.getImage(), 0,
					0, Config.UI_WIDTH, Config.SELECTION_HEIGHT, this);
			repaint();
		}

	}

	public void moveIn() {

	}

	public void moveOut() {

	}

	public void setLabelColor() {
		title.setForeground(Color.WHITE);
		lb_search.setForeground(Color.WHITE);
		lb_percent.setForeground(Color.WHITE);
		lb_efficiency.setForeground(Color.WHITE);
		lb_location.setForeground(Color.WHITE);
		lb_place.setForeground(Color.WHITE);
		lb_season.setForeground(Color.WHITE);
		lb_sort_season.setForeground(Color.WHITE);
		avg_sort.setForeground(Color.WHITE);
		total_sort.setForeground(Color.WHITE);

	}

	public void initPickupBounds() {
		lb_location.setBounds(13, Config.COBM_LOCATION_Y, Config.TEXT_WIDTH,
				Config.TEXT_height);
		add(lb_location);

		cb_district
				.setBounds(13 * Config.SORT_WIDTH
						- Config.SELECTION_COMB_TEAM_WIDTH,
						Config.COBM_LOCATION_Y, Config.SELECTION_SEARCH_WIDTH,
						Config.SELECTION_COMB_TEAM_WIDTH);
		cb_district.setBackground(Color.GRAY);
		add(cb_district);

		lb_percent.setBounds(15, 53, 35, 16);
		add(lb_percent);

		cb_type.setBounds(59, 49, Config.SELECTION_SEARCH_WIDTH,
				Config.SELECTION_COMB_CITY_WIDTH);
		cb_type.setBackground(Color.gray);
		add(cb_type);

		lb_efficiency.setForeground(Color.WHITE);
		lb_efficiency.setBounds(13 * Config.SORT_WIDTH
				- Config.SELECTION_COMB_TEAM_WIDTH - Config.COMB_TEXT_GAP, 53,
				35, 16);
		add(lb_efficiency);

		cb_standard
				.setBounds(13 * Config.SORT_WIDTH
						- Config.SELECTION_COMB_TEAM_WIDTH, 49,
						Config.SELECTION_SEARCH_WIDTH,
						Config.SELECTION_COMB_CITY_WIDTH);
		cb_standard.setBackground(Color.GRAY);
		add(cb_standard);

		lb_place.setBounds(13 * Config.SORT_WIDTH
				- Config.SELECTION_COMB_TEAM_WIDTH - Config.COMB_TEXT_GAP,
				Config.COBM_LOCATION_Y, Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_place);

		cb_position
				.setBounds(59, Config.COBM_LOCATION_Y,
						Config.SELECTION_SEARCH_WIDTH,
						Config.SELECTION_COMB_CITY_WIDTH);
		add(cb_position);

		lb_season.setBounds(21 * Config.SORT_WIDTH
				- Config.SELECTION_COMB_TEAM_WIDTH - Config.COMB_TEXT_GAP, 49,
				Config.TEXT_WIDTH, Config.TEXT_height);
		add(lb_season);
		cb_season
				.setBounds(21 * Config.SORT_WIDTH
						- Config.SELECTION_COMB_TEAM_WIDTH, 49,
						Config.SELECTION_SEARCH_WIDTH,
						Config.SELECTION_COMB_TEAM_WIDTH);
		add(cb_season);

		submit.setBounds(21 * Config.SORT_WIDTH
				- Config.SELECTION_COMB_TEAM_WIDTH, Config.COBM_LOCATION_Y,
				Config.SELECTION_SEARCH_WIDTH, Config.SELECTION_COMB_TEAM_WIDTH);
		add(submit);

	}

	public void initSortBounds() {

		avg_sort.setBounds(100, 45, Config.SORT_WIDTH * 2, Config.SORT_HEIGHT);
		total_sort
				.setBounds(100, 90, Config.SORT_WIDTH * 2, Config.SORT_HEIGHT);
		cb_avg_sort_data.setBounds(160, 77, Config.SELECTION_SEARCH_WIDTH,
				Config.SELECTION_COMB_TEAM_WIDTH);
		cb_total_sort_data.setBounds(160, 77, Config.SELECTION_SEARCH_WIDTH,
				Config.SELECTION_COMB_TEAM_WIDTH);
		lb_sort_season.setBounds(15 * Config.SORT_WIDTH
				- Config.SELECTION_COMB_TEAM_WIDTH - Config.COMB_TEXT_GAP, 77,
				Config.TEXT_WIDTH, Config.TEXT_height);
		cb_sort_season
				.setBounds(15 * Config.SORT_WIDTH
						- Config.SELECTION_COMB_TEAM_WIDTH, 77,
						Config.SELECTION_SEARCH_WIDTH,
						Config.SELECTION_COMB_TEAM_WIDTH);
	}

	public void showPickup() {
		lb_percent.setVisible(true);
		lb_efficiency.setVisible(true);
		lb_location.setVisible(true);
		lb_place.setVisible(true);
		cb_position.setVisible(true);
		cb_district.setVisible(true);
		cb_type.setVisible(true);
		cb_standard.setVisible(true);
		lb_season.setVisible(true);
		cb_season.setVisible(true);
		submit.setVisible(true);

		avg_sort.setVisible(false);
		total_sort.setVisible(false);
		cb_avg_sort_data.setVisible(false);
		cb_total_sort_data.setVisible(false);
		lb_sort_season.setVisible(false);
		cb_sort_season.setVisible(false);
	}

	public void showSortAvg() {
		lb_percent.setVisible(false);
		lb_efficiency.setVisible(false);
		lb_location.setVisible(false);
		lb_place.setVisible(false);
		cb_position.setVisible(false);
		cb_district.setVisible(false);
		cb_type.setVisible(false);
		cb_standard.setVisible(false);
		lb_season.setVisible(false);
		cb_season.setVisible(false);
		submit.setVisible(false);

		avg_sort.setVisible(true);
		total_sort.setVisible(true);
		cb_avg_sort_data.setVisible(true);
		cb_total_sort_data.setVisible(true);
		lb_sort_season.setVisible(true);
		cb_sort_season.setVisible(true);
	}

	public void showSortTotal() {
		cb_avg_sort_data.setVisible(false);
		cb_total_sort_data.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == pickup) {
			showPickup();
			isPickup = true;
		}
		if (e.getSource() == sort) {
			showSortAvg();
			isPickup = false;
		}

		if (e.getSource() == avg_sort) {
			showSortAvg();
			isAvg = true;
		}

		if (e.getSource() == total_sort) {
			showSortTotal();
			isAvg = false;
		}

		if (e.getSource() == submit) {
			if (isPickup) {
				String position = cb_position.getSelectedItem().toString();
				String district = cb_district.getSelectedItem().toString();
				String type = cb_type.getSelectedItem().toString();
				String standard = cb_standard.getSelectedItem().toString();
				Season season = TransferSortHelper.StringToSeason(cb_season
						.getSelectedItem().toString());
				PlayerData dataType = TransferSortHelper
						.StringToDataTypeForPlayer(type);
				Zone zone = null;
				if (position.equals("前锋"))
					position = "F";
				else if (position.equals("中锋"))
					position = "C";
				else
					position = "G";

				if (district.equals("东部")) {
					zone = Zone.E;
					district = null;
				} else if (district.equals("西部")) {
					zone = Zone.W;
					district = null;
				}
				if (standard.equals("场均")) {
					standard = "avg";
				}
				if (standard.equals("总计")) {
					standard = "total";
				}

				// position为英文，三种单字母
				ArrayList<PlayerPO> players = MainFrame.mainFrame.bl
						.pickUpPlayersByCondition(position, zone, district,
								standard, dataType, season);
				if (players != null) {
					MainFrame.mainFrame.topTabPanel.refreshPlayerTable(players);
				}
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		((JComponent)e.getSource()).setOpaque(true);
		((JComponent)e.getSource()).setBackground(LMouseAdapter.L);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((JComponent)e.getSource()).setOpaque(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 场均排序
		if (e.getSource() == cb_avg_sort_data
				|| e.getSource() == cb_sort_season) {
			String data = cb_avg_sort_data.getSelectedItem().toString();
			Season season = TransferSortHelper.StringToSeason(cb_sort_season
					.getSelectedItem().toString());
			PlayerData dataType = TransferSortHelper
					.StringToDataTypeForPlayer(data);
			ArrayList<PlayerPO> players = MainFrame.mainFrame.bl
					.sortPlayersByComprehension("avg", dataType, season);
			MainFrame.mainFrame.topTabPanel.refreshPlayerTable(players);
		}

		// 总排序
		if (e.getSource() == cb_total_sort_data
				|| e.getSource() == cb_sort_season) {
			String data = cb_total_sort_data.getSelectedItem().toString();
			Season season = TransferSortHelper.StringToSeason(cb_sort_season
					.getSelectedItem().toString());
			PlayerData dataType = TransferSortHelper
					.StringToDataTypeForPlayer(data);
			ArrayList<PlayerPO> players = MainFrame.mainFrame.bl
					.sortPlayersByComprehension("total", dataType, season);
			MainFrame.mainFrame.topTabPanel.refreshPlayerTable(players);
		}
	}
}

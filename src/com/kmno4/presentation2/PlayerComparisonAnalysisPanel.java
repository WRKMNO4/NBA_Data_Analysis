package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kmno4.common.Config;
import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.PlayerDetailPanel;
import com.kmno4.presentation.button.LMouseAdapter;

import Enum.PlayerData;
import PO.PlayerDataPO;
import PO.PlayerListPO;
import PO.PlayerPO;
import PO.TeamListPO;
import PO.TeamPO;
/**
 * 球员对比分析界面
 * 包含了一大堆功能
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerComparisonAnalysisPanel extends JPanel {
	private PlayerComparisonAnalysisPanel playerComparisonAnalysisPanel;
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO, anotherPlayerPO;
	public static final int 
    	PADDING = PlayerDataAnalysisPanel.PADDING,
        PLAYER_PANEL_WIDTH = 420,
        PLAYER_PANEL_HEIGHT = 500,
        OTHER_PANEL_WIDHT = PLAYER_PANEL_WIDTH,
        OTHER_PANEL_HEIGHT = PlayerDataAnalysisPanel.PANEL_HEIGHT - PADDING - PLAYER_PANEL_HEIGHT;
	private PlayerPanel player1, player2;
	private InfoPanel info;
	private InputPanel input;
	private JLabel v, s;
	
	public PlayerComparisonAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerComparisonAnalysisPanel = this;
		this.playerPO = playerPO;
		anotherPlayerPO = null;
		setBounds(
				PADDING,
				PADDING * 2 + PlayerDataAnalysisPanel.SELECT_PANEL_HEIGHT + PlayerDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING,
				PlayerDataAnalysisPanel.PANEL_HEIGHT);
		setLayout(null);
		setOpaque(false);
		
		Font font = new Font("default", 2, 80);
		int len =  getWidth() - 2 * PLAYER_PANEL_WIDTH;
		int wid = len * 2 / 3;
		v = new JLabel("V", JLabel.CENTER);
		v.setBounds(PLAYER_PANEL_WIDTH, getHeight() / 2 - wid + len / 6, wid, wid);
		PUtil.setFontandColor(v, font, Color.white);
		s = new JLabel("S", JLabel.CENTER);
		s.setBounds(PLAYER_PANEL_WIDTH + len / 3, getHeight() / 2 - len / 6, wid, wid);
		PUtil.setFontandColor(s, font, Color.white);
		add(v);
		add(s);
		
		input = new InputPanel();
		add(input);
	    comp(null);
		
	}
	/**
	 * 展示球员简略信息的一个panel
	 * @author hutao
	 *
	 */
	class PlayerPanel extends JPanel {
		public JLabel player, name, value, cond1, cond2, team;
		public PlayerPanel() {
			ini(true, playerPO);
		}
		
		public PlayerPanel(PlayerPO p) {
			ini(false, p);
			if(info != null) {
				info.setVisible(false);
				playerComparisonAnalysisPanel.remove(info);
			}
			if(anotherPlayerPO != null) {
				PlayerData pd;
				switch(input.conditions.getSelectedIndex()) {
				case 0 : pd = PlayerData.score; break;
				case 1 : pd = PlayerData.numberOfRebound; break;
				case 2 : pd = PlayerData.numberOfSteal; break;
				case 3 : pd = PlayerData.numberOfAssist; break;
				default : pd = PlayerData.score; 
				}
				String s = (String)input.conditions.getSelectedItem();
				if(playerPO.getName().equals(anotherPlayerPO.getName())) {
					boolean b1 = MainFrame.mainFrame.bl.ifBetterThanSelf(playerPO, pd, Config.LASTEST_SEASON);
					boolean b2 = MainFrame.mainFrame.bl.ifStableThanSelf(playerPO, pd, Config.LASTEST_SEASON);
					info = new InfoPanel(
						b1 ? "推测该球员本赛季" + s + "成绩较上赛季进步" : "推测该球员本赛季" + s + "成绩较上赛季退步",
						b2 ? "推测该球员本赛季" + s + "成绩比上赛季稳定" : "推测该球员本赛季" + s + "成绩没上赛季稳定");
				    info.setFontSize(18);
				}
				else {
					boolean b1 = MainFrame.mainFrame.bl.ifBetterThanAnother(playerPO, anotherPlayerPO, pd, Config.LASTEST_SEASON);
					boolean b2 = MainFrame.mainFrame.bl.ifStableThanAnother(playerPO, anotherPlayerPO, pd, Config.LASTEST_SEASON);
					info = new InfoPanel(
						"推测" + playerPO.getName() + "本赛季" + s + "发挥" + (b1 ? "比" : "不如") + anotherPlayerPO.getName() + "优秀",
						"推测" + playerPO.getName() + "本赛季" + s + "发挥" + (b2 ? "比" : "不如") + anotherPlayerPO.getName() + "稳定");
					info.setFontSize(16);
				}
			}
			else info = new InfoPanel(null, null);
		}
		private void ini(boolean isLeft, PlayerPO p) {
			if(isLeft) setBounds(0, 0, PLAYER_PANEL_WIDTH, PLAYER_PANEL_HEIGHT);
			else setBounds(playerComparisonAnalysisPanel.getWidth() - PLAYER_PANEL_WIDTH,
		                playerComparisonAnalysisPanel.getHeight() - PLAYER_PANEL_HEIGHT,
		                PLAYER_PANEL_WIDTH, PLAYER_PANEL_HEIGHT);
			setLayout(null);
			setBackground(new Color(0, 0, 0, 80));
			player = new JLabel();
			player.setBounds(
				isLeft ? PADDING : PLAYER_PANEL_WIDTH - PADDING - PLAYER_PIC_WIDTH,
				isLeft ? PADDING : PLAYER_PANEL_HEIGHT - PADDING - PLAYER_PIC_HEIGHT,
				PLAYER_PIC_WIDTH, PLAYER_PIC_HEIGHT);
			PlayerDetailPanel.fillLabel(p == null ? "images/nba_logo.png" : p.getActionURL(),
				    player, PLAYER_PIC_WIDTH, PLAYER_PIC_HEIGHT);
			name = new JLabel(p == null ? "Unknown" : p.getName());
			name.setBounds(
				player.getX(),
				player.getY() + (isLeft ? (PADDING + PLAYER_PIC_HEIGHT) : (- PADDING - NAME_HEIGHT)),
				400, NAME_HEIGHT);
			PUtil.setFontandColor(name, 30, Color.white);

			team = new JLabel();
			team.setBounds(
				isLeft ? PLAYER_PANEL_WIDTH - PADDING - TEAM_WIDTH : PADDING,
				isLeft ? PADDING : PLAYER_PANEL_HEIGHT - PADDING - TEAM_HEIGHT,
				TEAM_WIDTH, TEAM_HEIGHT);

			TeamPO t;
			try {
				t = TeamListPO.findTeamByShortName(p.getTeam(Config.LASTEST_SEASON));
			}catch(Exception e) { t = null; }
			
			if(t != null) PlayerDetailPanel.fillLabel(t.getTeamLogoURL(), team, TEAM_WIDTH, TEAM_HEIGHT);
			
			try {
				PlayerDataPO pd = p.getSeasonInfo(Config.LASTEST_SEASON).getAveragePlayerData();
				double d;
				switch(input.conditions.getSelectedIndex()) {
				case 0 : d = pd.getScore(); if(Double.isNaN(d)) d = 0; break;
				case 1 : d = pd.getNumberOfRebound(); if(Double.isNaN(d)) d = 0; break;
				case 2 : d = pd.getNumberOfSteal(); if(Double.isNaN(d)) d = 0; break;
				case 3 : d = pd.getNumberOfAssist(); if(Double.isNaN(d)) d = 0; break;
				default : d = 0; 
				}
				value = new JLabel(String.format("%.2f", d));
				value.setBounds(team.getX(), PLAYER_PANEL_HEIGHT / 2 + VALUE_HEIGHT, TEAM_WIDTH, VALUE_HEIGHT);
				PUtil.setFontandColor(value, 30, Color.white);
			}catch(Exception e) {
				value = new JLabel();
			}
			
			cond1 = new JLabel("本赛季");
			cond1.setBounds(team.getX(), PLAYER_PANEL_HEIGHT / 2 - VALUE_HEIGHT, TEAM_WIDTH, VALUE_HEIGHT);
			PUtil.setFontandColor(cond1, 28, Color.white);
			
			cond2 = new JLabel("场均" + input.conditions.getSelectedItem());
			cond2.setBounds(team.getX(), PLAYER_PANEL_HEIGHT / 2, TEAM_WIDTH, VALUE_HEIGHT);
			PUtil.setFontandColor(cond2, 28, Color.white);
			
			add(player);
			add(name);
			add(cond1);
			add(cond2);
			add(value);
			add(team);
		}
		
	}
	private static final int 
	    PLAYER_PIC_WIDTH = 250,
		PLAYER_PIC_HEIGHT = PLAYER_PIC_WIDTH * 700 / 440,
		NAME_HEIGHT = 50,
		TEAM_WIDTH = 150,
		TEAM_HEIGHT = TEAM_WIDTH,
		VALUE_HEIGHT = 40;
	
	/**
	 * 显示比对后信息的panel
	 * @author hutao
	 *
	 */
	class InfoPanel extends JPanel {
        public JLabel infoLabel1, infoLabel2;
		public InfoPanel(String info1, String info2) {
			setLayout(null);
			setBounds(0, PLAYER_PANEL_HEIGHT + PADDING, OTHER_PANEL_WIDHT, OTHER_PANEL_HEIGHT);
			setBackground(new Color(255, 255, 255, 80));
			infoLabel1 = new JLabel(info1);
			infoLabel1.setBounds(0, 0, getWidth(), OTHER_PANEL_HEIGHT / 2);
			infoLabel2 = new JLabel(info2);
			infoLabel2.setBounds(0, OTHER_PANEL_HEIGHT / 3, getWidth(), OTHER_PANEL_HEIGHT / 2);
			
			add(infoLabel1);
			add(infoLabel2);
			
			playerComparisonAnalysisPanel.add(this);
        }
		public void setFontSize(int size) {
			Font f = new Font("default", 0, size);
			infoLabel1.setFont(f);
			infoLabel2.setFont(f);
		}
		
	}
	/**
	 * 进行查询输入的panel
	 * @author hutao
	 *
	 */
	class InputPanel extends JPanel {
		public JComboBox<String> conditions;
		public JTextField name;
		public String[] buffer;
		private Popu pop;
		public InputPanel() {
			setLayout(null);
			setBounds(playerComparisonAnalysisPanel.getWidth() - PLAYER_PANEL_WIDTH,
					0,
					OTHER_PANEL_WIDHT, OTHER_PANEL_HEIGHT);
			setBackground(new Color(255, 255, 255, 80));
			buffer = new String[]{"", "", "", "", ""};
			
			conditions = new JComboBox<String>(Config.PLAYER_COMPARE);
			conditions.setFont(new Font("default", 0, 17));
			conditions.setBounds(PADDING, 20, 150, 30);
			add(conditions);
			
			name = new JTextField();
			name.setFont(new Font("default", 0, 18));
			name.setBounds(PADDING, 65, 300, 30);
			name.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if(e.getKeyChar() == 8 && name.getText().length() > 0) bufferChange(name.getText().substring(0, name.getText().length() - 1));
					else if(e.getKeyChar() == 8) bufferChange("");
					else bufferChange(name.getText() + e.getKeyChar());
					if(pop != null) {
						pop.setVisible(false);
						playerComparisonAnalysisPanel.remove(pop);
					}
					pop = new Popu(name);
					playerDataAnalysisFrame.repaint();
				}
			});
			add(name);
		}
		private void bufferChange(String type) {
			int k = 0;
			ArrayList<PlayerPO> pl = PlayerListPO.getAllPlayers();
			for(int i = 0; i < pl.size(); i ++) {
				if(pl.get(i).getName().contains(type)) {
					input.buffer[k] = new String(pl.get(i).getName());
					if(++ k == input.buffer.length)
						break;
				}
			}
			for(; k < input.buffer.length; k ++) {
				input.buffer[k] = "";
			}
		}
	}
	private static final int POP_UNIT_HEIGHT = 20;
	class Popu extends JPanel{
		public Popu(JTextField jtf) {
			setLayout(null);
			setBounds(jtf.getX() + input.getX(), jtf.getY() + jtf.getHeight() + input.getY(),
					jtf.getWidth(), 5 * POP_UNIT_HEIGHT);
//			setBackground(new Color(255, 255, 255, 150));
			for(int i = 0; i < input.buffer.length; i ++) {
				final JLabel l = new JLabel(input.buffer[i]);
				l.setBounds(0, i * POP_UNIT_HEIGHT, getWidth(), POP_UNIT_HEIGHT);
				PUtil.setFontandColor(l, 18, Color.black);
				l.addMouseListener(new LMouseAdapter(playerDataAnalysisFrame) {
					public void mouseClicked(MouseEvent e) {
						comp(l.getText());
						input.name.setText(l.getText());
						input.bufferChange(l.getText());
						if(input.pop != null) {
							input.pop.setVisible(false);
							playerComparisonAnalysisPanel.remove(input.pop);
						}
					}
				});
				add(l);
			}
			playerComparisonAnalysisPanel.add(this, 1);
			
		}
	}
	
	
	
	/**
	 * 输入完毕后进行查询，并输出结果
	 */
	private void comp(String name) {
		if(player1 == null) {
			player1 = new PlayerPanel();
			add(player1);
		}
		player1.cond2.setText("场均" + input.conditions.getSelectedItem());
		PlayerDataPO pd = playerPO.getSeasonInfo(Config.LASTEST_SEASON).getAveragePlayerData();
		double d;
		switch(input.conditions.getSelectedIndex()) {
		case 0 : d = pd.getScore(); if(Double.isNaN(d)) d = 0; break;
		case 1 : d = pd.getNumberOfRebound(); if(Double.isNaN(d)) d = 0; break;
		case 2 : d = pd.getNumberOfSteal(); if(Double.isNaN(d)) d = 0; break;
		case 3 : d = pd.getNumberOfAssist(); if(Double.isNaN(d)) d = 0; break;
		default : d = 0; 
		}
		player1.value.setText(String.format("%.2f", d));
		
		if(player2 != null) {
			player2.setVisible(false);
			remove(player2);
		}
		if(name == null || name.equals("")) anotherPlayerPO = null;
		else anotherPlayerPO = PlayerListPO.findPlayerAccurately(name);
		player2 = new PlayerPanel(anotherPlayerPO);
		add(player2);
	}

}

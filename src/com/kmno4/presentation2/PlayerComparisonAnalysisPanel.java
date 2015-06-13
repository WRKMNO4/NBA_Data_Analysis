package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kmno4.common.Config;
import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.button.LMouseAdapter;

import PO.PlayerListPO;
import PO.PlayerPO;
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
		JLabel player, name, value;
		public PlayerPanel() {
			setBounds(0, 0, PLAYER_PANEL_WIDTH, PLAYER_PANEL_HEIGHT);
			setLayout(null);
			setBackground(new Color(0, 255, 255, 80));
		}
		
		public PlayerPanel(PlayerPO p) {
			setBounds(playerComparisonAnalysisPanel.getWidth() - PLAYER_PANEL_WIDTH,
	                playerComparisonAnalysisPanel.getHeight() - PLAYER_PANEL_HEIGHT,
	                PLAYER_PANEL_WIDTH, PLAYER_PANEL_HEIGHT);
			setLayout(null);
			setBackground(new Color(0, 255, 255, 80));
			
			if(info != null) {
				info.setVisible(false);
				playerComparisonAnalysisPanel.remove(info);
			}
			info = new InfoPanel(null, null);
		}
		
	}
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
			setBackground(Color.black);
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
			setBackground(Color.white);
			buffer = new String[]{"", "", "", "", ""};
			
			conditions = new JComboBox<String>(Config.PLAYER_COMPARE);
			conditions.setFont(new Font("default", 0, 17));
			conditions.setBounds(PADDING, 0, 150, 30);
			add(conditions);
			
			name = new JTextField();
			name.setFont(new Font("default", 0, 18));
			name.setBounds(PADDING, 50, 300, 30);
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

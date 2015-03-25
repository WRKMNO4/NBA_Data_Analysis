package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PO.PlayerPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.button.LabelButton;
import com.kmno4.presentation.table.SlideTable;
import com.kmno4.presentation.table.SmallTable;

@SuppressWarnings("serial")
public class PlayerDetailPanel extends JPanel {
	private PlayerDetailFrame playerDetailFrame;
	private PlayerDetailPanel playerDetailPanel;
	private JLabel 
	    player_icon,
	    player_num,
	    player_name,
	    player_place,
	    player_team,
	    avg, //场均切换标签
	    sum; //总计切换标签
	private SmallTable mainInfo; //主要信息表格
	private SlideTable
	    sumInfo, //总计信息表格
	    avgInfo; //场均信息表格
	private GridBagLayout layout;
	private GridBagConstraints c;
	
	private PlayerPO playerPO;
	public PlayerDetailPanel(PlayerPO p, PlayerDetailFrame f) {
		playerPO = p;
		playerDetailPanel = this;
		playerDetailFrame = f;
		setBounds(0, 0,
				Config.PLAYER_DETAIL_UI_WIDTH,Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setBackground(new Color(255, 255, 255, 255));
		layout = new GridBagLayout();
		setLayout(layout);
		c = new GridBagConstraints();
		player_icon = new JLabel();
		
		Image i = null;
		BufferedImage bi = new BufferedImage(Config.PLAYER_ICON_WIDTH, Config.PLAYER_ICON_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
		try {
			i = ImageIO.read(new File(playerPO.getActionURL()));
		} catch (IOException e1) {
			System.out.println("image load fail");
			e1.printStackTrace();
		}
		bi.getGraphics().drawImage(i, 0, 0, Config.PLAYER_ICON_WIDTH, Config.PLAYER_ICON_HEIGHT, new Color(255, 255, 255, 0), null);
		Image image = bi;
		player_icon.setIcon(new ImageIcon(image));
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 4;
		c.weightx = 7;
		c.weighty = 5;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.NORTHWEST;
		layout.setConstraints(player_icon, c);
		add(player_icon);
		
		JLabel blank1 = new JLabel();
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 2;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(blank1, c);
		add(blank1);
		
		player_num = new JLabel("4", JLabel.CENTER);
		player_num.setForeground(Color.RED);
		player_num.setFont(new Font("default", Font.BOLD, 50));
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 2;
		c.weighty = 2;
		layout.setConstraints(player_num, c);
		add(player_num);
		
		player_name = new JLabel(playerPO.getName(), JLabel.LEFT);
		player_name.setFont(new Font("default", Font.PLAIN, 26));
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 5;
		c.weighty = 2;
		layout.setConstraints(player_name, c);
		add(player_name);
		
		player_place = new JLabel(playerPO.getPosition()+" / "+playerPO.getSchool()+"城市", JLabel.LEFT);
		player_place.setFont(new Font("default", Font.ITALIC, 17));
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 5;
		c.weighty = 1;
		layout.setConstraints(player_place, c);
		add(player_place);
		
		player_team = new JLabel(playerPO.getTeam(), JLabel.CENTER);
		player_team.setForeground(Color.gray);
		player_team.setFont(new Font("default", Font.BOLD, 17));
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 5;
		c.weighty = 2;
		layout.setConstraints(player_team, c);
		add(player_team);
		
		
		JLabel blank2 = new JLabel();
		c.gridx = 4;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(blank2, c);
		add(blank2);
		
		sum = new LabelButton("总计", JLabel.CENTER);
		sum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!sum.isEnabled()) return;
				sum.setEnabled(false);
				avg.setEnabled(true);
				avgInfo.setVisible(false);
				sumInfo.setVisible(true);
				layout.setConstraints(sumInfo, c);
				playerDetailPanel.remove(avgInfo);
				playerDetailPanel.add(sumInfo);
				playerDetailFrame.repaint();
			}
		});
		sum.setEnabled(false);
		c.gridx = 5;
		layout.setConstraints(sum, c);
		add(sum);
		
		avg = new LabelButton("场均", JLabel.CENTER);
		avg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!avg.isEnabled()) return;
				avg.setEnabled(false);
				sum.setEnabled(true);
				sumInfo.setVisible(false);
				avgInfo.setVisible(true);
				layout.setConstraints(avgInfo, c);
				playerDetailPanel.remove(sumInfo);
				playerDetailPanel.add(avgInfo);
				playerDetailFrame.repaint();
			}
		});
		c.gridx = 6;
		layout.setConstraints(avg, c);
		add(avg);
		
		
		mainInfo = new SmallTable(
				new String[] {"场均得分", "场均篮板", "场均助攻"},
				new String[][] {{
					"" + TableContentTransfer.cutTailOfAvgData(playerPO.getAveragePlayerData().getScore()),
					"" + TableContentTransfer.cutTailOfAvgData(playerPO.getAveragePlayerData().getNumberOfRebound()),
					"" + TableContentTransfer.cutTailOfAvgData(playerPO.getAveragePlayerData().getNumberOfAssist())}});
		mainInfo.setFont(new Font("default", Font.PLAIN, 15), null);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.weightx = 8;
		c.weighty = 1.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		layout.setConstraints(mainInfo, c);
		add(mainInfo);
		
		sumInfo = new SlideTable(
				Config.PLAYER_TOTAL_INFO,
				TableContentTransfer.transferPlayerTotalInfo(Config.PLAYER_TOTAL_INFO.length, this.playerPO,1));
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 7;
		c.gridheight = 1;
		c.weightx = 20;
		c.weighty = 20;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(sumInfo, c);
		add(sumInfo);
		//sumInfo.setFont(new Font("default", Font.BOLD, 18), new Font("default", Font.PLAIN, 10));
		
		avgInfo = new SlideTable(
				Config.PLAYER_AVERAGE_INFO,
				TableContentTransfer.transferPlayerAvgInfo(Config.PLAYER_AVERAGE_INFO.length,this.playerPO, 1));
		//avgInfo.setFont(new Font("default", Font.PLAIN, 7), new Font("default", Font.PLAIN, 8));
		
		
	}
}

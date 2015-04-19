package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

import PO.PlayerPO;

@SuppressWarnings("serial")
public class HeadIconPanel extends JPanel {
	private JLabel head;
	private JLabel name;
	private JLabel team;
	private GridBagLayout layout;
	private GridBagConstraints c;
	private PlayerPO playerPO;
	
	public HeadIconPanel(PlayerPO po) {
		playerPO = po;
		layout = new GridBagLayout();
		c = new GridBagConstraints();
		setLayout(layout);
		setBounds(0, 0, Config.HEAD_ICON_FRAME_WIDTH, Config.HEAD_ICON_FRAME_HEIGHT);
		this.setBackground(Color.WHITE);
		
		head = new JLabel();
		Image i = null;
		BufferedImage bi = new BufferedImage(Config.HEAD_ICON_WIDTH, Config.HEAD_ICON_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
		try {
			i = ImageIO.read(new File(playerPO.getPortraitURL()));
		} catch (IOException e1) {
			System.out.println("image load fail");
			e1.printStackTrace();
		}
		bi.getGraphics().drawImage(i, 0, 0, Config.HEAD_ICON_WIDTH, Config.HEAD_ICON_HEIGHT, new Color(255, 255, 255, 0), null);
		Image image = bi;
		head.setIcon(new ImageIcon(image));
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.weightx = 1;
		c.weighty = 2;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(head, c);
		add(head);
		
		
		
		name = new JLabel(playerPO.getName(), JLabel.CENTER);
		name.setFont(new Font("default", Font.PLAIN, 20));
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(name, c);
		add(name);
		
		team = new JLabel(playerPO.getTeam(Config.LASTEST_SEASON), JLabel.LEFT);
		team.setFont(new Font("default", Font.ITALIC, 25));
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(team, c);
		add(team);
	}
		
}

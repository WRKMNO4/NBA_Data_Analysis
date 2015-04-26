package com.kmno4.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;

import PO.TeamPO;

import com.kmno4.common.Config;
import com.kmno4.presentation.table.SlideTable;
import com.kmno4.presentation.table.SmallTable;

@SuppressWarnings("serial")
public class TeamDetailPanel extends JPanel {
	private TeamDetailPanel teamDetailPanel;
	private TeamDetailFrame teamDetailFrame;
	private JLabel team_icon, team_name, team_recent_game, team_achi, avg, sum;
	private JComboBox<String> seasonBox;
	private SmallTable mainInfo;
	private SlideTable sumInfo, avgInfo;
	private GridBagLayout layout;
	private GridBagConstraints c;

	private TeamPO teamPO;

	public TeamDetailPanel(TeamPO t, TeamDetailFrame f) {
		teamPO = t;
		teamDetailPanel = this;
		teamDetailFrame = f;
		setBounds(0, 0, Config.PLAYER_DETAIL_UI_WIDTH,
				Config.PLAYER_DETATI_UI_TOP_HEIGHT);
		setBackground(new Color(255, 255, 255, 255));
		layout = new GridBagLayout();
		setLayout(layout);
		c = new GridBagConstraints();

		team_icon = new JLabel();
		fillIcon(team_icon, t.getTeamLogoURL(), Config.TEAM_ICON_WIDTH, Config.TEAM_ICON_HEIGHT);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 4;
		c.weightx = 4;
		c.weighty = 4;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.NORTHWEST;
		layout.setConstraints(team_icon, c);
		add(team_icon);

		team_name = new JLabel(t.getFullName(), JLabel.LEFT);
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

		team_recent_game = new JLabel("查看近期比赛", JLabel.LEFT);
		team_recent_game.setFont(new Font("default", Font.ITALIC, 18));
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 3;
		c.weighty = 1;
		c.fill = GridBagConstraints.NONE;
		layout.setConstraints(team_recent_game, c);
		add(team_recent_game);
		team_recent_game.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(LastestGameFrame.lgf != null) {
					LastestGameFrame.lgf.setVisible(false);
					LastestGameFrame.lgf.dispose();
				}
				LastestGameFrame.lgf = new LastestGameFrame(
						teamPO,
						team_recent_game.getX() + teamDetailFrame.getX(),
						team_recent_game.getY() + teamDetailFrame.getY() + team_recent_game.getHeight());
			}
		});

		team_achi = new JLabel();
		team_achi.setFont(new Font("default", Font.BOLD, 20));
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

		seasonBox = new JComboBox<String>(Config.Seasons);
		seasonBox.setFont(new Font("default", Font.PLAIN, 11));
		seasonBox.setSelectedIndex(1);
		c.gridx = 3;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(seasonBox, c);
		add(seasonBox);
		seasonBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		sum = new JLabel("总计", JLabel.CENTER);
		sum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!sum.isEnabled())
					return;
				sum.setEnabled(false);
				avg.setEnabled(true);
				sumInfo.setVisible(true);
				avgInfo.setVisible(false);
				layout.setConstraints(sumInfo, c);
				teamDetailPanel.remove(avgInfo);
				teamDetailPanel.add(sumInfo);
				teamDetailFrame.repaint();
			}
		});
		//sum.setFont(new Font("default", Font.BOLD, 15));
		c.gridx = 4;
		c.gridy = 3;
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
				if (!avg.isEnabled())
					return;
				avg.setEnabled(false);
				sum.setEnabled(true);
				avgInfo.setVisible(true);
				sumInfo.setVisible(false);
				layout.setConstraints(avgInfo, c);
				teamDetailPanel.remove(sumInfo);
				teamDetailPanel.add(avgInfo);
				teamDetailFrame.repaint();
			}
		});
		//avg.setFont(new Font("default", Font.BOLD, 15));
		c.gridx = 5;
		layout.setConstraints(avg, c);
		add(avg);

		mainInfo = new SmallTable(
				new String[] { "场均得分", "场均助攻", "场均篮板", "场均抢断" },
				new String[][] { {
						TableContentTransfer.cutTailOfAvgData(teamPO
								.getAverageTeamData(Config.LASTEST_SEASON).getScore()) + "",
						TableContentTransfer.cutTailOfAvgData(teamPO
								.getAverageTeamData(Config.LASTEST_SEASON).getNumberOfAssist()) + "",
						TableContentTransfer.cutTailOfAvgData(teamPO
								.getAverageTeamData(Config.LASTEST_SEASON).getNumberOfRebound())
								+ "",
						TableContentTransfer.cutTailOfAvgData(teamPO
								.getAverageTeamData(Config.LASTEST_SEASON).getNumberOfSteal()) + "" } });
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 6;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.WEST;
		layout.setConstraints(mainInfo, c);
		add(mainInfo);

		sumInfo = new SlideTable(
				Config.TEAM_TOTAL_INFO,
				TableContentTransfer.transferTeamTotalInfo(
						Config.TEAM_TOTAL_INFO.length, this.teamPO, Config.LASTEST_SEASON),
				70, 50, Config.PLAYER_DETAIL_UI_WIDTH);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 6;
		c.gridheight = 1;
		c.weightx = 12;
		c.weighty = 18;
		c.fill = GridBagConstraints.BOTH;
		layout.setConstraints(sumInfo, c);
		add(sumInfo);
		sumInfo.setFont(new Font("default", Font.PLAIN, 12), new Font("default", Font.PLAIN, 11), null);

		avgInfo = new SlideTable(
				Config.TEAM_AVERAGE_INFO,
				TableContentTransfer.transferTeamAvgInfo(
						Config.TEAM_AVERAGE_INFO.length, this.teamPO, Config.LASTEST_SEASON),
				70, 50, Config.PLAYER_DETAIL_UI_WIDTH);
		avgInfo.setFont(new Font("default", Font.PLAIN, 12), new Font("default", Font.PLAIN, 11), null);
		// layout.setConstraints(avgInfo, c);
		// add(avgInfo);

	}

	public static void fillIcon(JLabel head, String url, int width, int height) {
		//TODO
//		File pngBuffer = new File(bufferURL);
//		FileOutputStream fos = null;
//		try {
//			pngBuffer.createNewFile();
//		} catch (IOException e) {
//			System.out.println("imageBuffer create fail");
//			e.printStackTrace();
//		}
//		try {
//			fos = new FileOutputStream(pngBuffer);
//		} catch (FileNotFoundException e) {
//			System.out.println("imageBuffer not found");
//			e.printStackTrace();
//		}
//		convertToPNG(url, fos);
//		if (fos != null)
//			try {
//				fos.close();
//			} catch (IOException e) {
//				System.out.println("fileoutputstream close fail");
//				e.printStackTrace();
//			}
//
//		Image i = null;
//		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
//		try {
//			i = ImageIO.read(pngBuffer);
//		} catch (IOException e) {
//			System.out.println("pngBuffer read fail");
//			e.printStackTrace();
//		}
//		bi.getGraphics().drawImage(i, 0, 0, width, height, new Color(255, 255, 255, 0), null);
//		Image image = bi;
//		head.setIcon(new ImageIcon(image));
//
//		pngBuffer.delete();

	}

	

	private static final String bufferURL = "buffer/teamHeadIconImageBuffer.png";

}

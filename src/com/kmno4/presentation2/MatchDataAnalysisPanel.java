/**
 * 
 */
package com.kmno4.presentation2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.MatchInfoDetailFrame;
import PO.MatchPO;

/**
 * @author MyCapitaine
 *
 */
@SuppressWarnings("serial")
public class MatchDataAnalysisPanel extends JPanel {
//	private MatchDataAnalysisPanel matchDataAnalysisPanel;
	private MatchDataAnalysisFrame matchDataAnalysisFrame;
	private MatchPO matchPO;
	public static final int 
		PADDING = 10,
		LABEL_HEIGHT = 60,
		LABEL_WIDTH = 300,
		SELECT_PANEL_HEIGHT = 45,
		PANEL_HEIGHT = Config.UI_HEIGHT - 2 * PADDING - LABEL_HEIGHT - SELECT_PANEL_HEIGHT,
		SELECT_LABEL_WIDTH = 120;
	
	private JLabel matchLabel;
	private SelectPanel selectPanel;
	
	
	public MatchDataAnalysisPanel(MatchPO m, MatchDataAnalysisFrame f) {
		matchPO = m;
		matchDataAnalysisFrame = f;
//		matchDataAnalysisPanel = this;
		setLayout(null);
		setBounds(0, 0, f.getWidth(), f.getHeight());
		
		matchLabel = new JLabel(matchPO.getFirstTeam() + "@" + matchPO.getSecondTeam(), JLabel.LEFT);
		matchLabel.setBounds(PADDING, PADDING, LABEL_WIDTH, LABEL_HEIGHT);
		matchLabel.setForeground(Color.white);
		matchLabel.setFont(new Font("default", 2, 30));
		matchLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				returnToDetailFrame();
			}
		});
		add(matchLabel);

		selectPanel = new SelectPanel();
		add(selectPanel);
		add(new MatchDataComparePanel(matchPO, matchDataAnalysisFrame));
	}
	
	class SelectPanel extends JPanel {
		JLabel compare;
		public SelectPanel() {
			setBounds(PADDING, PADDING + LABEL_HEIGHT,
					Config.UI_WIDTH - 2 * PADDING, SELECT_PANEL_HEIGHT);
			setLayout(null);
			setBackground(new Color(20, 79, 139, 150));
			compare = new JLabel(" 球队数据比对", JLabel.LEFT);
			compare.setBounds(0, 0, SELECT_LABEL_WIDTH, SELECT_PANEL_HEIGHT);
			compare.setForeground(Color.white);
			compare.setFont(new Font("default", 0, 15));
			add(compare);
		}
	}
	
	private void returnToDetailFrame() {
		new MatchInfoDetailFrame(matchPO, matchDataAnalysisFrame.getLocation());
		matchDataAnalysisFrame.setVisible(false);
		matchDataAnalysisFrame.dispose();
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(Config.DETAIL_BG.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

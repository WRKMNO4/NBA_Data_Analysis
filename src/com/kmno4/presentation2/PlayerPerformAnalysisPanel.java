package com.kmno4.presentation2;

import javax.swing.JPanel;

import com.kmno4.common.Config;
import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.TableContentTransfer;
import com.kmno4.presentation.table.TableFactory;
import com.kmno4.presentation.table.TableGroup;

import PO.PlayerPO;
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
	private PlayerDataAnalysisFrame playerDataAnalysisFrame;
	private PlayerPO playerPO;
	public static final int 
    	PADDING = PlayerDataAnalysisPanel.PADDING,
    	PANEL_HEIGHT = 60,
    	TABLE_HEGIHT = PlayerDataAnalysisPanel.PANEL_HEIGHT - PANEL_HEIGHT - PADDING;
	
	
	private TableGroup tg;
	private PlayerFieldPanel pfp;
	
	public PlayerPerformAnalysisPanel(PlayerPO playerPO, PlayerDataAnalysisFrame f) {
		this.playerDataAnalysisFrame = f;
		this.playerPerformAnalysisPanel = this;
		this.playerPO = playerPO;
		setBounds(
				PADDING,
				PADDING * 2 + PlayerDataAnalysisPanel.SELECT_PANEL_HEIGHT + PlayerDataAnalysisPanel.LABEL_HEIGHT,
				Config.UI_WIDTH - 2 * PADDING,
				PlayerDataAnalysisPanel.PANEL_HEIGHT);
		setLayout(null);
		
		pfp = new PlayerFieldPanel();
		add(pfp);
		
		//TODO
		tg = new TableGroup();
		TableFactory.createTable(tg, this,
				TableContentTransfer.transferPlayerHighInfo(MainFrame.mainFrame.bl.getPlayerHighInfo()),
				getWidth(), PANEL_HEIGHT,
				0, PADDING + PANEL_HEIGHT);
	}
	
	
	class PlayerFieldPanel extends JPanel {
		public PlayerFieldPanel() {
			
		}
	}
}

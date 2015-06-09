package com.kmno4.presentation2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setOpaque(false);
		pfp = new PlayerFieldPanel();
		add(pfp);
		
		//TODO
		tg = new TableGroup();
		TableFactory.createSortTable(tg, this,
				TableContentTransfer.transferPlayerHighInfo(MainFrame.mainFrame.bl.getPlayerHighInfo()),
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
		public PlayerFieldPanel() {
			
		}
	}
}

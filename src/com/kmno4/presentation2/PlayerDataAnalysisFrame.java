package com.kmno4.presentation2;

import java.awt.Point;

import javax.swing.JFrame;
import com.kmno4.common.Config;
import com.kmno4.presentation.MoveOfFrame;
import com.kmno4.presentation.RightClickClose;
import com.kmno4.presentation.button.ExitLabel;

import PO.PlayerPO;
/**
 * 球员数据分析界面{@link PlayerDataAnalysisPanel}
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class PlayerDataAnalysisFrame extends JFrame {
	public PlayerDataAnalysisFrame(PlayerPO playerPO) {
		this(playerPO, new Point());
	}
	public PlayerDataAnalysisFrame(PlayerPO playerPO, Point location) {
		setBounds(location.x, 
				location.y, 
				Config.UI_WIDTH,
				Config.UI_HEIGHT);
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBackground(bgColor);
		add(new ExitLabel(this));
		
		add(new PlayerDataAnalysisPanel(playerPO, this));
		
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
	}
	
	
}

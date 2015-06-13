package com.kmno4.presentation2;

import javax.swing.JFrame;

import com.kmno4.presentation.MainFrame;
import com.kmno4.presentation.MoveOfFrame;
import com.kmno4.presentation.RightClickClose;
import com.kmno4.presentation.button.ExitLabel;
/**
 * {@link AllTeamDataAnalysisPanel}
 * @author hutao
 *
 */
@SuppressWarnings("serial")
public class AllTeamDataAnalysisFrame extends JFrame {
	
	public AllTeamDataAnalysisFrame() {
		setBounds(MainFrame.mainFrame.getBounds());
		setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(new ExitLabel(this));
		add(new AllTeamDataAnalysisPanel(this));
		setVisible(true);
		
		@SuppressWarnings("unused")
		MoveOfFrame m = new MoveOfFrame(this);
		@SuppressWarnings("unused")
		RightClickClose r = new RightClickClose(this);
		
	}

}

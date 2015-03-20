package com.kmno4.presentation;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kmno4.common.Config;

//自定义JAVA JcomboBox
public class Combox extends JFrame {

	private JPanel contentPane;
	public List<JLabel> choices;
	public JLabel title;

	
	public Combox(List<String> labels,int location_x,int location_y,final JLabel title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(location_x,location_y, Config.SELECTION_COMB_CITY_WIDTH, 15);
		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(labels.size()+1,1));
		setContentPane(contentPane);
		
		this.title=title;
		this.choices=new ArrayList<JLabel>();
		for(int i=0;i<labels.size();i++){
			JLabel label=new JLabel(labels.get(i));
			label.setSize(Config.COMBOX_WIDTH,Config.LABEL_HEIGHT);
			contentPane.add(label);
			this.choices.add(label);
		}
		
		for(int i=0;i<this.choices.size();i++){
			this.choices.get(i).addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					//将下拉框设置为点击的选项
					title.setText(((JLabel)e.getSource()).getText());
					dispose();
				}
			});
		}
	}

}

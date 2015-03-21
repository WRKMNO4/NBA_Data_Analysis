package com.kmno4.common;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Config {
	
	public static final int MAIN_FRAME_X=100;
	public static final int MAIN_FRAME_Y=100;
	public static final int UI_WIDTH=800;
	public static final int UI_HEIGHT=600;
	
	public static final int COMBOX_WIDTH=20;
	public static final int LABEL_HEIGHT=15;
	
	public static final int SPLASH_MOTION_X=320;
	public static final	int SPLASH_MOTION_Y=210;
	
	public static final int TOP_TAB_HEIGHT=100;
	public static final int TOP_TAB_LABLE_WIDTH=60;
	public static final int TOP_TAB_LABLE_HEIGHT=40;
	
	public static final int PAGE_INTRO_HEIGHT=50;
	public static final int PAGE_INTRO_LABEL_HEIGHT=30;
	public static final int PAGE_INTRO_LABEL_WIDTH=50;
	
	public static final int SELECTION_HEIGHT=135;
	public static final int SELECTION_SEARCH_HEIGHT=20;
	public static final int SELECTION_COMB_CITY_WIDTH=20;
	public static final int SELECTION_COMB_TEAM_WIDTH=20;
	public static final int SELECTION_SEARCH_WIDTH=140;
	public static final int TEXT_WIDTH=35;
	public static final int TEXT_height=15;
	public static final int SORT_WIDTH=30;
	public static final int SORT_HEIGHT=30;
	public static final int COBM_LOCATION_Y=95;
	public static final int COMB_TEXT_GAP=50;
	
	public static final int MATCH_SELECTION_PANEL_WIDTH=800;
	public static final int MATCH_SELECTION_PANEL_HEIGHT=135;
	public static final int MATCH_SELECTION_PANEL_LABEL_WIDTH=100;
	public static final int MATCH_SELECTION_PANEL_LABEL_HEIGHT=100;
	
	public static final int MATCH_INFO_TEAM_ICON_WIDTH=80;
	public static final int MATCH_INFO_TEAM_ICON_HEIGHT=80;
	public static final int MATCH_INFO_TEAM_NAME_WIDTH=75;
	public static final int MATCH_INFO_TEAM_NAME_HEIGHT=15;
	public static final int MATCH_INFO_VS_WIDTH=20;
	public static final int MATCH_INFO_VS_HEIGHT=20;
	public static final int MATCH_INFO_TIME_PLACE_WIDTH=60;
	public static final int MATCH_INFO_TIME_PLACE_HEIGHT=15;

	public static final int INTRODUCTION_WHITE=50;
	
	public static final int PLAYER_DETAIL_UI_WIDTH=700;
	public static final int PLAYER_DETATI_UI_TOP_HEIGHT=400;
	public static final int PLAYER_ICON_X=70;
	public static final int PLAYER_ICON_Y=35;
	public static final int PLAYER_ICON_WIDTH=130;
	public static final int PLAYER_ICON_HEIGHT=160;
	public static final int PLAYER_NUMBER_WIDTH=60;
	public static final int PLAYER_NUMBER_HEIGHT=70;
	public static final int PLAYER_LABEL_HEIGHT=15;
	public static final int PLAYER_LABEL_WIDTH=60;
	
	//所有图片
	public static ArrayList<ImageIcon> motions=new ArrayList<ImageIcon>();
	public static final Icon SPLASH_TITLE=new ImageIcon("images/splash_title.png");
	public static final Icon SPLASH_BACKGROUND=new ImageIcon("images/splash_bg.png");
	public static final ImageIcon PLAYER_SELECTION_BACKGROUND=new ImageIcon("images/selection_bg.png");
	public static final ImageIcon TOP_TAB_BACKGROUND=new ImageIcon("images/top_tab_background.png");
	public static final ImageIcon WELCOME=new ImageIcon("images/welcome.png");
	public static final ImageIcon TEAM_SELECTION_BACKGROUND=new ImageIcon("images/team_selection_bg2.png");
	
	public static ArrayList<ImageIcon> getLoadingMotions(){
		for(int i=1;i<100;i++){
			motions.add(new ImageIcon("images/loading_motions/"+i+".png"));	
		}			
		return motions;
	}
}

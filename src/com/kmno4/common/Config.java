package com.kmno4.common;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Enum.Season;

public class Config {
	public static Season LASTEST_SEASON = Season.season12_13;
	public static String LASTEST_DATE = "10-30"   ;
	public static final String[] Seasons={"2012-2013赛季","2013-2014赛季","2014-2015赛季"};
	public static final String[] PLAYER_BASIC_INFO={"姓名","位置","球衣号","身高","体重","生日","年龄","球龄","毕业学校"};
	public static final String[] PLAYER_AVERAGE_INFO={"赛季", "篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率",
		"进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率",
		"GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率",
		"防守篮板率","助攻率","抢断率",
		"盖帽率","失误率","使用率",};
	public static final String[] PLAYER_TOTAL_INFO = {"赛季", "参赛场数","先发场数","篮板数","助攻数","在场时间","进攻数","防守数",
		"抢断数","盖帽数","失误数","犯规数","得分"} ;
	public static final String[] PLAYER_AVERAGE_INFO_OVERALL={"篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率",
		"进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率",
		"GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率",
		"防守篮板率","助攻率","抢断率",
		"盖帽率","失误率","使用率",};
	public static final String[] PLAYER_TOTAL_INFO_OVERALL = {"参赛场数","先发场数","篮板数","助攻数","在场时间","进攻数","防守数",
		"抢断数","盖帽数","失误数","犯规数","得分"} ;
	
	
	public static final String[] PLAYER_RECENT_INFO = {"赛季","日期","对阵","位置","在场时间","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数", "罚球出手数","进攻篮板",
		"防守篮板","总篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","个人得分"} ;
	public static final String[] TEAM_BASIC_INFO = {"队名","缩写","所在地","赛区","分区","主场","建立时间"} ;
	public static final String[] TEAM_AVERAGE_INFO = {"赛季","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数"
		,"助攻数","抢断数","盖帽数","失误数","犯规数","得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"} ;
	public static final String[] TEAM_TOTAL_INFO = {"赛季","比赛场数","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数"
		,"助攻数","抢断数","盖帽数","失误数","犯规数","得分","进攻回合"} ;
	
	public static final String[] TEAM_AVERAGE_INFO_OVERALL = {"投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数"
		,"助攻数","抢断数","盖帽数","失误数","犯规数","得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"} ;
	public static final String[] TEAM_TOTAL_INFO_OVERALL = {"比赛场数","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数"
		,"助攻数","抢断数","盖帽数","失误数","犯规数","得分","进攻回合"} ;
	
	public static final String[] TEAM_RECENT_INFO = {"赛季","日期","对阵","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数"
		,"助攻数","抢断数","盖帽数","失误数","犯规数","得分","投篮命中率","三分命中率","罚球命中率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"};
	public static final String[] MATCH_BASIC_INFO = {"日期", "球队",  "得分", "得分","球队"};
	public static final String[] MATCH_DETAIL_INFO = {"球员名","位置","在场时间","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数", "罚球出手数","进攻篮板",
		"防守篮板","总篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","个人得分"} ;
	
	public static final String[] PLAYER_SORT_AVERAGE={"球员","篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率",
		"进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率",
		"GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率",
		"防守篮板率","助攻率","抢断率",
		"盖帽率","失误率","使用率"} ;
	public static final String[] PLAYER_SORT_TOTAL={"球员","参赛场数","先发场数","篮板数","助攻数","在场时间","进攻数","防守数",
		"抢断数","盖帽数","失误数","犯规数","得分"};
	public static final String[] TEAM_SORT_AVERAGE={"球队","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数"
		,"助攻数","抢断数","盖帽数","失误数","犯规数","得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"};
	public static final String[] TEAM_SORT_TOTAL={"球队","比赛场数","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数"
		,"助攻数","抢断数","盖帽数","失误数","犯规数","得分","进攻回合"};
	
	//筛选功能
	public static final String[] PICKUP_POSITION={"前锋","中锋","后卫"};
	public static final String[] PICKUP_DISTRICT={"东部","Southeast","Central","Atlantic","西部","Northwest","Southwest","Pacific"};
	public static final String[] PICKUP_TYPE={"得分","篮板","助攻","得分/篮板/助攻","盖帽","抢断","犯规","失误","分钟","效率","投篮","三分","罚球","两双"};
	public static final String[] PICKUP_STANDARD={"总计","场均"};
	
	public static final String[] SORT_TEAM_TYPE = {};
	public static final String[] SORT_TEAM_STANDRAD = {"总计", "场均"};
	
	
	public static final String[] STANDING_DAILYPLAYER_TYPE={"得分","篮板","助攻","盖帽","抢断"} ;
	public static final String[] STANDING_DAILYPLAYER_TABLEHEAD = {"球员名称" ,"所属球队","球员位置","比赛数据"} ;
	
	public static final String[] STANDING_SEASONPLAYER_TYPE={"得分","篮板","助攻","盖帽","抢断","三分命中率","投篮命中率","罚球命中率"} ;
	public static final String[] STANDING_SEASONPLAYER_TABLEHEAD = {"球员名称" ,"所属球队","球员位置","比赛数据"} ;
	
	public static final String[] STANDING_SEASONTEAM_TYPE={"得分","篮板","助攻","盖帽","抢断","三分命中率","投篮命中率","罚球命中率"} ;
    public static final String[] STANDING_SEASONTEAM_TABLEHEAD = {"球队名称","所属联盟","分区","比赛数据"} ;
    
	public static final String[] STANDING_IMPROVED_TYPE = {"场均得分提升率","场均篮板提升率","场均助攻提升率"} ;
	public static final String[] STANDING_IMPROVE_TABLEHEAD = {"球员名称","所属球队","球员位置","近五场提升率"} ;
	
	public static final String[] PLAYER_HIGHINFO = {"姓名","球队","比赛场数","场均在场时间","在场进攻贡献度","在场防守贡献度","在场贡献度","球队胜利贡献度"};
	public static final String[] TEAM_RANKING = {"排名","球队","胜场","负场","胜率","主场胜","客场胜","连续胜场","连续负场","场均得分","场均失分"};
	public static final String[] TEAM_LATEST10MATCHES_ANALYSIS = {"球队","总胜场","总负场","连胜场数","连负场数","最近10场胜场","最近10主场胜场","最近10客场胜场","场均得分","场均失分"};
	
	public static final String[] TEAM_LEADERS = {"得分","篮板","助攻","抢断","盖帽","投篮命中率","三分命中率"};
	public static final String[] PLAYER_COMPARE = {"得分", "篮板", "抢断", "助攻"};
	public static final int 
	    MATCH_DETAIL_WIDTH = 800,
	    MATCH_DETAIL_HEIGHT = 600;
	
	public static final int
	    LASTEST_GAME_FRAME_HEIGHT = 130,
	    LASTEST_GAME_FRAME_WIDTH = 530;
	
	public static final int MAIN_FRAME_X=100;
	public static final int MAIN_FRAME_Y=100;
	public static final int UI_WIDTH=1000;
	public static final int UI_HEIGHT=750;
	
	public static final int COMBOBOX_HEIGHT=27;
	public static final int COMBOBOX_WIDTH=150;
	
	public static final int COMBOX_WIDTH=20;
	public static final int LABEL_HEIGHT=15;
	
	public static final int SPLASH_MOTION_X=320;
	public static final	int SPLASH_MOTION_Y=210;
	
	public static final int TOP_TAB_HEIGHT=100;
	public static final int TOP_TAB_LABLE_WIDTH=100;
	public static final int TOP_TAB_LABLE_HEIGHT=35;
	
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
	public static final int PLAYER_ICON_WIDTH=198;
	public static final int PLAYER_ICON_HEIGHT=315;
	public static final int PLAYER_NUMBER_WIDTH=60;
	public static final int PLAYER_NUMBER_HEIGHT=70;
	public static final int PLAYER_LABEL_HEIGHT=15;
	public static final int PLAYER_LABEL_WIDTH=60;
	public static final int PLAYER_TOP_LABEL_WIDTH=50;
	public static final int PLAYER_TOP_LABEL_HEIGHT=20;
	
	public static final int HEAD_ICON_FRAME_WIDTH = 368;
	public static final int HEAD_ICON_FRAME_HEIGHT = 148;
	public static final int HEAD_ICON_WIDTH = 184;
	public static final int HEAD_ICON_HEIGHT = 184;
	
	public static final int TEAM_ICON_WIDTH = 315;
	public static final int TEAM_ICON_HEIGHT = 315;
	
	
	public static final ImageIcon FLASH=new ImageIcon("images/flash.png");
	public static final ImageIcon FLASH2=new ImageIcon("images/flash2.png");
	//所有图片
	public static final ImageIcon FRAME_BACKGROUND=new ImageIcon("images/frame_bg_black.png");
		//tabPanel Label切换图片
	public static final ImageIcon TAB_PLAYER_CLICKED=new ImageIcon("images/tab_player_clicked.png");
	public static final ImageIcon TAB_TEAM_CLICKED=new ImageIcon("images/tab_team_clicked.png");
	public static final ImageIcon TAB_MATCH_CLICKED=new ImageIcon("images/tab_match_clicked.png");
	public static final ImageIcon TAB_HOT_CLICKED=new ImageIcon("images/tab_hot_clicked.png");
	public static final ImageIcon TAB_ABOUT_CLICKED=new ImageIcon("images/tab_about_clicked.png");

	public static final ImageIcon TAB_PLAYER_ENTERED=new ImageIcon("images/tab_player_entered.png");
	public static final ImageIcon TAB_TEAM_ENTERED=new ImageIcon("images/tab_team_entered.png");
	public static final ImageIcon TAB_MATCH_ENTERED=new ImageIcon("images/tab_match_entered.png");
	public static final ImageIcon TAB_HOT_ENTERED=new ImageIcon("images/tab_hot_entered.png");
	public static final ImageIcon TAB_ABOUT_ENTERED=new ImageIcon("images/tab_about_entered.png");

	public static final ImageIcon TAB_PLAYER_UNPRESSED=new ImageIcon("images/tab_player_unpressed.png");
	public static final ImageIcon TAB_TEAM_UNPRESSED=new ImageIcon("images/tab_team_unpressed.png");
	public static final ImageIcon TAB_MATCH_UNPRESSED=new ImageIcon("images/tab_match_unpressed.png");
	public static final ImageIcon TAB_HOT_UNPRESSED=new ImageIcon("images/tab_hot_unpressed.png");
	public static final ImageIcon TAB_ABOUT_UNPRESSED=new ImageIcon("images/tab_about_unpressed.png");
	public static final ImageIcon TAB_PLAYER_PRESSED=new ImageIcon("images/tab_player_pressed.png");
	
	public static final ImageIcon INTRO_PAGE_BG=new ImageIcon("images/intro_page_bg.png");
	public static final ImageIcon PLYAER=new ImageIcon("images/player.jpg");
	
	public static ArrayList<ImageIcon> motions=new ArrayList<ImageIcon>();
	public static final Icon SPLASH_TITLE=new ImageIcon("images/splash_title.png");
	public static final Icon SPLASH_BACKGROUND=new ImageIcon("images/splash_bg.png");
	
	public static final ImageIcon PLAYERGROUND=new ImageIcon("images/playerground.png");
	public static final ImageIcon SMOKE=new ImageIcon("images/smoke.gif");
	public static final ImageIcon RAIN=new ImageIcon("images/rain.gif");
	
	public static final ImageIcon PLAYER_SELECTION_SORT_BACKGROUND=new ImageIcon("images/player_selection_sort_bg.png");
	public static final ImageIcon PLAYER_SELECTION_BACKGROUND=new ImageIcon("images/player_selection_bg_1.png");
	public static final ImageIcon TOP_TAB_BACKGROUND=new ImageIcon("images/top_tab_background_1.png");
	public static final ImageIcon WELCOME=new ImageIcon("images/welcome.png");
	public static final ImageIcon TEAM_SELECTION_BACKGROUND=new ImageIcon("images/team_selection_bg_1.png");
	public static final ImageIcon CLOSE_ICON=new ImageIcon("images/close.png");
	public static final ImageIcon TOP_LINE=new ImageIcon("images/top_line.png");
	public static final ImageIcon LABEL_FOREGROUND=new ImageIcon("images/label_foreground.png");
	
	//match界面所有的icon
	public static final ImageIcon MATCH_SELECTION_BACKGROUND=new ImageIcon("images/match_selection_bg_1.png");
	public static final ImageIcon SCHEDULE=new ImageIcon("images/schedule.png");
	public static final ImageIcon TEAM_SELECTION=new ImageIcon("images/select_team.png");
	
	
	public static final ImageIcon HOT_SELECTION_BACKGROUND=new ImageIcon("images/hot_selection_bg_1.png");
	public static final ImageIcon LABEL_CALENDAR_BACKGROUND=new ImageIcon("images/label_calendar_bg_1.png");
	
	public static final ImageIcon CIRCLE_EMPTY=new ImageIcon("images/circle_empty.png");
	public static final ImageIcon CIRCLE_FULL=new ImageIcon("images/circle_full.png");
	
	public static final ImageIcon HOT_SELECTION_PROTECTION=new ImageIcon("images/hot_selection_protection.png");
	public static final ImageIcon TEAM_DETAIL_BACKGOURND=new ImageIcon("images/team.png");
	public static final ImageIcon DETAIL_BG=new ImageIcon("images/detail_bg.png");
	public static final ImageIcon NULL=new ImageIcon("images/null.png");
	public static final ImageIcon HEAD_DETAIL_BG=new ImageIcon("images/detail_head_bg.png");
	
	public static ArrayList<ImageIcon> getLoadingMotions(){
		for(int i=1;i<100;i++){
			motions.add(new ImageIcon("images/loading_motions/"+i+".png"));	
		}			
		return motions;
	}
	
	public static ArrayList<ImageIcon> getPlayers(){
		ArrayList<ImageIcon> icons=new ArrayList<>();
		for(int i=0;i<10;i++){
			icons.add(new ImageIcon("images/players/"+i+".jpg"));
		}
		
		return icons;
	}
	
	public static ArrayList<ImageIcon> getRains(){
		ArrayList<ImageIcon> icons=new ArrayList<>();
		for(int i=0;i<10;i++){
			icons.add(new ImageIcon("images/rains/"+i+".png"));
		}
		
		return icons;
	}
	
	public static final ImageIcon CALENDAR_BACKGROUND=new ImageIcon("images/calendar_bg.png");
	
	public static void setLatestSeason(Season season){
		Config.LASTEST_SEASON = season;
	}
	
	
}

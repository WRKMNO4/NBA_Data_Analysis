package PO;

import java.util.ArrayList;

import Enum.Season;

public class SeasonListPO {
	 static ArrayList<SeasonPO> seasons;
	 
	 public SeasonListPO(){
		 seasons= new ArrayList<SeasonPO>();
		 seasons.add(new SeasonPO(Season.season12_13));
		 seasons.add(new SeasonPO(Season.season13_14));
		 seasons.add(new SeasonPO(Season.season14_15));
		 
	 }
	 
	 public static SeasonPO findSeasonByYear(String key){
		 if(key.substring(0,5).equals("12-13"))
			 return seasons.get(0);
		 else if(key.substring(0,5).equals("13-14"))
			 return seasons.get(1);
		 else if(key.substring(0,5).equals("14-15"))
			 return seasons.get(2);
		 else
			 return null;
	 }
	 public static void addMatch(Season season,MatchPO oneMatch){
		 SeasonPO theSeason = getSeasonPO(season) ;
		 theSeason.addMatch(oneMatch);
	 }
   
	 public static MatchPO findMatch(Season season,String date,String nameOfTeams){
		SeasonPO theSeason = getSeasonPO(season) ;
		return theSeason.findMatch(date,nameOfTeams) ;
		
	 }
	 
	 public static ArrayList<MatchPO> getMatchesOfOneSeason(Season season){
		 SeasonPO theSeason=getSeasonPO(season);
		 return theSeason.getMatches();
	 }
	 
	 public static ArrayList<MatchPO> getMatchesOfOneDay(Season season,String date){
		 ArrayList<MatchPO> matches=getMatchesOfOneSeason(season);
		 ArrayList <MatchPO> matchesOfOneDay=new ArrayList<>();
		 for(int i=0;i<matches.size();i++){
			 MatchPO oneMatch=matches.get(i);
			 if(oneMatch.getDate().equals(date))
				 matchesOfOneDay.add(oneMatch);
		 }
		 return matchesOfOneDay;
	 }
	 
	 static SeasonPO getSeasonPO(Season season){
		 switch(season){
		 case season12_13:
			 return seasons.get(0) ;
		 case season13_14 :
			 return seasons.get(1) ;
		 case season14_15 :
			 return seasons.get(2) ;
		 default :
			 return null ;
		 }
	 }
}

package BusinessLogic.Statistics;

import java.util.ArrayList;

import org.fife.ui.rtextarea.RTextAreaEditorKit.UpperSelectionCaseAction;

import Enum.PlayerData;
import Enum.Season;
import PO.PlayerDataOfOneMatchPO;
import PO.PlayerPO;

public class StatisticsController implements StatisticsBusinessLogic {
	double[] upperPointOfChi={5.02, 7.38, 9.35, 11.14, 12.83, 14.45, 16.01, 17.53, 19.02, 20.48,
			21.92, 23.34, 24.74, 26.12, 27.49, 28.85, 30.19, 31.53, 32.85, 34.17, 35.48, 36.78, 38.08,
			39.36, 40.65, 41.92, 43.19, 44.46, 45.72, 46.98};
	
	@Override
	public boolean ifStableThanSelf(PlayerPO player, PlayerData dataType, Season season) {
		ArrayList<Double> datas = addToArray(player, dataType, season) ;
		ArrayList<Double> pastDatas = addToArray(player, dataType, getFormerSeason(season));
		
		if(datas.size()>30)
			datas = new ArrayList<>(datas.subList(0, 30));
		
		double chi_2 = (datas.size() - 1) * BasicCalculation.getS(datas) / 
				BasicCalculation.getVar(pastDatas);
		if (chi_2 >= upperPointOfChi[datas.size()-1-1])
			return true;
		else
			return false;
	}

	// Alpha = 0.01
	@Override
	public boolean ifBetterThanSelf(PlayerPO player, PlayerData dataType, Season season) {
		ArrayList<Double> datas = addToArray(player, dataType, season);
		ArrayList<Double> pastDatas = addToArray(player, dataType, getFormerSeason(season));
		
		if(datas.size()>30)
			datas = new ArrayList<>(datas.subList(0, 30));
		
		double Z = (BasicCalculation.getAvg(datas) - BasicCalculation.getAvg(pastDatas)) 
				* Math.sqrt(datas.size()) / Math.sqrt(BasicCalculation.getS(datas)) ;
		if(Z >= 2.33)
			return true;
		else
			return false;
	}

	@Override
	public boolean ifStableThanAnother(PlayerPO player, PlayerPO anotherPlayer,
			PlayerData dataType, Season season) {
		ArrayList<Double> datas = addToArray(player, dataType, season);
		ArrayList<Double> anotherData = addToArray(anotherPlayer, dataType, season);
		if(BasicCalculation.getS(datas) < BasicCalculation.getS(anotherData) )
			return true; 
		else 
			return false;
	}

	@Override
	public boolean ifBetterThanAnother(PlayerPO player, PlayerPO anotherPlayer,
			PlayerData dataType, Season season) {
		ArrayList<Double> datas = addToArray(player, dataType, season);
		ArrayList<Double> anotherDatas = addToArray(anotherPlayer, dataType, season);
		
		double divisor_2 = BasicCalculation.getS(datas) / datas.size() 
				+ BasicCalculation.getS(anotherDatas) / anotherDatas.size();
		double Z = (BasicCalculation.getAvg(datas) - BasicCalculation.getAvg(anotherDatas))
				/ Math.sqrt(divisor_2);
		if(Z >= 0.05)
			return true;
		else
			return false;
	}
	
	public Season getFormerSeason(Season season){
		for(int i = 0;i < Season.values().length;i++){
			if(Season.values()[i] == season && i > 0)
				return Season.values()[i-1];
		}
		return season;
	}
	
	public static void main(String[] args){
		StatisticsController s = new StatisticsController();
		System.out.println(s.getFormerSeason(Season.season12_13));
	}
	
	public ArrayList<Double> addToArray(PlayerPO player, PlayerData dataType, Season season){
		ArrayList<Double> datas = new ArrayList<>();
		ArrayList<PlayerDataOfOneMatchPO> records = player.getSeasonInfo(season).getDatas();
		
		switch (dataType){
		case score:
			for(PlayerDataOfOneMatchPO tmp: records)
				datas.add(tmp.getScoreOfOneMatch());
			break;
		case numberOfRebound:
			for(PlayerDataOfOneMatchPO tmp: records)
				datas.add(tmp.getNumberOfReboundOfOneMatch());
			break;
		case numberOfSteal:
			for(PlayerDataOfOneMatchPO tmp: records)
				datas.add(tmp.getNumberOfSteal());
			break;
		case numberOfAssist:
			for(PlayerDataOfOneMatchPO tmp: records)
				datas.add(tmp.getNumberOfAssistOfOneMatch());
			break;
	}
		return datas;
	}
}

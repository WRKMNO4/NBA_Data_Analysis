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
	public boolean ifStableThenSelf(PlayerPO player, PlayerData dataType, Season season) {
		ArrayList<Double> datas = new ArrayList<>();
		ArrayList<PlayerDataOfOneMatchPO> records = player.getSeasonInfo(season).getDatas();
		//888888888888888888888888888888888888
		ArrayList<PlayerDataOfOneMatchPO> pastRecords = player.getSeasonInfo(season).getDatas();
		switch(dataType){
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
		if(datas.size()>30)
			datas = new ArrayList<>(datas.subList(0, 30));
		
		return false;
	}

	@Override
	public boolean ifBetterThenSelf(PlayerPO player, PlayerData dataType, Season season) {
		
		return false;
	}

	@Override
	public boolean ifStableThenAnother(PlayerPO player, PlayerPO anotherPlayer,
			PlayerData dataType, Season season) {
		
		return false;
	}

	@Override
	public boolean ifBetterThenAnother(PlayerPO player, PlayerPO anotherPlayer,
			PlayerData dataType, Season season) {
		
		return false;
	}
	
	public static void main(String[] args){
		StatisticsController s = new StatisticsController();
		System.out.println(s.upperPointOfChi[29]);
	}
}

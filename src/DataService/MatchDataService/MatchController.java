package DataService.MatchDataService;

import java.io.File;
import java.util.ArrayList;

import DataService.FileHelper.FileHelper;
import PO.MatchListPO;
import PO.MatchPO;

public class MatchController implements MatchDataService{
	MatchListPO matchs ;
	
	public MatchController(){
		read("迭代一数据/matches") ;
	}
	void read(String fileName){
		File file = new File(fileName) ;
		if(file.isDirectory()){
			File[] allFiles = file.listFiles() ;
			for(int i = 0; i<allFiles.length;i++){
				ArrayList<String> tempString  = FileHelper.readByLine(allFiles[i]) ;
				MatchPO newMatch = new MatchPO() ;
				for(int j = 0;j<tempString.size() ;j++){
					
				}
			}
		}
	}
	@Override
	public void addMatch(MatchPO oneMatch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MatchPO findMatchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

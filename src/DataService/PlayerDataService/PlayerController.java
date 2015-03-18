package DataService.PlayerDataService;

import java.io.File;
import java.util.ArrayList;

import DataService.FileHelper.FileHelper;
import Enum.ResultMessage;
import PO.PlayerListPO;
import PO.PlayerPO;

public class PlayerController implements PlayerDataService{

	public PlayerListPO players ;
	
	public PlayerController(){
		players= new PlayerListPO();
		read("迭代一数据/players/info");
	}
	
	public void read(String fileName){
		File file=new File(fileName);
		if(file.isDirectory()){
			File[] allFiles=file.listFiles();
			for(int i=0;i<allFiles.length;i++){    //遍历info文件夹里的所有文件
				ArrayList<String> tempString=FileHelper.readByLine(allFiles[i]);
				PlayerPO newPlayer=new PlayerPO();
				for(int j=0;j<tempString.size();j++){
					if(j%2==0)
						continue;
					String data=FileHelper.analysisOfOneLine(tempString.get(j)).get(1);
					switch(j){
					case 1: newPlayer.setName(data); break;
					case 3: newPlayer.setNumber(data); break;
					case 5: newPlayer.setPosition(data); break;
					case 7: newPlayer.setHeight(data); break;
					case 9: newPlayer.setWeight(data); break;
					case 11: newPlayer.setBirth(data); break;
					case 13: newPlayer.setAge(data);
					        break;
					case 15: 
						     newPlayer.setExp(data); break;
					case 17: newPlayer.setSchool(data); break;
					default: break;
					}
				}
				newPlayer.setPortraitURL("迭代一数据/players/portrait/"+newPlayer.getName()+".png");
				newPlayer.setActionURL("迭代一数据/players/action/"+newPlayer.getName()+".png");
			
				players.addPlayer(newPlayer) ;
			}
			
		}
		
	}
	
	@Override
	public ResultMessage addPlayer(PlayerPO onePlayer) {
		// TODO Auto-generated method stub
		return players.addPlayer(onePlayer) ;
	}

	@Override
	public PlayerPO findPlayerByName(String name) {
		// TODO Auto-generated method stub
		return players.findPlayerByName(name);
	}

	public ArrayList<PlayerPO> getAllPlayers() {
		return players.getAllPlayers();
	}
	
	

}

package BusinessLogic.BLService;

import java.util.ArrayList;

import Enum.PlayerData;
import Enum.Season;
import Enum.TeamData;
import Enum.Zone;
import PO.MatchPO;
import PO.PlayerPO;
import PO.StandingDataPO;
import PO.TeamPO;

public interface BLService {
	public void init();
	public ArrayList<PlayerPO> getAllPlayers() ;
	public ArrayList<TeamPO> getAllTeams() ;
	/**
	 * 
	 * @param standard 标准（总数据、场均或姓名）
	 * @param dataType 技术类型
	 * @return 球队的排序结果
	 */
	public ArrayList<PlayerPO> sortPlayersByComprehension(String  standard,PlayerData dataType,Season season) ;
	/**
	 * 
	 * @param standard 标准（总数据、场均或队伍全名或队伍胜率等）
	 * @param dataType 技术类型
	 * @return 球员的排序结果
	 */
	public ArrayList<TeamPO> sortTeamsByComprehension(String standard,TeamData dataType,Season season);
	//以下方法为：根据球员位置、东西部、具体分区和排序依据返回所有满足条件的前50名球员序列,其中standard和dataType参数同排序方法中的参数
	/**
	 * 
	 * @param position 球员位置
	 * @param zone 东西部
	 * @param district 具体分区（界面上可以不选择，如果不选择，则传null）
	 * @param standard 排序依据的标准（总数据、场均或队伍全名或队伍胜率等）
	 * @param dataType 技术类型
	 * @return 球员的筛选结果
	 */
	public ArrayList<PlayerPO> pickUpPlayersByCondition(String position,
			Zone zone, String district, String standard,PlayerData dataType,Season season);
	public ArrayList<PlayerPO> pickUpPlayerByCondition(String position,String league,int lowAge,int highAge,Season season) ;
	/**
	 *  仅限精确查找
	 * @param season 赛季（枚举类型）
	 * @param date 日期（如01-01）
	 * @param nameOfTeams 两队名字（CHA-LAC）
	 * @return 查找的比赛
	 */
	public MatchPO findMatch(Season season,String date,String nameOfTeams) ;
	/**
	 * 
	 * @param name 球员名称
	 * @return 球员列表
	 */
	public ArrayList<PlayerPO> findPlayerByName(String name) ;
	/**
	 * 
	 *  @param dataType 筛选条件
	 * @return 一个球员信息.
	 */
	public StandingDataPO getDatasOfDailyStandingPlayers(PlayerData dataType) ;
	public ArrayList<StandingDataPO> getDatasOfDailyStandingPlayer(PlayerData dataType,int number) ; 
	/**
	 * 
	 * @param season 赛季
	 * @param dataType 筛选条件
	 * @return 前五名球员列表，如果不存在返回null
	 */
	public ArrayList<PlayerPO> getSeasonStandingPlayer(Season season , PlayerData dataType) ;
	public ArrayList<PlayerPO> getSeasonStandingPlayer(Season season,PlayerData dataType,int number) ;
	/**
	 * 
	 * @param season 赛季
	 * @param dataType 筛选条件
	 * @return 返回前五只球队，如果不存在返回null
	 */
	public ArrayList<TeamPO> getSeasonStandingTeam(Season season , TeamData dataType) ;
	public ArrayList<TeamPO> getSeasonStandingTeam(Season season,TeamData dataType,int number) ;
	/**
	 * 
	 * @param season 赛季
	 * @param dataType 筛选条件
	 * @return 返回前五名球员，如果不存在返回null
	 */
	public ArrayList<PlayerPO> getMostImprovePlayer(Season season ,PlayerData dataType) ;
	public ArrayList<PlayerPO> getMostImprovePlayer(Season season,PlayerData dataType,int number) ;
	/**
	 * 
	 * @param season 赛季
	 * @return 返回该赛季所有比赛列表
	 */
	public ArrayList<MatchPO> getAllMatches(Season season);
	/**
	 * 
	 * @return 返回最新的球队信息列表
	 */
	public ArrayList<MatchPO> getLatestTeam();
	/**
	 * 
	 * @param player 传入查询球员
	 * @return 返回该球员在最新赛季最近五场比赛，如少于五场，则传最新赛季所有比赛
	 */
	public ArrayList<MatchPO> getLatest5MatchesForPlayer(PlayerPO player);
	/**
	 * 
	 * @param team 传入查询球队
	 * @return 返回该球队在最新赛季最近五场比赛，如少于五场，则返回最新赛季所有比赛
	 */
	public ArrayList<MatchPO> getLatest5MatchesForTeam(TeamPO team);
	/**
	 * 
	 * @param season
	 * @param zone 分为Zone.W(西部) 和 Zone.E(东部)
	 * @return 返回按排名排下来的TeamPO数组
	 */
	
	public ArrayList<TeamPO> getTeamRankings(Season season, Zone zone);
	
	/**
	 * 
	 * @param sesaon 输入赛季
	 * @return  返回该赛季所有球员的场均得分，场均篮板，场均助攻，场均抢断，场均盖帽，场均失误，场均犯规列表
	 */
	public ArrayList<Double> getSeasonAvgData(Season season);
	
	/**
	 * 
	 * @param dataType 想要得到的数据类型，仅限于：命中率，效率，使用率，失误率
	 * @param player 想要查询的PlayerPO
	 * @return 返回该球员在所有赛季中的该个数据类型的数据
	 */
	public ArrayList<Double> getAllSeasonsDataOfOnePlayer(PlayerData dataType ,PlayerPO player) ;
	
	/**
	 * 
	 * @param dataType  想要得到的数据类型，仅限于：命中率，效率，使用率，失误率
	 * @param player 想要查询的PlayerPO
	 * @param season 想要得到的赛季
	 * @return 返回该球员在该赛季中所有比赛的该个数据类型的数据
	 */
	public ArrayList<Double> getAllMatchesDataOfOnePlayerOfOneSeason(PlayerData dataType,PlayerPO player,Season season) ;
	/**
	 * 
	 * @return 球员的高阶数据排名(如RPM等)
	 */
	public ArrayList<ArrayList<String>> getPlayerHighInfo();
	/**
	 * 
	 * @param 球队简写
	 * @return 该球队近三年排名
	 * mei yong le
	 */
	public ArrayList<Integer> getRankingOfOneTeamIn3Years(String teamShortName);
	/**
	 * 
	 * @param player 某球员
	 * @param dataType 只限得分、篮板、抢断、助攻
	 * @param season 赛季
	 * @return 推测是否比上赛季的自己稳定，是则返回true，否则返回false.
	 */
	public boolean ifStableThanSelf(PlayerPO player,PlayerData dataType, Season season);
	/**
	 * 
	 * @param player 某球员
	 * @param dataType 只限得分、篮板、抢断、助攻
	 * @param season 赛季
	 * @return 推测是否比上赛季的自己有进步，是则返回true，否则返回false.
	 */
	public boolean ifBetterThanSelf(PlayerPO player,PlayerData dataType, Season season);
	/**
	 * 
	 * @param player 自身
	 * @param anotherPlayer 另一位球员
	 * @param dataType 只限得分、篮板、抢断、助攻
	 * @param season 赛季
	 * @return 推测是否比另一位球员稳定，是则返回true，否则返回false
	 */
	public boolean ifStableThanAnother(PlayerPO player, PlayerPO anotherPlayer, PlayerData dataType, Season season);
	/**
	 * 
	 * @param player 自身
	 * @param anotherPlayer 另一位球员
	 * @param dataType 只限得分、篮板、抢断、助攻
	 * @param season 赛季
	 * @return 推测是否比另一位球员优秀，是则返回true，否则返回false
	 */
	public boolean ifBetterThanAnother(PlayerPO player, PlayerPO anotherPlayer, PlayerData dataType, Season season);
	/**
	 * 
	 * @param fullName 球队的全名！
	 * @return 球队的排名数组(数组大小是14，a[0]是2002年的排名......a[13]是2015年的排名)
	 */
	public int[] getgetRanksOfTeamByTeamFullName(String fullName);
	/**
	 * 
	 * @param 数据类型（得分、篮板、抢断、助攻） 
	 * @return 球员某一数据的均值的参数估计
	 */
	public double getEstimatedAvgData(PlayerPO player, PlayerData dataType);
	/**
	 * 
	 * @param 数据类型（得分、篮板、抢断、助攻）
	 * @param 球员某一数据的方差的参数估计
	 * @return
	 */
	public double getEstimatedVarData(PlayerPO player, PlayerData dataType);
	
	public double getMaxDataOfAllTeams(Season season, TeamData dataType);
}

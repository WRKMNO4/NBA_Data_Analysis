package MySqlTest;

/**
 * @author ：陶伟基 ，微博：http://weibo.com/taoandtao
 * @date ：2012/12/11
 * @place：广州大学华软软件学院
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
 
 
public class MysqlDemo {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String createPlayerTable;
        String createTeamTable ;
        String createMatchTable ;
        String createScores ; //每场比赛的每节比分
        String createPlayerDataOfOneMatchTable ;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建javademo数据库
        String url = "jdbc:mysql://localhost:3306/NBA_DATA?"
                + "user=root&password=941104&useUnicode=true&characterEncoding=UTF8";
 
        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or：
            // new com.mysql.jdbc.Driver();
 
            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            System.out.println("成功建表");
            Statement stmt = conn.createStatement();
            createPlayerTable = "create table players(name varchar(30),number int(3),position varchar(10),height varchar(20),weight int(3),birth char(12),"
            		+ "age int(3),exp int(2),school varchar(50),portraitURL varchar(100),actionURL varchar(100),primary key(name))";
       
            createTeamTable = "create table teams(fullName varchar(20),shortName char(3),city varchar(20),zone char(1),district varchar(20),homeCourt varchar(30),timeOfEstablishment year,teamLogoURL varchar(100),primary key(shortname))";
       
            createMatchTable = "create table matches(matchID int(6),time date,firstTeam char(3),secondTeam char(3),firstScore int(3),"
            		+ "secondScore int(3),primary key(matchID))";
         
            createScores = "create table scroesofonematch(matchID int,scoreID int,firstScore int(3),secondScore int(3),primary key(matchID ,scoreID))" ;
           
            createPlayerDataOfOneMatchTable = "create table playerdataofonematch(matchID int ,team char(3),name varchar(30),position char(1),ifStarting int(1),persentTime varchar(10),numberOfShooting int,numberOfShotAttempt int,"
            		+ "numberOf3_point int, numberOf3_pointAttempt int,numberOfFreeThrow int, numberOfFreeThrowAttempt int ,numberOfAttackRebound int,numberOfDefenseRebound int ,numberOfRebound int ,numberOfAssist int ,numberOfSteal int ,numberOfBlock int ,numberOfFault int,"
            		+ "numberOfFoul int ,score int, primary key(matchID,team ,name))" ;
            		
//            int result1 = stmt.executeUpdate(createPlayerTable);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
//            int result2= stmt.executeUpdate(createTeamTable) ;
//            int  result3 =stmt.executeUpdate(createScores) ;
//            int result4 = stmt.executeUpdate(createPlayerDataOfOneMatchTable) ;
            int result5 = stmt.executeUpdate(createMatchTable) ;
            int result =result5;
            if (result != -1) {
                System.out.println("创建数据表成功");
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if(conn!=null)
        		conn.close();
        }
 
    }
    
}
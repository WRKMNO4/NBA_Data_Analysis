package com.nba;

import com.kmno4.common.Config;

public class Main {
   
	public static void main(String[] args){
//		Console console = new Console() ;
//		console.execute(System.out, args);
		String[][] body = new String[2][13] ;
		body[0] = Config.PLAYER_SORT_TOTAL ;
		System.out.println(body[0][12]);
    }
}

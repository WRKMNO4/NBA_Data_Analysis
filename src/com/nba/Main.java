package com.nba;

import com.kmno4.common.Config;

public class Main {
   
	public static void main(String[] args){
		Console console = new Console() ;
		String com = "-player -all -n 50 -total ";
		console.execute(System.out, new String[]{"--datasource","E:/Data"});
		console.execute(System.out,com.split(" "));
    }
}

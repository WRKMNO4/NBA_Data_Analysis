package DataService.FileHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class FileHelper {
	public static ArrayList<String> readByLine(File file){
		ArrayList<String> content=new ArrayList<String>();
		
		BufferedReader reader;
		try {
			String tempString;
			reader=new BufferedReader(new FileReader(file));
			
			while((tempString = reader.readLine()) != null){
				
				content.add(tempString);
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return content;
		
	}
	
	public static ArrayList<String> analysisOfOneLine(String oneLine){   //解析每行数据
		ArrayList<String> results=new ArrayList<String>();
		oneLine=oneLine.substring(1,oneLine.length()-1);
		String[] eachString=oneLine.split("│");
		for(int i=0;i<eachString.length;i++){     //去掉空格
			results.add(eachString[i].trim());
		}
		
		return results;
		
	}
}

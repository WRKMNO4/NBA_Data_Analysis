package BusinessLogic.Statistics;

import java.util.ArrayList;

public class BasicCalculation {
	public static double getAvg(ArrayList<Double> list){
		double result = 0;
		for(double tmp : list)
			result += tmp;
		return result/list.size();
	}
	
	public static double getVar(ArrayList<Double> list){
		double result = 0;
		double avg = getAvg(list);
		for(double tmp: list)
			result += (tmp - avg) * (tmp - avg);
		return result/list.size();
	}
	//样本方差
	public static double getS(ArrayList<Double> list){
		double result = 0;
		double avg = getAvg(list);
		for(double tmp: list)
			result += (tmp - avg) * (tmp - avg);
		return result/(list.size() -1 );
	}
	
}

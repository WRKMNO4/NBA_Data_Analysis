package com.kmno4.presentation.table;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * 使表头可以执行简单升降序的一个model
 * @author hutao
 *
 */
public class SortModel {
	private final int begin, end, groupNum;
	/**
	 * @param begin 响应起始表头下标
	 * @param end 响应结尾表头下标
	 */
	public SortModel(int begin, int end) {
		this.begin = begin;
		this.end = end;
		this.groupNum = 1;
		currentSortNum = -1;
		sortStandrad = NONE;
	}
	/**
	 * @param begin 响应起始表头下标
	 * @param end 响应结尾表头下标
	 * @param groupNum 排序时多少行为一组，排序依据一组内的第一行为准
	 */
	public SortModel(int begin, int end, int groupNum) {
		this.begin = begin;
		this.end = end;
		this.groupNum = groupNum;
		currentSortNum = 1;
		sortStandrad = NONE;
	}
	/**
	 * 点击了某表头发生排序之后，该model发生的反应
	 */
	public boolean sortFired(int clickedNum) {
		if(clickedNum < begin || clickedNum > end) return false;
		if(clickedNum != currentSortNum) {
			currentSortNum = clickedNum;
			sortStandrad = UP;
		}
		else
			if(sortStandrad ++ > UP)
				sortStandrad = DOWN;
		return true;
	}
	
	public int getCurrentSortNum() { return currentSortNum; }
	public int getSortStandard() { return sortStandrad; }
	public int getGroupNum() { return groupNum; }
	private int currentSortNum;
	private int sortStandrad;
	private static final int 
	    UP = 1,
	    NONE = 0,
	    DOWN = -1;
	//TODO考虑球队 +对手 2行一组的情况
	public static TableModel sortTableModel(DefaultTableModel tableModel, SortModel sortModel,
			int sortNum, DefaultTableModel defaultTableModel) {
		if(!sortModel.sortFired(sortNum)) return tableModel;
		int groupNum = sortModel.getGroupNum();
		switch(sortModel.sortStandrad) {
		case SortModel.NONE :
			return defaultTableModel;
		default :
//			@SuppressWarnings("unchecked")
			Vector<Vector<Object>> v = tableModel.getDataVector();
			Object[][] body = new Object[v.size()][v.get(0).size()];
			Object[] head = new Object[v.get(0).size()];
			int groups = v.size() / groupNum;
			Map<Double, Integer> map = new TreeMap<Double, Integer>(new Comparator<Double>() {
				@Override
				public int compare(Double o1, Double o2) {
					return myCompare(o1, o2, sortModel.sortStandrad);
				}
			});
			for(int i = 0; i < groups - 1; i ++) {
				map.put(Double.parseDouble(v.get(i * groupNum).get(sortNum).toString()),
						new Integer(i * groupNum));
			}
			Iterator<Double> iter = map.keySet().iterator();
			int g = 0;
			while(iter.hasNext()) {
				Double d = iter.next();
				Integer i = map.get(d);
				for(int j = 0; j < sortModel.groupNum - 1; j ++)
					body[g * groupNum + j] = v.get(i + j).toArray();
				g ++;
				System.out.println(g);
			}
			for(int i = 0; i < head.length - 1; i ++) {
				head[i] = "";
			}
			
			
			return new DefaultTableModel(body, head);
		}
		
	}
	
	private static int myCompare(Double d1, Double d2, int model) {
		if((d1 > d2 && model == SortModel.UP) || (d1 < d2 && model == SortModel.DOWN)) return 1;
		if(d1 == d2) return 0;
		else return -1;
	}
	
	public static void main(String[] args) {
		DefaultTableModel t = (DefaultTableModel)SortModel.sortTableModel(
				new DefaultTableModel(new String[][] {{"1", "2", "3"},{"3", "2", "1"},{"3", "1", "2"}}, new String[]{"", "", ""}),
				new SortModel(0, 2, 1),
				2,
				null);
		Vector<Vector<Object>> v = t.getDataVector();
		for(Vector<Object> vv : v) {
			System.out.println(vv.get(2).toString());
		}
	}
}

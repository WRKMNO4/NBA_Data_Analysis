package com.kmno4.presentation.table;

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
	 * @param groupNum 排序时多少行为一组
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
	public static TableModel sortTableModel(TableModel tableModel, SortModel sortModel,
			int sortNum, TableModel defaultTableModel) {
		if(!sortModel.sortFired(sortNum)) return tableModel;
		String[][] body = null;
		String[] head = null;
		switch(sortModel.sortStandrad) {
		case SortModel.NONE :
			return defaultTableModel;
		case SortModel.UP :
			return new DefaultTableModel(body, head);
		case SortModel.DOWN :
			return new DefaultTableModel(body, head);
		default :
		}
		return null;
		
	}
}

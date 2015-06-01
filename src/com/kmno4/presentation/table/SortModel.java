package com.kmno4.presentation.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
			if(++ sortStandrad > UP)
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
	/**
	 * 
	 * @param tableModel 原model（包括变换过的）
	 * @param sortModel 
	 * @param sortNum 排序的列数
	 * @param defaultTableModel 默认即最初的model
	 * @return
	 */
	public static TableModel sortTableModel(DefaultTableModel tableModel, SortModel sortModel,
			int sortNum, DefaultTableModel defaultTableModel) {
		if(!sortModel.sortFired(sortNum)) return tableModel;
		int groupNum = sortModel.getGroupNum();
		switch(sortModel.sortStandrad) {
		case SortModel.NONE :
			return defaultTableModel;
		default :
			@SuppressWarnings("unchecked")
			Vector<Vector<Object>> v = tableModel.getDataVector();
			Object[][] body = new Object[v.size()][v.get(0).size()];
			Object[] head = new Object[v.get(0).size()];
			//第一行为表头
			int groups = (v.size() - 1) / groupNum;
			
			class Couple implements Comparator<Couple> {
				public int num;
				public double value;
				public Couple(int num, double value) {
					this.num = num;
					this.value = value;
				}
				private int model;
				public Couple(int model) {
					this.model = model;
				}
				@Override
				public int compare(Couple o1, Couple o2) {
					if((o1.value > o2.value && model == SortModel.UP) || (o1.value < o2.value && model == SortModel.DOWN)) return -1;
					if(o1.value == o2.value) return 0;
					else return 1;
				}
			}
			ArrayList<Couple> al = new ArrayList<Couple>();
			for(int i = 1; i < groups + 1; i ++) {
				al.add(new Couple(new Integer(i * groupNum),
						Double.parseDouble(v.get(i * groupNum).get(sortNum).toString())));
			}
			Collections.sort(al, new Couple(sortModel.sortStandrad));
			body[0] = v.get(0).toArray();
			for(int i = 0; i < al.size(); i ++) {
				for(int j = 0; j < groupNum; j ++) {
					body[1 + i * groupNum + j] = v.get(al.get(i).num + j).toArray();
				}
			}
			
			
			for(int i = 0; i < head.length; i ++) {
				head[i] = "";
			}
			
			
			return new DefaultTableModel(body, head);
		}
		
	}
	
	public static void main(String[] args) {
		SortModel s = new SortModel(0, 2, 1);
		DefaultTableModel t = (DefaultTableModel)SortModel.sortTableModel(
				new DefaultTableModel(new String[][] {{"a", "a", "a"},{"1", "2", "3.3"},{"3", "2", "1.1"},{"3", "1", "2.2"},{"3", "2", "5.5"}}, new String[]{"", "", ""}),
				s,
				2,
				null);
		@SuppressWarnings("unchecked")
		Vector<Vector<Object>> v = t.getDataVector();
		for(Vector<Object> vv : v) {
			System.out.println(vv.get(2).toString());
		}
	}
}

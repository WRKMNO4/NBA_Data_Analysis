package com.kmno4.presentation.table;
/**
 * 用于给sortTable响应事件后的表格样式更新
 * @author hutao
 *
 */
public interface OtherSet {
	/**
	 * 更新的方法
	 */
	public void reset();
	/**
	 * 设置tablegroup
	 * @param tg
	 */
	public void setTableGroup(TableGroup tg);

}

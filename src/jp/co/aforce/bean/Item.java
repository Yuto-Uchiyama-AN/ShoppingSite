package jp.co.aforce.bean;

import java.io.Serializable;

public class Item implements Serializable {

	private SweetBean sweetbean;
	private int count;

	public SweetBean getSweetBean() {
		return sweetbean;
	}

	public int getCount() {
		return count;
	}

	public void setSweetBean(SweetBean sweetbean) {
		this.sweetbean=sweetbean;
	}

	public void setCount(int count) {
		this.count=count;
	}


}

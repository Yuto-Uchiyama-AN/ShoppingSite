package jp.co.aforce.bean;

import java.io.Serializable;

public class SweetBean implements Serializable{
	private String id;
	private String name;
	private int price;
	private String info;
	private String imgname;

	public SweetBean() {}

	public SweetBean(String name, int price, String info, String imgname) {
		this.name = name;
		this.price = price;
		this.info = info;
		this.imgname = imgname;
	}

	public SweetBean(String id, String name, int price, String info, String imgname) {
		this(name,price,info,imgname);
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
}

package com.entity;

public class Nav {
	private String nav_id;// varchar(36) primary key comment '分类的主键UUID',
	private String nav_name;//varchar(50) not null comment '分类的名称',
    private int nav_feight;// int default 999 comment '排序的权重，越大越往后'
	public String getNav_id() {
		return nav_id;
	}
	public void setNav_id(String nav_id) {
		this.nav_id = nav_id;
	}
	public String getNav_name() {
		return nav_name;
	}
	public void setNav_name(String nav_name) {
		this.nav_name = nav_name;
	}
	public int getNav_feight() {
		return nav_feight;
	}
	public void setNav_feight(int nav_feight) {
		this.nav_feight = nav_feight;
	}
}

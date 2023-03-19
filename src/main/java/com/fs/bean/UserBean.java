package com.fs.bean;

public class  UserBean
{
	private String id = null;
	private String name = null;
	private String surname = null;
	public UserBean() {
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSurname() {
		return surname;
	}
	public String toString() {
		return super.toString()+"{"+id+","+name+","+surname+"}";
	}
}

package com.jspider.Student_CRUD_with_prepared.dto;


/**
 * @author Samiran
 */
public class Student {
	/*
	 * private variable
	 */
	private int sId;
	private String sName;
	private String sEmail;
	private long sPhone;
	/*
	 * no argument constructor
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * Parameterized constructor
	 */
	public Student(int sId, String sName, String sEmail, long sPhone) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sEmail = sEmail;
		this.sPhone = sPhone;
	}
	
	/*
	 * getter & setter methods for private members
	 */
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public long getsPhone() {
		return sPhone;
	}
	public void setsPhone(long sPhone) {
		this.sPhone = sPhone;
	}
	
	
	
}

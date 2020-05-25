package com.bday.portal.model;





import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bday")
public class Bday {

	private long eid;
	private String name;
	private String email;
	private Date dob;
	private String date1;
	
	public Bday() {
		
	}
	
	public Bday(String name, String email, Date dob,String date1) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.date1= date1;
	}
	
	
	

	@Id
	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "dob", nullable = false)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Column(name = "date1")
	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	@Override
	public String toString() {
		return "Bdays {" + "eid=" + eid + ", name=" + name + ", email=" + email + ", dob=" + dob
				+ "}";
	}
	
}


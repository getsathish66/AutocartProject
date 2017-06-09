	package com.niit.autocart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity 
@Table(name = "Supplier") 
@Component 
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	
	
	private String suppliername;
	private String supplierdescription;
	private String address;
	private String email;
	private String contact;
	private String citycode;
	
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplierdescription() {
		return supplierdescription;
	}
	public void setSupplierdescription(String supplierdescription) {
		this.supplierdescription = supplierdescription;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
}
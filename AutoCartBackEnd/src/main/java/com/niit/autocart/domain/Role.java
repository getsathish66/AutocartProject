package com.niit.autocart.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;
@SuppressWarnings("unused")
@Entity 
@Component 
@Table( name="role" )
public class Role {
	@Id
	@GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator",strategy="foreign",parameters={
    @Parameter(value="user",name="property")})		
	private String id;
    private String name;
    private String mail;
    public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	private String role;
    @OneToOne(cascade=CascadeType.ALL)
   	@JoinColumn(name="id")
       private User user;
    public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
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

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}

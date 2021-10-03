package com.ashi.learning.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;



@Entity
public class Role implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	
	public Role() {
	}

	public Role(Long idLong, String name) {
		this.id = idLong;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setIdg(Long idLong) {
		this.id = idLong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}

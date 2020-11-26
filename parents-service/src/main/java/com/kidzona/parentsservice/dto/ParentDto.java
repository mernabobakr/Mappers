package com.kidzona.parentsservice.dto;

import java.util.Set;

public class ParentDto {
	private int id;


	private FullName fullName;

	private String address;
	private String pictureUrl;
	private String email;
	private Set<KidDto> kids;




	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public Set<KidDto> getKids() {
		return kids;
	}

	public void setKids(Set<KidDto> kids) {
		this.kids = kids;
	}


}
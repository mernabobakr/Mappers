package com.kidzona.parentsservice.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.kidzona.parentsservice.entity.Parent;


public class ParentDto {
	private int id;


	private FullName fullName;

	private String address;
	private String pictureUrl;
	private String email;
	private Set<KidDto> kids;

	 private List<Parent> childrenItems=new ArrayList<Parent>();


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

	public List<Parent> getChildrenItems() {
		return childrenItems;
	}

	public void setChildrenItems(List<Parent> childrenItems) {
		this.childrenItems = childrenItems;
	}


}
package com.kidzona.parentsservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "parents")
public class Parent {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;

	@Column(name = "first_name")
	@NotNull(message = "first name should be provided")
	@NotEmpty(message = "first name can not be empty")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "last name should be provided")
	@NotEmpty(message = "last name can not be empty")
	private String lastName;

	@Column(name = "address")
	@NotNull(message = "address should be provided")
	@NotEmpty(message = "address can not be empty")
	private String address;

	@Column(name = "picture_url")
	private String pictureUrl;

	@Column(name = "email", unique = true)
	@NotNull(message = "an Email should be provided")
	@Email(message = "Not a valid email")
	private String email;
	@JsonManagedReference
	@OneToMany(mappedBy = "parent")
	private Set<Kid> kids;
	@OneToOne
	private Parent parent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public Set<Kid> getKids() {
		return kids;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public void setKids(Set<Kid> kids) {
		this.kids = kids;
	}

}
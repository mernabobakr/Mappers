package com.kidzona.parentsservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "kids")
public class Kid {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	@NotNull
	private String firstName;

	@Column(name = "school_address")
	@NotNull
	private String schoolAddress;

	@Column(name = "picture_url")
	private String pictureUrl;

	@Column(name = "birthday")
	@NotNull
	@Past
	private Date birthday;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "parent_id")
	private Parent parent;
	@JsonBackReference
	@OneToMany(mappedBy = "kid")
	private Set<Skill> skills;

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

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

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parentId) {
		this.parent = parentId;
	}
}

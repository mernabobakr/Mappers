package com.kidzona.parentsservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skill")
public class Skill {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	
	@NotNull(message = "skill name should be provided")
	@Column(name = "skill_name",unique=true)
	String skillName;
	public void setKid(Kid kid) {
		this.kid = kid;
	}
	@ManyToOne
	@JsonBackReference
    @JoinColumn(name = "kid_id")
    private Kid kid;
	public int getId() {
		return id;
	}
	public Kid getKid() {
		return kid;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

}
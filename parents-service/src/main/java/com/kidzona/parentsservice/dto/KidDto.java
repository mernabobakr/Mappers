package com.kidzona.parentsservice.dto;

import java.util.Set;


public class KidDto {
	private int id;
	private String name;
	
	private String schoolAddress;
	private Set<SkillDto> skills;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SkillDto> getSkills() {
		return skills;
	}

	public void setSkills(Set<SkillDto> skills) {
		this.skills = skills;
	}



}

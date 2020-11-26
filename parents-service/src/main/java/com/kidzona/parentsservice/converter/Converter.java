package com.kidzona.parentsservice.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kidzona.parentsservice.dto.KidDto;
import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.dto.SkillDto;
import com.kidzona.parentsservice.entity.Kid;
import com.kidzona.parentsservice.entity.Parent;
import com.kidzona.parentsservice.entity.Skill;

import ma.glasnost.orika.MapperFacade;

@Component
public class Converter {
	@Autowired
	MapperFacade mapper;

	public ParentDto convertToDto(Parent parent) {
		ParentDto parentDto = mapper.map(parent, ParentDto.class);
		return parentDto;
	}

	public Parent convertFromDto(ParentDto parentDto) {
		Parent parent = mapper.map(parentDto, Parent.class);
		return parent;
	}

	public KidDto convertToDto(Kid kid) {
		KidDto kidDto = mapper.map(kid, KidDto.class);
		return kidDto;
	}

	public Kid convertFromDto(KidDto kidDto) {
		Kid kid = mapper.map(kidDto, Kid.class);
		return kid;
	}

	public SkillDto convertToDto(Skill skill) {
		SkillDto skillDto = mapper.map(skill, SkillDto.class);
		return skillDto;
	}

	public Skill convertFromDto(SkillDto skillDto) {
		Skill skill = mapper.map(skillDto, Skill.class);
		return skill;
	}
}

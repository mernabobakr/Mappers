package com.kidzona.parentsservice.converter;

import org.modelmapper.ModelMapper;

import com.kidzona.parentsservice.dto.SkillDto;
import com.kidzona.parentsservice.entity.Skill;

public class SkillConverter {

	static ModelMapper mapper = new ModelMapper();

	public static SkillDto convertToDto(Skill skill) {
		SkillDto skillDto = mapper.map(skill, SkillDto.class);
		return skillDto;
	}

	public static Skill convertFromDto(SkillDto skillDto) {
		Skill skill = mapper.map(skillDto, Skill.class);
		return skill;
	}

}

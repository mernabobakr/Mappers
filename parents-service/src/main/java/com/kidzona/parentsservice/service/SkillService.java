package com.kidzona.parentsservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidzona.parentsservice.converter.Converter;
import com.kidzona.parentsservice.dto.SkillDto;
import com.kidzona.parentsservice.entity.Skill;
import com.kidzona.parentsservice.exception.ConflictException;
import com.kidzona.parentsservice.exception.NotFoundException;
import com.kidzona.parentsservice.repository.SkillRepo;
import com.kidzona.parentsservice.repository.KidRepo;

@Service
public class SkillService {
	@Autowired
	private SkillRepo skillRepo;
	@Autowired
	private KidRepo kidRepo;
	@Autowired
	Converter converter;

	public List<SkillDto> findAll() {
		List<Skill> skills = skillRepo.findAll();
		return skills.stream().map(converter::convertToDto).collect(Collectors.toList());
	}

	public Skill addSkil(SkillDto skillDto, int kidId) {
		try {
			Skill skill = converter.convertFromDto(skillDto);
			skill.setKid(kidRepo.getOne(kidId));
			return skillRepo.save(skill);

		} catch (Exception e) {
			throw new ConflictException("You cann't add skill with same name");

		}
	}

	public SkillDto getOne(int id) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			return converter.convertToDto(skillRepo.getOne(id));
		} catch (Exception e) {
			throw new NotFoundException("You cann't add skill with same name");
		}
	}
}

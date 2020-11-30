package com.kidzona.parentsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	public List<Skill> findAll() {
		return skillRepo.findAll();
	}

	public Skill addSkil(Skill skill, int kidId) {
		try {
		skill.setKid(kidRepo.getOne(kidId));
		return skillRepo.save(skill);

	}catch(Exception e){
		throw new ConflictException("You cann't add skill with same name");

	}
	}

	public Skill getOne(int id) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			return skillRepo.getOne(id);
		} catch (Exception e) {
			throw new NotFoundException("You cann't add skill with same name");
		}
	}
	
	
	
}

package com.kidzona.parentsservice.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kidzona.parentsservice.entity.Skill;
import com.kidzona.parentsservice.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	@Autowired
	private SkillService skillService;
	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Skill>> getAllSkill() {
		List<Skill> result=skillService.findAll();
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PostMapping("/{KidId}/new")
	public ResponseEntity<Skill> saveNewSkill(@PathVariable int KidId, @Valid @RequestBody Skill skill) {

		Skill result = skillService.addSkil(skill,KidId);
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}
	
	
}

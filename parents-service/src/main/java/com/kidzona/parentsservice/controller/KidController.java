package com.kidzona.parentsservice.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kidzona.parentsservice.entity.Kid;
import com.kidzona.parentsservice.entity.Skill;
import com.kidzona.parentsservice.service.KidService;

@RestController
@RequestMapping("/kids")
public class KidController {
	@Autowired
	private KidService kidService;

	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Kid>> getAllSkill() {
		List<Kid> result = kidService.findAll();
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@GetMapping("/{id}/skill")
	public ResponseEntity<Set<Skill>> getSkillById(@PathVariable int id) {

		Set<Skill> result = kidService.getAllskillsByKidId(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/{parentId}/new")
	public ResponseEntity<Kid> saveNewKid(@PathVariable int parentId, @Valid @RequestBody Kid kid) {

		Kid result = kidService.saveNewKid(kid, parentId);
		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteParent(@PathVariable int id) {
		kidService.deleteKid(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}

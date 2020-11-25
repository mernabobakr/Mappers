package com.kidzona.parentsservice.controller;

import com.kidzona.parentsservice.dto.KidDto;
import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Kid;
import com.kidzona.parentsservice.entity.Parent;
import com.kidzona.parentsservice.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/parent")
@CrossOrigin
public class ParentController {

	@Autowired
	private ParentService parentService;

	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<ParentDto>> getAllSkill() {
		List<ParentDto> result = parentService.findAll();
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ParentDto> getParentById(@PathVariable int id) {

		ParentDto result = parentService.getParentById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@GetMapping("/parent/{id}")
	public ResponseEntity<ParentDto> getParentByParentId(@PathVariable int id) {

		ParentDto result = parentService.getParentByParentId(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<Parent> saveNewParent(@Valid @RequestBody ParentDto parentDto) {

		Parent result = parentService.saveParent(parentDto);
		return new ResponseEntity<>(result, HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteParent(@PathVariable int id) {
		parentService.deleteParent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@GetMapping("/{id}/kids/all")
	public ResponseEntity<Set<KidDto>> getAllKids(@PathVariable int id) {

		Set<KidDto> result = parentService.getAllKidsByParentId(id);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

}

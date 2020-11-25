package com.kidzona.parentsservice.service;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidzona.parentsservice.converter.KidConverter;
import com.kidzona.parentsservice.converter.ParentConverter;
import com.kidzona.parentsservice.dto.KidDto;
import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Kid;
import com.kidzona.parentsservice.entity.Parent;
import com.kidzona.parentsservice.exception.ConflictException;
import com.kidzona.parentsservice.exception.NotAllowedException;
import com.kidzona.parentsservice.exception.NotFoundException;
import com.kidzona.parentsservice.repository.ParentRepo;
import java.util.List;


@Service
public class ParentService {
	@Autowired
	private ParentRepo parentRepo;
	@Autowired
	ParentConverter parentConverter;
	@Autowired
	KidConverter kidConverter;

	public List<ParentDto> findAll() {
		List<Parent>parentList= parentRepo.findAll();
		 return parentList.stream()
		          .map(parentConverter::convertToDto)
		          .collect(Collectors.toList());
	}

	public ParentDto getParentById(int id) throws NotFoundException {

		try {

			return parentConverter.convertToDto(parentRepo.getOne(id));
		} catch (Exception e) {
			throw new NotFoundException("can't find parent with this id");
		}
	}
 
	public ParentDto getParentByParentId(int id) throws NotFoundException {

		try {

			return parentConverter.convertToDto(parentRepo.getOne(id).getParent());
		} catch (Exception e) {
			throw new NotFoundException("can't find parent with this id");
		}
	}
	public Parent saveParent(ParentDto parentDto) throws ConflictException {
		try {
			return this.parentRepo.save(parentConverter.convertFromDto(parentDto));
		} catch (Exception e) {
			throw new ConflictException("this email already exists");
		}
	}
/*
	public Set<Kid> getAllKidsByParentId(int id) {
		return parentRepo.getOne(id).getKids();
	}
*/
	public Set<KidDto> getAllKidsByParentId(int id) {
		Set<Kid>kids= parentRepo.getOne(id).getKids();
		return kids.stream()
		          .map(kidConverter::convertToDto)
		          .collect(Collectors.toSet());
	}
	public void deleteParent(int id) throws NotAllowedException {

		try {
			parentRepo.deleteById(id);
		} catch (Exception e) {
			throw new NotAllowedException("can't delete parents with existing kids");
		}

	}

}
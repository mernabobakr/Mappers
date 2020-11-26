package com.kidzona.parentsservice.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidzona.parentsservice.converter.Converter;
import com.kidzona.parentsservice.dto.KidDto;
import com.kidzona.parentsservice.dto.SkillDto;
import com.kidzona.parentsservice.entity.Kid;
import com.kidzona.parentsservice.entity.Skill;
import com.kidzona.parentsservice.exception.ConflictException;
import com.kidzona.parentsservice.exception.NotAllowedException;
import com.kidzona.parentsservice.exception.NotFoundException;
import com.kidzona.parentsservice.repository.KidRepo;
import com.kidzona.parentsservice.repository.ParentRepo;

@Service
public class KidService {
	@Autowired
	private KidRepo kidRepo;
	@Autowired
	private ParentRepo parentRepo;
	@Autowired
	Converter converter;

	public List<KidDto> findAll() {
		List<Kid>kids =kidRepo.findAll();
		return kids.stream().map(converter::convertToDto).collect(Collectors.toList());
	}



	public KidDto getKidById(int id) {

		if (!this.kidRepo.existsById(id))
			throw new NotFoundException("can't find parent with this id");

		return converter.convertToDto(kidRepo.getOne(id))  ;
	}
	public Kid saveNewKid(@Valid KidDto kidDto, int parentId) {
		Kid kid =converter.convertFromDto(kidDto);
		kid.setParent(parentRepo.getOne(parentId));

		return kidRepo.save(kid);
	}

	public Set<SkillDto> getAllskillsByKidId(int id) {

		Set<Skill> result = kidRepo.getOne(id).getSkills();
		return result.stream().map(converter::convertToDto).collect(Collectors.toSet());

	}

	public void deleteKid(int id) throws NotAllowedException {

		try {
			kidRepo.deleteById(id);
		} catch (Exception e) {

			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new NotAllowedException("can't delete kids with existing skills");

			}
		}

	}

}

package com.kidzona.parentsservice.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kidzona.parentsservice.entity.Kid;
import com.kidzona.parentsservice.entity.Skill;
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

	public List<Kid> findAll() {
		return kidRepo.findAll();
	}

	public Kid getKidById(int id) {

		if (!this.kidRepo.existsById(id))
			throw new NotFoundException("can't find parent with this id");

		return kidRepo.getOne(id);
	}

	public Kid saveNewKid(@Valid Kid kid, int parentId) {
		kid.setParent(parentRepo.getOne(parentId));

		return kidRepo.save(kid);
	}

	public Set<Skill> getAllskillsByKidId(int id) {
		return kidRepo.getOne(id).getSkills();

	}

	public void deleteKid(int id) throws NotAllowedException {

		try {
			kidRepo.deleteById(id);
		} catch (Exception e) {
			
			if(e instanceof SQLIntegrityConstraintViolationException  ) {
							throw new NotAllowedException("can't delete kids with existing skills");

			}
		}

	}

}

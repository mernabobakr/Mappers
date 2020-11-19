package com.kidzona.parentsservice.service;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kidzona.parentsservice.entity.Kid;
import com.kidzona.parentsservice.entity.Parent;
import com.kidzona.parentsservice.exception.ConflictException;
import com.kidzona.parentsservice.exception.NotAllowedException;
import com.kidzona.parentsservice.exception.NotFoundException;
import com.kidzona.parentsservice.repository.ParentRepo;

@Service
public class ParentService {
	@Autowired
	private ParentRepo parentRepo;

	public List<Parent> findAll() {
		return parentRepo.findAll();
	}

	public Parent getParentById(int id) throws NotFoundException {

		try {

			return parentRepo.getOne(id);
		} catch (Exception e) {
			throw new NotFoundException("can't find parent with this id");
		}
	}

	public Parent saveParent(Parent parent) throws ConflictException {
		try {
			return this.parentRepo.save(parent);
		} catch (Exception e) {
			throw new ConflictException("this email already exists");
		}
	}

	public Set<Kid> getAllKidsByParentId(int id) {
		return parentRepo.getOne(id).getKids();
	}

	public void deleteParent(int id) throws NotAllowedException {

		try {
			parentRepo.deleteById(id);
		} catch (Exception e) {
			throw new NotAllowedException("can't delete parents with existing kids");
		}

	}

}

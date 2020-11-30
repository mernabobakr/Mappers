package com.kidzona.parentsservice.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidzona.parentsservice.converter.Converter;
import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.dto.KidDto;
import com.kidzona.parentsservice.entity.Parent;
import com.kidzona.parentsservice.entity.Kid;
import com.kidzona.parentsservice.exception.ConflictException;
import com.kidzona.parentsservice.exception.NotAllowedException;
import com.kidzona.parentsservice.exception.NotFoundException;
import com.kidzona.parentsservice.repository.ParentRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ParentService {
	@Autowired
	private ParentRepo parentRepo;
	@Autowired
	Converter converter;

	public List<ParentDto> findAll() {
		List<Parent> parentList = parentRepo.findAll();
		return parentList.stream().map(converter::convertToDto).collect(Collectors.toList());
	}

	public ParentDto getParentById(int id) throws NotFoundException {

		try {

			return converter.convertToDto(parentRepo.getOne(id));
		} catch (Exception e) {
			throw new NotFoundException("can't find parent with this id");
		}
	}

	public ParentDto getParentByParentId(int id) throws NotFoundException {

		try {

			return converter.convertToDto(parentRepo.getOne(id).getParent());
		} catch (Exception e) {
			throw new NotFoundException("can't find parent with this id");
		}
	}

	public Parent saveParent(ParentDto parentDto) throws ConflictException {
		try {
			return this.parentRepo.save(converter.convertFromDto(parentDto));
		} catch (Exception e) {
			throw new ConflictException("this email already exists");
		}
	}

	public Set<KidDto> getAllKidsByParentId(int id) {
		Set<Kid> kids = parentRepo.getOne(id).getKids();
		return kids.stream().map(converter::convertToDto).collect(Collectors.toSet());
	}

	public void deleteParent(int id) throws NotAllowedException {

		try {
			parentRepo.deleteById(id);
		} catch (Exception e) {
			throw new NotAllowedException("can't delete parents with existing kids");
		}

	}

	public List<Parent> gethierarchicalParents() {
		Map<Integer, Parent> hm = new HashMap<Integer, Parent>();
		List<Parent> parentsList = parentRepo.findAll();
		for (Parent p : parentsList) {
			// check if the hashmap contains the id of this person ,if not we gonna put a
			// new person in the map
			Parent child;
			if (hm.containsKey(p.getId())) {

				child = hm.get(p.getId());
			} else {

				child = new Parent();
				child.setFirstName(p.getFirstName());
				hm.put(p.getId(), child);
			}
			child.setId(p.getId());
			child.setFirstName(p.getFirstName());
			child.setLastName(p.getLastName());
			child.setEmail(p.getEmail());
			child.setPictureUrl(p.getPictureUrl());
			child.setAddress(p.getAddress());

			child.setParent(p.getParent());

			// getting parents for that parent
			Parent parent;
			if (p.getParent() != null) {
				if (hm.containsKey(p.getParent().getId())) {

					parent = hm.get((p.getParent().getId()));

				} else {
					parent = new Parent();

					hm.put(p.getParent().getId(), parent);
					parent.setParent(null);
				}
				parent.setId(p.getParent().getId());

				parent.addChildrenItem(child);

			}

		}
		// get a hierarchical list
		List<Parent> hierarchicalList = new ArrayList<Parent>();
		for (Parent p : hm.values()) {
			if (p.getParent() == null)
				hierarchicalList.add(p);
		}
		return hierarchicalList;
		
	}

}
package com.kidzona.parentsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kidzona.parentsservice.entity.Skill;
@Repository
public interface SkillRepo extends JpaRepository<Skill, Integer> {
	Skill findBySkillName(String skillName);
}

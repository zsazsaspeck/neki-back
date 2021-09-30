package br.com.neki.userskill.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.userskill.entity.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}

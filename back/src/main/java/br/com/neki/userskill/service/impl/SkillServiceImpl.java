package br.com.neki.userskill.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.neki.userskill.entity.model.Skill;
import br.com.neki.userskill.model.repository.SkillRepository;
import br.com.neki.userskill.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService{

private SkillRepository repository;

public SkillServiceImpl(SkillRepository repository) {
	this.repository = repository;
	
}
	
	@Override
	@Transactional
	public Skill save(Skill skill) {
		// TODO Auto-generated method stub
		return repository.save(skill);
	}

	@Override
	@Transactional
	public Skill update(Skill skill) {
		Objects.requireNonNull(skill.getId());
		return repository.save(skill);
	}

	@Override
	public void delete(Skill skill) {
		Objects.requireNonNull(skill.getId());
		repository.delete(skill);
	}

	@Override
	public Optional<Skill> obterPorId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}

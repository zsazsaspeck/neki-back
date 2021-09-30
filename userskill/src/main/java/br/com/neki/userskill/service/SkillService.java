package br.com.neki.userskill.service;

import java.util.List;
import java.util.Optional;

import br.com.neki.userskill.entity.model.Skill;

public interface SkillService {
	
	Skill save(Skill skill);
	Skill update(Skill skill);
	void delete (Skill skill);
	Optional<Skill> obterPorId(Long id);

}

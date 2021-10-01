package br.com.neki.userskill.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.userskill.entity.model.UserSkill;
import br.com.neki.userskill.model.repository.User_SkillRepository;
import br.com.neki.userskill.service.User_SkillService;

@Service
public class User_SkillImpl implements User_SkillService {
	
	private User_SkillRepository repository;

	public User_SkillImpl(User_SkillRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@Transactional
	public UserSkill save(UserSkill userskill) {
		// TODO Auto-generated method stub
		return repository.save(userskill);
	}

}

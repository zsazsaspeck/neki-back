package br.com.neki.userskill.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.userskill.api.dto.SkillDTO;
import br.com.neki.userskill.api.dto.UserDTO;
import br.com.neki.userskill.api.dto.User_SkillDTO;
import br.com.neki.userskill.entity.model.Skill;
import br.com.neki.userskill.entity.model.User;
import br.com.neki.userskill.entity.model.UserSkill;
import br.com.neki.userskill.exception.RegraNegocioException;
import br.com.neki.userskill.service.User_SkillService;
import lombok.Builder;

@RestController
@RequestMapping("/api/userskill")
public class User_SkillResource {
	
	private User_SkillService service;
	
	public User_SkillResource(User_SkillService service) {
		this.service = service;
		}
	
	   @PostMapping
		public ResponseEntity save( @RequestBody User_SkillDTO dto) {
		   try {
				UserSkill entity = convert(dto);
				entity = service.save(entity);
				return new ResponseEntity(entity, HttpStatus.CREATED);
			}catch (RegraNegocioException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	   }

	private UserSkill convert(User_SkillDTO dto) {
		UserSkill userskill = new UserSkill();
		userskill.setUser(dto.getUser());
		userskill.setSkill(dto.getSkill());
		userskill.setKnowledgeLevel(dto.getKnowledgeLevel());
		userskill.setCreatedAt(dto.getCreatedAt());
		userskill.setUpdatedAt(dto.getUpdatedAt());
		return userskill;
	}
}
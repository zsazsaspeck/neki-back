package br.com.neki.userskill.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.userskill.api.dto.SkillDTO;
import br.com.neki.userskill.entity.model.Skill;
import br.com.neki.userskill.exception.RegraNegocioException;
import br.com.neki.userskill.service.SkillService;

@RestController
@RequestMapping("/api/skills")
public class SkillResource {

		private SkillService service;
		
		public SkillResource(SkillService service) {
			this.service = service;
		}
		
		@PostMapping
		public ResponseEntity save( @RequestBody SkillDTO dto) {
			
			try {
			Skill entity = convert(dto);
			entity = service.save(entity);
			return new ResponseEntity(entity, HttpStatus.CREATED);
		}catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
		
		@PutMapping("{id}")
		public ResponseEntity update( @PathVariable("id") Long id, @RequestBody SkillDTO dto) {
			return service.obterPorId(id).map ( entity -> {
				Skill skill = convert(dto);
				skill.setId(entity.getId());
				service.update(skill);
				return ResponseEntity.ok(skill);
				}).orElseGet( () -> new ResponseEntity("Skill não encontrado.", HttpStatus.BAD_REQUEST));
		}
		
		private Skill convert(SkillDTO dto) {
			Skill skill = new Skill();
			skill.setDescription(dto.getDescription());
			skill.setName(dto.getName());
			skill.setVersion(dto.getVersion());
			
			return skill;
		}
}

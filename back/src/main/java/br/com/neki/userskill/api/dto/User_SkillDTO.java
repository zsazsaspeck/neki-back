package br.com.neki.userskill.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.neki.userskill.entity.model.Skill;
import br.com.neki.userskill.entity.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User_SkillDTO {
	private Integer id;
	private User user;	
	private Skill skill;
	private Integer userId;
	private Integer skillId;
	private Integer knowledgeLevel;
	private LocalDate createdAt;
	private LocalDateTime updatedAt;
}

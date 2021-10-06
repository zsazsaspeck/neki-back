package br.com.neki.userskill.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO {

	private Long Id;
	private String name;
	private String version;
	private String description;
}

package br.com.neki.userskill.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkillDTO {

	private long Id;
	private String name;
	private String version;
	private String description;
}

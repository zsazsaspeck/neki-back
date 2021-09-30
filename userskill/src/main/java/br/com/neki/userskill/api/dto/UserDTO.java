package br.com.neki.userskill.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {

	private String login;
	private String senha;
}

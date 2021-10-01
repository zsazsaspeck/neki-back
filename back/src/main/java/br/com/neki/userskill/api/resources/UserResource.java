package br.com.neki.userskill.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.userskill.api.dto.UserDTO;
import br.com.neki.userskill.entity.model.User;
import br.com.neki.userskill.exception.ErroAutenticacao;
import br.com.neki.userskill.exception.RegraNegocioException;
import br.com.neki.userskill.service.UserService;

@RestController
@RequestMapping("/api/usuarios")
public class UserResource {
	
	private UserService service;
	
	public UserResource(UserService service) {
		this.service = service;
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar ( @RequestBody UserDTO dto ) {
		try {
			User userAutenticado = service.autenticar(dto.getLogin(), dto.getSenha());
			return ResponseEntity.ok(userAutenticado);
		}catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@PostMapping
	public ResponseEntity save( @RequestBody UserDTO dto ) {
		
		User user = User.builder()
				.login(dto.getLogin())
				.senha(dto.getSenha()).build();
		
		try {
			User userSalvo = service.salvarUsuario(user);
			return new ResponseEntity(userSalvo, HttpStatus.CREATED);
			
		}catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

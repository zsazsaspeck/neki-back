package br.com.neki.userskill.service;

import br.com.neki.userskill.entity.model.User;

public interface UserService {
	
	User autenticar(String login, String senha);
	
	User salvarUsuario(User user);
	
	void validarLogin(String login);
}

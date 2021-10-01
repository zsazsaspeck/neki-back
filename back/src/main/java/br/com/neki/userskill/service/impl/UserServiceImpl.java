package br.com.neki.userskill.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.userskill.entity.model.User;
import br.com.neki.userskill.exception.ErroAutenticacao;
import br.com.neki.userskill.exception.RegraNegocioException;
import br.com.neki.userskill.model.repository.UserRepository;
import br.com.neki.userskill.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository repository;
	
	@Autowired
	public UserServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public User autenticar(String login, String senha) {
		Optional<User> user = repository.findByLogin(login);
		
		if(!user.isPresent()) {
			throw new ErroAutenticacao("Login não encontrado");
		}
		
		if(!user.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha invalida");
		}
		
		return user.get();
	}

	@Override
	@Transactional
	public User salvarUsuario(User user) {
		validarLogin(user.getLogin());
		return repository.save(user);
	}

	@Override
	public void validarLogin(String login) {
		boolean exist = repository.existsByLogin(login);
		if(exist) {
			throw new RegraNegocioException("Já existe um cadastro com esse login.");
		}
	}

}

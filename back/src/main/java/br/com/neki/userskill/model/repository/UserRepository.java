package br.com.neki.userskill.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.userskill.entity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
		
		boolean existsByLogin(String login);
		
		Optional<User> findByLogin(String login);
}

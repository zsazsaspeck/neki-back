package br.com.neki.userskill.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "user" , schema = "teste_residencia")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator ="teste_residencia.user_seq")
	private Long id;

	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String senha;
	
}
package br.com.neki.userskill.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skill", schema = "teste_residencia")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator ="teste_residencia.skill_seq")
	@SequenceGenerator(
		    name="skill_seq",
		    sequenceName="skill_sequence",
		    allocationSize=1,
		    initialValue = 50
		)
		 
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "version")
	private String version;
	
	@Column(name = "description")
	private String description;
	
	
}
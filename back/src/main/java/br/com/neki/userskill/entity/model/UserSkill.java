package br.com.neki.userskill.entity.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "user_skill" , schema = "teste_residencia")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSkill {
			
		@Id
		@Column(name = "id")
		@GeneratedValue( strategy = GenerationType.SEQUENCE, generator ="teste_residencia.user_skill_seq")
		private Long id;
		
		@ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;
		
	    @ManyToOne
	    @JoinColumn(name = "skill_id")
	    private Skill skill;
		
		@Column(name = "knowledge_level") //, nullable = false)
	    private Integer knowledgeLevel;

	    @JsonFormat(pattern = "dd-MM-yyyy" )
	    @Column(name = "created_at" )
	    private LocalDate createdAt;
	    
	    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;

}


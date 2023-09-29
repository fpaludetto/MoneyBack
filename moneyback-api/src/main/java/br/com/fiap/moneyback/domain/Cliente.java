package br.com.fiap.moneyback.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class Cliente extends AbstractDomain{

	enum SexoType {
		M, F
	}

	@NotBlank(message = "Nome obrigatório!")
	@Column(name = "nm_cliente")
	private String nome;

	@NotBlank(message = "Sobrenome obrigatório!")
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Past
	@Column(name = "dt_nascimento")
	private LocalDate dtNascimento;

	@NotBlank(message = "CPF obrigatório!")
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "sexo")
	@Enumerated(EnumType.STRING)
	private SexoType sexo;
	
	@NotBlank(message = "Email obrigatório!")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "DDD obrigatório!")
	@Column(name = "ddd")
	private String ddd;
	
	@NotBlank(message = "Celular obrigatório!")
	@Column(name = "celular")
	private String telefone;
	
	@NotBlank(message = "CEP obrigatório!")
	@Column(name = "cep")
	private String cep;

	
}

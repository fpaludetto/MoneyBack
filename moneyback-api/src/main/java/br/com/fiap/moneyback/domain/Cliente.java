package br.com.fiap.moneyback.domain;

import java.time.LocalDate;
import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente extends AbstractDomain{

	
	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@Column(name = "cd_cliente")
	private String cd_cliente;

	@NotBlank(message = "Nome obrigatório!")
	@Size(max = 20)
	@Column(name = "nm_cliente")
	private String nm_cliente;

	@NotBlank(message = "Sobrenome obrigatório!")
	@Size(max = 30)
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Past
	@Column(name = "dt_nascimento")
	private LocalDate dt_nascimento;

	@NotBlank(message = "CPF obrigatório!")
	@Size(max = 10)
	@Column(name = "cpf")
	private String cpf;
	
	@NotBlank(message = "Sexo obrigatório!")
	@Size(max = 1)
	@Column(name = "sexo")
	private String sexo;
	
	@NotBlank(message = "Email obrigatório!")
	@Size(max = 60)
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "DDD obrigatório!")
	@Size(max = 3)
	@Column(name = "ddd")
	private String ddd;
	
	@NotBlank(message = "Celular obrigatório!")
	@Size(max = 10)
	@Column(name = "celular")
	private String celular;
	
	@NotBlank(message = "CEP obrigatório!")
	@Size(max = 8)
	@Column(name = "cep")
	private Integer cep;
		
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_cadastro")
	private Calendar dh_cadastro;

	
	
	// Getters and Setters
	public String getCd_cliente() {
		return cd_cliente;
	}

	public void setCd_cliente(String cd_cliente) {
		this.cd_cliente = cd_cliente;
	}

	public String getNm_cliente() {
		return nm_cliente;
	}

	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDatadt_nascimento() {
		return dt_nascimento;
	}

	public void setdt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Calendar getDh_cadastro() {
		return dh_cadastro;
	}

	public void setDh_cadastro(Calendar dh_cadastro) {
		this.dh_cadastro = dh_cadastro;
	}
		
}

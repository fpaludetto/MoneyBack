package br.com.fiap.moneyback.domain;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Token extends AbstractDomain{

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@Column(name = "cd_token")
	private String cd_token;
	
	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@JoinColumn(name = "cd_cliente")
	@ManyToOne
	private Cliente cd_cliente;
	
	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@JoinColumn(name = "cd_veiculo")
	@ManyToOne
	private Veiculo cd_veiculo;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_token")
	private Calendar dh_token;
	
	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@JoinColumn(name = "cd_status_token")
	@OneToOne
	private StatusCashback cd_status_token;

	
	//Getters and Setters
	public String getCd_token() {
		return cd_token;
	}

	public void setCd_token(String cd_token) {
		this.cd_token = cd_token;
	}

	public Cliente getCd_cliente() {
		return cd_cliente;
	}

	public void setCd_cliente(Cliente cd_cliente) {
		this.cd_cliente = cd_cliente;
	}

	public Veiculo getCd_veiculo() {
		return cd_veiculo;
	}

	public void setCd_veiculo(Veiculo cd_veiculo) {
		this.cd_veiculo = cd_veiculo;
	}

	public Calendar getDh_token() {
		return dh_token;
	}

	public void setDh_token(Calendar dh_token) {
		this.dh_token = dh_token;
	}

	public StatusCashback getCd_status_token() {
		return cd_status_token;
	}

	public void setCd_status_token(StatusCashback cd_status_token) {
		this.cd_status_token = cd_status_token;
	}
		
}

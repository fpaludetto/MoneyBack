package br.com.fiap.moneyback.domain;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Mensagem extends AbstractDomain {

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@Column(name = "cd_mensagem")
	private String cd_mensagem;

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@JoinColumn(name = "cd_cliente")
	@ManyToOne
	private Cliente cd_cliente;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_mensagem")
	private Calendar dh_mensagem;

	@NotBlank(message = "Mensagem obrigatório!")
	@Size(max = 300)
	@Column(name = "mensagem")
	private String mensagem;

	// Getters and Setters
	public String getCd_mensagem() {
		return cd_mensagem;
	}

	public void setCd_mensagem(String cd_mensagem) {
		this.cd_mensagem = cd_mensagem;
	}

	public Cliente getCd_cliente() {
		return cd_cliente;
	}

	public void setCd_cliente(Cliente cd_cliente) {
		this.cd_cliente = cd_cliente;
	}

	public Calendar getDh_mensagem() {
		return dh_mensagem;
	}

	public void setDh_mensagem(Calendar dh_mensagem) {
		this.dh_mensagem = dh_mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}

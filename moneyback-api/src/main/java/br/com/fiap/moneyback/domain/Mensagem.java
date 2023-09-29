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
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
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

}

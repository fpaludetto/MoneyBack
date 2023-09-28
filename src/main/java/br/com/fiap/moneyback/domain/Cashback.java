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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cashback extends AbstractDomain {

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)	
	@Column(name = "cd_cashback")
	private String cd_cashback;

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@JoinColumn(name = "cd_cliente")
	@ManyToOne
	private Cliente cd_cliente;
		
	@Min(value = 0, message = "Preço não pode ser negativo")
	@Column
	private double vlr_saldo_cashback;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_atualizacao")
	private Calendar dh_atualizacao;

	
	//Getters and Setters
	public String getCd_cashback() {
		return cd_cashback;
	}

	public void setCd_cashback(String cd_cashback) {
		this.cd_cashback = cd_cashback;
	}

	public Cliente getCd_cliente() {
		return cd_cliente;
	}

	public void setCd_cliente(Cliente cd_cliente) {
		this.cd_cliente = cd_cliente;
	}

	public double getVlr_saldo_cashback() {
		return vlr_saldo_cashback;
	}

	public void setVlr_saldo_cashback(double vlr_saldo_cashback) {
		this.vlr_saldo_cashback = vlr_saldo_cashback;
	}

	public Calendar getDh_atualizacao() {
		return dh_atualizacao;
	}

	public void setDh_atualizacao(Calendar dh_atualizacao) {
		this.dh_atualizacao = dh_atualizacao;
	}

	
	
	
}

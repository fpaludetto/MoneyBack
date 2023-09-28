package br.com.fiap.moneyback.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ItemExtrato extends AbstractDomain{

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@Column(name = "cd_item_extrato")
	private String cd_item_extrato;

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@JoinColumn(name = "cd_cliente")
	@ManyToOne
	private Cliente cd_cliente;
	
	//@Min(value = 0, message = "Preço não pode ser negativo")
	@Column(name = "vlr_item_Extrato")
	private float vlr_item_Extrato;
	
	@Past
	@Column(name = "dt_lancamento")
	private LocalDate dt_lancamento;
	
	@Min(value = 0, message = "Valor do CashBack não pode ser negativo")
	@Column(name = "vlr_cashback")
	private double vlr_cashback;
		
	@Past
	@Column(name = "dt_expr_cashback")
	private LocalDate dt_expr_cashback;
	
	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@JoinColumn(name = "cd_status_cashback")
	@OneToOne
	private StatusCashback cd_status_cashback;

	
	
	
	//Getters and Setters
	public String getCd_item_extrato() {
		return cd_item_extrato;
	}

	public void setCd_item_extrato(String cd_item_extrato) {
		this.cd_item_extrato = cd_item_extrato;
	}

	public Cliente getCd_cliente() {
		return cd_cliente;
	}

	public void setCd_cliente(Cliente cd_cliente) {
		this.cd_cliente = cd_cliente;
	}

	public float getVlr_item_Extrato() {
		return vlr_item_Extrato;
	}

	public void setVlr_item_Extrato(float vlr_item_Extrato) {
		this.vlr_item_Extrato = vlr_item_Extrato;
	}

	public LocalDate getDt_lancamento() {
		return dt_lancamento;
	}

	public void setDt_lancamento(LocalDate dt_lancamento) {
		this.dt_lancamento = dt_lancamento;
	}

	public double getVlr_cashback() {
		return vlr_cashback;
	}

	public void setVlr_cashback(double vlr_cashback) {
		this.vlr_cashback = vlr_cashback;
	}

	public LocalDate getDt_expr_cashback() {
		return dt_expr_cashback;
	}

	public void setDt_expr_cashback(LocalDate dt_expr_cashback) {
		this.dt_expr_cashback = dt_expr_cashback;
	}

	public StatusCashback getCd_status_cashback() {
		return cd_status_cashback;
	}

	public void setCd_status_cashback(StatusCashback cd_status_cashback) {
		this.cd_status_cashback = cd_status_cashback;
	}
	
		
	
	
}

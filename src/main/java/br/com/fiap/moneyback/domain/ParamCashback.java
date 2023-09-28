package br.com.fiap.moneyback.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ParamCashback extends AbstractDomain {

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@Column(name = "cd_param_cashback")
	private String cd_param_cashback;
	
	@Min(value = 0, message = "Percentual não pode ser negativo")
	@Column(name = "percentual_cashback")
	private float percentual_cashback;
	
	@Past
	@Column(name = "dt_vigencia_ini")
	private LocalDate dt_vigencia_ini;
	
	@Past
	@Column(name = "dt_vigencia_fim")
	private LocalDate dt_vigencia_fim;

	
	// Getters and Setters
	public String getCd_param_cashback() {
		return cd_param_cashback;
	}

	public void setCd_param_cashback(String cd_param_cashback) {
		this.cd_param_cashback = cd_param_cashback;
	}

	public float getPercentual_cashback() {
		return percentual_cashback;
	}

	public void setPercentual_cashback(float percentual_cashback) {
		this.percentual_cashback = percentual_cashback;
	}

	public LocalDate getDt_vigencia_ini() {
		return dt_vigencia_ini;
	}

	public void setDt_vigencia_ini(LocalDate dt_vigencia_ini) {
		this.dt_vigencia_ini = dt_vigencia_ini;
	}

	public LocalDate getDt_vigencia_fim() {
		return dt_vigencia_fim;
	}

	public void setDt_vigencia_fim(LocalDate dt_vigencia_fim) {
		this.dt_vigencia_fim = dt_vigencia_fim;
	}
		
}

package br.com.fiap.moneyback.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StatusCashback extends AbstractDomain {

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)	
	@Column(name = "cd_status_cashback")
	private String cd_status_cashback;
	
	@NotBlank(message = "Status obrigatório!")
	@Size(max = 20)
	@Column(name = "status")
	private String status;
	

	//Getters and Setters
	public String getCd_status_cashback() {
		return cd_status_cashback;
	}

	public void setCd_status_cashback(String cd_status_cashback) {
		this.cd_status_cashback = cd_status_cashback;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}

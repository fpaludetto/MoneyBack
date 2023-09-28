package br.com.fiap.moneyback.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StatusToken extends AbstractDomain {

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)	
	@Column(name = "cd_status_token")
	private String cd_status_token;
	
	@NotBlank(message = "Status obrigatório!")
	@Size(max = 20)
	@Column(name = "status")
	private String status;

	
	//Getters and Setters
	public String getCd_status_token() {
		return cd_status_token;
	}

	public void setCd_status_token(String cd_status_token) {
		this.cd_status_token = cd_status_token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}

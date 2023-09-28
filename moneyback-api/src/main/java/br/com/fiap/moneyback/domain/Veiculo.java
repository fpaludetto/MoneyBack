package br.com.fiap.moneyback.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Veiculo extends AbstractDomain{

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@Column(name = "cd_veiculo")
	private String cd_veiculo;
	
	@NotBlank(message = "Código obrigatório!")
	@Size(max = 10)
	@JoinColumn(name = "cd_cliente")
	@ManyToOne
	private Cliente cd_cliente;
	
	@NotBlank(message = "Marca obrigatório!")
	@Size(max = 20)
	@Column(name = "marca")
	private String marca;
	
	@NotBlank(message = "Modelo obrigatório!")
	@Size(max = 20)
	@Column(name = "modelo")
	private String modelo;
	
	@NotBlank(message = "Placa obrigatório!")
	@Size(max = 10)
	@Column(name = "placa")
	private String placa;

	
	//Getters and Setters
	public String getCd_veiculo() {
		return cd_veiculo;
	}

	public void setCd_veiculo(String cd_veiculo) {
		this.cd_veiculo = cd_veiculo;
	}

	public Cliente getCd_cliente() {
		return cd_cliente;
	}

	public void setCd_cliente(Cliente cd_cliente) {
		this.cd_cliente = cd_cliente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
		
}

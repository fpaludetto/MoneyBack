package br.com.fiap.moneyback.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class Veiculo extends AbstractDomain{

	@NotNull(message = "Código obrigatório!")
	@JoinColumn(name = "id_cliente", foreignKey=@ForeignKey(name="fk_veiculo_cliente"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
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
	
	@Column(name = "ativo")
	private Boolean ativo;

		
}

package br.com.fiap.moneyback.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@Table(name = "configuracao_cashback")
public class ConfiguracaoCashback extends AbstractDomain {


	@Min(value = 0, message = "Percentual não pode ser negativo")
	@Column(name = "taxa_cashback")
	private Double taxaCashback;
	
	@NotNull
	@Column(name = "dt_vigencia_ini")
	private LocalDate vigenciaInicial;
	
	@Column(name = "dt_vigencia_fim")
	private LocalDate vigenciaFinal;

	@NotNull
	@Column(name = "qt_dias_validade")
	private Integer diasValidade;
	
	@Column(name = "in_ativo")
	private Boolean ativo;
		
}

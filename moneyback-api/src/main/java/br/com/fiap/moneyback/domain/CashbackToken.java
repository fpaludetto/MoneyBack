package br.com.fiap.moneyback.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cashback_token")
public class CashbackToken extends AbstractDomain{

	@NotNull(message = "Cliente obrigatório!")
	@JoinColumn(name = "id_cliente", foreignKey=@ForeignKey(name="fk_cashback_token_cliente"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	@Column(name = "vlr_cashback")
	private Double valor;
	
	@Column(name = "dt_utilizacao")
	private LocalDateTime dtUtilizacao;
	
}

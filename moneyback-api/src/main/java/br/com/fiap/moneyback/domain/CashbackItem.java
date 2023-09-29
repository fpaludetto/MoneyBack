package br.com.fiap.moneyback.domain;

import java.time.LocalDate;
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
@Table(name = "cashback")
@Setter
@Getter
public class CashbackItem extends AbstractDomain{

	
	@NotNull(message = "Cliente obrigatório!")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", foreignKey=@ForeignKey(name="fk_cashback_cliente"))
	private Cliente cliente;

	@NotNull(message = "Valor deve ser obrigatório.")
	@Column(name = "vlr_item")
	private Double valor;
	
	@NotNull(message = "Data expiração não pode ser vazia.")
	@Column(name = "dt_expiracao")
	private LocalDate dtExpiracao;
	
	@Column(name = "dt_utilizacao")
	private LocalDateTime dtUtilizacao;
}

package br.com.fiap.moneyback.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@Table(name = "item_extrato")
public class ItemExtrato extends AbstractDomain{

		
	@NotNull(message = "Cliente obrigatório!")
	@JoinColumn(name = "id_cliente", foreignKey=@ForeignKey(name="fk_item_extrato_cliente"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@NotNull(message = "Descricação do item deve ser obrigatório.")
	@Column(name = "ds_item")
	private String descricao;
	
	@Column(name = "id_cashback_token")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cashback_token", foreignKey=@ForeignKey(name="fk_item_extrato_cashback_token"))
	private CashbackToken cashbackToken;
	
	@Column(name = "vlr_cashback")
	private Double valorCashback;
	
	@NotNull(message = "Valor do item deve ser obrigatório.")
	@Column(name = "vlr_item")
	private Double valorItem;
	
	@NotNull(message = "Valor do item deve ser obrigatório.")
	@Column(name = "vlr_total")
	private Double valorTotal;

	
}
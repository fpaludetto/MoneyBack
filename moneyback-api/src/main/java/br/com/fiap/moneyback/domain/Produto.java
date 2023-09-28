package br.com.fiap.moneyback.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@SequenceGenerator(name = "produto", sequenceName = "SQ_PRODUTO", allocationSize = 1)
public class Produto extends AbstractDomain{

	@NotBlank(message = "Código obrigatório!")
	@Size(max = 50)
	@Column
	private String codigo;

	@NotBlank(message = "Nome obrigatório!")
	@Size(max = 50)
	@Column
	private String nome;

	@Min(value = 0, message = "Preço não pode ser negativo")
	@Column
	private double preco;

	@Column
	private boolean novo;

	@Past
	@Column(name = "data_fabricacao")
	private LocalDate dataFabricacao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_categoria", updatable=true, foreignKey=@ForeignKey(name="fk_produto_categoria"))
	private Categoria categoria;
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
	

}
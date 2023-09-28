package br.com.fiap.moneyback.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractDomain implements IdentifiableDomain<String>, Serializable {

	private static final long serialVersionUID = 3343378367873094440L;

	@Id
	@Column(name = "id", nullable = false, updatable = false)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;

	@CreationTimestamp
	@Column(name = "dt_criacao")
	private LocalDateTime criacao;

	@UpdateTimestamp
	@Column(name = "dt_atualizacao")
	private LocalDateTime atualizacao;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public boolean isNew() {
		return this.id == null;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	public void setCriacao(LocalDateTime criacao) {
		this.criacao = criacao;
	}

	public LocalDateTime getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(LocalDateTime atualizacao) {
		this.atualizacao = atualizacao;
	}

	@Override
	public String toString() {
		return String.format("%s#%s", this.getClass().getName(), getId());
	}
}

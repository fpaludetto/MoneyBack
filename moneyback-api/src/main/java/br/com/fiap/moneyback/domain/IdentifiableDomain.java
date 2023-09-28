package br.com.fiap.moneyback.domain;

import java.io.Serializable;

public interface IdentifiableDomain<T> extends Serializable{

	void setId(T id);
	
	T getId();
}

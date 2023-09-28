package br.com.fiap.moneyback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.moneyback.domain.ItemExtrato;

@Repository
public interface ItemExtratoRepository extends JpaRepository<ItemExtrato, String> {

}
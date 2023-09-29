package br.com.fiap.moneyback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.moneyback.domain.CashbackItem;
import br.com.fiap.moneyback.domain.Cliente;

@Repository
public interface CashbackItemRepository extends JpaRepository<CashbackItem, String> {

	@Query(value = "from CashbackItem where dtExpiracao >= CURRENT_DATE and dtUtilizacao is null and cliente = :cliente")
	List<CashbackItem> getAllActive(Cliente cliente);

}
package br.com.fiap.moneyback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.moneyback.domain.ConfiguracaoCashback;

@Repository
public interface ConfiguracaoCashbackRepository extends JpaRepository<ConfiguracaoCashback, String> {

	
	@Query(value = "from ConfiguracaoCashback where vigenciaInicial < CURRENT_DATE and vigenciaFinal > CURRENT_DATE")
	ConfiguracaoCashback findActiveConfiguration();
}

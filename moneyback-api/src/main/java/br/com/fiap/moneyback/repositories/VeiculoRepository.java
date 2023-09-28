package br.com.fiap.moneyback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.moneyback.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {

}
package br.com.fiap.moneyback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.moneyback.domain.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {

	
	  List<Produto> findByNome(String prod);
	  
	  List<Produto> findByNovo(boolean novo);
	  
	  List<Produto> findByNomeAndNovo(String prod, boolean novo);
	  
	  List<Produto> findByPrecoGreaterThan(double preco);
	  
	  List<Produto> findByCodigo(String codigo);
	 
	
}





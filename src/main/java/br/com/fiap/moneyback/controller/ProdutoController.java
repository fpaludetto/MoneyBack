package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.Produto;
import br.com.fiap.moneyback.repositories.ProdutoRepository;

@RequestMapping("/produto") 
@RestController 
public class ProdutoController extends AbstractCrudController<Produto, ProdutoRepository> {

	
}

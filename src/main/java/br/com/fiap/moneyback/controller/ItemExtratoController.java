package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.ItemExtrato;
import br.com.fiap.moneyback.repositories.ItemExtratoRepository;

@RequestMapping("/item_extrato") 
@RestController 
public class ItemExtratoController extends AbstractCrudController<ItemExtrato, ItemExtratoRepository> {

	
}
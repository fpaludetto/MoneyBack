package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.Cashback;
import br.com.fiap.moneyback.repositories.CashbackRepository;

@RequestMapping("/cashback") 
@RestController 
public class CashbackController extends AbstractCrudController<Cashback, CashbackRepository> {

}




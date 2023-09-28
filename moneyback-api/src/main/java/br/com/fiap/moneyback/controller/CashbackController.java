package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cashback") 
@RestController 
public class CashbackController extends AbstractCrudController<CashBack, CashBackRepository> {

}




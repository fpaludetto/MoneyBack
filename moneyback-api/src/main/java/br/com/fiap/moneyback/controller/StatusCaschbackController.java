package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.StatusCashback;
import br.com.fiap.moneyback.repositories.StatusCashbackRepository;

@RequestMapping("/status_cashback") 
@RestController 
public class StatusCaschbackController extends AbstractCrudController<StatusCashback, StatusCashbackRepository> {

}

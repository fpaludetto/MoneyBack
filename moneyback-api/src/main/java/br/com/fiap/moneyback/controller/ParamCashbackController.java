package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.moneyback.domain.ParamCashback;
import br.com.fiap.moneyback.repositories.ParamCashbackRepository;

@RequestMapping("/paramCashback") 
@RestController 
public class ParamCashbackController extends AbstractCrudController<ParamCashback, ParamCashbackRepository> {



}

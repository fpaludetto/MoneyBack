package br.com.fiap.moneyback.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/status_cashback") 
@RestController 
public class StatusCaschbackController extends AbstractCrudController<StatusCaschback, StatusCaschbackRepository> {

}

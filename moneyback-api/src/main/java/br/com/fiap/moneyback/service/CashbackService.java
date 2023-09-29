package br.com.fiap.moneyback.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.moneyback.domain.CashbackItem;
import br.com.fiap.moneyback.domain.CashbackToken;
import br.com.fiap.moneyback.domain.Cliente;
import br.com.fiap.moneyback.domain.ConfiguracaoCashback;
import br.com.fiap.moneyback.exception.BusinessException;
import br.com.fiap.moneyback.repositories.CashbackItemRepository;
import br.com.fiap.moneyback.repositories.CashbackTokenRepository;
import br.com.fiap.moneyback.repositories.ConfiguracaoCashbackRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CashbackService {

	@Autowired
	private CashbackItemRepository cashbackItemRepository;
	
	@Autowired
	private ConfiguracaoCashbackRepository configCashbackRepository;
	
	@Autowired
	private CashbackTokenRepository cashbackTokenRepository;
	
	public List<CashbackItem> listAll(String idCliente, Boolean ativo){
		return cashbackItemRepository.findAll().stream()
				.filter(e -> ativo == null || (ativo && e.getDtExpiracao().isBefore(LocalDate.now()) && e.getDtUtilizacao() != null))
				.toList();
	}
	
	public CashbackItem geraCashbackItem(Cliente cliente, Double valor) {
		
		ConfiguracaoCashback cashbackConfig = configCashbackRepository.findActiveConfiguration();
		CashbackItem cashback = null;
		
		//Gera o cashback
		if(cashbackConfig != null) {
		
			Double cashbackValue = valor * cashbackConfig.getTaxaCashback();
			
			cashback = new CashbackItem();
			cashback.setCliente(cliente);
			cashback.setDtExpiracao(LocalDate.now().plusDays(cashbackConfig.getDiasValidade()));
			cashback.setValor(cashbackValue);
			cashbackItemRepository.save(cashback);
		}
		
		return cashback;
	}
	
	public CashbackToken findCachbackActiveClientToken(Cliente cliente, String tokenId) {
		CashbackToken token = cashbackTokenRepository.findById(tokenId).orElse(null);

		if(token == null) {
			throw new BusinessException("Token Cashback não encontrado.");
		}
		if(token.getDtUtilizacao() != null) {
			throw new BusinessException("Token de cashback já utilizado.");
		}
		if(!token.getCliente().equals(cliente)) {
			throw new BusinessException("Token não pertence ao cliente.");
		}
		return token;

	}
	
	public void setTokenUsed(CashbackToken token) {
		token.setDtUtilizacao(LocalDateTime.now());
		cashbackTokenRepository.save(token);
	}
	
	public Double getCashbackTotal(Cliente cliente, boolean mandatory){
		
		List<CashbackItem> items = cashbackItemRepository.getAllActive(cliente);
		
		if(mandatory && items == null) {
			throw new BusinessException("Cliente não possui itens de cashback ou todos já foram utilizados.");
		}
		
		if(items == null) {
			return 0D;
		}
		
		return items.stream().mapToDouble((a) -> a.getValor()).sum();
	}
	
	public CashbackToken geraCashbackToken(Cliente cliente, Double value) {
		
		List<CashbackItem> items = cashbackItemRepository.getAllActive(cliente);
		
		if(items == null) {
			throw new BusinessException("Cliente não possui itens de cashback ou todos já foram utilizados.");
		}
		
		Double total = items.stream().mapToDouble((a) -> a.getValor()).sum();
		
		if(total < value) {
			throw new BusinessException("O valor requisitado é maior do que os itens de cashback");
		}
		if(total >= value) {
			
			//Subtrai o valor requisitado do total de itens
			total = total - value;
			
			//Remove o saldo de todos os cashbackitems
			for(CashbackItem i : items) {
				i.setDtUtilizacao(LocalDateTime.now());
			}
			cashbackItemRepository.saveAll(items);
			
			//Cria um novo cashbackitem com o saldo restante
			CashbackItem newItem = new CashbackItem();
			newItem.setCliente(cliente);
			newItem.setValor(total);
		}
		
		CashbackToken newToken = new CashbackToken();
		newToken.setCliente(cliente);
		newToken.setValor(value);
		
		cashbackTokenRepository.save(newToken);
		
		return newToken;
		
	}
	
}

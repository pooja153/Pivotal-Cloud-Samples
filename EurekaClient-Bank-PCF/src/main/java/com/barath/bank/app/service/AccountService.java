package com.barath.bank.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barath.bank.app.model.Account;
import com.barath.bank.app.repository.AccountRepository;


@Service
public class AccountService {
	

	private AccountRepository accountRep; 
	
	
	@Autowired
	public AccountService(AccountRepository accountRep){
		this.accountRep=accountRep;
	}
	
	public void addAccount(Account account){
		accountRep.save(account);
	}
	
	public Account getAccount(long accountId){
		Account account=null;
		if(accountRep.exists(accountId)){
			account=accountRep.findOne(accountId);
		}
		
		return account;
	}

	public void updateAccount(Account account){
		if(isAccountExists(account)){
			accountRep.save(account);
		}
	}
	
	
	public void deleteAccount(long accountId){
		if(isAccountExists(accountId)){
			accountRep.delete(accountId) ;
		}
	}
	public void deleteAccount(Account account){
		if(isAccountExists(account)){
			accountRep.delete(account) ;
		}
	}
	
	public boolean isAccountExists(long accountId){
		return accountRep.exists(accountId);
	}
	
	public boolean isAccountExists(Account account){
		if(account != null){
			return accountRep.exists(account.getAccountNumber());
		}
		return false;
	}

	public List<Account> getAllAccounts() {
		
		return accountRep.findAll();
	}

	

	

}

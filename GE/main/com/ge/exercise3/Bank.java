package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bank {

    //private static final Logger logger = LogManager.getLogger(Bank.class);
    private Map<String, Account> accountMap;
    

    public Bank() {
        accountMap = new HashMap<>();
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void depositToAccount(String accountNumber, float amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, float amount) {
        Account account = getAccount(accountNumber);
        if(account.equals("Checking") && amount > 100.0f)
        	System.out.println("withdraw limit exceeded");
        else{
        	if(account.getBalance() < amount)
        		System.out.println("savings should have non zero balance");        	
        	else
        		account.withdraw(amount);
        	}
    }

    public int numAccounts() {
        return accountMap.size();
    }
    
    public int sumOfCurrentHoldings(){
    	int sum = 0;
    	for(Map.Entry<String, Account> entry : accountMap.entrySet()){
    		Account account =(Account)entry.getValue();
    		if(account.getAccountType().equals("Checking"))
    			sum ++;
    	} 
    	return sum;    	
    }
    public String projectProfitOrLoss(){
    	float interestPaid = 0.0f;
    	float monthlyFees = 0.0f;
    	for(Map.Entry<String, Account> entry : accountMap.entrySet()){
    		Account account =(Account)entry.getValue();
    		interestPaid = interestPaid + (account.getBalance() * account.getMonthlyInterestRate());
    		monthlyFees = monthlyFees + account.getMonthlyFee();
    	}   
    	
    	if(monthlyFees == interestPaid)
    		return "no profit no losss";
    	return monthlyFees > interestPaid ? "Profit" : "Loss";
    }
    
    
    
    
}

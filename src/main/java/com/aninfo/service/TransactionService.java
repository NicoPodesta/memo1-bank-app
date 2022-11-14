package com.aninfo.service;

import com.aninfo.model.Transaction;
import com.aninfo.model.TransactionType;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private AccountService accountService;
    private TransactionRepository transactionRepository;

    public TransactionService(AccountService accountService) {
        this.accountService = accountService;
    }
    public Transaction createTransaction(Transaction transaction) {
        if (transaction.getType() == TransactionType.DEPOSIT) {
            accountService.deposit(transaction.getCbu(), transaction.getSum());
        } else {
            accountService.withdraw(transaction.getCbu(), transaction.getSum());
        }
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }
    public Collection<Transaction> findTransactionsByCbu(Long cbu) {
        return transactionRepository.findTransactionsByCbu(cbu);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}

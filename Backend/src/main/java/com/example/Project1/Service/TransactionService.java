package com.example.Project1.Service;

import com.example.Project1.Model.Accounts;
import com.example.Project1.Model.Transaction;
import com.example.Project1.Model.TransactionStatus;
import com.example.Project1.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }


    @Transactional
    public void transferMoneyByAccountId(int fromAccountId, int toAccountId, BigDecimal amount) {
        // Find accounts based on account IDs
        Accounts fromAccount = accountService.getAccountById(fromAccountId);
        Accounts toAccount = accountService.getAccountById(toAccountId);

        // Validate the transfer amount
        if (fromAccount.getBalance() < amount.longValue()) {
            throw new IllegalArgumentException("Insufficient balance in the source account.");
        }

        // Perform the transfer
        fromAccount.setBalance(fromAccount.getBalance() - amount.longValue());
        toAccount.setBalance(toAccount.getBalance() + amount.longValue());

        // Create and save the transaction
        Transaction transaction = new Transaction();
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.COMPLETED);

        transactionRepository.save(transaction);
    }
}

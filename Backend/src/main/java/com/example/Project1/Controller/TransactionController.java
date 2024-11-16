package com.example.Project1.Controller;

import com.example.Project1.Model.Transaction;
import com.example.Project1.Service.TransactionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAll();
    }

    @PostMapping("/transfer/accountNumber")
    public ResponseEntity<String> transferMoneyByAccountId(@RequestBody Transaction req){
        try{
            transactionService.transferMoneyByAccountId(req.getFromAccount().getAccount_id(),req.getToAccount().getAccount_id(),req.getAmount());
            return ResponseEntity.ok("Transaction Completed Successfully");
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.status(500).body("An error occured duting the transaction"+e.getMessage());
        }

    }
}

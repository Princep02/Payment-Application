package com.example.Project1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Project1.Model.Accounts;
import com.example.Project1.Service.*;



@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountsController {
    @Autowired
    AccountService service;

    @GetMapping("/accounts")
    public List<Accounts> getAccounts(){
        return service.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Accounts getAccountById(@PathVariable int id){
        return service.getAccountById(id);
    }

    @GetMapping("/accounts/user/{phoneNumber}")
    public List<Accounts> getAccountsByUserPhoneNumber(@PathVariable Long phoneNumber) {
        return service.getAccountsByUserPhoneNumber(phoneNumber);
    }

    @PostMapping("/accounts/create")
    public ResponseEntity<String> createAccount(@RequestBody Accounts acc) {
        if(acc.getAccount_number().isEmpty() || acc.getAccount_number()==null){
            return ResponseEntity.badRequest().body("Account number is mandatory");
        }
        if(acc.getUser().getUserid()<=0 || acc.getUser()==null){
            return ResponseEntity.badRequest().body("User id is mandatory");
        }
        try {
            service.updateAccount(acc);
            return ResponseEntity.ok("Account added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }


    @PutMapping("/accounts/update/{id}")
    public ResponseEntity<Accounts> updateAccountById(@PathVariable int id, @RequestBody Accounts acc){
        Accounts account=service.getAccountById(id);
        if(account!=null){
            acc.setAccount_id(id);
            service.updateAccount(account);
            return ResponseEntity.ok(service.getAccountById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable int id) {
        try {
            service.deleteAccount(id);
            return ResponseEntity.ok("Account deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting account: " + e.getMessage());
        }
    }

    @GetMapping("/accounts/balance/{id}")
    public ResponseEntity<Long> checkBalance(@PathVariable int id) {
        Accounts account = service.getAccountById(id);
        if (account != null) {
            return ResponseEntity.ok(account.getBalance());
        }
        return ResponseEntity.notFound().build();
    }
}

package com.example.Project1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Project1.Model.Transaction;

public interface TransactionRepository extends JpaRepository <Transaction, Long>{
    
    
}

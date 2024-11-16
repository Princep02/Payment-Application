package com.example.Project1.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;
    @Column(nullable = false)
    private long balance;
    @Column(nullable = false)
    private String account_number;
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonBackReference
    private Users user;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}


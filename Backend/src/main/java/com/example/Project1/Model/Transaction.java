package com.example.Project1.Model; 
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Accounts fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Accounts toAccount;

    private BigDecimal amount;
    private LocalDateTime timestamp;
    
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    // Getters and setters...
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Accounts getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Accounts fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Accounts getToAccount() {
        return toAccount;
    }

    public void setToAccount(Accounts toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}




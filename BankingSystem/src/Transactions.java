import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDateTime;
import java.util.*;

public class Transactions {
    private String bankAccId;
    private String bankAccIdTo;
    TransactionType transactionType;
    private double amount;
    private double balance;
    private LocalDateTime timestamp;


    public Transactions(String bankAccId, String bankAccIdTo, TransactionType transactionType, double amount, double balance, LocalDateTime timestamp) {
        this.bankAccId = bankAccId;
        this.bankAccIdTo = bankAccIdTo;
        this.transactionType = transactionType;
        this.amount = amount;
        this.balance = balance;
        this.timestamp = timestamp == null ? LocalDateTime.now() : timestamp;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }


    public String getBankAccId() {
        return bankAccId;
    }

    public String getbankAccIdTo() {
        return bankAccIdTo;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }


}



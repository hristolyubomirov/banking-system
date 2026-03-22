import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDateTime;
import java.util.*;

public class Transactions {
    private String ownerID;
    private String ownerTo;
    TransactionType transactionType;
    private double amount;
    private double balance;
    private LocalDateTime timestamp;


    public Transactions(String ownerID,String ownerTo,TransactionType transactionType, double amount, double balance, LocalDateTime timestamp) {
        this.ownerID = ownerID;
        this.ownerTo = ownerTo;
        this.transactionType = transactionType;
        this.amount = amount;
        this.balance = balance;
        this.timestamp = timestamp == null ? LocalDateTime.now() : timestamp;
    }
}



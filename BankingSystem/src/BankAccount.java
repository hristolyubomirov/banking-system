import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BankAccount {
    private String bankAccId;
    private double balance;
    protected static final double per_withdrawFee = 1.0;
    private List<Transactions> transactions = new ArrayList<>();

    public BankAccount(String custName,double balance){
        this.bankAccId = custName;
        this.balance = balance;
    }

    public String getBankAccId(){
        return bankAccId;
    }



    public void deposit(double deposit_amount){
            this.setBalance(this.balance+deposit_amount);
            transactions.add(new Transactions(this.getBankAccId(),null,TransactionType.Deposit, deposit_amount,this.getBalance(),null));



    }
    public void withdraw(double withdraw_amount){

        double curBalance = this.getBalance();
        if (withdraw_amount + per_withdrawFee <= curBalance) {
          this.setBalance(curBalance - (withdraw_amount + per_withdrawFee));
            transactions.add(new Transactions(this.getBankAccId(),null,TransactionType.Withdraw, withdraw_amount,this.getBalance()+per_withdrawFee,null));
            transactions.add(new Transactions(this.getBankAccId(),null,TransactionType.FEE, per_withdrawFee,this.getBalance(),null));
        }else{
            System.out.println("Not enough balance to withdraw."); //old
            throw new RuntimeException("Not enough balance to withdraw.");
        }
    }

    public void transferTo(BankAccount ownerTo,double amount){
        double curBalance = this.getBalance();
        if(amount <= curBalance) {
            this.withdraw(amount);
            ownerTo.deposit(amount);
            transactions.add(new Transactions(this.getBankAccId(), ownerTo.getBankAccId(), TransactionType.transferTo,amount,this.getBalance(),null));
        }else{
            System.out.println("Not enough balance to transfer."); //old
            throw new RuntimeException("Not enough balance to transfer.");
        }


    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }





    public List<Transactions> generateStatement(LocalDateTime fromDate, LocalDateTime toDate){
        List<Transactions> report = new ArrayList<>();


        for (int i = 0; i<this.getTransactions().size();i++){
            Transactions transaction = this.getTransactions().get(i);
            if(!transaction.getTimestamp().isBefore(fromDate) && !transaction.getTimestamp().isAfter(toDate)){
                report.add(transaction);
            }
        }
        return report;

    }

    public List<Transactions> getTransactions(){
        return this.transactions;
    }



}

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String owner;
    private double balance;
    protected static final double per_withdrawFee = 1.0;
    private List<Transactions> transactions = new ArrayList<>();

    public BankAccount(String owner,double balance){
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner(){
        return owner;
    }

    public void deposit(double deposit_amount){
            this.setBalance(this.balance+deposit_amount);
            transactions.add(new Transactions(this.getOwner(),null,TransactionType.Deposit, deposit_amount,this.getBalance(),null));



    }
    public void withdraw(double withdraw_amount){

        double curBalance = this.getBalance();
        if (withdraw_amount + per_withdrawFee <= curBalance) {
          this.setBalance(curBalance - (withdraw_amount + per_withdrawFee));
            transactions.add(new Transactions(this.getOwner(),null,TransactionType.Withdraw, withdraw_amount,this.getBalance()+per_withdrawFee,null));
            transactions.add(new Transactions(this.getOwner(),null,TransactionType.FEE, per_withdrawFee,this.getBalance(),null));
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
            transactions.add(new Transactions(this.getOwner(), ownerTo.getOwner(), TransactionType.transferTo,amount,this.getBalance(),null));
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

}

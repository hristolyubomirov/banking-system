import java.lang.classfile.instruction.ThrowInstruction;
import java.util.ArrayList;
import java.util.List;

public class CheckingAccount extends BankAccount{
    private static final double overdraftLimit = -50;
    private static final double overdraftFee = 0.5;
    private List<Transactions> transactions = new ArrayList<>();
    public CheckingAccount(String owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void withdraw(double withdraw_amount) {
        double curBalance = this.getBalance();
        if (curBalance - (withdraw_amount +per_withdrawFee) <= 0){
            curBalance = curBalance - overdraftFee;

        }
        if(curBalance - (withdraw_amount +per_withdrawFee) >= overdraftLimit){
            //doJob
            this.setBalance(curBalance-(withdraw_amount+ per_withdrawFee));
            transactions.add(new Transactions(this.getOwner(),null,TransactionType.Withdraw,withdraw_amount,curBalance + per_withdrawFee,null));
            transactions.add(new Transactions(this.getOwner(),null,TransactionType.FEE,per_withdrawFee,curBalance - per_withdrawFee,null));
            transactions.add(new Transactions(this.getOwner(),null,TransactionType.FEE,overdraftFee,0.0,null));
        }else{
            //reject

            System.out.println("Rejected. Overdraft limit exceeded."); //old
            throw new RuntimeException("Rejected. Overdraft limit exceeded.");
        }
    }
}

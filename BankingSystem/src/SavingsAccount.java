import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends BankAccount{
    private double maximumBalance;
    private List<Transactions> transactions = new ArrayList<>();
    public SavingsAccount(String owner, double balance) {
        super(owner, balance);
        this.maximumBalance = maximumBalance;
    }


    public void applyInterest(double interestRate, Integer time_period, CompoundingMode compoundingMode){
            double increase_amount;
            double curBalance = this.getBalance();
            if(interestRate < 1 && interestRate > 0 &&  curBalance >0) {

                switch(compoundingMode){
                    case YEARLY ->  time_period = time_period * 12;
                }


                //monthly default
                for (int i = 0; i < time_period; i++) {

                    increase_amount = interestRate * curBalance;
                    if (maximumBalance > curBalance + increase_amount) {
                        this.setBalance(curBalance + increase_amount);
                        transactions.add(new Transactions(this.getOwner(),null,TransactionType.applyInterest,increase_amount,curBalance,null));

                    } else {
                        throw new RuntimeException("Maximum balance is exceeded.");
                    }
                }
            }else{
                System.out.println("Please provide appropriate interestRate in range (0.0 - 1.0)."); //old
                throw new RuntimeException("Please provide appropriate interestRate in range (0.0 - 1.0).");

            }
            }





    @Override
    public void deposit(double deposit_amount){
        if(maximumBalance > this.getBalance() + deposit_amount) {
            this.setBalance(this.getBalance() + deposit_amount);
            transactions.add(new Transactions(this.getOwner(),null,TransactionType.Deposit,deposit_amount,this.getBalance() ,null));

        }else{
            throw new RuntimeException("Maximum balance is exceeded.");
        }


    }
}


import java.util.*;

void main(String[] args) {
    BankAccount ac1 = new BankAccount("test",10.1);
    BankAccount ac2 = new BankAccount("test2",20.1);

    Bank bank = new Bank();
    System.out.println();bank.openAccount();
    System.out.println();bank.openAccount();


    List<BankAccount> currListAccs= bank.listAllAccounts();
        for(int i = 0; i< currListAccs.size();i++){
            currListAccs.get(i).deposit(10.0);
            System.out.println(currListAccs.get(i).getOwner() + " " + currListAccs.get(i).getBalance());
        }
    // bank.closeAccount("c013232c-015e-4431-926a-e07b4f877197");

//        for(int i = 0; i<currListAccs.size();i++){
//            System.out.println(currListAccs.get(i).getBalance());
//
//        }




//    // test1 - transferTo appropriate amount
//    ac1.transferTo(ac2,10.1);
//    System.out.println(ac1.getBalance());
//    System.out.println(ac2.getBalance());

//    //test2 - transferTo not enough balance to perform
//    ac1.transferTo(ac2,10.2);
//    System.out.println(ac1.getBalance());
//    System.out.println(ac2.getBalance());

    //test 3 - savingAcc -success
    //   10+5, 15, 22.5, 11.25 -> 33.75

//    SavingsAccount svAc1 = new SavingsAccount("svAcc1",10);
//    svAc1.applyInterest(0.5,3);
//    System.out.println(svAc1.getBalance());

    //test 4 -savingAcc - fail - too much interestRate
//    SavingsAccount svAc2 = new SavingsAccount("svAcc2",10);
//    svAc1.applyInterest(20,3);
//    System.out.println(svAc2.getBalance());

}
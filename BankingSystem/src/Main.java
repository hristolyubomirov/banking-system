
import java.util.*;

void main(String[] args) {
    BankAccount ac1 = new BankAccount("test", 10.1);
    BankAccount ac2 = new BankAccount("test2", 20.1);

    Bank bank = new Bank();
    bank.openAccountNewCust("Test1");
    //bank.openAccountNewCust("Test1");
    bank.openAccount("Test1");
    bank.openAccount("Test1");
    bank.openAccount("Test1");
    bank.openAccountNewCust("Test2");


    Map<String, List<BankAccount>> getcustomers = bank.getCustomersList();
    List<BankAccount> listAccounts = bank.listAllAccounts();
    for (int i = 0; i < listAccounts.size(); i++) {
        System.out.println(listAccounts.get(i).getBankAccId());
    }


    for (String k : getcustomers.keySet()) {
        for (int i = 0; i < getcustomers.get(k).size(); i++) {
            System.out.println("List size of " + k + " = " + getcustomers.get(k).size() + " " + "balance:" + getcustomers.get(k).get(i).getBalance());
        }
    }


    Bank b = new Bank();
    b.openAccountNewCust("Test1");
    b.openAccount("Test1");
    b.openAccountNewCust("Test2");
    b.getAccount("Test1", 0).deposit(100);
    b.getAccount("Test1").deposit(100);
    b.getAccount("Test1").withdraw(10);
    b.getAccount("Test1", 0).transferTo(b.getAccount("Test2"), 100);
    List<Transactions> reportByDate = b.getAccount("Test1").generateStatement(LocalDateTime.of(2026, 3, 23, 0, 0), LocalDateTime.of(2026, 3, 23, 22, 0));

    for (int i = 0; i < reportByDate.size(); i++) {
        Transactions t = reportByDate.get(i);
        System.out.println("BankAccId: " + t.getBankAccId() + "\nTransferTo: " + t.getbankAccIdTo() + "\nTransaction Type: " + t.getTransactionType() + "\nAmount: " + t.getAmount() + "\nBalance: " + t.getBalance() + "\nTimestamp: " + t.getTimestamp());
    }

//    BankAccount bacc = new BankAccount("123",123);
//    BankAccount bacc2 = new BankAccount("123",123);
//
//    bacc.deposit(100);
//    bacc.withdraw(10);
//    System.out.println(bacc.getBalance());
//    bacc.transferTo(bacc2,10);

//    for(int i = 0; i<bacc.generateStatement(getcustomers).size();i++){
//        System.out.println(bacc.generateStatement().get(i).);
//    }


    //    List<BankAccount> currListAccs= bank.listAllAccounts();
//        for(int i = 0; i< currListAccs.size();i++){
//            currListAccs.get(i).deposit(10.0);
//            System.out.println(currListAccs.get(i).getOwner() + " " + currListAccs.get(i).getBalance());
//        }
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
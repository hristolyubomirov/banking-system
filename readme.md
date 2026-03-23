# Bank System (Java)

## Overview

Simple banking system implemented in Java to practice OOP:

- Encapsulation
- Inheritance
- Polymorphism
- Exception handling

## Features

- Create customers
- Open multiple accounts per customer
- Deposit / Withdraw / Transfer money
- Transaction history tracking
- Generate account statements (by date range)
- Different account types:
    - CheckingAccount (with overdraft)
    - SavingsAccount (no overdraft)

## Project Structure

![IMG_1](https://github.com/user-attachments/assets/399f5f1a-3f59-495a-9cd5-569c455d2480)

`Bank` → manages customers and accounts

`Customer` → holds customer info and accounts

`BankAccount` → base class for accounts

`CheckingAccount` → supports overdraft / overdraft Fee, overdraft Limit

`SavingsAccount` → restricted withdrawals / Applying Interestt - YEARLY / MONTHLY

`Transaction` → stores transaction data / Generate reports per Bank Account based on Date

## Example

```java
    Bank bank = new Bank();
    bank.openAccountNewCust("Test1");
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

```



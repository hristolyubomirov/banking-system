import java.time.LocalDateTime;
import java.util.*;

public class Bank {
    private final Map<String, BankAccount> store_bankAcc = new HashMap<>();
    //private + final -> encapsulation + final prevents overriding the map.

    private final List<Customer> customersList = new ArrayList<>();
    private final Map<String, List<BankAccount>> custAccounts = new HashMap<>();
    private List<Transactions> transactions = new ArrayList<>();


    public void openAccount(String custName) {
        String id = String.valueOf(UUID.randomUUID());
        store_bankAcc.put(id, new BankAccount(id, 0));
        //creating new cust as well

        for (int i = 0; i < customersList.size(); i++) {
            if (custName.equals(customersList.get(i).getName())) {
                Customer c = customersList.get(i);
                c.getAccounts().add(new BankAccount(id, 0));
                custAccounts.put(c.getName(), c.getAccounts());
                transactions.add(new Transactions(id, null, TransactionType.openAccount, 0, 0, null));
            } else {
                throw new RuntimeException("No such a Customer. Please create new customer by openAccountNewCust.");
            }
        }


        //custAccounts.put(c.getName(),custAccounts.computeIfAbsent(c.getName())custAccounts.get(c.getName()).add(new BankAccount(id,0)),new ArrayList<>(new BankAccount(id,0));


        //        map.put(Name,add newbank if new else  map.get(name).add(new bank) )

    }


    public void openAccountNewCust(String custName) {
        String id = String.valueOf(UUID.randomUUID());
        store_bankAcc.put(id, new BankAccount(id, 0));
        //creating new cust as well
        Customer c = new Customer(custName);


        customersList.add(c);

        c.getAccounts().add(new BankAccount(id, 0));
        custAccounts.put(c.getName(), c.getAccounts());
        transactions.add(new Transactions(id, null, TransactionType.openAccountNewCust, 0, 0, null));

    }


    public void closeAccount(String id) {
        if (store_bankAcc.containsKey(id)) {
            store_bankAcc.remove(id, store_bankAcc.get(id));
            transactions.add(new Transactions(id, null, TransactionType.closeAccount, 0, store_bankAcc.get(id).getBalance(), null));
        } else {
            System.out.println("Account not found."); //not needed but added first
            throw new RuntimeException("Account not found.");
        }
    }

    public BankAccount getAccount(String custName, int ind) {
        if (ind < custAccounts.size() && custAccounts.containsKey(custName)) {
            return custAccounts.get(custName).get(ind);
        } else {
            if (!custAccounts.containsKey(custName)) {
                System.out.println("No such an account. Please try again with another Account ID."); // not needed but added first

                throw new RuntimeException("No such an account. Please try again with another Account ID.");
            } else {
                throw new RuntimeException("Not a valid Bank Account index.");
            }
        }
    }


    public BankAccount getAccount(String custName) {
        if (custAccounts.containsKey(custName)) {
            return custAccounts.get(custName).get(0);

        } else {
            System.out.println("No such an account. Please try again with another Account ID."); // not needed but added first

            throw new RuntimeException("No such an account. Please try again with another Account ID.");
        }
    }

    public List<BankAccount> listAllAccounts() {

        List<BankAccount> list = new ArrayList<>();
        return new ArrayList<>(store_bankAcc.values());
    }


    public Map<String, List<BankAccount>> getCustomersList() {
        return custAccounts;
    }


}

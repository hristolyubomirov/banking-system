import java.util.*;

public class Customer {
    private String name;
    private static Integer idIncrement = 1;
    private final Integer id;
    private final String nid;
    private List<BankAccount> accounts = new ArrayList<>();

//    public Customer(boolean newCustomer, String name) {
//        this.newCustomer = newCustomer;
//        this.name = name;
//        this.id = idIncrement;
//        idIncrement++;
//        this.nid = name + id;
//    }

    public Customer(String name) {
        this.name = name;
        this.id = idIncrement;
        idIncrement++;
        this.nid = name + id;
    }


    public List<BankAccount> getAccounts(){
        return this.accounts;

    }
    public String getNid(){
        return this.nid;
    }
    public String getName(){
        return this.name;
    }

    public Customer getCustomer(){
        return this;
    }

}

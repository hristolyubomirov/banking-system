import java.util.*;

public class Bank {
    private final Map<String,BankAccount> store_bankAcc = new HashMap<>();
//private + final -> encapsulation + final prevents overriding the map.
    public void openAccount(){
        String id = String.valueOf(UUID.randomUUID());
        store_bankAcc.put(id,new BankAccount(id,0));


    }

    public void closeAccount(String id){
        if (store_bankAcc.containsKey(id)){
            store_bankAcc.remove(id,store_bankAcc.get(id));
        }else{
            System.out.println("Account not found."); //not needed but added first
            throw new RuntimeException("Account not found.");
        }
    }

        public BankAccount getAccount(String id){
            if(store_bankAcc.containsKey(id)){
                return store_bankAcc.get(id);
            }else{
                System.out.println("No such an account. Please try again with another Account ID."); // not needed but added first

                throw new RuntimeException("No such an account. Please try again with another Account ID.");
            }
        }

        public List<BankAccount> listAllAccounts(){

            List<BankAccount> list = new ArrayList<>();
            return new ArrayList<>(store_bankAcc.values());
        }
}

package service;

import model.Account;
import java.util.ArrayList;

public class BankService {

    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void createAccount(int accNo,String name,double balance){
        accounts.add(new Account(accNo,name,balance));
    }

    public static Account findAccount(int accNo){

        for(Account a:accounts){
            if(a.getAccNo()==accNo)
                return a;
        }

        return null;
    }
}
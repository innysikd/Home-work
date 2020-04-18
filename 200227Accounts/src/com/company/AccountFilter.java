package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class AccountFilter {

    public static List<Account> filterAccounts  (List<Account> accountList, Predicate<Account> accountPredicate){

        List<Account> accounts = new LinkedList<>();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountPredicate.test(accountList.get(i)) == true){
                accounts.add(accountList.get(i));
            }
        }

        return accounts;
    }
}

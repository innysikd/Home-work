package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<>();
        Account a1 = new Account("1234", 120000, false);
        Account a2 = new Account("3565", 0, false);
        Account a3 = new Account("7467", 1500000, true);
        Account a4 = new Account("8643", 0, true);
        Account a5 = new Account("8643", 56778, false);

        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);
        accounts.add(a5);

        Predicate<Account> isBalanceMoreThanO = (x) -> x.getBalance() > 0;

        Predicate<Account> notLocked = (x) -> x.isLocked() == false;

        Predicate<Account> isBalanceMoreThanOAndNotLocked = isBalanceMoreThanO.and(notLocked);

        AccountFilter filter1 = new AccountFilter();
        System.out.println(filter1.filterAccounts(accounts, isBalanceMoreThanO));
        System.out.println(filter1.filterAccounts(accounts, isBalanceMoreThanOAndNotLocked));

    }
}

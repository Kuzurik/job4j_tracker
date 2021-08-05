package ru.job4j.bank;

import java.util.*;

/**
    * Class describes work bank system and transfer money from account
    * to account.
    * @author Kuzura Alexandr
    * @version 1.0
    */

public class BankService {

    /**
     * Collection map keep Users and list of accounts every user.
     */

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Method adds the user to map.
     * @param user the user which adds to map
     */

    public void addUser(User user) {
      this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Method finds the User by passport and adds the account to list of accounts.
     * @param passport the passport by finds the user.
     * @param account the account which add to the list
     */

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        user.ifPresent(value -> this.users.get(value).add(account));
    }

    /**
     * finds the user by his passport.
     * @param passport the passport by
     * @return returns the user that was found.
     */

    public Optional<User> findByPassport(String passport) {
       return users.keySet().stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Finds the user by passport and finds the account in the list
     * @param passport the passport by finds the user.
     * @param requisite the requisite by finds the account
     * @return returns the account that was found.
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get()).stream().filter(a -> a.getRequisite().equals(requisite)).findFirst();
        }
        return rsl;
    }

    /**
     * Method finds source account and destination account.
     * if sours account and destination account dont equals null
     * method transfer money from sours account to destination account.
     * @param srcPassport the passport by finds the srcUser.
     * @param srcRequisite the requisite by finds the srcAccount.
     * @param destPassport the passport by finds the destUser.
     * @param destRequisite the requisite by finds the destAccount.
     * @param amount the amount which transfer from srcAccount to destAccount.
     * @return true if the operation was successful.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            srcAccount.get().transfer(destAccount.get(), amount);
            result = true;

        }
        return result;
    }
}

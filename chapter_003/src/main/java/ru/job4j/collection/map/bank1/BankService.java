package ru.job4j.collection.map.bank1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление нового пользователя.
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавление нового счета пользователя.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        if (user != null && !list.contains(account)) {
            list.add(account);
        }
    }

    /**
     * Поиск по паспорту списка пользователя.
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return rsl;
    }

    /**
     * Сначала ищем пользователя по паспорту,
     * затем ищем в списке счетов, нужный счет по реквитам.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        for (Account ac : users.get(user)) {
            if (ac.getRequisite().equals(requisite)) {
                rsl = ac;
            }
        }
        return rsl;
     }

     /**
      * Ищем аккаунты по реквизитам с которого отправим и на который отправим,
      * затем делаем проверку что они не пустые и на счете отправителя сумма не меньше суммы перевода*/
     public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcPassport != null && destPassport != null
                && srcAccount.getBalance() >= amount) {
            rsl = true;
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;

     }
}

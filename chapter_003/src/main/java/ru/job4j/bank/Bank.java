package ru.job4j.bank;


import java.util.ArrayList;
import java.util.List;


import java.util.*;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Bank {
    /**
     * Коллекция пользователей с баковскими счетами */
private Map<User, ArrayList<Account>> base = new HashMap<>();

/**
 * Добавление пользователей в базу.
 *
 * @param user - пользователь.
 */
public void addUser(User user)  {
    this.base.putIfAbsent(user, new ArrayList<>());
    }

/**
 * Удаление пользователя из базы.
 * @param user - пользователь.
 */
public void delete(User user) {
    this.base.remove(user);
}

 /**
  * Ищет пользователя по номеру паспорта..
  *  @param passport
  */
 public User getUser(String passport) {
     return this.base.keySet()
             .stream().filter(e ->
                     e.getPassport().equals(passport)).findFirst().orElse(null);
    }

/**
 * Метод добавляет банковский счет для пользователя.
 * @param account - банковский счет.
 * @param passport - пользователь.
 */

public void addAccountToUser(String passport, Account account) {
    this.base.keySet()
    .stream()
            .filter(e -> e.getPassport().equals(passport))
            .findFirst()
            .map(user -> base.get(user))
            .ifPresent(a -> a.add(account));
}



/**
 * Метод удаляет счет пользователя.
 * @param account - банковский счет.
 * @param passport - пользователь.
 */
public void deleteAccountFromUser(String passport, Account account)  {
    this.base.keySet()
    .stream()
    .filter(e -> e.getPassport().equals(passport))
    .findFirst()
    .map(user -> this.base.get(user))
    .ifPresent(a -> a.remove(account));
}

/**
 * Метод возвращает список счетов конкретного пользователя.
 *
 * @param passport - паспорт пользователь.
 * @return - список счетов пользователя.
 * */
public List<Account> getUserAccounts(String passport) {
    return this.base.get(getUser(passport));
}

/**
 * Метод возвращает список всех пользователей банка.
 *
 * @return список пользователей.
 */
public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    users.addAll(this.base.keySet());
    return users;
}

/**
 * Метод возвращает аккаунт пользователя в результате поиска по паспорту и реквезитам.
 * @param passport номер паспорта пользователя.
 * @param requisite реквизиты пользователя.
 * @return найденный аккаунт.
 */
public Account getOneUserAccount(String passport, String requisite) {
    return getUserAccounts(passport)
            .stream()
            .filter(u -> u.getRequisites().equals(requisite))
            .findFirst()
            .orElse(null);
}

/**
 * Метод осуществляет перевод денег с одного банковского счета на другой.
 * Перевод произойдет только в том случае, если счет куда переводятся деньги
 * существует и количество денег на счете с которого будет осуществлен перевод
 * не меньше суммы перевода.
 *
 * @param srcPassport - номер паспорта пользователь осуществляющий перевод.
 * @param srcRequisite - реквизиты пользователя отправляющего деньги.
 * @param destPassport - номер паспорта пользователя получающего деньги.
 * @param destRequisite - реквизиты пользователя, получающего деньги.
 * @param amount - сумма перевода.
 * @return true - если все прошло успешно. */
public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
    boolean valid = false;
    Account src = getOneUserAccount(srcPassport, srcRequisite);
    Account dst = getOneUserAccount(destPassport, destRequisite);
    if (src != null && dst != null) {
        if (amount > 0 && src.getValues() != 0 && src.getValues() > amount) {
            src.subAmount(amount);
            dst.addAmount(amount);
            valid = true;
        }
    }
    return valid;
}

public String toString() {
    return "Bank{" + "accounts=" + base + "}";
    }
}

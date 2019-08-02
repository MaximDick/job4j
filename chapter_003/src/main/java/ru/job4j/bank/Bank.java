package ru.job4j.bank;


import ru.job4j.bank.exceptions.AccountAlreadyExistException;
import ru.job4j.bank.exceptions.NoSuchAccountException;
import ru.job4j.bank.exceptions.UserAlreadyExistExeption;

import java.lang.reflect.Array;
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
     Optional<User> searched = this.base.keySet().stream()
             .filter(user -> user.getPassport().equals(passport))
             .findAny();
     return searched.get();
    }

/***
 * Метод добавляет банковский счет для пользователя.
 * @param account - банковский счет.
 * @param passport - пользователь.
 */
public void addAccountToUser(String passport, Account account) {
    ArrayList<Account> temp = this.base.get(getUser(passport));
    if (temp.indexOf(account) != -1) {
        throw new AccountAlreadyExistException("Account already exist!");
    }
        temp.add(account);
}


/**
 * Метод удаляет счет пользователя.
 * @param account - банковский счет.
 * @param passport - пользователь.
 * @throws NoSuchAccountException if can't find this account.
 */
public void deleteAccountFromUser(String passport, Account account) throws NoSuchAccountException {
    ArrayList<Account> temp = this.base.get(getUser(passport));
    if (temp.indexOf(account) < 0) {
        throw new NoSuchAccountException("No such account!");
    }
    temp.remove(account);
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
 * @throws NoSuchAccountException if can't find this account.
 * @return найденный аккаунт.
 */
public Account getOneUserAccount(String passport, String requisite) throws NoSuchAccountException {
    List<Account> accounts = getUserAccounts(passport);
    int index = accounts.indexOf(new Account(0, requisite));
    if (index < 0) {
        throw new NoSuchAccountException("No such account!");
    }
    return accounts.get(index);
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

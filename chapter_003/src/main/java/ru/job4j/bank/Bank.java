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
 * Добавление пользователей в базу. При этом изначально
 * клиент инициализируется без коллекции банковских счетов.
 *
 * @param user - пользователь.
 */
public void addUser(User user) {
    this.base.put(user, null);
}

/**
 * Удаление пользователя из базы.
 * @param user - пользователь.
 */
public void delete(User user) {
    this.base.remove(user);
}

/***
 * Метод производит добавление счета клиенту. При этом
 * проверяется существует ли у этого пользователя счета, если да, то
 * в коллекцию добавляется новый счет. Если нет, по ключу
 * добавляется коллекция и только потом в нее записывается новый счет.
 *
 * @param account - банковский счет.
 * @param user - пользователь.
 */
public void addAccountToUser(Account account, User user) {
    this.base.putIfAbsent(user, new ArrayList<>());
    this.base.get(user).add(account);
}

/**
 * Метод удаляет счет пользователя.
 *
 * @param account - банковский счет.
 * @param user - пользователь.
 */
public void deleteAccountFromUser(Account account, User user) {
    this.base.get(user).remove(account);
}

/**
 * Метод возвращает список счетов конкретного пользователя.
 *
 * @param user - пользователь.
 * @return - список счетов пользователя.
 * */
public List<Account> getUserAccounts(User user) {
    return this.base.get(user);
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
 * Метод осуществляет перевод денег с одного банковского счета на другой.
 * Перевод произойдет только в том случае, если счет куда переводятся деньги
 * существует и количество денег на счете с которого будет осуществлен перевод
 * не меньше суммы перевода.
 *
 * @param srcUser - пользователь осуществляющий перевод.
 * @param srcAccount - счет с которого осуществляется перевод.
 * @param dstUser - пользователь получатель.
 * @param dstAccount - счет получателя.
 * @param amount - сумма перевода.
 * @return true - если все прошло успешно. */

public boolean transfer(User srcUser, Account srcAccount,
                                User dstUser, Account dstAccount, double amount) {
    boolean valid = false;
    if (this.base.get(dstUser).contains(dstAccount) && amount <= srcAccount.getValues()) {
        srcAccount.setValues(srcAccount.getValues() - amount);
        dstAccount.setValues(dstAccount.getValues() + amount);
        valid = true;
    }
    return valid;
}

public String toString() {
    return "Bank{" + "accounts=" + base + "}";
    }
}

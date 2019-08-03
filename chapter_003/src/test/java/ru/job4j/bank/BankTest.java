package ru.job4j.bank;

import org.junit.Test;
import ru.job4j.bank.exceptions.NoSuchAccountException;



import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {

    /**
     * При добавлении двух пользователей размер хранилища должен быть равен 2.
     */

    @Test
    public void whenAddTwoUsers() {
        Bank bank  = new Bank();
        bank.addUser(new User("Dima", "123456"));
        bank.addUser(new User("Ivan", "345678"));
        assertThat(bank.getAllUsers().size(), is(2));
    }
    /**
     * Добавляем двух пользователей и удаляем первого.
     * Размер зранилища должен быть 1.
     */
    @Test
    public void deleteUser() {
        Bank bank = new Bank();
        User first = new User("Dima", "123456");
        User second = new User("Ivan", "356788");
        bank.addUser(first);
        bank.addUser(second);
        bank.delete(first);
        assertThat(bank.getAllUsers().size(), is(1));
    }


    /**
     * Добавляем одного пользователя и создаем у него
     * банковский счет.
     */
    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Dima", "123456"));
        bank.addAccountToUser("123456", new Account(50.00, "1"));
        Account expected = new Account(50.00, "1");
        assertThat(bank.getOneUserAccount("123456", "1"), is(expected));
    }

    /**
     * Добавляем одного пользователя и создаем у него 2 банковский счета.
     * Затем удаляем этот банковский счет.
     *
     */
    @Test (expected = NoSuchAccountException.class)
    public void deleteAccountFromUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Ivan", "123456"));
        bank.addAccountToUser("123456", new Account(50.00, "1"));
        bank.addAccountToUser("123456", new Account(50.00, "2"));
        bank.deleteAccountFromUser("123456", bank.getOneUserAccount("123456", "2"));
        bank.getOneUserAccount("123456", "2");
    }

    /**
     * Добавляем одного пользователя, создаем у него два счета.
     * Проверяем размер коллекции со счетами этого пользователя равен 2.
     */
   @Test
    public void getUserAccounts() {
        Bank bank = new Bank();
        bank.addUser(new User("Dima", "123456"));
        bank.addAccountToUser("123456", new Account(50.00, "1"));
        bank.addAccountToUser("123456", new Account(50.00, "2"));
        List<Account> expected = Arrays.asList(
                new Account(50.00, "1"),
                new Account(50.00, "2")
        );
        assertThat(bank.getUserAccounts("123456"), is(expected));
    }
    /**
     * Добавляем двух пользователей и у каждого из них создаем по одному счету
     * Осуществляем перевод со счета первого 40.00 единиц на счет второго.
     */
    @Test
    public void transferMoney() {
        Bank bank = new Bank();
        User first = new User("Dima", "12345");
        User second = new User("Ivan", "23456");
        bank.addUser(first);
        bank.addUser(second);
        bank.addAccountToUser("12345", new Account(50.00, "123"));
        bank.addAccountToUser("23456", new Account(50.00, "321"));
        assertTrue(bank.transferMoney("12345", "123", "23456", "321", 10.00));
    }

    /**
     * Добавляем одного клиента и создаем у него два счета.
     * Осуществляем перевод с первого счета 20 единиц на второй счет.
     */
    @Test
    public void whenTransferFromAccountUserThen() {
        Bank bank = new Bank();
        bank.addUser(new User("Dima", "12345"));
        bank.addAccountToUser("12345", new Account(50.00, "123"));
        bank.addAccountToUser("12345", new Account(50.00, "321"));
       assertTrue(bank.transferMoney("12345", "123", "12345", "321", 30.00));
    }

    /**
     * Добавляем одного пользоваеля и создаем два счета.
     * Осуществляем перевод суммы превышающей допустимую.
     * Проверяем что false.
     */
    @Test
    public void whenTransferBigAmountThenFalse() {
        Bank bank = new Bank();
        bank.addUser(new User("Dima", "12345"));
        bank.addAccountToUser("12345", new Account(50.00, "123"));
        bank.addAccountToUser("12345", new Account(50.00, "321"));
        assertThat(bank.transferMoney("12345", "123", "12345", "321", 500.00), is(false));
    }
}

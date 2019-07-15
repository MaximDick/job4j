package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankTest {

    /**
     * Поля для тестирования методов.
     *Два объекта типа User  и два объекта типа Account.
     */
    private static final User FIRST = new User("Mark", "1266");
    private static final User SECOND = new User("Boris", "1345");
    private static final Account FIRST_ACC = new Account(122.97, "1555");
    private static final Account SECOND_ACC = new Account(65.21, "9233");

    /**
     * При добавлении двух пользователей размер хранилища должен быть равен 2.
     */

    @Test
    public void whenAddTwoUsersThenSizeTwo() {
        Bank bank  = new Bank();
        bank.addUser(FIRST);
        bank.addUser(SECOND);
        assertThat(bank.getAllUsers().size(), is(2));
    }
    /**
     * Добавляем двух пользователей и удаляем первого.
     * Размер зранилища должен быть 1.
     */
    @Test
    public void deleteUser() {
        Bank bank = new Bank();
        bank.addUser(FIRST);
        bank.addUser(SECOND);
        bank.delete(FIRST);
        assertThat(bank.getAllUsers().size(), is(1));
    }


    /**
     * Добавляем одного пользователя и создаем у него
     * 2 банковских счета. Проверяем, что под индексом 1 коллекции
     * счетов содержится реквизит второго счета.
     */
    @Test
    public void addAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(FIRST);
        bank.addAccountToUser(FIRST_ACC, FIRST);
        bank.addAccountToUser(SECOND_ACC, FIRST);
        assertThat(bank.getUserAccounts(FIRST).get(1).getRequisites(), is("9233"));
    }

    /**
     * обавляем одного пользователя и создаем у него один банковский счет.
     * Затем удаляем этот банковский счет.
     * Размер хранилища счетов этого пользователя равен 0.
     */
    @Test
    public void deleteAccountFromUser() {
        Bank bank = new Bank();
        bank.addUser(FIRST);
        bank.addAccountToUser(FIRST_ACC, FIRST);
        bank.deleteAccountFromUser(FIRST_ACC, FIRST);
        assertThat(bank.getUserAccounts(FIRST).size(), is(0));
    }

    /**
     * Добавляем одного пользователя, создаем у него два счета.
     * Проверяем размер коллекции со счетами этого пользователя равен 2.
     */
    @Test
    public void getUserAccounts() {
        Bank bank = new Bank();
        bank.addUser(FIRST);
        bank.addAccountToUser(FIRST_ACC, FIRST);
        bank.addAccountToUser(SECOND_ACC, FIRST);
        assertThat(bank.getUserAccounts(FIRST).size(), is(2));
    }

    /**
     * Добавляем двух пользователей и у каждого из них создаем по одному счету
     * Осуществляем перевод со счета первого 60.00 единиц на счет второго и проверяем,
     * что теперь на счете второго содержится сумма его старого счета + сумма перевода.
     */
    @Test
    public void transferMoney() {
        Bank bank = new Bank();
        bank.addUser(FIRST);
        bank.addUser(SECOND);
        bank.addAccountToUser(FIRST_ACC, FIRST);
        bank.addAccountToUser(SECOND_ACC, SECOND);
        bank.transfer(FIRST, FIRST_ACC, SECOND, SECOND_ACC, 60.00);
        assertThat(bank.getUserAccounts(SECOND).get(0).getValues(), is(125.21));
    }

    /**
     * Добавляем одного клиента и создаем у него два счета.
     * Осуществляем перевод с первого счета 22 единиц на второй счет и проверяем,
     * что на первом счете осталось 100.97 */
    @Test
    public void whenTransferFromAccountUserThen() {
        Bank bank = new Bank();
        bank.addUser(FIRST);
        bank.addAccountToUser(FIRST_ACC, FIRST);
        bank.addAccountToUser(SECOND_ACC, FIRST);
        bank.transfer(FIRST, FIRST_ACC, FIRST, SECOND_ACC, 22.00);
        assertThat(bank.getUserAccounts(FIRST).get(0).getValues(), is(40.97));
    }

    /**
     * Добавляем одного пользоваеля и создаем два счета.
     * Осуществляем перевод суммы превышающей допустимую.
     * Проверяем что false.
     */
    @Test
    public void whenTransferBigAmountThenFalse() {
        Bank bank = new Bank();
        bank.addUser(SECOND);
        bank.addAccountToUser(FIRST_ACC, SECOND);
        bank.addAccountToUser(SECOND_ACC, SECOND);
        assertThat(bank.transfer(SECOND, FIRST_ACC, SECOND, SECOND_ACC, 500), is(false));
    }
}

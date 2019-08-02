package ru.job4j.bank.exceptions;

import ru.job4j.bank.Account;

public class AccountAlreadyExistException  extends RuntimeException {
    public AccountAlreadyExistException(String message) {
        super(message);
    }
}

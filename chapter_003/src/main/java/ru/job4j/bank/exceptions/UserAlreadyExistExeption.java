package ru.job4j.bank.exceptions;

public class UserAlreadyExistExeption extends RuntimeException {
    public UserAlreadyExistExeption(String message) {
        super(message);
    }
}

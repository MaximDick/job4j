package ru.job4j.collection.set;

import ru.job4j.collection.set.Account;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();

        for (Account people: accounts) {
            rsl.add(people);
        }
       return rsl;
    }
}

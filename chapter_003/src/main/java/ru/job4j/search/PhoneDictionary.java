package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }


    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return result Список подходящих пользователей.
     */
    public List<Person> find(String key) {
        var result = new ArrayList<Person>();
        for (var value : persons) {
            if (value.getName().contains(key)
                || value.getSurname().contains(key)
                || value.getPhone().contains(key)
                || value.getAddress().contains(key)) {
                 result.add(value);
            }
        }
        return result;
    }
}
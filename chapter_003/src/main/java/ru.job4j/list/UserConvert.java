package ru.job4j.list;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class UserConvert {

    /**
     * Method convert List to Map.
     * @param list ArrayList<User>.
     * @return Map<User>.
     */

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}

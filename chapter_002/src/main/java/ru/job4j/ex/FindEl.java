package ru.job4j.ex;

import java.util.Arrays;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFounfException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value != null && value[i].equals(key)) {
                rsl = i;
            }
        }

        if (rsl == -1)  {
            throw new ElementNotFounfException("Not found index");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] arr = {"Ivan", "Max", "Dom", "Dima"};
        try {
            System.out.println("Index : " + FindEl.indexOf(arr, "Dom"));
            System.out.println("Index : " + FindEl.indexOf(new String[] {"al", "mood", "jo"}, "mood"));

        } catch (ElementNotFounfException e) {
            e.printStackTrace();
        }
    }
}

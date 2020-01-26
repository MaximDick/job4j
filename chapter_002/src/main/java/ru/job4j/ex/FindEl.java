package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFounfException {
        int rsl = -1;
        if (value == null) {
            throw new ElementNotFounfException("Not found index");
        }

        int i = 0;
        while (i < value.length) {
            if (value[i] == key) {
                return i;
            } else i += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String [] arr = {"Tom", "John", "Tim"};
        try{
            System.out.println("Index : " + indexOf(arr, "pit"));
        } catch (ElementNotFounfException e) {
            e.printStackTrace();
        }
    }
}

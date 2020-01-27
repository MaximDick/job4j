package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        if (n == 1) {
            return 1;
        } else {
            return (n - 1) * n;
        }
    }
        //return n == 1 ? 1 : (n -1) * n; можно через тернарный оператор.

    public static void main(String[] args) {
        int rsl = calc(6);
        System.out.println(rsl);
    }
}

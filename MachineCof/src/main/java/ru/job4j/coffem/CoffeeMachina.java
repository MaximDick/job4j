package ru.job4j.coffem;

import java.util.Arrays;

public class CoffeeMachina {

    private  final int[] coins = {10, 5, 2, 1};


    public static void main(String[] args) {

        CoffeeMachina coffe = new CoffeeMachina();
        int[] result2 = coffe.changes(50, 15);
        System.out.println(Arrays.toString(result2));
    }



    public int[] changes(int value, int price) {
        int[] result = new int[6];
        int b = value - price;
        int coount = 0;
        for (int i = 0; i < result.length; i++) {
            if (b != 0) {
                int a = coins[i];
                int c = b / a;
                while (i < result.length) {
                    int tmp = c;
                    while (tmp != 0) {
                        int d = a;
                        result[coount] = d;
                        coount++;
                        tmp--;
                    }
                    break;
                }
                if (b % a == 0) {
                    break;
                }
                b = b - (a * c);
            }

        }
        return result;
    }
}
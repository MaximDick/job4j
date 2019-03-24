package ru.job4j.tracker;

import java.util.List;


public class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1 ;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutExeption moe) {
                System.out.println("Please select key from menus. ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again. ");
            }
        } while (invalid);
        return value;
    }
}

/*public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

   *//*public ValidateInput() {

    }*//*

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutExeption moe) {
                System.out.println("Please select key from menu. ");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again. ");
            }
        } while (invalid);
        return value;
    }
}*/

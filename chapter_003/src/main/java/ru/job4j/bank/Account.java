package ru.job4j.bank;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Account {
    private double values; // кол-во денег
    private String requisites; // банковский счет

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public double getValues() {
        return this.values;
    }


    public String getRequisites() {
        return this.requisites;
    }

    /**
     * Списание денег со счета
     * */
    public void subAmount(double amount) {
        this.values -= amount;
    }
    /**
     * Зачисление денег на счет.*/
    public void addAmount(double amount) {
        this.values += amount;
    }

    public String toString() {
        return "Account{ values=" + values + ", reqs='" + requisites + "\\" + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.requisites.equals(account.requisites);
    }

    public int hashCode() {
        return this.requisites.hashCode();
    }
}

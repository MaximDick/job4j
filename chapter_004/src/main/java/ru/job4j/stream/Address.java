package ru.job4j.stream;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Address {
    private String city;
    private String street;

    private int home;

    private int apartment;


    /**
     * @param city - city.
     * @param street - street.
     * @param home - home.
     * @param apartment - apartment.
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Address address = (Address) o;

            if (home != address.home) {
                return false;
            }

            if (apartment != address.apartment) {
                return false;
            }
            if (city != null ? !city.equals(address.city) : address.city == null) {
                return false;
            }

            return street != null ? street.equals(address.street) : address.street == null;
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 22 * result + (street != null ? street.hashCode() : 0);
        result = 22 * result + home;
        result = 22 * result + apartment;
        return result;
    }
}

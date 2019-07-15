package ru.job4j.bank;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User {
    private String name;
    private String passport;

    public User() { }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public   String toString() {
        return String.format("User [Name: %s. Passport: %s.]", name, passport);
    }

   @Override
    public int hashCode() {
        return this.passport.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean valid = false;
        if (obj != null) {
            if (this == obj) {
                valid = true;
            }
            if (!valid && getClass() == obj.getClass()) {
                User user = (User) obj;
                if ((this.name != null && this.passport != null && user.name != null && user.passport != null)) {
                    valid = this.name.equals(user.name) && this.passport.equals(user.passport);
                }
            }
        }
        return valid;
    }
}

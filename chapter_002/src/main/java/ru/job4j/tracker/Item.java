package ru.job4j.tracker;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Item {

    public String id;
    public String name;

    public String description;

    public long create;

    public Item() {
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Item(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Переопределение метода toString()
     */
    @Override
    public String toString() {
        return "Название : " + getName()
                + ", ID :  " + getId()
                + ", Описание : " + getDescription();
    }
}


package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Tracker {
    /***
     * Массив для хранения заявок.
     */
    private Item[] items = new Item[100];

    /**
     * Указателья чейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод для редактирования заявок
     *
     * @param id идентификационный номер.
     * @param item заявка.
     * @return result
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index != this.position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                item.setId(id);
                items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод для удаления заявок
     * @param id
     * @return result
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != this.position; index++) {
            if (items[index].getId().equals(id)) {
                if (index != items.length) {
                    System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                    position--;
                    result = true;
                    break;
                }
                if (index == items.length) {
                    System.arraycopy(items, index + 1, items, index, 1);
                    position--;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод для получения списка всех заявок.
     * @return result
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }


    /**
     * Метод для получения заявки по имени.
     * @param key название передаваемое в качестве параметра для сравнения.
     * @return result
     */
    public Item[] findByName(String key) {

        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index < position; index++) {
            if (items[index].getName().equals(key)) {
                result[count++] = items[index];
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Метод для получения заявки по id.
     * @param id идентификационный номер передаваемый в качестве параметра.
     * @return result
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
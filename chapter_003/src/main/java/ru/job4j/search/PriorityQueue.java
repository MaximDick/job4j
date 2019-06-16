package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставляет в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        for (int i = 0; i <= tasks.size(); i++) {
            if (tasks.isEmpty() || task.getPriority() < tasks.get(i).getPriority()) {
                tasks.add(i, task);
                break;
            }

            if (task.getPriority() > tasks.get(tasks.size() - 1).getPriority()) {
                tasks.add(tasks.size(), task);
                break;
            }
        }

    }

    public Task take() {
        return this.tasks.poll();
    }
}
package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingleThree {

    private static final TrackerSingleThree INSTANCE = new TrackerSingleThree();
    private TrackerSingleThree() {

    }

    public static TrackerSingleThree getInstance() {
        return INSTANCE;
    }

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        TrackerSingleThree tracker = TrackerSingleThree.getInstance();
    }

}
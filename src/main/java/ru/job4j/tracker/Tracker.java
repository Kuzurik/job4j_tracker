package ru.job4j.tracker;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            items[index].setId(id);
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = false;
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, items.length - index - 1);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }
}
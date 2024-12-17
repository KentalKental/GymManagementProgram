package main;

import java.util.*;

public class CrudService<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
        System.out.println("Item added successfully.");
    }

    public List<T> getAll() {
        return items;
    }

    public void delete(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void update(int index, T item) {
        if (index >= 0 && index < items.size()) {
            items.set(index, item);
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }
}

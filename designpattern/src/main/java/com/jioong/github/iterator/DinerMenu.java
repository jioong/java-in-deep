package com.jioong.github.iterator;

/**
 * Created by jioong on 17-8-22.
 */
public class DinerMenu {

    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    MenuItem[] items;

    public DinerMenu() {
        this.items = new MenuItem[MAX_ITEMS];

        addItem("a", "b", true, 1.2);
        addItem("d", "c", true, 1.2);
        addItem("e", "f", false, 1.2);
        addItem("g", "h", true, 1.2);
    }

    public void addItem(String name, String desc, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, desc, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("Out of menu");
        } else {
            items[numberOfItems] = item;
            numberOfItems += 1;
        }
    }

    public MenuItem[] getItems() {
        return items;
    }
}

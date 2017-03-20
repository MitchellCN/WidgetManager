package com.theironyard;

/**
 * This class represents a widget of some sort.
 */
public class Widget {

    public String name;
    public String description;
    public String type;
    public int weight;
    public int inventory;

    public Widget(String name, String description, String type, int weight, int inventory) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.weight = weight;
        this.inventory = inventory;
    }
}

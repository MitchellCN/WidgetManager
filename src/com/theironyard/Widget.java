package com.theironyard;

/**
 * This class represents a widget of some sort.
 */
public class Widget {

    // these are five properties that represent a widget
    public String name;
    public String description;
    public String type;
    public int weight;
    public int inventory;

    /**
     * This is a public constructor to more easily create an instance of Widget.
     *
     * @param name
     * @param description
     * @param type
     * @param weight
     * @param inventory
     */
    public Widget(String name, String description, String type, int weight, int inventory) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.weight = weight;
        this.inventory = inventory;
    }
}

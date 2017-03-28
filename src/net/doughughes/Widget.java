package net.doughughes;

/**
 * Created by doug on 3/28/17.
 */
public class Widget {
    private String name;
    private String description;
    private String type;
    private double weight;
    private int quantity;

    public Widget(String name, String description, String type, double weight, int quantity) {

        this.name = name;
        this.description = description;
        this.type = type;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }
}

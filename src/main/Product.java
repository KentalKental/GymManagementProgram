package main;
public class Product {
	private String[] attributes = {"id","name","price","quantity"};
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String[] getAtt() { return attributes; };
    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | %-10.2f | %-10d |", id, name, price, quantity);
    }
}

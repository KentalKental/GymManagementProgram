package main;
public class Package {
	private String[] attributes = {"id","name","price","durationInDays"};
    private String id;
    private String name;
    private double price;
    private int durationInDays;

    public Package(String id, String name, double price, int durationInDays) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.durationInDays = durationInDays;
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getDurationInDays() { return durationInDays; }
    public String[] getAtt() { return attributes; };
    
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Price: %.2f | Duration: %d days", id, name, price, durationInDays);
    }
}

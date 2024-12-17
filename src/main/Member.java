package main;
public class Member {
	private String[] attributes = {"id","name","age","tier"};
    private String id;
    private String name;
    private int age;
    private String tier; // Gold, Silver, Base
    
    public Member(String id, String name, int age, String tier) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tier = tier;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getTier() { return tier; }
    public String[] getAtt() { return attributes; };

    @Override
    public String toString() {
        return String.format("| %s | %s | %d | %s |", id, name, age, tier);
    }
}

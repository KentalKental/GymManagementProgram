package main;
public class Member {
	private String[] attributes = {"id","name","age","tier","package"};
    private String id;
    private String name;
    private int age;
    private String tier; // Gold, Silver, Base
    private Package packageType;
    
    public Member(String id, String name, int age, String tier,Package pack) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tier = tier;
        this.packageType = pack;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getTier() { return tier; }
    public String[] getAtt() { return attributes; }
    public Package getPackageType() { return packageType; }

	@Override
    public String toString() {
        return String.format("| %-10s | %-10s | %-10d | %-10s | %10s |", id, name, age, tier, packageType.getName());
    }
}

package main;
import java.util.*;
public class MemberFactory implements Factory<Member> {
    private final Scanner scanner = new Scanner(System.in);
    private static int memberCounter = 0;

    @Override
    public Member create(int x) {
    	String input,name,tier,id;
    	int age = -1;
    	input = name = tier = id = "";
	    System.out.print("Enter Member's Name [Enter '0' to exit]: ");
	    input = name = scanner.nextLine();
	        
	    if(input.equals("0")) return null;   	
	    System.out.print("Enter Member's Age [Enter '0' to exit]: ");
	    age =Integer.parseInt(input = scanner.nextLine());
	    
	    if(input.equals("0")) return null;
	
	    String temp;
	    do {
	        System.out.print("Enter Membership Tier (Gold/Silver/Base) [Enter '0' to exit]: ");
	        tier = input =scanner.nextLine();
		        
	        if(input.equals("0")) return null;
		        
	        temp = tier.toLowerCase();
		        
	       	if(temp.equals("gold")) id = "GM-";
	       	else if(temp.equals("silver")) id = "SM-";
	       	else if(temp.equals("base")) id = "BM-";
	       	else System.out.println("Invalid input !");
	       	
	    }while(!temp.equals("gold") && !temp.equals("silver") && !temp.equals("base"));
	    id = (x != -1) ? id + (x+1):id + (++memberCounter);// -1 artinya create. bukan -1 artinya update
    	
        return new Member(id, name, age, tier);
    }

}

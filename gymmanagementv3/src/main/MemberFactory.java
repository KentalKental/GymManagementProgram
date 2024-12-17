package main;
import java.util.*;
public class MemberFactory implements Factory<Member> {
    private final Scanner scanner = new Scanner(System.in);
    private static int memberCounter = 0;

    @Override
    public Member create() {
        System.out.print("Enter Member's Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Member's Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Membership Tier (Gold/Silver/Base): ");
        String tier = scanner.nextLine();

        String id = "M-" + (++memberCounter);
        return new Member(id, name, age, tier);
    }

}

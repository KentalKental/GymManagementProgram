package main;

import java.util.*;

public class GymManagementApp {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        CrudService<Member> memberService = new CrudService<>();
        CrudService<Product> productService = new CrudService<>();
        // CrudService<Package> packageService = new CrudService<>();

        MemberFactory memberFactory = new MemberFactory();
        ProductFactory productFactory = new ProductFactory();

        while (true) {
            System.out.println("\n=== Gym Management System ===");
            System.out.println("1. Manage Members");
            System.out.println("2. Manage Products");
            System.out.println("3. Manage Packages");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> menuController.showCrudMenu("Member", memberService, memberFactory);
                case "2" -> menuController.showCrudMenu("Product", productService, productFactory);
                case "3" -> System.out.println("Package management coming soon!");
                case "4" -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
    }
}

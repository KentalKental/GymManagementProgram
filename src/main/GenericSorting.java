package main;
import java.util.*;
public class GenericSorting {
	
	public <T> void sortList(List<T> service, String choice) {
		if(service.get(0) instanceof Member) {
			switch (choice) {
            case "2": 
                service.sort((p1, p2) -> ((Member) p1).getId().compareTo(((Member) p2).getId()));
                break;
            case "3": 
                service.sort((p1, p2) -> ((Member) p1).getName().compareTo(((Member) p2).getName()));
                break;
            case "4": 
                service.sort((p1, p2) -> Integer.compare(((Member) p1).getAge(), ((Member) p2).getAge()));
                break;
            case "5": 
                service.sort((p1, p2) -> ((Member) p1).getTier().compareTo(((Member) p2).getTier()));
                break;
            default:
                System.out.println("Invalid choice");
                }
		}
		else if(service.get(0) instanceof Product) {
			switch (choice) {
            case "2": 
                service.sort((p1, p2) -> ((Product) p1).getId().compareTo(((Product) p2).getId()));
                break;
            case "3": 
                service.sort((p1, p2) -> ((Product) p1).getName().compareTo(((Product) p2).getName()));
                break;
            case "4": 
                service.sort((p1, p2) -> Double.compare(((Product) p1).getPrice(), ((Product) p2).getPrice()));
                break;
            case "5": 
                service.sort((p1, p2) -> Integer.compare(((Product) p1).getQuantity(), ((Product) p2).getQuantity()));
                break;
            default:
                System.out.println("Invalid choice");
			}
		}
		else if(service.get(0) instanceof Package) {
			switch (choice) {
            case "2": 
                service.sort((p1, p2) -> ((Package) p1).getId().compareTo(((Package) p2).getId()));
                break;
            case "3": 
                service.sort((p1, p2) -> ((Package) p1).getName().compareTo(((Package) p2).getName()));
                break;
            case "4": 
                service.sort((p1, p2) -> Double.compare(((Package) p1).getPrice(), ((Package) p2).getPrice()));
                break;
            case "5": 
            service.sort((p1, p2) -> Long.compare(((Package) p1).getDurationInDays(), ((Package) p2).getDurationInDays()));
            break;
            default:
                System.out.println("Invalid choice");
			}
		}
    }
}
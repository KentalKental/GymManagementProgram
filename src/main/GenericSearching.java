package main;

import java.util.*;

public class GenericSearching {
	
	@SuppressWarnings("unchecked")
	public <T> List<T> searchList(List<T> service, String choice) {
		
		List<T> returnedList = new ArrayList<>();
		
		if (service == null || service.isEmpty()) {
		    System.out.println("The list is empty.");
		    return returnedList;
		}
		
		Scanner scanner = new Scanner(System.in);
		T target = null;
		int targetInt;
		double targetDouble;
		
		if(service.get(0) instanceof Member) {
			
			
			List<Member> memberList = service.stream()
                    .filter(item -> item instanceof Member)
                    .map(item -> (Member) item)
                    .toList();
			
			switch (choice) {
				case "1": // Search by ID (String)
					System.out.print("Enter ID to search: ");
					target = (T) scanner.nextLine();
		            for (Member member : memberList) {
		                if (member.getId().equals((String)target)) {
		                	returnedList.add((T) member);
		                }
		            }
		            break;
	                
	            case "2": // Search by Name (String)
	            	System.out.print("Enter name to search: ");
					target = (T) scanner.nextLine();
	                for (Member member : memberList) {
	                    if (member.getName().equals((String)target)) {
	                    	returnedList.add((T) member);
	                    }
	                }
	                break;
	                
	            case "3": // Search by Age (Integer)
	                
                	System.out.print("Enter age to search: ");
                	targetInt = scanner.nextInt();
                    for (Member member : memberList) {
                        if (member.getAge() == (Integer) targetInt) {
                        	returnedList.add((T) member);
                        }
                    }
	                
	                break;
	            case "4": // Search by Tier (String)
	            	System.out.print("Enter tier to search: ");
					target = (T) scanner.nextLine();
	                for (Member member : memberList) {
	                    if (member.getTier().equals((String)target)) {
	                        returnedList.add((T) member);
	                    }
	                }
	                break;
	            default:
	                System.out.println("Invalid choice");
	                break;
	         }
			return returnedList;
		}
		else if(service.get(0) instanceof Product) {

			List<Product> productList = service.stream()
                    .filter(item -> item instanceof Product)
                    .map(item -> (Product) item)
                    .toList();
			
			switch (choice) {
			case "1": // Search by ID (String)
				System.out.print("Enter ID to search: ");
				target = (T) scanner.nextLine();
	            for (Product product : productList) {
	            	
	                if (product.getId().equals((String)target)) {
	                	returnedList.add((T) product);
	                }
	            }
	            break;
	                
	            case "2": // Search by Name (String)
	            	System.out.print("Enter name to search: ");
					target = (T) scanner.nextLine();
	            	for (Product product : productList) {
		                if (product.getName().equals((String)target)) {
		                	returnedList.add((T) product);
		                }
		            }
	                break;
	                
	            case "3": // Search by Price (Double)
	            	System.out.print("Enter price to search: ");
	                targetDouble = scanner.nextDouble();
                	for (Product product : productList) {
		                if (product.getPrice() == (Double)targetDouble) {
		                	returnedList.add((T) product);
		                }
		            }
	                
	                break;
	            case "4": // Search by Quantity (int)
	            	System.out.print("Enter quantity to search: ");
                	targetInt = scanner.nextInt();
                	
                	for (Product product : productList) {
		                if (product.getPrice() == (Integer) targetInt) {
		                	returnedList.add((T) product);
		                }
		            }
	                break;
	            default:
	                System.out.println("Invalid choice");
	                break;
	         }
			return returnedList;
		}
		else if(service.get(0) instanceof Package) {
			List<Package> packageList = service.stream()
                    .filter(item -> item instanceof Package)
                    .map(item -> (Package) item)
                    .toList();
			
			switch (choice) {
			case "1": // Search by ID (String)
				System.out.print("Enter ID to search: ");
				target = (T) scanner.nextLine();
	            for (Package p : packageList) {
	                if (p.getId().equals(target)) {
	                	returnedList.add((T) p);
	                }
	            }
	            break;
	                
	            case "2": // Search by Name (String)
	            	System.out.print("Enter name to search: ");
					target = (T) scanner.nextLine();
	            	for (Package p : packageList) {
		                if (p.getName().equals(target)) {
		                	returnedList.add((T) p);
		                }
		            }
	                break;
	                
	            case "3": // Search by Price (Double)
	            	System.out.print("Enter price to search: ");
	                targetDouble = scanner.nextDouble();
                	for (Package p : packageList) {
		                if (p.getPrice() <= (Double)targetDouble) {
		                	returnedList.add((T) p);
		                }
		            }
	                	
	            default:
	                System.out.println("Invalid choice");
	                break;
	         }
			return returnedList;
			
		}
		return returnedList;
	}
}

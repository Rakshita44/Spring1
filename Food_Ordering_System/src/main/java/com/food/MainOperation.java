package com.food;
import java.util.Scanner;

public class MainOperation {
	static Scanner sc = new Scanner(System.in);
    public static void mainOps() {
  
        while (true) {
        	System.out.println("====FoodDelivery Management System====");
            System.out.println("Press 1. Customer Details");
            System.out.println("Press 2. Food Details");
            System.out.println("Press 3. Order Details");
            System.out.println("Press 4. Delivery Boy Details");
            System.out.println("Press 5. Payment Details");
            System.out.println("Press 6. Admin Details");
            System.out.println("Press 7. Category Details");
            System.out.println("Press 8. to quit");
            System.out.println("Enter your choice:");
            int input = sc.nextInt();

            switch (input) {
            case 1:
				AllOperations.CustomerOperations();
				System.out.println("=======================================");
		        break;
		          
			case 2:
				AllOperations.FoodOperations();
				System.out.println("=======================================");
				break;
				
			case 3:
				AllOperations.OrdersOperations();
				System.out.println("=======================================");
				break;
				
			case 4:
				AllOperations.DeliveryBoyOperations();
				System.out.println("=======================================");
				break;
				
			case 5:
				AllOperations.PaymentOperations();
				System.out.println("=======================================");
				break;
				
			case 6:
				AllOperations.AdminOperations();
				System.out.println("=======================================");
				break;
	
			case 7:
				AllOperations.CategoriesOperations();
				System.out.println("=======================================");
				break;
				
			case 8:System.exit(0);
				default:
					System.out.println("wrong input");
		}
		}
        

	}

	public static void main(String[] args)
	{
		
		mainOps();

	}


}

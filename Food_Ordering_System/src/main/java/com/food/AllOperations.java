package com.food;
import java.util.List;
import java.util.Scanner;
import com.food.Seviceimpl.*;
import com.food.entity.*;
import com.food.exception.ResourceNotFoundException;
import com.food.service.*;

public class AllOperations {

    static CustomerService customerService = new CustomerServiceimpl();
    static FoodService foodService = new FoodServiceimpl();
    static OrdersService orderService = new OrdersServiceimpl();
    static DeliveryBoyService deliveryBoyService = new DeliveryBoyServiceimpl();
    static PaymentService paymentService = new PaymentServiceimpl();
    static Adminservice adminService = new AdminServiceimpl();
    static CategoriesService categoryService = new CategoriesServiceimpl();

    static Scanner sc = new Scanner(System.in);

    public static Customer CustomerInputs()
	{		
		sc.nextLine();
		System.out.println("Enter CustomerID");
		String customerId=sc.nextLine();

		System.out.println("Enter Name");
		String name=sc.nextLine();
		
		System.out.println("Enter Contact_No");
		String contactNo=sc.nextLine();
		
		System.out.println("Enter Email");
		String email=sc.nextLine();
		
		System.out.println("Enter Address");
		String address=sc.nextLine();
		
		return new Customer(customerId,name, contactNo, email,address);
						
		}
    
    public static Categories CategoriesInputs()
	{
		
    	sc.nextLine();
    	
    	System.out.println("Enter Category ID");
		String id=sc.nextLine();
    	
		System.out.println("Enter Veg item");
		String veg=sc.nextLine();
		
		System.out.println("Enter Non-Veg item");
		String non_Veg=sc.nextLine();
		
		return new Categories(veg,non_Veg,id);
						
		}


    public static Food FoodInputs()
	{
		sc.nextLine();
		System.out.println("Enter FoodID");
		String foodId=sc.nextLine();

		System.out.println("Enter Food Name");
		String food_name=sc.nextLine();
		
		System.out.println("Enter Price");
		String price=sc.nextLine();
		
		System.out.println("Enter Description");
		String description=sc.nextLine();
		
		System.out.println("Enter Quantity");
		String quantity=sc.nextLine();
		
		return new Food(foodId,food_name,price, description,quantity);
						
		}


   public static Orders placeOrder() {
        sc.nextLine();
        System.out.println("Enter Order No");
        String orderID = sc.nextLine();
        
        System.out.println("Enter Customer ID");
        String customerID = sc.nextLine();

        System.out.println("Enter Order Date");
        String orderDate = sc.nextLine();
        
        System.out.println("Enter Order Status");
        String orderStatus = sc.nextLine();

        System.out.println("Enter Order Time");
        String time = sc.nextLine();

        System.out.println("Enter Amount");
        String amount = sc.nextLine();
                      
        return new Orders(orderID,customerID,orderDate,orderStatus,time,amount);
    }

    public static Delivery_Boy DeliveryBoyInputs() {
        sc.nextLine();
        System.out.println("Enter Delivery Boy Id");
        String deliveryBoyId = sc.nextLine();

        System.out.println("Enter Name");
        String name = sc.nextLine();

        System.out.println("Enter Contact No");
        String contactNo = sc.nextLine();

        return new Delivery_Boy(deliveryBoyId, name, contactNo);
    }

    public static Payment PaymentInputs()
	{
		sc.nextLine();
		System.out.println("Enter PaymentID");
		String paymentId=sc.nextLine();

		System.out.println("Enter Payment Date");
		String payment_date=sc.nextLine();
		
		System.out.println("Enter Payment Amount");
		String payment_amount=sc.nextLine();
		
		System.out.println("Enter Payment Status");
		String payment_status=sc.nextLine();
		
		System.out.println("Enter Payment Method");
		String payment_method=sc.nextLine();
		
		return new Payment(paymentId,payment_date,payment_amount,payment_status,payment_method);
						
	}


    public static Admin AdminInputs() {
        sc.nextLine();
        System.out.println("Enter Admin Id");
        String adminId = sc.nextLine();

        System.out.println("Enter Name");
        String name = sc.nextLine();

        System.out.println("Enter Email Address");
        String emailAddress = sc.nextLine();

        System.out.println("Enter Contact No");
        String contactNo = sc.nextLine();

        return new Admin(adminId, name, emailAddress, contactNo);
    }


    public static Categories CategoryInputs() {
    	sc.nextLine();
    	
    	System.out.println("Enter Category ID");
		String id=sc.nextLine();
		
		System.out.println("Enter Veg item");
		String veg=sc.nextLine();
		
		System.out.println("Enter Non-Veg item");
		String non_Veg=sc.nextLine();
		
		return new Categories(veg,non_Veg,id);
    }
    
    public static Customer updatedCustomerData()
	{
		sc.nextLine();
		System.out.println("Enter CustomerID");
		String customerId=sc.nextLine();

		System.out.println("Enter Name");
		String name=sc.nextLine();
		
		System.out.println("Enter Contact_No");
		String contactNo=sc.nextLine();
		
		System.out.println("Enter Email");
		String email=sc.nextLine();
		
		System.out.println("Enter Address");
		String address=sc.nextLine();
		
		return new Customer(customerId,name, contactNo, email,address);
				
		}
    public static Orders updatedplaceOrderData() {
    	sc.nextLine();
        System.out.println("Enter Order No");
        String orderID = sc.nextLine();
        
        System.out.println("Enter Customer ID");
        String customerID = sc.nextLine();

        System.out.println("Enter Order Date");
        String orderDate = sc.nextLine();
        
        System.out.println("Enter Order Status");
        String orderStatus = sc.nextLine();

        System.out.println("Enter Order Time");
        String time = sc.nextLine();

        System.out.println("Enter Amount");
        String amount = sc.nextLine();
        
        return new Orders(orderID,customerID,orderDate,orderStatus,time,amount);
    }
    public static void CustomerOperations()
	{
		while(true) {
			System.out.println("Press 1.Add Customer Details\nPress 2.Retrieve All Customer Data\n"
					+ "Press 3.Update Customer Data\nPress 4.Delete Customer Data\n"
					+ "Press 5.To getback to the main menu\nEnter your choice: ");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Customer user=CustomerInputs();
				Customer savedEntity=customerService.createCustomer(user);
				System.out.println("User Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:
				List<Customer> users=customerService.getAllCustomer();
				for(Customer user1:users)
				{
					System.out.println(user1);
				}
				break;
				
			case 3:sc.nextLine();
				System.out.println("Enter User Id to update the infromation");
			       String uId=sc.next();
			       Customer u=customerService.getCustomer(uId);
			       if(u!=null) {
			    	   Customer us=updatedCustomerData();
			     //service
			    	   Customer updatedInfo=customerService.updatecustomer(uId, us);
			       System.out.println("Customer Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("Customer Id not found");
			       }
			       
				break;
			
			case 4:
				System.out.println("Enter Customer Id to delete the infromation");
			       String id=sc.next();
			       String message=customerService.deleteCustomer(id);
			       System.out.println(message);
				break;
			case 5:MainOperation.mainOps();
			}
			
			}
		}

    public static Void OrdersOperations() {
    	while(true) {
			System.out.println("Press 1.Add Order Details\nPress 2.Retrieve All Order Data\n"
					+ "Press 3.Update Order Data\nPress 4.Delete Order Data\n"
					+ "Press 5.To getback to the main menu\nEnter your choice: ");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Orders user=placeOrder();
				Orders savedEntity=orderService.createOrders(user);
				System.out.println("Order Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:
				List<Orders> users=orderService.getAllOrders();
				for(Orders user1:users)
				{
					System.out.println(user1);
				}
				break;
				
			case 3:sc.nextLine();
				System.out.println("Enter Order Id to update the information");
			       String uId=sc.next();
			       Orders u=orderService.getOrders(uId);
			       if(u!=null) {
			    	   Orders us=updatedplaceOrderData();
			     //service
			    	   Orders updatedInfo=orderService.updateOrders(uId, us);
			       System.out.println("Order Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("Order Id not found");
			       }
			       
				break;
			
			case 4:
				System.out.println("Enter Order Id to delete the infromation");
			       String id=sc.next();
			       String message=orderService.deleteOrders(id);
			       System.out.println(message);
				break;
			case 5:MainOperation.mainOps();
			}
			
			}
    }
	public static Food updatedFoodData() {
    	sc.nextLine();
		System.out.println("Enter FoodID");
		String foodId=sc.nextLine();

		System.out.println("Enter Food Name");
		String food_name=sc.nextLine();
		
		System.out.println("Enter Price");
		String price=sc.nextLine();
		
		System.out.println("Enter Description");
		String description=sc.nextLine();
		
		System.out.println("Enter Quantity");
		String quantity=sc.nextLine();
		
		return new Food(foodId,food_name,price, description,quantity);
    }

    public static Void FoodOperations() {
    	while(true) {
			System.out.println("Press 1.Add Food Details\nPress 2.Retrieve All Food Data\n"
					+ "Press 3.Update Food Data\nPress 4.Delete Food Data\n"
					+ "Press 5.To getback to the main menu\nEnter your choice: ");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Food user=FoodInputs();
				Food savedEntity=foodService.createFood(user);
				System.out.println("Food Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:
				List<Food> users=foodService.getAllFoods();
				for(Food user1:users)
				{
					System.out.println(user1);
				}
				break;
				
			case 3:sc.nextLine();
				System.out.println("Enter Food Id to update the infromation");
			       String uId=sc.next();
			       Food u=foodService.getFood(uId);
			       if(u!=null) {
			    	   Food us=updatedFoodData();
			     //service
			    	   Food updatedInfo=foodService.updateFood(uId, us);
			       System.out.println("Food Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("Food Id not found");
			       }
			       
				break;
			
			case 4:
				System.out.println("Enter Food Id to delete the infromation");
			       String id=sc.next();
			       String message=foodService.deleteFood(id);
			       System.out.println(message);
				break;
			case 5:MainOperation.mainOps();
			}
			
			}
    }

    public static Delivery_Boy updatedDeliveryBoyData() {
    	 sc.nextLine();
         System.out.println("Enter Delivery Boy Id");
         String deliveryBoyId = sc.nextLine();

         System.out.println("Enter Name");
         String name = sc.nextLine();

         System.out.println("Enter Contact No");
         String contactNo = sc.nextLine();


         return new Delivery_Boy(deliveryBoyId, name, contactNo);
    }

    public static Void DeliveryBoyOperations() {
    	while(true) {
			System.out.println("Press 1.Add Delivery Boy Details\nPress 2.Retrieve All Delivery Boy Data\n"
					+ "Press 3.Update Delivery Boy Data\nPress 4.Delete Delivery Boy Data\n"
					+ "Press 5.To getback to the main menu\nEnter your choice: ");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Delivery_Boy user=DeliveryBoyInputs();
				Delivery_Boy savedEntity=deliveryBoyService.createDelivery_Boy(user);
				System.out.println("Delivery Boy Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:
				List<Delivery_Boy> users=deliveryBoyService.getAllDelivery_Boys();
				for(Delivery_Boy user1:users)
				{
					System.out.println(user1);
				}
				break;
				
			case 3:sc.nextLine();
				System.out.println("Enter Delivery Boy Id to update the infromation");
			       String uId=sc.next();
			       Delivery_Boy u=deliveryBoyService.getDelivery_Boy(uId);
			       if(u!=null) {
			    	   Delivery_Boy us=updatedDeliveryBoyData();
			     //service
			    	   Delivery_Boy updatedInfo=deliveryBoyService.updateDeliveryBoy(uId, us);
			       System.out.println("Delivery Boy Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("Delivery Boy is Id not found");
			       }
			       
				break;
			
			case 4:
				System.out.println("Enter Delivery Boy Id to delete the infromation");
			       String id=sc.next();
			       String message=deliveryBoyService.deleteDeliveryBoy(id);
			       System.out.println(message);
				break;
			case 5:MainOperation.mainOps();
			}
			
			}
    }

    public static Payment updatedPaymentData() {
    	sc.nextLine();
		System.out.println("Enter PaymentID");
		String paymentId=sc.nextLine();

		System.out.println("Enter Payment Date");
		String payment_date=sc.nextLine();
		
		System.out.println("Enter Payment Amount");
		String payment_amount=sc.nextLine();
		
		System.out.println("Enter Payment Status");
		String payment_status=sc.nextLine();
		
		System.out.println("Enter Payment Method");
		String payment_method=sc.nextLine();
		
		return new Payment(paymentId,payment_date,payment_amount,payment_status,payment_method);
    }

    public static Void PaymentOperations() {
    	while(true) {
			System.out.println("Press 1.Add payment Details\nPress 2.Retrieve All payment Data\n"
					+ "Press 3.Update payment Data\nPress 4.Delete payment Data\n"
					+ "Press 5.To getback to the main menu\nEnter your choice: ");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Payment user=PaymentInputs();
				Payment savedEntity=paymentService.createPayment(user);
				System.out.println("payment Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:
				List<Payment> users=paymentService.getAllPayments();
				for(Payment user1:users)
				{
					System.out.println(user1);
				}
				break;
				
			case 3:sc.nextLine();
				System.out.println("Enter payment Id to update the infromation");
			       String uId=sc.next();
			       Payment u=paymentService.getPayment(uId);
			       if(u!=null) {
			    	   Payment us=updatedPaymentData();
			     //service
			    	   Payment updatedInfo=paymentService.updatePayment(uId, us);
			       System.out.println("payment Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("payment Id not found");
			       }
			       
				break;
			
			case 4:
				System.out.println("Enter payment Id to delete the infromation");
			       String id=sc.next();
			       String message=paymentService.deletePayment(id);
			       System.out.println(message);
				break;
			case 5:MainOperation.mainOps();
			}
			
			}
    }

    public static Admin updatedAdminData() {
        sc.nextLine();

        System.out.println("Enter AdminID");
        String adminID = sc.nextLine();
        
        System.out.println("Enter Name");
        String name = sc.nextLine();

        System.out.println("Enter Email Address");
        String emailAddress = sc.nextLine();

        System.out.println("Enter Contact No");
        String contactNo = sc.nextLine();

        return new Admin(adminID,name, emailAddress, contactNo);
    }

    public static Void AdminOperations() {
    	while(true) {
			System.out.println("Press 1.Add Admin Details\nPress 2.Retrieve All Admin Data\n"
					+ "Press 3.Update Admin Data\nPress 4.Delete Admin Data\n"
					+ "Press 5.To getback to the main menu\nEnter your choice: ");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Admin user=AdminInputs();
				Admin savedEntity=adminService.createAdmin(user);
				System.out.println("Admin Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:
				List<Admin> users=adminService.getAllAdmin();
				for(Admin user1:users)
				{
					System.out.println(user1);
				}
				break;
				
			case 3:sc.nextLine();
				System.out.println("Enter Admin Id to update the infromation");
			       String uId=sc.next();
			       Admin u=adminService.getAdmin(uId);
			       if(u!=null) {
			    	   Admin us=updatedAdminData();
			     //service
			    	   Admin updatedInfo=adminService.updateAdmin(uId, us);
			       System.out.println("Admin Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("Admin Id not found");
			       }
			       
				break;
			
			case 4:
				System.out.println("Enter Admin Id to delete the infromation");
			       String id=sc.next();
			       String message=adminService.deleteAdmin(id);
			       System.out.println(message);
				break;
			case 5:MainOperation.mainOps();
			}
			
			}
    }

    public static Categories updatedCategoryData() {
    	sc.nextLine();
    	System.out.println("Enter Category ID");
		String id=sc.nextLine();
    	
    	System.out.println("Enter Veg item");
		String veg=sc.nextLine();
		
		System.out.println("Enter Non-Veg item");
		String non_Veg=sc.nextLine();
		
		return new Categories(id,veg,non_Veg);
    }

    public static Void CategoriesOperations() {
    	while(true) {
			System.out.println("Press 1.Add Category Details\nPress 2.Retrieve All Category Data\n"
					+ "Press 3.Update Category Data\nPress 4.Delete Category Data\n"
					+ "Press 5.To getback to the main menu\nEnter your choice: ");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Categories user=CategoriesInputs();
				Categories savedEntity=categoryService.createCategories(user);
				System.out.println("Category Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:
				List<Categories> users=categoryService.getAllCategories();
				for(Categories user1:users)
				{
					System.out.println(user1);
				}
				break;
				
			case 3:sc.nextLine();
				System.out.println("Enter Category Id to update the infromation");
			       String uId=sc.next();
			       Categories u=categoryService.getCategories(uId);
			       if(u!=null) {
			    	   Categories us=updatedCategoryData();
			     //service
			    	   Categories updatedInfo=categoryService.updateCategories(uId, us);
			       System.out.println("Category Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("Category Id not found");
			       }
			       
				break;
			
			case 4:
				System.out.println("Enter Category Id to delete the infromation");
			       String id=sc.next();
			       String message=categoryService.deleteCategories(id);
			       System.out.println(message);
				break;
				
			case 5:MainOperation.mainOps();
			}
			
			}
    }

}
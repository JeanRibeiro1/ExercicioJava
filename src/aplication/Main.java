package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth data(DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("how many item to this order? ");
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(nameClient,email,birthDate));
		
		int n = sc.nextInt();
		for (int i=0; i<n;i++) {
			System.out.println("Enter #"+(i+1)+" item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantity, productPrice, new Product(productName,productPrice));
			order.addItem(orderItem);
		}
		System.out.println();
		
		System.out.println(order);
		
		
		
		sc.close();

	}

}

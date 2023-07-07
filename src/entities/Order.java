package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> orderItem = new ArrayList<>();
	private Client client;
	
	
	
	public Order() {
	}



	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		
		this.client = client;
	}



	public Date getMoment() {
		return moment;
	}



	public void setMoment(Date moment) {
		this.moment = moment;
	}



	public OrderStatus getStatus() {
		return status;
	}



	public void setStatus(OrderStatus status) {
		this.status = status;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	
	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	public Double total() {
		double sum = 0;
		
		for (OrderItem i : orderItem) {
			sum += i.subTotal();
			}
		
		return sum;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (OrderItem item : orderItem) {
			builder.append(item + "\n");
		}
		return builder.toString();
	}
	
}

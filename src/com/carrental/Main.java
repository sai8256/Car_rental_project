package com.carrental;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Car{
	private static String carId;
	private String brand;
	private String model;
	private int basePricePerDay;
	private boolean isAvailable;
	
	public Car(String carId, String brand, String model, double d) {
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable = true;
		
	}
	public static String getCarId() {
		return carId;
	}
	public String getBrand() {
		return brand;
	}
	public String getmodel() {
		return model;
	}
	public double calculatePrice(int rentalDays) {
		return basePricePerDay * rentalDays;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void rent() {
		isAvailable = false;
	}
	public void returnCar() {
		isAvailable = true;
	}
}

class Customer{
	private String customerId;
	private String customerName;
	
	public Customer(String customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
}
class Rental{
	private Car car;
	private Customer customer;
	private int days;
	
	public Rental(Car car, Customer customer, int days) {
		this.car = car;
		this.customer = customer;
		this.days = days;
		
	}
	public Car getCar() {
		return car;
	}
	public Customer getCustomer() {
		return customer;
	}
	public int getDays() {
		return days;
	}
}
class CarRentalSystem{
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;
	
	public CarRentalSystem() {
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
		
	}
	public void addCar(Car Car) {
		cars.add(Car);
	}
	
	public void rentCar(Car car, Customer customer, int days ) {
		if(car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car, customer, days));
			
		}else {
			System.out.println("Car is not available for rent");
		}
	}
	public void returnCar(Car car) {
		car.returnCar();
		Rental rentalToRemove = null;
		for (Rental rental : rentals) {
			if (rental.getCar() == car) {
				rentalToRemove = rental;
				break;
			}
		}
		if (rentalToRemove != null) {
			rentals.remove(rentalToRemove);
				System.out.println("Car returned successfully");
			} else {
				System.out.println("Car was not rented");
			}
		}
		
		public void menu() {
			Scanner sc = new Scanner(System.in);
			
			while (true) {
				System.out.println("==== CAR RENTAL SYSTEM ====");
				System.out.println("1. Rent a Car");
				System.out.println("2. Return a Car");
				System.out.println("3. Exit");
				System.out.print("Enter your choice");
				
				int choice = sc.nextInt();
				sc.nextLine();
				
				if (choice == 1) {
					System.out.println("\navailable Cars ==\n");
					System.out.println("Enter you name");
					String customerName = sc.nextLine();
					
					System.out.println("\nAvailable Cars:");
					for (Car car : cars) {
						if (car.isAvailable()) {
							System.out.println(car.getCarId() + " = " + car.getBrand() + " " + car.getmodel());
							}
					}
					
					System.out.print("\nEnter the car ID you want to rent: ");
					String carId = sc.nextLine();
					
					System.out.print("Enter the number of days for rental: ");
					int rentalDays = sc.nextInt();
					sc.nextLine();
					
					String customerId = null;
					Customer newCustomer = new Customer(customerId + (customers.size() + 1), customerName);
					addCustomer(newCustomer);
					
					Car selectedCar = null;
					for(Car car : cars) {
						if (car.getCarId().equals(carId) && car.isAvailable()) {
						selectedCar = car;
						break;
					}
					}
				
				
				
				if (selectedCar != null) {
					double totalPrice = selectedCar.calculatePrice(rentalDays);
					System.out.println("\n== Rental Information =\n");
					System.out.println("Cus" + newCustomer.getCustomerId());
					System.out.println("Cuatomer Name: " + newCustomer.getCustomerName());
					System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getmodel());
					System.out.println("Rental Days: " + rentalDays());
					Object tatalPrice;
					System.out.println("Total Price: $%2f%n");
					System.out.println("\nConfirm rental (Y/N): ");
					String confirm = sc.nextLine();
					
					String anotherString = null;
					if(confirm.equalsIgnoreCase( "y" )) {
						rentCar(selectedCar, newCustomer, rentalDays);
						System.out.println("/nCar rented sucessfully.");
						
					}else {
						System.out.println("\nRental cancelled");
					}
					
					} else {
						System.out.println("\nInavalid Car slection or car not available for rent.");
					}	}
					 else if (choice == 2){
						System.out.println("\n== Return a car ==\n");
						System.out.println("Enter the car id you want to return: ");
						String carId = sc.nextLine();
						
						Car carToreturn = null;
						for (Car car : cars) {
							if(Car.getCarId().equals(carId) && !car.isAvailable()) {
								carToreturn = car;
								break;
							}
					}
						if (carToreturn != null) {
							Customer customer = null;
							for (Rental rental : rentals) {
								if(rental.getCar() == carToreturn) {
									customer = rental.getCustomer();
									break;
								}
							}
							if (customer != null) {
								returnCar(carToreturn);
								System.out.println("Caar returned successfully by " + customer.getCustomerName());
								
							}else {
								System.out.println("Car was not returned or rental information is missing");
								
							}
							
						} else {
							System.out.println("Invalid car id or car is not found");
						}
			} else if(choice == 3) {
				break;
			} else {
				System.out.println("Invalid choice please enter a valid option");
			}
				
			
		}
			System.out.println("\nThank You for using car rental system");
			}
		
		
		private String rentalDays() {
			// TODO Auto-generated method stub
			return null;
		}
		private void addCustomer(Customer newCustomer) {
			// TODO Auto-generated method stub
			
		}
	
}
public class Main {
	public static void main(String[] args) {
		CarRentalSystem rentalsystem = new CarRentalSystem();
		
		Car car1 = new Car("c001","Toyota", "canry", 60.0);
		Car car2 = new Car("c002", "Honda", "citi", 80.0);
		Car car3 = new Car("c003", "KIA", "Seltos", 100.0);
		rentalsystem.addCar(car1);
		rentalsystem.addCar(car2);
		rentalsystem.addCar(car3);
		rentalsystem.menu();
		
		
	}
}



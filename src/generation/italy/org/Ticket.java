package generation.italy.org;

import javax.management.ValueExp;

public class Ticket {
	private int km;
	private int age;
	private double price;
	static final double priceAtKm = 0.21;
	static final double discountOver65 = 40;
	static final double discountUnder18 = 20;
	
	
	private boolean isValidKm(int value) {
		if(value > 0) 
			return true;
		else
			return false;
	}
	
	private boolean isValidAge(int value) {
		if(value > 0) 
			return true;
		else
			return false;
	}
	
	private String setNegativeNumbersErrorMessage(String value) {
		return value + " value cannot be less than 1";
	}
		
	public int getKm() {
		return km;
	}
	public void setKm(int km) throws Exception {
		if(!isValidKm(km))
			throw new Exception(setNegativeNumbersErrorMessage("Km"));
		this.km = km;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception {
		if(!isValidAge(age))
			throw new Exception(setNegativeNumbersErrorMessage("Age"));
		this.age = age;
	}
	
	private double setDiscount() {
		price = (km * priceAtKm);
		if(age < 18)
			price -= (price * discountUnder18) / 100;
		else if(age >= 65)
			price -= (price * discountOver65) / 100;
		return price;
	}
	
	public double getPrice() {
		price = setDiscount();
		return price;
	}

	
	// costruttore
	public Ticket(int km, int age) throws Exception {
		setKm(km);
		setAge(age);
	}
	
	@Override
	public String toString() {
		
		return "km: " + km 
				+ "\nage: " + age;
	}

}

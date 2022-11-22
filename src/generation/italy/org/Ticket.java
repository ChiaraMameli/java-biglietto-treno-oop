package generation.italy.org;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Ticket {
	private int km;
	private int age;
	private LocalDate date;
	private boolean flex;
	private static final int TERMINATION_30 = 30;
	private int TERMINATION_60 = 60;
	private static final BigDecimal PRICE = new BigDecimal(.21); 
	private static final BigDecimal DISCOUNT_OVER_65 = new BigDecimal(.40);
	private static final BigDecimal DISCOUNT_UNDER_18 = new BigDecimal(.20);	
	
	private boolean isValidKm(int value) {
		return value > 0;
	}
	
	private boolean isValidAge(int value) {
		return value > 0;
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
		if (age < 18) {
			
			return DISCOUNT_UNDER_18.floatValue();
		}
		if (age >= 65) {
			
			return DISCOUNT_OVER_65.floatValue();
		}
		
		return 0;
	}
	
	public LocalDate setTerminationDate() {			
		return date.plusDays(
			isFlex() 
			? TERMINATION_60
			: TERMINATION_30
		);
	}
	
	public double getPrice() {
		BigDecimal priceKm = new BigDecimal(km);
		priceKm = priceKm.multiply(PRICE);
		
		BigDecimal discount = new BigDecimal(setDiscount()).multiply(priceKm);
		priceKm = priceKm.subtract(discount);
		
		if (isFlex()) {
			
			priceKm = priceKm.add(priceKm.divide(new BigDecimal(10)));
		}
		
		return priceKm.floatValue();
	}
	public LocalDate getDate() {
   
		return date;
	}
	public boolean isFlex() {
		return flex;
	}

	public void setFlex(boolean flex) {
		this.flex = flex;
	}

	
	// costruttore
	public Ticket(int km, int age, boolean isFlex) throws Exception {
		setKm(km);
		setAge(age);
		setFlex(isFlex);
		date = LocalDate.now();
	}
	
	@Override
	public String toString() {
		
		return "km: " + km 
				+ "\nage: " + age
				+ "\ndate of booking: " + getDate()
				+ "\ndate of termination: " + setTerminationDate();
	}

}

package generation.italy.org;

import java.util.Scanner;

public class TicketOffice {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Km: ");
		int km = sc.nextInt();
		
		System.out.print("Age: ");
		int age = sc.nextInt();
		
		try {			
			Ticket ticket = new Ticket(km, age);
			System.out.println(ticket);
			System.out.println(ticket.getPrice() + "€");
		} catch(Exception e) {
			
			System.err.println(e.getMessage());
		}
	}
}

package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		//chiedo all'utente di istanziare un evento
		System.out.println("Vuoi creare un nuovo evento? Y/N");
		String creationAnswer = sc.nextLine().toLowerCase();
		Evento test = new Evento("test", LocalDate.now(), 300);
		
		if(creationAnswer.equals("y")) {

			System.out.println("Come si chiama l'evento?");
			String titolo = sc.nextLine();
			
			System.out.println("Inserisci la data dell'evento YYYY-MM-dd");
			LocalDate data = LocalDate.parse(sc.next());
			
			System.out.println("Quante persone può ospitare l'evento?");
			int postiTot = sc.nextInt();
			
			test = new Evento(titolo, data, postiTot);

			
			//chiedo all'utente di gestire le prenotazioni
			System.out.println("Premi 1 se vuoi inserire nuove prenotazioni");
			int prenAnswer = sc.nextInt();
			
			if(prenAnswer == 1) {
				
				System.out.println("Quante prenotazioni vuoi effettuare?");
				int prenNum = sc.nextInt();
				for(int x = 0; x < prenNum; x++) {
					try {
							test.prenota();
						}
						catch(Exception e) {
						  System.err.println(e.getMessage());
						}
				}
				System.out.println("Posti prenotati: " + test.getPostiPren() + "/" + test.getPostiTot());
			}
			
			
			//chiedo all'utente di gestire le disdette
			System.out.println("Premi 1 se vuoi inserire nuove disdette");
			int disdAnswer = sc.nextInt();
			
			if(disdAnswer == 1) {
				
				System.out.println("Quante disdette vuoi effettuare?");
				int disdNum = sc.nextInt();
				for(int x = 0; x < disdNum; x++) {
					try {
							test.disdici();
						}
						catch(Exception e) {
						  System.err.println(e.getMessage());
						}
				}
				System.out.println("Posti prenotati: " + test.getPostiPren() + "/" + test.getPostiTot());
			}
		} else {
			System.out.println("Ok");
		}
		sc.close();

		Evento test2 = new Evento("test2", LocalDate.now(), 300);
		Evento test3 = new Evento("test3", LocalDate.now().plusDays(10), 200);
		Evento test4 = new Evento("test4", LocalDate.now().plusMonths(10), 50);
		Concerto test5 = new Concerto("test5", LocalDate.now().plusWeeks(10),20000, LocalTime.now().plusHours(2), new BigDecimal(120));
		Concerto test6 = new Concerto("test6", LocalDate.now().plusMonths(10),10000, LocalTime.now().plusHours(5), new BigDecimal(90.50));
		Concerto test7 = new Concerto("test7", LocalDate.now().plusMonths(10),900, LocalTime.now().plusHours(10), new BigDecimal(64.99));
		
		ProgrammEventi listaEventi = new ProgrammEventi("Lista eventi");
		listaEventi.aggiungiEvento(test);
		//listaEventi.svuotaLista();
		listaEventi.aggiungiEvento(test2);
		listaEventi.aggiungiEvento(test3);
		listaEventi.aggiungiEvento(test4);
		listaEventi.aggiungiEvento(test5);
		listaEventi.aggiungiEvento(test6);
		listaEventi.aggiungiEvento(test7);

		listaEventi.stampaLista();
		
		System.out.println("----------------");
		System.out.println("Eventi tra 10 mesi: " + listaEventi.filtraPerData(LocalDate.now().plusMonths(10)));
		
		System.out.println("----------------");
		System.out.println("Numero eventi: " + listaEventi.numeroEventi());
	}
}

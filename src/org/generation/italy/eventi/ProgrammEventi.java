package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		setTitolo(titolo);
		eventi = new ArrayList<Evento>();
		
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	//un metodo che aggiunge alla lista un Evento, passato come parametro
	public void aggiungiEvento(Evento nuovoEvento) throws Exception {
		if(!(nuovoEvento instanceof Evento))
			throw new Exception("Il parametro non è valido");
		
		eventi.add(nuovoEvento);
	}
	
	//un metodo che restituisce una lista con tutti gli eventi presenti in una certa data
	public List<Evento> filtraPerData(LocalDate data) {
		List<Evento> list = new ArrayList<Evento>();
		for (Evento evento : eventi) {
			if(evento.getData().equals(data))
				list.add(evento);
		}
		return list;
	}
	
	//un metodo che restituisce quanti eventi sono presenti nel programma
	public int numeroEventi() {
		return eventi.size();
	}
	
	//un metodo che svuota la lista di eventi
	public void svuotaLista() {
		eventi.clear();
	}
	
	//un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi
	public void stampaLista() {		
		for (Evento evento : eventi) {
			System.out.println("○ " + evento.getData() + " - " + evento.getTitolo());
		}
	}
	
	
	@Override
	public String toString() {
		return getTitolo() + ":\n"
				+ getEventi();
	}
}

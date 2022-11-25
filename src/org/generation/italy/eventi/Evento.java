package org.generation.italy.eventi;

import java.time.LocalDate;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int postiTot;
	private int postiPren;
	
	public Evento(String titolo, LocalDate data, int postiTot) throws Exception {
		setTitolo(titolo);
		setData(data);
		setPostiTot(postiTot);
		this.postiPren = 0;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) throws Exception {
		LocalDate today = LocalDate.now();
		if(today.isAfter(data))
			throw new Exception("La data inserita non è valida");		
		this.data = data;
	}

	public int getPostiTot() {
		return postiTot;
	}
	private void setPostiTot(int postiTot) throws Exception {
		if(postiTot < 0)
			throw new Exception("Il numero dei posti totali non può essere negativo");
		this.postiTot = postiTot;
	}

	public int getPostiPren() {
		return postiPren;
	}
	
	
	public int prenota() throws Exception {
		if(postiPren == postiTot)
			throw new Exception("Non ci sono posti disponibili");		
		return postiPren++;
	}
	
	public int disdici() throws Exception {
		if(postiPren == 0)
			throw new Exception("Non ci sono posti disponibili");		
		return postiPren--;
	}
	
	public String dataFormatter() {
		return (data.getDayOfMonth() + "/" + data.getMonth() + "/" + data.getYear()).toLowerCase();	
		}

	
	@Override
		public String toString() {
			return dataFormatter() + " - " 
					+ getTitolo();
		}
	
}

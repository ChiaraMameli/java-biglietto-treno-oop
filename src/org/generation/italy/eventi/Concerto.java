package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {
	
	private LocalTime orario;
	private BigDecimal prezzo;
	
	public Concerto(String titolo, LocalDate data, int postiTot, LocalTime orario, BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTot);
		setOrario(orario);
		setPrezzo(prezzo);
	}

	
	public LocalTime getOrario() {
		return orario;
	}
	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	
	public String timeFormatter() {	
		return orario.getHour() + ":" + orario.getMinute();
	}
	
	public String priceFormatter() {		
		return String.format("%.2f", getPrezzo()) + "€";
	}
	
	@Override
	public String toString() {
		return  "" + dataFormatter()
				+ " " + timeFormatter()
				+ " - " + getTitolo()
				+ " - " + priceFormatter();
	}
	

}

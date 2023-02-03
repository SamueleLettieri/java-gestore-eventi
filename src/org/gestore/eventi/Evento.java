package org.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {

	protected String titolo;
	protected LocalDate data;
	protected int numeroPostiTotale;
	protected int numeroPostiPrenotati;
	
	public Evento(String titolo, LocalDate data, int numeroPostiTotale) throws Exception {
		super();
		this.titolo = titolo;
		setData(data);
		this.data = data;
		controlloPosti(numeroPostiTotale);
		this.numeroPostiTotale = numeroPostiTotale;
		this.numeroPostiPrenotati = 0;
	}
	
	public void setData(LocalDate data) throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("La data inserita non è valida");
		}
		
		this.data = data;
	}
	
	public LocalDate getData() {
		return data;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getNumeroPostiTotale() {
		return numeroPostiTotale;
	}

	public int getNumeroPostiPrenotati() {
		return numeroPostiPrenotati;
	}
	
	
	public void controlloPosti(int numeroPostiTotale) throws Exception{
		if (numeroPostiTotale <= 0) {
			throw new Exception("Posti non disponibili");
		}
		
		this.numeroPostiTotale = numeroPostiTotale;
	}
	
	public void prenota(int numeroPostiTotale, int numeroPostiPrenotati) throws Exception{
		if (numeroPostiTotale == numeroPostiPrenotati || data.isBefore(LocalDate.now())) {
			throw new Exception("Data non valida o posti non disponibili");
		}
		
		this.numeroPostiPrenotati++;
	}
	
	public void disdici(int numeroPostiPrenotati) throws Exception{
		if (numeroPostiPrenotati == 0 || data.isBefore(LocalDate.now())) {
			throw new Exception("Data non valida o nessun posto prenotato");
		}
		
		this.numeroPostiPrenotati--;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALIAN);
		return df +" - "+ getTitolo() ;
	}
}

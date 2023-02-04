package org.gestore.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {

	protected LocalTime ora;
	protected BigDecimal prezzo;
	
	public Concerto(String titolo, LocalDate data, int numeroPostiTotale, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, numeroPostiTotale);
		this.ora = ora;
		this.prezzo = prezzo;
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	
	public String prezzoFormattato() {
		DecimalFormat d = new DecimalFormat("##.00");
		return d.format(getPrezzo()) + "€";
	}
	
	
	public String data(LocalDate data) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALIAN);
		return data.format(df) ;
	}
	
	public String ora(LocalTime ora) {
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("hh:mm").withLocale(Locale.ITALIAN);
		return  ora.format(dft);
	}

	@Override
	public String toString() {
		return data(data) + " - " + ora(ora) + " - " + getTitolo() + " - " + prezzoFormattato();
	}
	 
	
}

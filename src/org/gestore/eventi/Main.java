package org.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
	
		String titolo;
		LocalDate data;
		int numeroPostiTotale =  0;
		int numeroPostiPrenotati;
		String dataString;
		boolean check = true;
		
		
		Evento eventi = null;
		
		Scanner s = new Scanner(System.in);
		
		try {
			
			System.out.print("Inserisci nome evento: ");
			titolo = s.nextLine();
			
			System.out.print("Inserisci data evento (aaaa-mm-gg): ");
			dataString = s.next();
			data = LocalDate.parse(dataString);
			
			System.out.print("Inserisci numero posti totali: ");
			numeroPostiTotale = s.nextInt();
			
			eventi = new Evento(titolo, data, numeroPostiTotale);
		} catch (Exception e) {
			System.out.println( e.getMessage());
		}
			
		
		System.out.print("Inserisci numero posti che vuoi prenotare: ");
		numeroPostiPrenotati = s.nextInt();
		
		try {
			
			for (int i = 0; i < numeroPostiPrenotati; i++) {
				eventi.prenota();
			}
			
		} catch (Exception e) {
			System.out.println( e.getMessage());
			check = false;
		}
		
		
		
		
		if (check == true) {
			System.out.println("I posti prenonati sono: " + eventi.getNumeroPostiPrenotati() + ", rimangono disponibili: " + eventi.getNumeroPostiTotale() + " posti");
		}
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Vuoi disdire una prenotazione? ");
		String discdici = scan.nextLine();
		
		if (discdici.equals("si")) {
			System.out.print("Quante prenotazioni vuoi disdire? ");
			int numeroPostidisdetti = scan.nextInt();
			
			try {
				
				for (int i = 0; i < numeroPostidisdetti; i++) {
					eventi.disdici();
				}
				
			} catch (Exception e) {
				System.out.println( e.getMessage());
				check = false;
			}
			
			if (check == true) {
				System.out.println("I posti prenonati sono: " + eventi.getNumeroPostiPrenotati() + ", rimangono disponibili: " + eventi.getNumeroPostiTotale() + " posti");
			}
		}
		
		scan.close();
		
	}

}

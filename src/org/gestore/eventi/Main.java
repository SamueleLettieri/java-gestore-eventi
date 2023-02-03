package org.gestore.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
	
		String titolo;
		LocalDate data;
		int numeroPostiTotale =  0;
		int numeroPostiPrenotati;
		boolean check = true;
		String eventoString;
		LocalTime ora;
		BigDecimal prezzo;
		
		Concerto concerti;
		Evento eventi = null;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Inserisci se come evento vuoi un concerto o altro: ");
		eventoString = s.nextLine();
		
		if (eventoString.equals("altro")) {
			
				try {
					
					System.out.print("Inserisci nome evento: ");
					titolo = s.nextLine();
					
					System.out.print("Inserisci anno concerto (yyyy): ");
					int anno = s.nextInt();
					
					System.out.print("Inserisci anno concerto (MM): ");
					int mese = s.nextInt();
					
					System.out.print("Inserisci giorno concerto (gg): ");
					int giorno = s.nextInt();
					
					data = LocalDate.of(anno, mese, giorno);
					
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
				
				s.close();
				
				
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
				
				System.out.println(eventi.getData() + "-" + eventi.getTitolo());
				
		} else if (eventoString.equals("concerto")) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Inserisci nome concerto: ");
			titolo = sc.nextLine();
			
			System.out.print("Inserisci anno concerto (yyyy): ");
			int anno = sc.nextInt();
			
			System.out.print("Inserisci anno concerto (MM): ");
			int mese = sc.nextInt();
			
			System.out.print("Inserisci giorno concerto (gg): ");
			int giorno = sc.nextInt();
			
			data = LocalDate.of(anno, mese, giorno);
			
			System.out.print("Inserisci hh concerto (hh): ");
			int ore = sc.nextInt();
			
			System.out.print("Inserisci minuti concerto (mm): ");
			int minuti = sc.nextInt();
			
			ora = LocalTime.of(ore, minuti);
			
			System.out.print("Inserisci numero posti totali: ");
			numeroPostiTotale = s.nextInt();
			
			System.out.print("Inserisci il prezzo del concerto: ");
			float p = sc.nextFloat();
			
			prezzo = new BigDecimal(p);
			
			
			concerti = new Concerto(titolo, data, numeroPostiTotale, ora, prezzo);
			
			sc.close();
			
			
			System.out.println("arrivederci");
			
		}
	}

}

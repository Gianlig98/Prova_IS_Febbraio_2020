package main;
import entity.*;
import control.*;
import database.DAOException;

public class Principale {

		public static void main (String[] args) {
			
			try {
				
				GestioneElaborati gestionelaborati = new GestioneElaborati();
				Docente d1=gestionelaborati.aggiungiDocente("Roberto", "Natella", 11, "101");
				Docente d2=gestionelaborati.aggiungiDocente("Luigi", "Verolino", 7, "102");
				Docente d3=gestionelaborati.aggiungiDocente("Alessandro", "Tocchi", 9, "103");
				Docente d4=gestionelaborati.aggiungiDocente("Umberto", "Izzo", 12, "104");
				Docente d5=gestionelaborati.aggiungiDocente("Roberto", "Bagio", 4, "105");
				Docente d6=gestionelaborati.aggiungiDocente("Stefano", "Fontana", 8, "106");
				
				Studente s1=gestionelaborati.aggiungiStudente("Fernando", "Afflitto", "N46009812",  140);
				Studente s2=gestionelaborati.aggiungiStudente("Gigi", "Riva", "N46009712", 80);
				Studente s3=gestionelaborati.aggiungiStudente("Aldo", "Baglio", "N46009783", 112);
				Studente s4=gestionelaborati.aggiungiStudente("Mario", "Negri", "N46009347", 100);
				Studente s5=gestionelaborati.aggiungiStudente("Ludovico", "Mazzarisi", "N43009080", 86);
				
				
				Elaborato e2=gestionelaborati.aggiungiElaborato("Progetto", TipoElaborato.ATTIVITAPROGETTUALE,false, "IS", d1);
				Elaborato e1=gestionelaborati.aggiungiElaborato("Elettronica", TipoElaborato.ATTIVITAPROGETTUALE,false, "SO", d2);
				Elaborato e3=gestionelaborati.aggiungiElaborato("Misura di uno Schedino", TipoElaborato.ATTIVITAPROGETTUALE,false, "LMM", d3);
				Elaborato e4=gestionelaborati.aggiungiElaborato("Fisica", TipoElaborato.ATTIVITAPROGETTUALE,false, "Fisica1", d4);
				Elaborato e5=gestionelaborati.aggiungiElaborato("Matematica", TipoElaborato.ATTIVITAPROGETTUALE,true, "Analisi2", d5);
				Elaborato e6=gestionelaborati.aggiungiElaborato("IBM", TipoElaborato.ATTIVITAPROGETTUALE,false, "Programmazione1", d5);
				Elaborato e7=gestionelaborati.aggiungiElaborato("Analisi del Mercato", TipoElaborato.ATTIVITAPROGETTUALE,false, "Economia", d6);
				
				Richiesta r1 = new Richiesta (1,StatoRichiesta.ACCETTATA,e7,e3,e1,s1);
				Richiesta r2 = new Richiesta (2,StatoRichiesta.ACCETTATA,e5,e4,e7,s2);
				Richiesta r3 = new Richiesta (3,StatoRichiesta.ACCETTATA,e6,e2,e7,s3);
				Richiesta r4 = new Richiesta (4,StatoRichiesta.RIFIUTATA,e3,e5,e1,s4);
				Richiesta r5 = new Richiesta (5,StatoRichiesta.ACCETTATA,e4,e2,e5,s5);
				gestionelaborati.assegnaElaborato(r1,90);
				System.out.println( "\n");
				gestionelaborati.assegnaElaborato(r2,60);
				System.out.println( "\n");
				gestionelaborati.assegnaElaborato(r3,100);
				System.out.println( "\n");
				gestionelaborati.assegnaElaborato(r4,120);
				System.out.println( "\n");
				gestionelaborati.assegnaElaborato(r5,70);
				
				
				
				
				
			} catch (DAOException e) {

				System.out.println("ERRORE: Impossibile accedere al database.\n");

				e.printStackTrace();

				System.exit(1);

			}
			
		} 
	
}
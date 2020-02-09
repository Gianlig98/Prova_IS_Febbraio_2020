package control;
import entity.*;

import database.*;
import java.util.ArrayList;


public class GestioneElaborati {
	private ArrayList<Elaborato> listaElaborati = new ArrayList<Elaborato>();
	private ArrayList<Docente> listaDocenti = new ArrayList<Docente>();
	private ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
	
	public GestioneElaborati() throws DAOException {
		listaElaborati =elaboratoDAO.readAll();
		listaDocenti=DocenteDAO.readAll();
		listaStudenti = StudenteDAO.readAll();
		}
	
	public ArrayList<Elaborato> getListaElaborato() {
		return listaElaborati;
	}
	
	public void setListaElaborato(ArrayList<Elaborato> listaElaborati) {
		this.listaElaborati=listaElaborati;
	}
	
	public Elaborato aggiungiElaborato(String tema,TipoElaborato tipo,boolean assegnato,String insegnamento,Docente docente)throws DAOException {
		
		Elaborato elaborato = elaboratoDAO.create(tema, tipo,assegnato,insegnamento,docente);
		listaElaborati.add(elaborato);
		return elaborato;
	}
	
	public Studente aggiungiStudente(String nome,String cognome,String matricola,int CFU)throws DAOException {
		
		Studente studente = StudenteDAO.create(nome, cognome, matricola, CFU);
		listaStudenti.add(studente);
		return studente;
	}
	
	public Docente aggiungiDocente(String nome,String cognome,int numelab,String id)throws DAOException {
		
		Docente docente= DocenteDAO.create(nome, cognome, numelab, id);
		listaDocenti.add(docente);
		return docente;
	}
	
	
	public void assegnaElaborato(Richiesta r,int CFUminimi) throws DAOException {

		int CFUstudente = r.getStudente().getCFU();
		
		if(CFUstudente > CFUminimi) {
			Elaborato Assegnato = null;
			if(r.getElabPref1().getAssegnato() == false && r.getElabPref1().getDocente().getElaboratiAss() <=10 && r.getElabPref1() != null) {
				Assegnato = r.getElabPref1();
				Assegnato.setAssegnato(true);
				elaboratoDAO.update(Assegnato);
				DocenteDAO.update(r.getElabPref1().getDocente());
				System.out.println("L'elaborato assegnato è :" + Assegnato.getTema()+"  " + "Con il docente:"+ Assegnato.getDocente().getNome()+ " "+ Assegnato.getDocente().getCognome()+ " "+ "Richiesto dallo studente:"+ r.getStudente().getMatricola());
				
			}else {
				System.out.print("Prima preferenza non disponibile. Analisi disponibilita della seconda \n");
				if(r.getElabPref2().getAssegnato() == false && r.getElabPref2().getDocente().getElaboratiAss() <=10 && r.getElabPref2()!=null) {
					Assegnato = r.getElabPref2();
					Assegnato.setAssegnato(true);
					elaboratoDAO.update(Assegnato);
					DocenteDAO.update(r.getElabPref2().getDocente());
					System.out.println("L'elaborato assegnato è :" + Assegnato.getTema()+"  " + "Con il docente;"+ Assegnato.getDocente().getNome()+ " "+ Assegnato.getDocente().getCognome()+ " "+ "Richiesto dallo studente:"+ r.getStudente().getMatricola());
				}else {
					System.out.print("Seconda preferenza non disponibile. Analisi disponibilita della terza \n");
					if(r.getElabPref3().getAssegnato()== false &&  r.getElabPref3().getDocente().getElaboratiAss()<=10 && r.getElabPref3() !=null) {
						Assegnato=r.getElabPref3();
						Assegnato.setAssegnato(true);
						elaboratoDAO.update(Assegnato);
						DocenteDAO.update(r.getElabPref3().getDocente());
						System.out.println("L'elaborato assegnato è :" + Assegnato.getTema()+"  " + "Con il docente:"+ Assegnato.getDocente().getNome()+ " "+ Assegnato.getDocente().getCognome()+ " "+ "Richiesto dallo studente:"+ r.getStudente().getMatricola());
					}else {
						System.out.print("Terza preferenza non disponibile. Assegnazione automatica. \n");
						for(Elaborato elaborato : listaElaborati) {
							if(elaborato.getAssegnato()== false && elaborato.getDocente().getElaboratiAss()<=10) {
								Assegnato = elaborato;
								Assegnato.setAssegnato(true);
								elaboratoDAO.update(Assegnato);
								System.out.println("L'elaborato assegnato è :" + Assegnato.getTema()+"  " + "Con il docente:"+ Assegnato.getDocente().getNome()+ " "+ Assegnato.getDocente().getCognome()+ " "+ "Richiesto dallo studente:"+ r.getStudente().getMatricola());
								break;
							}else {
								if(elaborato.getAssegnato()== true && elaborato.getDocente().getElaboratiAss()>10)
								System.out.println("Tutti gli elaborati sono stati assegnati ");
							}
						}
							
					
						
					}
				}
			}
			
			
		
		}else {
			System.out.println("Numero dei CFU non sufficiente per ottenere un elaborato");
		}
		
	}
		
		
		
	

}

package entity;


public class Richiesta {
	private int id;
	public StatoRichiesta stato;
	public Elaborato Elaboratopref1;
	public Elaborato Elaboratopref2;
	public Elaborato Elaboratopref3;
	public Studente studente;
	
	public Richiesta(int id, StatoRichiesta stato,Elaborato Elaboratopref1,Elaborato Elaboratopref2,Elaborato Elaboratopref3,Studente studente) {
		this.id= id;
		this.stato=stato;
		this.Elaboratopref1=Elaboratopref1;
		this.Elaboratopref2=Elaboratopref2;
		this.Elaboratopref3=Elaboratopref3;
		this.studente=studente;
	}
	
	public int getId() {
		return id;
	}
	
	public StatoRichiesta getStato() {
		return stato;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setStato(StatoRichiesta stato) {
		this.stato=stato;
	}
	
	
	public Elaborato getElabPref1() {
		return Elaboratopref1;
	}
	
	public Elaborato getElabPref2() {
		return Elaboratopref2;
	}
	
	public Elaborato getElabPref3() {
		return Elaboratopref3;
	}
	
	public void setElabPref1(Elaborato Elaboratopref1) {
		this.Elaboratopref1=Elaboratopref1;
	}
	
	public void setElabPref2(Elaborato Elaboratopref2) {
		this.Elaboratopref2=Elaboratopref2;
	}
	
	public void setElabPref3(Elaborato Elaboratopref3) {
		this.Elaboratopref3=Elaboratopref3;
	}
	
	public Studente getStudente() {
		return studente;
	}
	
	public void setStudente(Studente studente) {
		this.studente=studente;
	}
	
	
}
	
	
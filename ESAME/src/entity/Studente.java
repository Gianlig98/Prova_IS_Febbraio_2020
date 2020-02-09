package entity;

public class Studente {
	private String nome;
	private String cognome;
	private String matricola;
	public int CFU;
	
	public Studente (String nome, String cognome, String matricola, int CFU) {
		this.nome =nome;
		this.cognome=cognome;
		this.matricola=matricola;
		this.CFU=CFU;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public int getCFU() {
		return CFU;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	
	public void setMatricola(String matricola) {
		this.matricola=matricola;
	}
	
	public void setCFU(int CFU) {
		this.CFU=CFU;
	}
	
	
}

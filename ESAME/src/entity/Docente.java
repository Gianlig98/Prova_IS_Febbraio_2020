package entity;

public class Docente {
	public  String nome;
	public  String cognome;
	public  int elaboratiAssegnati;
	public  String Id;
	
	public Docente(String nome, String cognome, int elaboratiAssegnati,String Id) {
		this.nome=nome;
		this.cognome=cognome;
		this.elaboratiAssegnati=elaboratiAssegnati;
		this.Id=Id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public int getElaboratiAss() {
		return elaboratiAssegnati;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	
	public void setElaboratiASS(int elaboratiAssegnati) {
		this.elaboratiAssegnati=elaboratiAssegnati;
	}
	
	public  String getId() {
		return Id;
	}
	
	public  void setId(String Id) {
		this.Id=Id;
	}

	public static Docente valueOf(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

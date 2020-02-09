package entity;

public class Elaborato {
	private String tema;
	private TipoElaborato tipo;
	public boolean assegnato;
	private String insegnamento;
	private Docente docente;
	
	public Elaborato(String tema,TipoElaborato tipo,String insegnamento,Docente docente) {
		this.tema=tema;
		this.tipo=tipo;
		this.assegnato=false;
		this.insegnamento=insegnamento;
		this.docente=docente;
	}
	
	public Elaborato(String tema,TipoElaborato tipo,boolean assegnato,String insegnamento,Docente docente) {
		this.tema=tema;
		this.tipo=tipo;
		this.assegnato=assegnato;
		this.insegnamento=insegnamento;
		this.docente=docente;
	}
	
	public String getTema() {
		return tema;
	}
	
	public TipoElaborato getTipo() {
		return tipo;
	}
	
	public String getInsegnamento() {
		return insegnamento;
	}
	
	public boolean getAssegnato() {
		return assegnato;
	}
	
	public void setTema(String tema) {
		this.tema=tema;
	}
	
	public void setTipo(TipoElaborato tipo) {
		this.tipo=tipo;
	}
	
	public void setInsegnamento(String insegnamento) {
		this.insegnamento=insegnamento;
	}
	
	public void setAssegnato(boolean assegnato) {
		this.assegnato=assegnato;
	}
	
	public Docente getDocente() {
		return docente;
	}
	
	public void setDocente(Docente docente) {
		this.docente=docente;
	}
	
	
	
}

package it.polito.tdp.lab04.model;

public class Corso {

	

	private String codins;		//codice insegnamento
	private String nomeCorso;
	private int crediti;
	private int pd;		//periodo didattico
	
	public Corso(String codins,int crediti, String nomeCorso,  int pd) {
		super();
		this.codins = codins;
		this.nomeCorso = nomeCorso;
		this.crediti = crediti;
		this.pd = pd;
	}
	public String getCodins() {
		return codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public int getPd() {
		return pd;
	}
	public void setPd(int pd) {
		this.pd = pd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("Corso [codins=%s, nomeCorso=%s, crediti=%s, pd=%s]", codins, nomeCorso, crediti, pd);
	}
	
	
	
	
	
	
}

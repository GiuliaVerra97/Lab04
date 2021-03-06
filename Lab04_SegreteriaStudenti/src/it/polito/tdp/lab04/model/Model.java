package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	public Model() {
		super();
	}


	public List<Corso> getTuttiICorsi() {
		CorsoDAO c = new CorsoDAO();
		return c.getTuttiICorsi();
	}
	
	
	public List<Studente> getTuttiStudenti(){
		StudenteDAO s=new StudenteDAO();
		return s.getTuttiStudenti();
	}
	

	public Studente cercaStudente(int numeroMatricola){
		StudenteDAO s=new StudenteDAO();

		for(Studente studente: s.getTuttiStudenti()) {		//studenteDao restituisce lo stesso uno studente normale, non dao
			if(numeroMatricola==studente.getMatricola()) {
				return studente;
			}
		}	
		
		return null;
		
	}

	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {		
		CorsoDAO c=new CorsoDAO();
		return c.getStudentiIscrittiAlCorso(corso);
	
	}
	
	
	public Corso verificaCorsoMenuTendina(String corsoScelto) {
		if(corsoScelto!=null) {
			for(Corso c: this.getTuttiICorsi()) {
				if(c.getNomeCorso().equals(corsoScelto)){
					c=new Corso(c.getCodins(), c.getCrediti(), c.getNomeCorso(), c.getPd());
					return c;
				}
			}
			return null;
		}
		return null;
	}


	public List<Corso> corsiFrequentati(Studente s) {
		CorsoDAO c=new CorsoDAO();
		return c.corsiFrequentati(s) ;
	}


	public boolean isIscritto(Studente s, String nomeCorso) {
		CorsoDAO corso=new CorsoDAO();
		Corso c=this.verificaCorsoMenuTendina(nomeCorso);
		List<Corso> listaCorsi=corso.corsiFrequentati(s);
		if(listaCorsi.contains(c)) {
			return true;
		}
		return false;
	}


	public boolean iscrivi(Studente s, String nomeCorso) {
		CorsoDAO corso=new CorsoDAO();
		Corso c=this.verificaCorsoMenuTendina(nomeCorso);
		boolean result=corso.inscriviStudenteACorso(s, c);
		return result;
	}
	
	
}

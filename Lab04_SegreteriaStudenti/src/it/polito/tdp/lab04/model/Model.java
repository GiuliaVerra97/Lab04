package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

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
		
	
		for(Studente studente: s.getTuttiStudenti()) {
			if(numeroMatricola==studente.getMatricola()) {
				return studente;
			}
		}	
		
		return null;
		
	}
	
	
}

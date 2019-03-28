package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	private List<Studente> listaStudentiIscritti=new LinkedList<Studente>();
	private Model model=new Model();
 	StudenteDAO stud = new StudenteDAO();
 	
 	
	/**
	 * Ottengo tutti i corsi salvati nel DB
	 * return lista della classe {@link Corso}
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				Corso c=new Corso(codins, numeroCrediti, nome, periodoDidattico);
				corsi.add(c);
				
			}

			//conn.close(); andrebbe messo ma da errore perchè manca una parte nel connectDB
			return corsi;

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}

	/**
	 * Dato un codice insegnamento, ottengo il corso
	 * return corso cercato
	 */
	public Corso getCorso(String codiceInsegnamento) {		//era Corso corso e void
		// TODO
		for(Corso c: this.getTuttiICorsi()) {
			if(codiceInsegnamento.equals(c.getCodins())) {
				return c;
			}
		}
		return null;
		
	}

	/**
	 * Ottengo tutti gli studenti iscritti al Corso
	 * return lista della classe {@link Studente}
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {		//era void
		
				listaStudentiIscritti.clear();
				List<Studente> listaStudentiIscritti=new LinkedList<Studente>();

				final String sql = "SELECT matricola FROM iscrizione "+
						"WHERE codins=?";

		try {
			
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins());		//setto il primo ? al codice del corso passato come parametro
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int matricola = rs.getInt("matricola");
				Studente s=model.cercaStudente(matricola);
				listaStudentiIscritti.add(s);
			}
			
			//conn.close(); andrebbe messo ma da errore perchè manca una parte nel connectDB
			return listaStudentiIscritti;
			
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
 
		
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}
	
	
	
	
	
}

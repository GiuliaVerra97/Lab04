package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	/**
	 * ottengo dal db tutti gli studenti presenti
	 * @return lista della classe {@link Studente}
	 */
	public List<Studente> getTuttiStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola");
				String nomeStudente=rs.getString("nome");
				String cognomeStudente=rs.getString("cognome");
				String cds=rs.getString("CDS");

				System.out.println(matricola + " " + nomeStudente + " " + cognomeStudente + " " + cds);

				Studente s=new Studente(matricola, nomeStudente, cognomeStudente, cds );
				studenti.add(s);
				
			}

			//conn.close(); andrebbe messo ma da errore perchè manca una parte nel connectDB
			return studenti;

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}
	
	
	
	
	
	
	
	
}

package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> menuTendinaCorso;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button check;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtcognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnReset;
    
    private Model model;

    @FXML
    void doCercaCorsi(ActionEvent event) {    
    	txtArea.clear();
    	txtNome.clear();
    	txtcognome.clear();
    	int matricola;
    	try {
    		matricola=Integer.parseInt(txtMatricola.getText());
    	}catch(NumberFormatException e) {
    		txtArea.appendText("Come numero di matricola bisogna scrivere un intero\n");
    		return;
    	}
		Studente s=model.cercaStudente(matricola);
    	if(s==null) {
    			txtArea.appendText("Matricola non esistente\n");
    			return;
    	}
    	List<Corso> listaCorsi=model.corsiFrequentati(s);
    	if(listaCorsi!=null) {
    	for(Corso c: listaCorsi) {
    		String stringa=c.getCodins()+" "+c.getNomeCorso()+" "+c.getCrediti()+" "+c.getPd();
    		txtArea.appendText(stringa+"\n");
    	}
    	}else {
    		txtArea.appendText("La matricola cercata non segue nessun corso\n");
    	}
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	txtArea.clear();
    	if(menuTendinaCorso.getValue()!=null) {
    		String corsoScelto=menuTendinaCorso.getValue();
    		List<Studente> listaStudentiIscritti=new LinkedList<Studente>();
    		Corso c=model.verificaCorsoMenuTendina(corsoScelto);
    		if(c!=null) {
    			listaStudentiIscritti=model.getStudentiIscrittiAlCorso(c);
    			for(Studente s: listaStudentiIscritti) {
    				txtArea.appendText(" "+ s.getMatricola()+" "+s.getNome()+" "+s.getCognome()+" "+s.getCds()+"\n");
    			}
    		}
    	}else{
    		txtArea.appendText("Errore nella selezione del corso\n");
    	}
    }

    @FXML
    void doCheck(ActionEvent event) {

    	txtNome.clear();
    	txtcognome.clear();
    	txtArea.clear();
    	
    	String matricolaDaCercare=txtMatricola.getText();
    	
    	
    	int m;
    	try {
    	 m= Integer.parseInt(matricolaDaCercare);
    	}catch(NumberFormatException e) {
    		txtArea.appendText("Come numero di matricola bisogna scrivere un intero");
    		return;
    	}
    	
    	Studente s=model.cercaStudente(m);
    	if(s!=null) {
    		txtNome.appendText(s.getNome());
    		txtcognome.appendText(s.getCognome());
    	}else {
    		txtArea.appendText("Studente non trovato");
    	}
    	
    }

    
    @FXML
    void doCercaSeIscritto(ActionEvent event) {
    	txtArea.clear();
    	if(menuTendinaCorso.getValue()==null) {
    		txtArea.appendText("Errore: corso non selezionato\n");
    		return;
    	}
    	int matricola;
    	try {
       	 matricola= Integer.parseInt(txtMatricola.getText());
       	}catch(NumberFormatException e) {
       		txtArea.appendText("Come numero di matricola bisogna scrivere un intero");
       		return;
       	}
    	Studente s=model.cercaStudente(matricola);
    	if(s==null) {
    		txtArea.appendText("Studente non trovato");
    	}
    	boolean iscritto=model.isIscritto(s, menuTendinaCorso.getValue());
    	if(iscritto==true) {
    		txtArea.appendText("Lo studente è iscritto al corso");
    	}else {
    		txtArea.appendText("Lo studente NON è iscritto al corso");
    	}
    	
    	
    	
    }
    
    
    @FXML
    void doIscrivi(ActionEvent event) {
    	txtArea.clear();
    	if(menuTendinaCorso.getValue()==null) {
    		txtArea.appendText("Errore: corso non selezionato\n");
    		return;
    	}
    	int matricola;
    	try {
       	 matricola= Integer.parseInt(txtMatricola.getText());
       	}catch(NumberFormatException e) {
       		txtArea.appendText("Come numero di matricola bisogna scrivere un intero");
       		return;
       	}
    	Studente s=model.cercaStudente(matricola);
    	if(s==null) {
    		txtArea.appendText("Studente non trovato");
    	}
    	boolean iscritto=model.iscrivi(s, menuTendinaCorso.getValue());
    	if(iscritto==true) {
    		txtArea.appendText("Lo studente è stato iscritto al corso");
    	}else {
    		txtArea.appendText("Lo studente è già iscritto al corso");
    	}
    }

    
    
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtArea.clear();
    	txtNome.clear();
    	txtcognome.clear();
    	txtMatricola.clear();
    }

    @FXML
    void initialize() {
        assert menuTendinaCorso != null : "fx:id=\"menuTendinaCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtcognome != null : "fx:id=\"txtcognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }

	public void setModel(Model m) {
	    	this.model=m;
	    	
	    	for(Corso c: model.getTuttiICorsi()){
	    		menuTendinaCorso.getItems().add(c.getNomeCorso());				//inserisco nel menu tendina tutti i valori
	    	}
	    	
	    	menuTendinaCorso.getItems().add("");		//aggiungo una riga vuota all'interno del menuTendina
	}

	
	
	
	public ComboBox<String> getMenuTendinaCorso() {
		return menuTendinaCorso;
	}

	public void setMenuTendinaCorso(ComboBox<String> menuTendinaCorso) {
		this.menuTendinaCorso = menuTendinaCorso;
	}
	
	
	
	
	
}

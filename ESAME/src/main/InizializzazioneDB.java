package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import database.*;

public class InizializzazioneDB {

	public static void main(String[] args) {

		Connection conn = ConnessioneDB.getConnection();
		
		ArrayList<String> sqlqueries = new ArrayList<String>();
		
		sqlqueries.add("CREATE TABLE STUDENTE( \n" + 
				"  Nome VARCHAR(100), \n" +
				"  Cognome VARCHAR(100), \n" +
				"  Matricola VARCHAR(100),\n" + 
				"  CFU INT,\n" +  
				"  PRIMARY KEY(Matricola)\n" + 
				");");
		
		sqlqueries.add("CREATE TABLE Docente( \n" + 
				"  Nome VARCHAR(100),\n" +
				"  Cognome VARCHAR(100),\n" +
				"  Numelaborati INT,\n" + 
				"  Id VARCHAR(100),\n" +
				"  PRIMARY KEY(Id)\n" + 
				");");
		
		sqlqueries.add("CREATE TABLE Elaborato( \n" + 
				"  Tema VARCHAR(100),\n" +
				"  Tipo VARCHAR(100),\n"  +
				"  Assegnato BOOLEAN,\n" + 
				"  Insegnamento VARCHAR(100),\n"+
				"  Docente VARCHAR(100),\n" +
				"  FOREIGN KEY(Docente) REFERENCES Docente(Id),\n" +
				"  PRIMARY KEY(tema)\n" + 
				");"); 
		
		
		try {
			for(String query : sqlqueries) {
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.executeUpdate();
			}
		}
		catch(SQLException e) {

			e.printStackTrace();
		}	
		

		
	}

}

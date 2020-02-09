package database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import entity.*;

public class StudenteDAO {
public static Studente create(String nome, String cognome,String matricola,int CFU) throws DAOException {
		
		Studente studente = new Studente(nome,cognome,matricola,CFU);
		
		Connection conn = ConnessioneDB.getConnection();

		String sqlquery = "INSERT INTO Studente VALUES (?, ?, ?,?)";
		
		try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			
			stmt.setString(1, studente.getNome());
			stmt.setString(2, studente.getCognome());
			stmt.setString(3, studente.getMatricola());
			stmt.setInt(4, studente.getCFU());
			stmt.executeUpdate();

		}
		catch(SQLException e) {
			
			throw new DAOException("Errore INSERT Studente");
		}

		return studente;
	}

	public static Studente read(String matricola) throws DAOException {
	
	Studente studente= null;
	
	Connection conn = ConnessioneDB.getConnection();
	
	String sqlquery = "SELECT nome,cognome,CFU FROM Studente WHERE Matricola=?";
	
	try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
	{
		
		stmt.setString(1, matricola.toString());

		try( ResultSet result = stmt.executeQuery(); )
		{
			while (result.next()) {
        	
				String nome =result.getString(1);
				String cognome =result.getString(2);
				int CFU = result.getInt(4);
				
				studente= new Studente(nome,cognome,matricola,CFU);
			}
		}
	}
	catch(SQLException e) {

		throw new DAOException("Errore SELECT Studente");
	}
	
	return studente;

}
	
public static ArrayList<Studente> readAll() throws DAOException {
		
		ArrayList<Studente> listaStudente = new ArrayList<Studente>();
		
		Connection conn = ConnessioneDB.getConnection();
		
		String sqlquery = "SELECT nome,cognome,matricola,CFU FROM Studente";
		
		try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{

			try( ResultSet result = stmt.executeQuery(); )
			{
				while (result.next()) {
	        	
					String nome = result.getString(1);
					String cognome = result.getString(2);
					String matricola = result.getString(3);
					int CFU = result.getInt(4);
					
					Studente studente = new Studente(nome,cognome,matricola,CFU);

					listaStudente.add(studente);
				}
			}
		}
		catch(SQLException e) {

			throw new DAOException("Errore SELECT Studente");
		}
		
		return listaStudente;
	}

	public static void update(Studente studente) throws DAOException {
	
	String nome = studente.getNome();
	String cognome = studente.getCognome();
	String matricola = studente.getMatricola();
	int CFU=studente.getCFU();
	
	Connection conn = ConnessioneDB.getConnection();
	
	String sqlquery = "UPDATE Studente SET nome=?,cognome=?, CFU=?, WHERE matricola=?;";

	try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
	{
		stmt.setString(1, nome.toString());
		stmt.setString(2, cognome.toString());
		stmt.setString(3, matricola.toString());
		stmt.setInt(4, CFU);
		
		stmt.executeUpdate();
	}
	catch(SQLException e) {

		throw new DAOException("Errore UPDATE Studente");
	}
}
	
	public static void delete(Studente studente) throws DAOException {
		
		String id_docente= studente.getMatricola();
		
		Connection conn =ConnessioneDB.getConnection();
		
		String sqlquery = "DELETE FROM Studente WHERE matricola=?;";
		
		try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			stmt.setString(1, id_docente);
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {

			throw new DAOException("Errore DELETE Studente");
		}
	}

}

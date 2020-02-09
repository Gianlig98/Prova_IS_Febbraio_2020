package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import entity.*;

public class elaboratoDAO {

	public static Elaborato create(String tema,TipoElaborato tipo,boolean assegnato,String insegnamento,Docente docente) throws DAOException {
	Elaborato elaborato = new Elaborato(tema,tipo,assegnato,insegnamento,docente);
	
	Connection conn = ConnessioneDB.getConnection();
	
	String sqlquery = "INSERT INTO Elaborato VALUES (?, ?, ?,?,?);";
	try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
	{
		
		stmt.setString(1, elaborato.getTema());
		stmt.setString(2, elaborato.getTipo().toString());
		stmt.setBoolean(3, elaborato.getAssegnato());
		stmt.setString(4, elaborato.getInsegnamento());
		stmt.setString(5, elaborato.getDocente().getId());
		
		
		stmt.executeUpdate();
	}
		
	catch(SQLException e) {
		
		throw new DAOException("Errore INSERT Elaborato");
	}
	
	elaborato.setAssegnato(assegnato);

	return elaborato;
	
	}
	
	public static Elaborato read(String tema) throws DAOException {
		
		Elaborato elaborato = null;
		
		Connection conn = ConnessioneDB.getConnection();
		
		String sqlquery = "SELECT tipo,assegnato,insegnamento,docente FROM Elaborato WHERE tema=?";
		
		try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			
			stmt.setString(1, tema);

			try( ResultSet result = stmt.executeQuery(); )
			{
				while (result.next()) {
					TipoElaborato tipo = TipoElaborato.valueOf( result.getString(2) );
					boolean assegnato=result.getBoolean(3);
					String insegnamento = result.getString(4);
					Docente docente = DocenteDAO.read( result.getString(5) );
					
					
					elaborato= new Elaborato(tema, tipo,assegnato,insegnamento,docente);
				}
			}
		}
		catch(SQLException e) {

			throw new DAOException("Errore SELECT Elaborato");
		}
		
		return elaborato;
	
}
	
	public static ArrayList<Elaborato> readAll() throws DAOException {
		
		ArrayList<Elaborato> listaElaborati = new ArrayList<Elaborato>();
		
		Connection conn = ConnessioneDB.getConnection();
		
		String sqlquery = "SELECT tema,tipo,assegnato,insegnamento,docente FROM Elaborato";
		
		try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{

			try( ResultSet result = stmt.executeQuery(); )
			{
				while (result.next()) {
	        	
					String tema = result.getString(1);
					TipoElaborato tipo = TipoElaborato.valueOf( result.getString(2));
					boolean assegnato=result.getBoolean(3);
					String insegnamento = result.getString(4);
					Docente docente = DocenteDAO.read( result.getString(5));
					
					Elaborato elaborato = new Elaborato(tema,tipo,assegnato,insegnamento,docente);

					listaElaborati.add(elaborato);
				}
			}
		}
		catch(SQLException e) {

			throw new DAOException("Errore SELECT Elaborato");
		}
		
		return listaElaborati;
	}

	public static void update(Elaborato elaborato) throws DAOException {
	
	String tema = elaborato.getTema();
	TipoElaborato tipo = elaborato.getTipo();
	boolean assegnato=elaborato.getAssegnato();
	String insegnamento = elaborato.getInsegnamento();
	Docente docente = elaborato.getDocente();
	
	Connection conn = ConnessioneDB.getConnection();
	
	String sqlquery = "UPDATE Elaborato SET tipo=?,assegnato=?, insegnamento=?, docente=? WHERE tema=?;";

	try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
	{
		stmt.setString(2, tipo.toString());
		stmt.setBoolean(3, assegnato);
		stmt.setString(4, insegnamento.toString());
		stmt.setString(5, docente.getId());
		stmt.setString(1, tema.toString());
		
		stmt.executeUpdate();
	}
	catch(SQLException e) {

		throw new DAOException("Errore UPDATE Elaborato");
	}
}
	public static void delete(Elaborato elaborato) throws DAOException {
		
		String id_docente= elaborato.getTema();
		
		Connection conn =ConnessioneDB.getConnection();
		
		String sqlquery = "DELETE FROM Elaborato WHERE tema=?;";
		
		try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			stmt.setString(1, id_docente);
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {

			throw new DAOException("Errore DELETE Elaborato");
		}
	}
}

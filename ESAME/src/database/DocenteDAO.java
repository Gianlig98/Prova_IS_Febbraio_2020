package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Docente;

public class DocenteDAO {
	public static Docente create(String nome,String cognome,int numelaborati,String id) throws DAOException {
		Docente docente=new Docente(nome,cognome,numelaborati,id);
		
		Connection conn = ConnessioneDB.getConnection();
		
		String sqlquery = "INSERT INTO Docente VALUES (?, ?, ?,?);";
		try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			
			stmt.setString(1, docente.getNome());
			stmt.setString(2, docente.getCognome());
			stmt.setInt(3, docente.getElaboratiAss());
			stmt.setString(4, docente.getId());
			
			
			stmt.executeUpdate();
		}
			
		catch(SQLException e) {
			
			throw new DAOException("Errore INSERT Docente");
		}
		

		return docente;
		
		}
		
		public static Docente read(String id) throws DAOException {
			
			Docente docente = null;
			
			Connection conn = ConnessioneDB.getConnection();
			
			String sqlquery = "SELECT nome,cognome,numelaborati FROM Docente WHERE Id=?";
			
			try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
			{
				
				stmt.setString(1, id.toString());

				try( ResultSet result = stmt.executeQuery(); )
				{
					while (result.next()) {
		        	
						String nome =result.getString(1);
						String cognome =result.getString(2);
						int numelaborati = result.getInt(3);
						
						
						docente= new Docente(nome,cognome,numelaborati,id);
					}
				}
			}
			catch(SQLException e) {

				throw new DAOException("Errore SELECT Docente");
			}
			
			return docente;
		
	}
		
		public static ArrayList<Docente> readAll() throws DAOException {
			
			ArrayList<Docente> listaDocenti = new ArrayList<Docente>();
			
			Connection conn = ConnessioneDB.getConnection();
			
			String sqlquery = "SELECT nome,cognome,numelaborati,id FROM Docente";
			
			try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
			{

				try( ResultSet result = stmt.executeQuery(); )
				{
					while (result.next()) {
		        	
						String nome =result.getString(1);
						String cognome =result.getString(2);
						int numelaborati = result.getInt(3);
						String id =result.getString(4);
						
						Docente docente = new Docente(nome,cognome,numelaborati,id);

						listaDocenti.add(docente);
					}
				}
			}
			catch(SQLException e) {

				throw new DAOException("Errore SELECT Docente");
			}
			
			return listaDocenti;
		}
		
		public static void update(Docente docente) throws DAOException {
			
			String nome =docente.getNome();
			String cognome =docente.getCognome();
			String id =docente.getId();
			
			Connection conn = ConnessioneDB.getConnection();
			
			String sqlquery=
			"UPDATE Docente SET Nome=?, cognome=?, numelaborati = numelaborati + 1 WHERE id=?;";

			try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
			{
				stmt.setString(1, nome.toString());
				stmt.setString(2, cognome.toString());
				stmt.setString(3, id.toString());
				
				stmt.executeUpdate();
			}
			catch(SQLException e) {

				throw new DAOException("Errore UPDATE Docente");
			}
		}
		
	public static void delete(Docente docente) throws DAOException {
			
			String id_docente= docente.getId();
			
			Connection conn =ConnessioneDB.getConnection();
			
			String sqlquery = "DELETE FROM Docente WHERE id=?;";
			
			try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
			{
				stmt.setString(1, id_docente);
				
				stmt.executeUpdate();
			}
			catch(SQLException e) {

				throw new DAOException("Errore DELETE Docente");
			}
		}
	}

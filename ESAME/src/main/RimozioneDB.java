 package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnessioneDB;

public class RimozioneDB
{
	public static void main(String[] args) 
	{
		Connection conn = ConnessioneDB.getConnection();
		
		ArrayList<String> sqlqueries = new ArrayList<String>();
		
		sqlqueries.add( 
					   "drop table elaborato;\n" + 
					   "drop table docente;\n" + 
					   "drop table studente");
		try 
		{
			for(String query : sqlqueries) 
			{
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.executeUpdate();
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}	
	}
}

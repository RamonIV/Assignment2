package samplewebapp;
import java.sql.*;
import java.util.ArrayList;

public class DBConnect 
{
	static ArrayList<Street> Streetz = new ArrayList<Street>();
	
	public static void main(String[] args) 
	{

	}
	
	public Street[] returnStreetNames()
	{
		String dbUrl = "jdbc:mysql://localhost:3306/assignment2data";
		String user = "root";
		String password = "1234";
		int lastStreetID = 3;
		PreparedStatement myStat = null;
		ResultSet myRs = null;
		String StreetNamee;
		int StreetId;
		int AmountOfParks;
		float cost;
		
		Streetz.clear();
		try 
		{
			Connection myConn = DriverManager.getConnection(dbUrl, user, password);

			for(int i = 0; i < lastStreetID + 1; i++)
			{
				myStat = myConn.prepareStatement("select * from parkinginfo where StreetID=?");
				myStat.setString(1, Integer.toString(i));
				myRs=myStat.executeQuery();
				if(myRs.next())
					{
						StreetNamee=myRs.getString("StreetName");
						StreetId = myRs.getInt("StreetID");
						AmountOfParks = myRs.getInt("NumberOfParks");
						cost = myRs.getFloat("Cost");
						
						Streetz.add(new Street(StreetId, StreetNamee, AmountOfParks, cost));
					}
			}
			
			myStat.close();
			myConn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		Street[] tempArray = new Street[Streetz.size()];
		Streetz.toArray(tempArray);
		return tempArray;
		
	}
}
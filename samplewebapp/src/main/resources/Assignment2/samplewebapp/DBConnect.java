package samplewebapp;
import java.sql.*;
import java.util.ArrayList;

public class DBConnect 
{
	static ArrayList<String> StreetNames = new ArrayList<String>();
	
	public static void main(String[] args) 
	{
		String dbUrl = "jdbc:mysql://localhost:3306/assignment2data";
		String user = "root";
		String password = "1234";
		int lastStreetID = 3;
		PreparedStatement myStat = null;
		ResultSet myRs = null;
		String fuckfuckfuck;
		String[] fuckfuckfucking = null;
		
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
						fuckfuckfuck=myRs.getString("StreetName");
						System.out.println(fuckfuckfuck);
						StreetNames.add(fuckfuckfuck);
					}
			}
			
			myStat.close();
			myConn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] returnStreetNames()
	{
		String[] tempArray = new String[StreetNames.size()];
		StreetNames.toArray(tempArray);
		return tempArray;
		
	}
}
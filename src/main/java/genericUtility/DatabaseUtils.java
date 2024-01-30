package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils 
{
	Connection con ;
	/**
	 * This method is used to register the driver and build connection
	 * @throws SQLException
	 */
	public void registerDriver() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DBUrl, IpathConstants.DBUsername, IpathConstants.DBPassword);
	}
	/**
	 * This method is used to execute the query
	 * @param query
	 * @param colIndex
	 * @param ExpectedData
	 * @return
	 * @throws SQLException
	 */
	public String exeQuery(String query,int colIndex,String ExpectedData) throws SQLException
	{
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery(query);
		String actual ="";
		boolean flag = false;
		while(res.next()) {
			actual = res.getString(colIndex);
			if(actual.equalsIgnoreCase(ExpectedData))
			{
				flag = true;
				break;
			}
		}
		if(flag) {
			return actual;
		}else {
			return "";
		}
	}
	/**
	 * This method is used to close the connetion
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException
	{
		con.close();
	}
	
}

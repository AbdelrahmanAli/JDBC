package jdbc;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

import org.apache.log4j.Logger;

public class Main 
{
	private static Scanner in = new Scanner(System.in);
	Logger log = Logger.getLogger(Main.class);
	public static void main(String[] args) 
	{
		createWorkSpace();
		String url = "JDBC:jdbc:dbms";
		try {	Class.forName("jdbc.Driver");	}
		catch (ClassNotFoundException e) {	e.printStackTrace();	}
		Connection con = null;
		Properties prob = new Properties();
		prob.setProperty("User", "lol");
		prob.setProperty("PassWord", "12345");
		Driver dr = new Driver();
		try 
		{	con = dr.connect(url, prob);
			Statement stmt =  (Statement) con.createStatement();
			run(stmt);
		} catch (SQLException e) {e.printStackTrace();}

	}
	
	private static void run(Statement stmt) throws SQLException 
	{
		while(true) 
		{
			System.out.print("-----------\n1- Execute \n2- Batch\n3- Exit\n-----------\nOption: ");
			int choice = in.nextInt();
			in.nextLine();
			if(choice == 1) executeQuery(stmt);
			else if(choice == 2) handleBatch(stmt);
			else break;
		}
		
	}

	private static void handleBatch(Statement stmt) throws SQLException 
	{
		System.out.println("-----------");
		int option = 1;
		System.out.println("1) addBatch()\n2) clearBatch()\n3) executeBatch()");
		option = in.nextInt();
		in.nextLine();
		switch(option)
		{
			case 1:	System.out.println("Insert Query: ");
					String query = in.nextLine();
					stmt.addBatch(query);
					break;
			case 2:
					stmt.clearBatch();
					break;
			case 3:
					stmt.executeBatch();
					break;
		}
	}

	public static void executeQuery(Statement stmt) throws SQLException
	{
		System.out.println("-----------");
		System.out.println("Insert Query: ");
		String query = in.nextLine();
		
		int executionType = 1;
		System.out.println("1) execute()\n2) executeQuery()\n3) executeUpdate()");
		executionType = in.nextInt();
		in.nextLine();
		switch(executionType)
		{
			case 1:	stmt.execute(query);
					break;
			case 2:
					jdbc.ResultSet rs = stmt.executeQuery(query);
					printResultSet(rs);
					break;
			case 3:
					System.out.println("number of elements updated = "+stmt.executeUpdate(query));
					break;
		}
	}
	
	public static void createWorkSpace()
	{
		FileSystemView filesys = FileSystemView.getFileSystemView();		
		// check work space
		File workSpace = new File(filesys.getHomeDirectory() + "\\DBMS Workspace");
		boolean success = workSpace.mkdirs();
		if (success) 	System.out.println("Workspace Created.");
		else 	System.out.println("Workspace successfully found.");
	}
	
	public static void printResultSet(jdbc.ResultSet rs) throws SQLException{
		jdbc.ResultSetMetaData rsmd = new ResultSetMetaData(rs);
		int size = rsmd.getColumnCount();
		System.out.println("size = "+size);
		for(int i = 1; i<=size; i++){
			System.out.print("||\t"+rsmd.getColumnName(i)+"\t");
		}
		System.out.print("||\n");
		while(rs.next()){
			for(int i = 1; i<=size; i++){
				System.out.print("||\t"+rs.getObject(i)+"\t");
			}
			System.out.print("||\n");
		}
	}

}

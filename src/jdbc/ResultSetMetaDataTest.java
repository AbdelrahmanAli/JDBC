package jdbc;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;

import org.junit.Test;


public class ResultSetMetaDataTest {
	
	private ResultSetMetaData rsmd;
	
	private void fillAtt(){
		HashMap<String, Integer> columnNameToIndex = new HashMap();
		HashMap<Integer, String> IndexToColumnType = new HashMap();
		int [][]prop = new int[3][4];
		
		columnNameToIndex.put("col1", 1);
		columnNameToIndex.put("col2", 2);
		columnNameToIndex.put("col3", 3);
		
		IndexToColumnType.put(1, "boolean");
		IndexToColumnType.put(2, "int");
		IndexToColumnType.put(3, "long");
		
		prop[0][0] = 0;
		prop[1][0] = 1;
		prop[2][0] = 0;
		
		prop[0][1] = 0;
		prop[1][1] = 1;
		prop[2][1] = 1;

		prop[0][2] = ResultSetMetaData.columnNullable;
		prop[1][2] = ResultSetMetaData.columnNoNulls;
		prop[2][2] = ResultSetMetaData.columnNullableUnknown;

		prop[0][3] = 0;
		prop[1][3] = 1;
		prop[2][3] = 1;
		
		rsmd = new jdbc.ResultSetMetaData(columnNameToIndex,IndexToColumnType,prop);
	}
	
	
	@Test
	public void getColumnCount() throws SQLException{
		fillAtt();
		rsmd.getColumnCount();
		String Expected = "3";
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getColumnLabel() throws SQLException{
		fillAtt();
		rsmd.getColumnLabel(3);
		String Expected = "col3";
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getColumnName() throws SQLException{
		fillAtt();
		rsmd.getColumnName(3);
		String Expected = "col3";
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getColumnType() throws SQLException{
		fillAtt();
		rsmd.getColumnType(2);
		String Expected = ((Integer)(Types.INTEGER)).toString();
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getTableName() throws SQLException{
		fillAtt();
		rsmd.getTableName(2);
		String Expected = "";
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isAutoIncrement() throws SQLException{
		fillAtt();
		rsmd.isAutoIncrement(2);
		String Expected = "true";
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isNullable() throws SQLException{
		fillAtt();
		rsmd.isNullable(3);
		String Expected = ((Integer)(ResultSetMetaData.columnNullableUnknown)).toString();
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isReadOnly() throws SQLException{
		fillAtt();
		rsmd.isReadOnly(1);
		String Expected = "false";
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isSearchable() throws SQLException{
		fillAtt();
		rsmd.isSearchable(2);
		String Expected = "true";
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isWritable() throws SQLException{
		fillAtt();
		rsmd.isWritable(3);
		String Expected = "true";
		String Actual = jdbc.ResultSetMetaData.getTestResult();
		assertEquals(Expected,Actual);
	}
}

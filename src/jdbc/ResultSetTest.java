package jdbc;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import org.junit.Test;


public class ResultSetTest {
	
	private ResultSet rs;
	
	private void fillAtt(){
		HashMap<String, Integer> columnNameToIndex = new HashMap();
		HashMap<Integer, String> IndexToColumnType = new HashMap();
		String [][] records = new String[2][7];
		
		ResultSetMetaData metaData = null;
		Statement statement = null;
		int [][]prop = new int[7][4];
		
		columnNameToIndex.put("col1", 1);
		columnNameToIndex.put("col2", 2);
		columnNameToIndex.put("col3", 3);
		columnNameToIndex.put("col4", 4);
		columnNameToIndex.put("col5", 5);
		columnNameToIndex.put("col6", 6);
		columnNameToIndex.put("col7", 7);
		
		
		IndexToColumnType.put(1, "boolean");
		IndexToColumnType.put(2, "int");
		IndexToColumnType.put(3, "long");
		IndexToColumnType.put(4, "double");
		IndexToColumnType.put(5, "float");
		IndexToColumnType.put(6, "string");
		IndexToColumnType.put(7, "date");
		
		
		records[0][0] = "true";

		records[0][1] = "1";
		
		records[0][2] = "1";
		
		records[0][3] = "1.23";

		records[0][4] = "1.23";
		
		records[0][5] = "string";

		records[0][6] = "1993-5-4";
		
		prop[0][0] = 0;
		prop[1][0] = 1;
		prop[2][0] = 0;
		prop[3][0] = 0;
		prop[4][0] = 0;
		prop[5][0] = 0;
		prop[6][0] = 0;
		
		prop[0][1] = 0;
		prop[1][1] = 1;
		prop[2][1] = 1;
		prop[3][1] = 1;
		prop[4][1] = 0;
		prop[5][1] = 0;
		prop[6][1] = 0;
		
		prop[0][2] = ResultSetMetaData.columnNullable;
		prop[1][2] = ResultSetMetaData.columnNoNulls;
		prop[2][2] = ResultSetMetaData.columnNullableUnknown;
		prop[3][2] = ResultSetMetaData.columnNullableUnknown;
		prop[4][2] = ResultSetMetaData.columnNullableUnknown;
		prop[5][2] = ResultSetMetaData.columnNullableUnknown;
		prop[6][2] = ResultSetMetaData.columnNullableUnknown;
		
		prop[0][3] = 0;
		prop[1][3] = 1;
		prop[2][3] = 1;
		prop[3][3] = 1;
		prop[4][3] = 0;
		prop[5][3] = 0;
		prop[6][3] = 0;
		
		rs = new ResultSet(columnNameToIndex,IndexToColumnType,records ,prop,statement);
	
	}
	
	
	@Test
	public void absolute1() throws SQLException{
		fillAtt();
		rs.absolute(2);
		String Expected = "1";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	@Test
	public void absolute2() throws SQLException{
		fillAtt();
		rs.absolute(-2);
		String Expected = "0";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}

	@Test
	public void absolute3() throws SQLException{
		fillAtt();
		rs.absolute(0);
		String Expected = "-1";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
		
	@Test
	public void absolute4() throws SQLException{
		fillAtt();
		rs.absolute(7);
		String Expected = "2";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void afterLast() throws SQLException{
		fillAtt();
		rs.afterLast();
		String Expected = "2";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void beforFirst() throws SQLException{
		fillAtt();
		rs.next();
		rs.beforeFirst();
		String Expected = "-1";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void close() throws SQLException{
		fillAtt();
		rs.close();
		String Expected = "closed";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void findColumn() throws SQLException{
		fillAtt();
		rs.findColumn("col2");
		String Expected = "2";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getArray() throws SQLException{
		fillAtt();
		rs.next();
		rs.getArray(2);
		String Expected = "done";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getBoolean() throws SQLException{
		fillAtt();
		rs.next();
		rs.getBoolean(1);
		String Expected = "true";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getInt() throws SQLException{
		fillAtt();
		rs.next();
		rs.getInt(2);
		String Expected = "1";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getLong() throws SQLException{
		fillAtt();
		rs.next();
		rs.getLong(3);
		String Expected = "1";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}

	@Test
	public void getDouble() throws SQLException{
		fillAtt();
		rs.next();
		rs.getDouble(4);
		String Expected = "1.23";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getFloat() throws SQLException{
		fillAtt();
		rs.next();
		rs.getFloat(5);
		String Expected = "1.23";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getString() throws SQLException{
		fillAtt();
		rs.next();
		rs.getString(6);
		String Expected = "string";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getDate() throws SQLException{
		fillAtt();
		rs.next();
		rs.getDate(7);
		String Expected = "1993-05-04";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getObject() throws SQLException{
		fillAtt();
		rs.next();
		rs.getObject(3);
		String Expected = "1";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isAfterLast() throws SQLException{
		fillAtt();
		rs.isAfterLast();
		String Expected = "false";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isBeforeFirst() throws SQLException{
		fillAtt();
		rs.isBeforeFirst();
		String Expected = "true";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isClosed() throws SQLException{
		fillAtt();
		rs.close();
		rs.isClosed();
		String Expected = "true";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isFirst() throws SQLException{
		fillAtt();
		rs.next();
		rs.isFirst();
		String Expected = "true";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void isLast() throws SQLException{
		fillAtt();
		rs.next();
		rs.next();
		rs.isLast();
		String Expected = "true";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void first() throws SQLException{
		fillAtt();
		rs.next();
		rs.first();
		String Expected = "true";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void last() throws SQLException{
		fillAtt();
		rs.next();
		rs.next();
		rs.last();
		String Expected = "true";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void next() throws SQLException{
		fillAtt();
		rs.next();
		String Expected = "true";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void next2() throws SQLException{
		fillAtt();
		rs.next();
		rs.next();
		rs.next();
		String Expected = "false";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getFetchDirection() throws SQLException{
		fillAtt();
		rs.getFetchDirection();
		String Expected = ((Integer)ResultSet.FETCH_UNKNOWN).toString();
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getMetaData() throws SQLException{
		fillAtt();
		rs.getMetaData();
		String Expected = "done";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
	@Test
	public void getStatement() throws SQLException{
		fillAtt();
		rs.getStatement();
		String Expected = "done";
		String Actual = ResultSet.getTestResult();
		assertEquals(Expected,Actual);
	}
	
}

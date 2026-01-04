package utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import Base.TestBase;



public class TestUtils extends TestBase {
	
	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int row = excel.getRowCount(sheetName);
		int col = excel.getColumnCount(sheetName);
		Object[][] data = new Object[row - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= row; rowNum++) {
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < col; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
		return data;
	}
}

package Dataset;

import java.util.Arrays;
import java.io.*;

import com.hcl.products.onetest.datasets.DataSetRow;
import com.ibm.rational.test.lt.kernel.services.IDataSetController;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;

/**
 * @author unknown
 */
public class Class implements com.ibm.rational.test.lt.kernel.custom.ICustomCode2 {

	/**
	 * Instances of this will be created using the no-arg constructor.
	 */
	public Class() {
	}

	/**
	 * For javadoc of ICustomCode2 and ITestExecutionServices interfaces, select 'Help Contents' in the
	 * Help menu and select 'Extending Rational Performance Tester functionality' -> 'Extending test execution with custom code'
	 */
	public String exec(ITestExecutionServices tes, String[] args) {
		// the name of the dataset is the same as what is shown in the test. The dataset must be added to the test in order
		// to get a controller for it.
		System.out.printf("I'm in a custom code");
		        IDataSetController control = tes.getDataSetController("/SAP/DS_Test.csv");
		        try {
		        // once you have the controller you can get a row
		        DataSetRow row1 = control.getNextRow();
		        // return row number of next row
		        int rowNumber=row1.getRowNumber();
		        // now read current row (nextrow-1)
		        DataSetRow row = control.getRow(rowNumber-1);
		        tes.getTestLogManager().alwaysReportMessage(" Current Row in DS is "+rowNumber);
		        
		        
		        // alternatively you can get individual values by the column name
		        String SalesOrganization=row.getValue("Sales Organization");
		        System.out.printf(" Sales Organization="+SalesOrganization);
		        tes.getTestLogManager().alwaysReportMessage(" SalesOrganization="+SalesOrganization);
		        
		        String EntireRow=row.getEntireRow();
		        System.out.printf(" SEntire Row="+EntireRow);
		        tes.getTestLogManager().alwaysReportMessage(" SEntire Row="+EntireRow);
		        // you can also write a new row to the dataset
		        // -1 means append to the end
		        // alternatively you can specify a row number and whether to overwrite that row or to insert a new row at the spot
		        //control.writeRow(-1, Arrays.asList("a", "b", "c"), false);
		      } catch (Exception e) {
		            tes.getTestLogManager().alwaysReportMessage( e.toString());
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		       }
		return null;
	}

}

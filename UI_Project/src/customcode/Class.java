package customcode;


import org.eclipse.hyades.test.common.event.VerdictEvent;

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
		try {
    		tes.getTestLogManager().reportMessage("uno1");
    		//java.lang.Class.forName("com.ibm.db2.jcc.DB2Jcc");

			tes.getTestLogManager().reportMessage("due");
			java.lang.Class.forName("oracle.jdbc.driver.OracleDriver");
			tes.getTestLogManager().reportMessage("tre");
		} catch (Exception e) {
	        tes.getTestLogManager().reportVerificationPoint(e.toString(), VerdictEvent.VERDICT_FAIL);
		}
		return null;
	}

}

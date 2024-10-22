package extractnumber;

import com.ibm.rational.test.lt.kernel.IDataArea;
import com.ibm.rational.test.lt.kernel.services.ITestExecutionServices;
import com.ibm.rational.test.lt.kernel.services.ITestLogManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


		
		ITestLogManager history= tes.getTestLogManager();
		history.reportMessage("args0 Input Value=="+args[0]);
		//args[0].substring(1);
        Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(args[0]);
        while(m.find()) {
            System.out.println(m.group());
            args[0]=m.group();
            tes.setValue("OrderId", ITestExecutionServices.STORAGE_LOCAL, "args[0]");  // Change the value of the variable myVar, which is shared between tests, to myNewValue           
        }
		history.reportMessage("args0 Output Value=="+args[0]);

		return args[0];
	}

}

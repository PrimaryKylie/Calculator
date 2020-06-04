import java.text.DecimalFormat;
import java.util.*;
/**
 * This class controls how the calculator will be displayed to the user
 * It will show the values from the user in an operation and the answer,
 * which will be to the third decimal 
 * 
 * @author Kylie Cashwell
 * @author Judy Nguyen
 * @version 5/10/19
 *
 */


/*
 * Create a public class and name it CalcView
 */
public class CalcView {
	private CalcModel model;
	
	/*
     * No-arg constructor creates a new instance of the model.
     */
	public CalcView() {
		this.model = new CalcModel();
	}
	
	/*
     * Constructor sets instance variable to an already instantiated model 
     * passes as a parameter.
     * @param c CalcModel
     */
	public CalcView(CalcModel c) {
		this.model = c;
	}
	
	/*
     * This method will print out an equation that contains the user's input and the resulting total
     */
	public String printCalculator(String val1, String val2) {
		String answer = "";
		DecimalFormat df = new DecimalFormat("#.###");
		// If the user puts both key words, it will print the key in output and not the number
		if (val1.toLowerCase().equals("pi") || val1.toLowerCase().equals("e") && 
				val2.toLowerCase().equals("pi") || val2.toLowerCase().equals("e")) {
			if (this.model.getOperator().equals("sqrt") ) { 
				answer = String.format("sqrt(%s) ", val1.toLowerCase());
			}
			else if (this.model.getOperator().equals("ln") ) {
				answer = String.format("ln(%s)",val1.toLowerCase());
			}
			else if (this.model.getOperator().equals("log")) {
				answer = String.format("log_%s(%s)",val1.toLowerCase(),val2.toLowerCase());
			}
			else {
				String str1 = String.format("%s ", val1.toLowerCase());
				//System.out.print(this.model.getOperator());
				String str2 = String.format(" %s", val2.toLowerCase());
				answer = str1 + this.model.getOperator() + str2;
			}
			answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
		}
		
		// If the user puts keyword e for either value, it will print e and not the number
		else if (val1.toLowerCase().equals("pi") || val1.toLowerCase().equals("e") && !divInt(val1)) {
			if (this.model.getOperator().equals("sqrt") ) { 
				answer = String.format("sqrt(%s) ",val1.toLowerCase());
			}
			else if (this.model.getOperator().equals("ln")) {
				answer = String.format("ln(%s)",val1.toLowerCase());
			}
			else if (this.model.getOperator().equals("log") ) {
				answer = String.format("log_%s(%f)", val1.toLowerCase() , df.format(this.model.getValue2()) );
			}
			else {
				answer = String.format("%s ",val1.toLowerCase());
				answer = answer + this.model.getOperator();
				answer = answer + String.format(" " + df.format(this.model.getValue2()));
			}
			answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
		}
		
		// If the user puts keyword pi for either value, it will print pi and not the number
		else if (val2.toLowerCase().equals("pi") || val2.toLowerCase().equals("e") && !divInt(val2)) {
			if (this.model.getOperator().equals("sqrt")) { 
				answer = String.format("sqrt(%s) ", df.format(this.model.getValue1()));
			}
			else if (this.model.getOperator().equals("ln")) {
				answer = String.format("ln(%s)",df.format(this.model.getValue1()));
			}
			else if (this.model.getOperator().equals("log")) {
				answer = String.format("log_%s(%s)", df.format(this.model.getValue1()), val2.toLowerCase());
			}
			else if (this.model.getOperator().equals("!")) {
				answer = String.format("%d!", (int)this.model.getValue1());
			}
			else {
				answer = String.format(df.format(this.model.getValue1()) + " ");
				answer = answer + this.model.getOperator();
				answer = answer + String.format(" %s", val2.toLowerCase());
			}
			answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			
		}
		// If there is no keywords, then it will print the values and answer as doubles or as
		// integers if values are integer.
		else {
			// For non int value(s)
			if (this.model.getOperator().equals("sqrt") && !divInt(val1)) { 
				answer = String.format("sqrt(" + df.format(this.model.getValue1()) + ")");
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For int value(s)
			else if (this.model.getOperator().equals("sqrt")) { 
				answer =  String.format("sqrt(%d) ", (int) this.model.getValue1());
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For non int value(s)
			else if (this.model.getOperator().equals("ln")&& !divInt(val1)) {

				answer = String.format("ln(" + df.format(this.model.getValue1()) + ")");
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For int value(s)
			else if (this.model.getOperator().equals("ln") && divInt(val1)) {
				answer =  String.format("ln(%d)", (int) this.model.getValue1());
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For int value(s)
			else if (this.model.getOperator().equals("!")) {
				answer = String.format("%d!", (int)this.model.getValue1());
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For non int value(s)System.out.println(
			else if ((this.model.getOperator().equals("+") || this.model.getOperator().equals("-")) && !divInt(val1) || !divInt(val2)) {
				answer = String.format( df.format(this.model.getValue1()) + " ");
				answer = answer + this.model.getOperator();
				answer = answer + String.format(" " + df.format(this.model.getValue2()));
				answer = answer + String.format(" = " +  df.format(this.model.getAnswer()));
			}
			// For int value(s)
			else if (this.model.getOperator().equals("+") || this.model.getOperator().equals("-") ) {
	
				answer = String.format("%d ", (int) this.model.getValue1());
				answer = answer + this.model.getOperator();
				answer = answer + String.format(" %d", (int) this.model.getValue2());
				answer = answer + String.format(" = %d ", (int) this.model.getAnswer());
			}
			// For non int value(s)
			else if (this.model.getOperator().equals("log") && !divInt(val1) || !divInt(val2)) {
				answer = String.format("log_" + df.format(this.model.getValue1()) + "(" + df.format(this.model.getValue2()) + ")");
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For int value(s)
			else if (this.model.getOperator().equals("log") && divInt(val1) && divInt(val2)) {
				answer = String.format("log_%.0f(%.0f)",this.model.getValue1(),this.model.getValue2());
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For int value(s)
			else if (this.model.getOperator().equals("mod")) {
				answer = String.format("%d mod %d", (int)this.model.getValue1(), (int)this.model.getValue2());
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For non int value(s)
			else if (this.model.getOperator().equals("/") && !divInt(val1) || !divInt(val2)) {
				answer = String.format( df.format(this.model.getValue1()) + " ");
				answer = answer + this.model.getOperator();
				answer = answer + String.format(" " + df.format(this.model.getValue2()));
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For int value(s)
			else if (this.model.getOperator().equals("/")) {
				answer = String.format("%.0f ", this.model.getValue1());
				answer = answer + this.model.getOperator();
				answer = answer + String.format(" %.0f", this.model.getValue2());
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For int value(s)
			else if (divInt(val1) && divInt(val2)) {
				answer = String.format(df.format(this.model.getValue1()) + " ");
				answer = answer + this.model.getOperator();
				answer = answer + String.format(" " + df.format(this.model.getValue2()));
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
			// For non int value(s)
			else {
				answer = String.format(df.format(this.model.getValue1()) + " ");
				answer = answer + this.model.getOperator();
				answer = answer + String.format(" " + df.format(this.model.getValue2()));
				answer = answer + String.format(" = " + df.format(this.model.getAnswer()));
			}
		}
		return answer;
	}
	
	/*
     * Updates the view with a new version of the model
     * @param b CalcModel
     */
	public void update(CalcModel b)
	{
		this.model = b;
	}
	
	
	/*
	 * This returns if the value is an integer
	 * @param val
	 * @return boolean
	 */
	private boolean divInt(String val) {
		try
	    {
	        Integer.parseInt(val);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}
	
	
	
}
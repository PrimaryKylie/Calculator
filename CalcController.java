import java.util.*;
import java.lang.*;



/**
 * This is the controller class that takes the input
 * and sends it to the model and view in order to use 
 * calculator. Detects errors from input
 * 
 * @author Kylie Cashwell
 * @author Judy Nguyen
 * @version 5/10/19
 *
 */

public class CalcController {

	private CalcView view;
	private CalcModel model;

    /*
     * No-arg constructor creates a new instance of the model.
     */
	public CalcController() {
		this.view = new CalcView();
		this.model = new CalcModel();
	}
	
	/*
	 * Constructor that sets instance variables to be passed as a parameter.
	 * @param view
	 * @param model
	 */
	public CalcController(CalcView view, CalcModel model) {
		this.view = view;
		this.model = model;
	}
	
	/*
     * Checks to see if the right hand side and the left hand side are appropriate
     * for the operator.
     * @param sqrt
     * @param ln
     * @return boolean
     */
	public boolean needRightValue(String operator) {
		if (operator.equals("sqrt") || operator.equals("ln") || operator.equals("!")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/*
	 * Returns boolean to determine if using the operation is possible with the values given
	 * by the user.
	 * @return boolean
	 */
	public boolean errorOfValue(String val1, String val2) {
		
		if (this.model.getOperator().equals("/") && this.model.getValue2() == 0) {
			return true;
		}
		if (this.model.getOperator().equals("sqrt") && this.model.getValue1() < 0) {
			return true;
		}
		if (this.model.getOperator().equals("log") && this.model.getValue1() <= 0){
			return true;
		}
		if (this.model.getOperator().equals("log") && this.model.getValue2() <= 0) {
			return true;
		}
		if (this.model.getOperator().equals("ln") && this.model.getValue1() <= 0){
			return true;
		}
		if (this.model.getOperator().equals("!") && !isInt(val1)){
			return true;
		}
		if (this.model.getOperator().equals("!") && this.model.getValue1() < 0){
			return true;
		}
		if (this.model.getOperator().equals("mod") && (!isInt(val1) || !isInt(val2))) {
			return true;
		}
		
		// returns false if math can be done
		return false;	
	}
	
	/*
	 * Returns a string that states why using the operation is not possible with the values given
	 * by the user.
	 * @return String
	 */
	
	public String errorOfValuePrint(String val1, String val2) {
		String anError = "";
		if (this.model.getOperator().equals("/") && this.model.getValue2() == 0) {
			anError = "Denominator cannot be zero.";
		}
		if (this.model.getOperator().equals("sqrt") && this.model.getValue1() < 0) {
			anError = "Cannot take the square root of negative numbers";
		}
		if (this.model.getOperator().equals("log") && this.model.getValue1() <= 0){
			anError = "Values must be greater than zero!";
		}
		if (this.model.getOperator().equals("log") && this.model.getValue2() <= 0) {
			anError = "Domain error. Values must be greater than zero!";
		}
		if (this.model.getOperator().equals("ln") && this.model.getValue1() <= 0){
			anError = "Domain error. Value must be greater than zero!";
		}
		if (this.model.getOperator().equals("!") && !isInt(val1)){
			anError = "Factorial only works on integers";
		}
		if (this.model.getOperator().equals("!") && this.model.getValue1() < 0){
			anError = "Factorial only works on positive integers";
		}
		if (this.model.getOperator().equals("mod") && (!isInt(val1) || !isInt(val2))) {
			anError = "Finding the remainder requires integers not decimals.";
		}
		if (this.model.getOperator().equals("mod") && (!isInt(val1) || !isInt(val2)) && this.model.getValue2() == 0) {
			anError = "You cannot divide by zero to get remainder.";
		}
		
		// returns false if math can be done
		return anError;	
	}
	
	
	
	
	
	/*
	 * Performs the type of math from the model on values based on the operator
	 * @param val1
	 * @param val2
	 * @param oper
	 */
	public String performMath(String val1, String val2, String oper) {
		// Make sure only these string are acceptable operators
		if (this.model.getOperator().equals("+")) {
			this.model.add();
		}
		if (this.model.getOperator().equals("-")) {
			this.model.subtract();
		}
		if (this.model.getOperator().equals("*")) {
			this.model.multiply();
		}
		if (this.model.getOperator().equals("/") && !isInt(val1) || !isInt(val2)) {
			this.model.divide();
		}
		else if (this.model.getOperator().equals("/") ) {
			this.model.intDivision();
		}
		if (this.model.getOperator().equals("sqrt")) {
			this.model.squareRoot();
		}
		if (this.model.getOperator().equals("log")) {
			this.model.logWithBase();
		}
		if (this.model.getOperator().equals("ln") ) {
			this.model.naturalLog();
		}
		if (this.model.getOperator().equals("%")) {
			this.model.percent();
		}
		if (this.model.getOperator().equals("^")) {
			this.model.exponent();
		}
		if (this.model.getOperator().equals("mod")  ) {
			this.model.remainder();
		}
		else if (this.model.getOperator().equals("!") || oper.equals("!")) {
			this.model.factorial();
		}
		// Prints and updates the view after the math is performed
		this.view.update(model);
		String answer = this.view.printCalculator(val1, val2);
			
		return answer;
	}
	
	
	/*
	 * Determines if it's actually an operator.
	 * @param oper
	 * @return boolean
	 */
	public void isAnOperator(String oper) {
		if (oper.equals("+") ||
			oper.equals("-") ||
			oper.equals("*") ||
			oper.equals("/") ||
			oper.equals("sqrt")||
			oper.equals("log") ||
			oper.equals("ln") ||
			oper.equals("%") ||
			oper.equals("^") ||
			oper.equals("mod")||
			oper.equals("!")){
			this.model.setOperator(oper);
		}

	}
	

    /*
     * Restarts the calculator by updating the view of the model.
     */
	public void restartCalc() {
		this.model.reset();
		this.view.update(model);
	}
	
	
	/*
	 * This makes the string value a double based on a keyword if there is one or not
	 * or string value given
	 * @param val
	 * @param side
	 * @return boolean
	 */
	public boolean valueKeyWords(String val, String side) {
		
		boolean isKeyword = false;
		// Determines the double value on the first left value
		if (side.equals("left")) {
			// make value the previous answer
			if (val.toLowerCase().equals("ans")) {
				try {
					this.model.setValue1(this.model.getAnswer());
					isKeyword = true;
				} catch (NullPointerException ex) {
					System.out.println("Error: Calculator does not have previous answer");	
				}
			}
			else if (val.toLowerCase().equals("e")) {
				this.model.setValue1(Math.E);
				isKeyword = true;
			}
			else if (val.toLowerCase().equals("pi")) {
				this.model.setValue1(Math.PI);
				isKeyword = true;
			}
			// If not a keyword, make string value into double version
			else {
				double value = Double.valueOf(val);
				this.model.setValue1(value);
			}
		}
		// Determines the double value on the second right value
		else if (side.equals("right")) {
			// make value the previous answer
			// make value the previous answer
			if (val.toLowerCase().equals("ans")) {
				try {
					this.model.setValue2(this.model.getAnswer());
					isKeyword = true;
				} catch (NullPointerException ex) {
					System.out.println("Error: Calculator does not have previous answer");	
				}
			}
			else if (val.toLowerCase().equals("e")) {
				this.model.setValue2(Math.E);
				isKeyword = true;
			}
			else if (val.toLowerCase().equals("pi")) {
				this.model.setValue2(Math.PI);
				isKeyword = true;
			}
				// If not a keyword, make string value into double version
			else {
				double value = Double.valueOf(val);
				this.model.setValue2(value);
			}		
		}
		return isKeyword;
	}
	
	/*
	 * Determines if the value is an integer or not
	 * @param val
	 * @return boolean
	 */
	private boolean isInt(String val)
	{
		// For certain operators, try to see if they are integers and not double
		if (this.model.getOperator().equals("!") || this.model.getOperator().equals("mod") ||
			this.model.getOperator().equals("/" )){
			
			try
			{
				Integer.parseInt(val);
				return true;
				
			} catch (NumberFormatException ex)
			{
				return false;
			}
		}
		else {
			return true;
		}
	}
	

	
}
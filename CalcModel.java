import java.util.*;
import java.lang.Math;

/**
 * This is the model for a calculator that
 * contains the  operations need be 
 * performed by the calculator  
 * 
 * @author Kylie Cashwell
 * @author Judy Nguyen
 * @version 3/28/19
 *
 */


/*
 * Create a public class and name it CalcModel
 */
public class CalcModel {
    
    private String operator = "";
    private double answer;
    private double value1;
    private double value2;
    

    public void setValue1(Double num) {
        this.value1 = num;
    }
    

    public void setValue2(Double num) {
        this.value2 = num;
    }
    
    
    public double getValue1() {
        return this.value1;
    }
    
    public double getValue2() {
        return this.value2;
    }
    
    
    /*
     * Create method for addition. This calculator should be able to add two numbers together
     */
    public void add() {
        double total;
        total = this.value1 + this.value2;
        answer = total;
        
    }
    
    /*
     * Create method for subtraction. This calculator should be able to subtract two numbers together.
     */
    public void subtract() {
        double subtract = this.value1 + this.value2;
        answer = subtract;
        
    }
    
    /*
     * Create method for multiplication. This calculator should be able to multiple two numbers together.
     */
    public void multiply() {
        double mult = this.value1 * this.value2;
        answer = mult;
    }
    
    
    /*
     * Create method for division. This calculator should be able to divide two numbers together. Division by zero should not be allowed
     * and should instead send an error message to the user and allow them to try again.
     */
    public void divide() {
        //ArithmeticException divideZero = new ArithmeticException("Denominator this.model.getOperator().equals("+")cannot be zero.");
        if (this.value2 == 0) {
            System.out.print("Denominator cannot be zero.");
        }
        else if (this.value2 != 0) {
            double div = this.value1 / this.value2;
            answer = div;
        }{
            double div = this.value1 / this.value2;
            answer = div;    
        }
    }
    
    /*
     * Create method for finding the square root. This calculator should be able to take the square root of a number. The square root negative numbers should not be allowed 
     * and should instead send an error message.
     */
    public void squareRoot() {
        if (this.value1 >= 0) {
            answer = Math.sqrt(this.value1);
        }
        System.out.print("Cannot take the square root of negative numbers");
    }
    
    /*
     * Create method for exponentiation. This calculator should be able to raise a number to a power. The left hand side is the base
     * and the right hand side is the exponent.
     */
    public void exponent() {
        double mult = 1;
        for (int i = 0; i < this.value2; i++) {
            mult = mult * this.value1;
        }
        answer = mult;
    }

    /* 
     * Create method for finding log with base. This calculator should be able to calculate the logbx where b, the base, is the left hand side and x is the right hand side.
     * All values for logs must be greater than zero otherwise print an error message. 
     */
    public void logWithBase() {
        if (this.value1 > 0 && this.value2 > 0) {
            answer = Math.log(this.value2)/ Math.log(this.value1);
        }
        System.out.print("Domain error. Values must be greater than zero!");
    }
    
    /*
     * Create a method for finding the natural log. This calculator should be able to calculate the natural log of a number. All values for logs must be greater than zero otherwise 
     * print an error message.
     */
    public void naturalLog() {
        if (this.value1 > 0) {
            answer = Math.log(this.value1);
        }
        System.out.print("Domain error. Values must be greater than zero!");
    }
    
    /* 
     * Create a method for finding the percent of a number. This calculator should be able to calculate the percent of two numbers. The left hand side is the percentage and the right hand 
     * side is the amount we are taking the percent of.
     */
    public void percent() {
        double div = (this.value1 / this.value2);
        answer = (div*100);
    }
    
    
    public void setOperator(String operation) {
        this.operator= operation;
    }
    
    /* 
     * Create a method to get the operator. 
     */
    public String getOperator() {
        return this.operator;
    }
    
    /*
     * Create a method to get the answer. The calculator should allow for a special keyword ANS to be used which will substitute the previous answer in for the left or right hand side.
     */
    public double getAnswer() {
        return this.answer;
    }
    
    public void reset() {
        operator = "";
    }
    
	/*
	 * This method does the remainder between two values
	 */
	public void remainder() {
			answer = this.getValue1() % this.getValue2();	
	}
	
	/*
	 * This method divides the values only if they are integers
	 */
	public void intDivision() {
		this.divInt = true;
		int origAnswer;
		origAnswer = (int) (this.getValue1() / this.getValue2());
		answer = (double)origAnswer;
	
	}
	
	/*
	 * This method gets the factorial of a value
	 */
	public void factorial() {
			
			int mult = 1;
			for (int i = 1; i <= (int)this.getValue1(); i++) {
				mult = mult * i;
			}
			answer = (double) mult;
	}
	
	/*
	 * This determines if the integer division has been done
	 * @return boolean
	 */
	public boolean getIsDivInt() {
		return this.divInt;
	}
	
	
}

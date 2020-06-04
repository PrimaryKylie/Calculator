import java.util.*;
/**
 * This class controls how the calculator will be displayed to the user
 * It will show the values from the user in an operation and the answer,
 * which will be to the third decimal 
 * 
 * @author Kylie Cashwell
 * @version 4/9/19
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
     * This string will print out an equation that contains the user's input and the resulting total
     */
    public String printCalculator() {
        String calcStr = "";
        calcStr = calcStr + "Output:    %0.3f " + String.format("%0.3f",String.valueOf(this.model.getValue1())) + " " + this.model.getOperator();
        calcStr = calcStr + " " + String.format("%0.3f",String.valueOf(this.model.getValue2())) + " " + String.format("%0.3f",String.valueOf(this.model.getAnswer()));
        return calcStr;
        
    }
    
    /*
     * Updates the view with a new version of the model
     * @param b CalcModel
     */
    public void update(CalcModel b)
    {
        this.model = b;
    }
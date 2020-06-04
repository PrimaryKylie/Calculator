import java.util.*;
import java.lang.Math;

/**
 * This is the controller class that takes the input
 * and sends it to the model and view in order to use 
 * calculator
 * 
 * @author Kylie Cashwell
 * @author Judy Nguyen
 * @version 3/9/19
 *
 */

/*
 * Create a public class and name it CalcController. Takes the 
 * CalcView and CalcModel as instance variables. 
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
    public Boolean needRightValue() {
        if (this.model.getOperator() == "sqrt" || this.model.getOperator() == "ln") {
            return false;
        }
        return true;
    }
    
    public Boolean errorOfValue() {
        if (this.model.getOperator() == "/" && this.model.getValue2() == 0) {
            return true;
        }
        else if (this.model.getOperator()== "sqrt" && this.model.getValue2() < 0) {
            return true;
        }
        else if (this.model.getOperator() == "log" && this.model.getValue1() < 0 && this.model.getValue2() < 0 ){
            return true;
        }
        else if (this.model.getOperator() == "ln" && this.model.getValue1() < 0 && this.model.getValue2() < 0 ){
            return true;
        }
        return false;
        
    }
    
    /*
     * Restarts the calculator by updating the view of the model.
     */
    public void restartCalc() {
        this.model.reset();
        this.view.update(model);
    }
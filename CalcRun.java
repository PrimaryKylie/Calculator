
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;






/**
 * This tests the calculator methods using javaFx to create a 
 * GUI that does the calculations
 * 
 * @author Kylie Cashwell
 * @author Judy Nguyen
 * @version 5/10/19
 *
 */

public class CalcRun extends Application{
	// Controller class
	CalcController control = new CalcController();
	String theOperator = "";
	public void start(Stage primaryStage) {
		
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		
		TextField lhsMessage = new TextField();
		lhsMessage.setEditable(true);
		lhsMessage.setAlignment(Pos.BASELINE_LEFT);
		lhsMessage.setPadding(new Insets(5,5,5,5));
		
		TextField rhsMessage = new TextField();
		rhsMessage.setEditable(true);
		rhsMessage.setAlignment(Pos.BASELINE_LEFT);
		rhsMessage.setPadding(new Insets(5,5,5,5));
		
		
		Label lhs = new Label("LHS ", lhsMessage);
		lhs.setContentDisplay(ContentDisplay.RIGHT);
		
		
		Label rhs = new Label("RHS", rhsMessage);
		rhs.setContentDisplay(ContentDisplay.RIGHT);
		
		
		
		
		// Make Buttons 
		Button calc = new Button("Calculate");
		calc.setAlignment(Pos.CENTER);
		
		box.getChildren().add(lhs);
		box.getChildren().add(rhs);
		box.getChildren().add(calc);
		

		
		
		
		GridPane radioPane = new GridPane();
		radioPane.setAlignment(Pos.CENTER);

		final ToggleGroup group = new ToggleGroup();

		RadioButton add = new RadioButton("Addition");
		add.setToggleGroup(group);
		//add.setSelected(true);

		RadioButton sub = new RadioButton("Subtraction");
		sub.setToggleGroup(group);
		 
		RadioButton mult = new RadioButton("Multiply");
		mult.setToggleGroup(group);
		
		RadioButton div = new RadioButton("Divide");
		div.setToggleGroup(group);

		RadioButton sqrt = new RadioButton("Square Root");
		sqrt.setToggleGroup(group);
		 
		RadioButton exp = new RadioButton("Exponent");
		exp.setToggleGroup(group);
		
		RadioButton log = new RadioButton("Log");
		log.setToggleGroup(group);

		RadioButton ln = new RadioButton("Natural Log");
		ln.setToggleGroup(group);
		 
		RadioButton perc = new RadioButton("Percent");
		perc.setToggleGroup(group);
		
		RadioButton mod = new RadioButton("Mod");
		mod.setToggleGroup(group);

		RadioButton fact = new RadioButton("Factorial");
		fact.setToggleGroup(group);

		radioPane.add(add,0,0);
		radioPane.add(sub,0,1);
		radioPane.add(mult,0,2);
		radioPane.add(div,1,0);
		radioPane.add(sqrt,1,1);
		radioPane.add(exp,1,2);
		radioPane.add(log,2,0);
		radioPane.add(ln,2,1);
		radioPane.add(perc,2,2);
		radioPane.add(mod,3,0);
		radioPane.add(fact,3,1);
		
		
		
		add.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(add.isSelected()) {
					control.isAnOperator("+");
					theOperator = "+";
				}
			}
		});
		
		sub.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(sub.isSelected()) {
					control.isAnOperator("-");
					theOperator = "-";
				}
			}
		});
		
		mult.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(mult.isSelected()) {
					control.isAnOperator("*");
					theOperator = "*";
				}
			}
		});
		
		div.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(div.isSelected()) {
					control.isAnOperator("/");
					theOperator = "/";
				}
			}
		});
		
		sqrt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(sqrt.isSelected()) {
					control.isAnOperator("sqrt");
					theOperator = "sqrt";
				}
			}
		});
		
		exp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(exp.isSelected()) {
					control.isAnOperator("^");
					theOperator = "^";
				}
			}
		});
		
		log.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(log.isSelected()) {
					control.isAnOperator("log");
					theOperator = "log";
				}
			}
		});
		
		
		perc.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(perc.isSelected()) {
					control.isAnOperator("%");
					theOperator = "%";
				}
			}
		});
		
		mod.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(mod.isSelected()) {
					control.isAnOperator("mod");
					theOperator = "mod";
				}
			}
		});
		
		fact.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(fact.isSelected()) {
					control.isAnOperator("!");
					theOperator = "!";
				}
			}
		});
		
		ln.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(ln.isSelected()) {
					control.isAnOperator("ln");
					theOperator = "ln";
				}
			}
		});
		
		

		TextField tfAns = new TextField();
		tfAns.setEditable(false);
		tfAns.setAlignment(Pos.BASELINE_LEFT);
		tfAns.setPadding(new Insets(5,5,5,5));
		
		
		
		calc.setOnAction(new EventHandler<ActionEvent>() {
			public void handle (ActionEvent e2) {
				
				//calc.defaultButtonProperty();
				if (!control.errorOfValue(lhsMessage.getText(),rhsMessage.getText())){
					try {
						
						control.valueKeyWords(lhsMessage.getText(), "left");
						control.valueKeyWords(rhsMessage.getText(), "right");
						
						tfAns.setText(control.performMath(lhsMessage.getText(),rhsMessage.getText(), theOperator));
					} catch (NumberFormatException ex) {
						if (theOperator.equals("ln") || theOperator.equals("sqrt") || theOperator.equals("!") && !control.errorOfValue(lhsMessage.getText(),rhsMessage.getText())) {
							control.valueKeyWords(lhsMessage.getText(), "left");
							tfAns.setText(control.performMath(lhsMessage.getText(),rhsMessage.getText(), theOperator));
						}
						else {
							tfAns.setText("Please enter a number or a keyword.");
						}
					}
				}
				else {
					tfAns.setText(control.errorOfValuePrint(lhsMessage.getText(),rhsMessage.getText()));
				}
			}
		});
		
		
	
		
		// Create pane
		BorderPane pane = new BorderPane();

	
		pane.setCenter(box);
		pane.setBottom(radioPane);
		pane.setTop(tfAns);
		//pane.getChildren().add(enter);
		//pane.getChildren().add(rhsMessage);
		
		
		Scene scene = new Scene(pane, 500, 250);
	
		
		// Set the title of the stage 
		primaryStage.setTitle("Calculator");
						
		// Set the scene of the stage
		primaryStage.setScene(scene);
						
		// Show the stage
		primaryStage.show();


	}
	
		
	
	public static void main(String[] args){
		// Launch application
		Application.launch(args);
	}

    
}
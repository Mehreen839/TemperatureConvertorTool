package com.internshala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField userInputField;
	@FXML
	public Button convertButton;
	private static final String C_F = "Celsius to Fahrenheit";
	private static final String F_C = "Fahrenheit to Celsius";
	private boolean isC_F = true;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		choiceBox.getItems().add(C_F);
		choiceBox.getItems().add(F_C);
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
			if (t1.equals(C_F)) {
				isC_F = true;
			}//if user has selected celsius to Fahrenheit
			else {
				isC_F = false;
			}
		});
		choiceBox.setValue(C_F);//default value to choice box
		convertButton.setOnAction(actionEvent -> {
			convert();
		});
	}

	private void convert() {
		String input = userInputField.getText();
		float enteredTemperature=0.0f;
		try {
			 enteredTemperature = Float.parseFloat(input);//23.4f
		} catch(Exception ex){

			return;
		}
		float newTemperature = 0.0f;
		if (isC_F) {
			newTemperature = (enteredTemperature * 9 / 5) + 32;
		} else {
			newTemperature = (enteredTemperature - 32) * 5 / 9;
		}
		display(newTemperature);
	}

	private void warnUser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();
	}

	private void display(float newTemperature){
		String unit=isC_F?"F":"C";
		System.out.println("The new Temperature is:"+newTemperature+unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new Temperature is:"+newTemperature+unit);
		alert.show();
	}
}


package com.example.assignment2fx;


import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private TextField input;


    @FXML
    private TextField result;

    @FXML
    private ToggleGroup function;


    public void calculate(){
        String numString=input.getText();
        ArrayList<Double> numbers=parseNumbers(numString);
        Excel excel=new Excel(numbers);
        double output;
        RadioButton obj=(RadioButton) function.getSelectedToggle();
        String function= obj.getId();
        output = switch (function) {
            case "Tot" -> excel.findTotal();
            case "Avg" -> excel.findAvg();
            case "Max" -> excel.findMax();
            default -> excel.findMin();
        };


        result.setText("  "+Double.toString(output));

    }
    // Implement event handlers here if required

    private ArrayList<Double> parseNumbers (String inputText) {
        ArrayList<Double> numbers = new ArrayList<>();
        String[] inputValues = inputText.split (" ") ;
        for (String value : inputValues) {
            try {
                double number = Double.parseDouble (value.trim());
                numbers. add (number);
            } catch (NumberFormatException e) {

            }

        }   return numbers;
    }


}

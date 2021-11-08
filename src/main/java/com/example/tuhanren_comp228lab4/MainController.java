package com.example.tuhanren_comp228lab4;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MainController {
    public TextField name;
    public TextField address;
    public TextField province;
    public TextField city;
    public TextField postalCode;
    public TextField phoneNumber;
    public TextField email;
    public CheckBox studentCouncil;
    public CheckBox volunteerWork;
    public RadioButton computerScience;
    public RadioButton business;
    ToggleGroup radioGroup = new ToggleGroup(); //radio button group
    public ComboBox<String> comboBox;
    public ListView<String> listBox;
    public TextArea displayArea;
    public Button display;
    //initializing
    public void initialize() {
        computerScience.setToggleGroup(radioGroup);
        business.setToggleGroup(radioGroup);
    }
    //display all information
    public void onDisplayClicked(ActionEvent actionEvent) {
        String output = "------Basic Information------" + "\n" +
                        "Name: " + name.getText() + "\n" +
                        "Address: " + address.getText() + "\n" +
                        "Province: " + province.getText() + "\n" +
                        "City: " + city.getText() + "\n" +
                        "Postal Code: " + postalCode.getText() + "\n" +
                        "Phone Number: " + phoneNumber.getText() + "\n" +
                        "Email: " + email.getText() + "\n" +
                        "------Student Achievement------" + "\n" +
                        "Student Council Member: " + studentCouncil.isSelected() + "\n" +
                        "Volunteer Work Done: " + volunteerWork.isSelected() + "\n" +
                        "------Academic Information------" + "\n";
//                        + ((computerScience.isSelected())?
//                                ("Program: Computer Science"+ "\n" + "Selected Courses: " + listBox.getItems().toString().substring(1, listBox.getItems().toString().length() - 1)):
//                                ("Program: Business"+ "\n" + "Selected Courses: " + listBox.getItems().toString().substring(1, listBox.getItems().toString().length() - 1)));
        //display all item strings added by combo box
        if (computerScience.isSelected()) {
            output += "Program: Computer Science" + "\n" + "Selected Courses: " + listBox.getItems().toString().substring(1, listBox.getItems().toString().length() - 1);
        } else if(business.isSelected()) {
            output += "Program: Business" + "\n" + "Selected Courses: " + listBox.getItems().toString().substring(1, listBox.getItems().toString().length() - 1);
        } else {
            output += "Program: Unknown"+ "\n" + "Selected Courses: " + listBox.getItems().toString().substring(1, listBox.getItems().toString().length() - 1);
        }
        displayArea.setText(output);
    }
    //radio button
    public void onRadioChanged(ActionEvent actionEvent) {
        if(computerScience.isSelected()){
            comboBox.getItems().clear();
            comboBox.getItems().addAll("Java", "C#", "Angular");
            comboBox.setValue("Java");
        } else {
            comboBox.getItems().clear();
            comboBox.getItems().addAll("Accountant", "Economics", "Finance");
            comboBox.setValue("Accountant");
        }
        listBox.getItems().clear();
    }

    public void onComboChanged(ActionEvent actionEvent) {
        // check null to avoid runtime exception && check if course is already exist in the list view
        if(comboBox.getValue() != null && !listBox.getItems().toString().contains(comboBox.getValue())) {
            listBox.getItems().add(comboBox.getValue());
        }
    }
}
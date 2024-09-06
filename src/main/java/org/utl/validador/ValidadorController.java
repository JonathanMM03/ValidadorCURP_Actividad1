package org.utl.validador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class HelloController {
    @FXML
    private TextField txtCurp;

    @FXML
    private TextField txtRfc;

    Alert alerta = new Alert(Alert.AlertType.INFORMATION);

    Pattern curpPattern = Pattern.compile("[a-zA-Z1-9]{18}");

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    void verifiarCurp(){
        String curp = txtCurp.getText().toUpperCase().trim();
        System.out.println(curp);
        System.out.println(curp.matches(String.valueOf(curpPattern)));
    }

    boolean isValidCURP(){
        String curp = txtCurp.getText();
        if(curp.isEmpty() && curp.length() != 18){
            alerta.setTitle("Información");
            alerta.setContentText("El CURP esta vacio o no el tamaño correcto(18)");
            return false;
        }
        String letrasIniciales = curp.substring(1,4);
        // Primeros digitos son letras
        for(int i=0;letrasIniciales.length() < i ;i++){
            return Character.isDigit(letrasIniciales.charAt(i)) ? false : true;
        }

        return false;
    }
}
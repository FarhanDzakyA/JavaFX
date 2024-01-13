package javafx_calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainPageController {

    @FXML
    private Button btn0; // Button Angka 0

    @FXML
    private Button btn1; // Button Angka 1

    @FXML
    private Button btn2; // Button Angka 2

    @FXML
    private Button btn3; // Button Angka 3

    @FXML
    private Button btn4; // Button Angka 4

    @FXML
    private Button btn5; // Button Angka 5

    @FXML
    private Button btn6; // Button Angka 6

    @FXML
    private Button btn7; // Button Angka 7

    @FXML
    private Button btn8; // Button Angka 8

    @FXML
    private Button btn9; // Button Angka 9

    @FXML
    private Button btnAdd; // Button Penambahan

    @FXML
    private Button btnClear; // Button Clear

    @FXML
    private Button btnDel; // Button Delete

    @FXML
    private Button btnDiv; // Button Pembagian

    @FXML
    private Button btnDot; // Button Koma

    @FXML
    private Button btnMinus; // Button Minus

    @FXML 
    private Button btnMult; // Button Perkalian

    @FXML
    private Button btnPersent; // Button Persen

    @FXML
    private Button btnResult; // Button Sama Dengan

    @FXML
    private Button btnSubs; // Button Pengurangan

    @FXML
    private Label lblDisplay; // Label Display Angka
    
    private Button numbers[]; // Array untuk menampung button-button angka
    
    double num1 = 0, num2 = 0, result = 0; // Variabel untuk menyimpan angka yang diinputkan oleh pengguna
    char operator; // Variabel untuk menyimpan operasi yang dilakukan oleh pengguna
    
    @FXML
    private void initialize() {
        // Memasukkan button angka kedalam array
        numbers = new Button[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        
        // Memanggil fungsi ButtonHandle untuk button-button yang ada didalam array numbers
        for (Button number : numbers) {
            number.setOnAction(this::ButtonHandle);
        }
    }

    @FXML
    void ButtonHandle(ActionEvent event) {
        // Membuat penanganan ketika button angka dipencet oleh pengguna
        for(int i = 0; i < 10; i++) {
            if(event.getSource() == numbers[i]) {
                if(result != 0) {
                    lblDisplay.setText("");
                    result = 0;
                    lblDisplay.setText(lblDisplay.getText().concat(String.valueOf(i)));
                } else {
                    lblDisplay.setText(lblDisplay.getText().concat(String.valueOf(i)));
                }
            }
        }
        
        if(event.getSource() == btnClear) { // Membuat penanganan ketika button Clear dipencet oleh pengguna
            lblDisplay.setText("");
        } else if(event.getSource() == btnDel) { // Membuat penanganan ketika button Delete dipencet oleh pengguna
            if(result == 0) {
                String str = lblDisplay.getText();
                lblDisplay.setText(str.substring(0, str.length() - 1));
            }
        } else if(event.getSource() == btnAdd) { // Membuat penanganan ketika button Tambah dipencet oleh pengguna
            num1 = Double.parseDouble(lblDisplay.getText());
            operator = '+';
            lblDisplay.setText("");
        } else if(event.getSource() == btnSubs) { // Membuat penanganan ketika button Pengurangan dipencet oleh pengguna
            num1 = Double.parseDouble(lblDisplay.getText());
            operator = '-';
            lblDisplay.setText("");
        } else if(event.getSource() == btnMult) { // Membuat penanganan ketika button Perkalian dipencet oleh pengguna
            num1 = Double.parseDouble(lblDisplay.getText());
            operator = '*';
            lblDisplay.setText("");
        } else if(event.getSource() == btnDiv) { // Membuat penanganan ketika button Pembagian dipencet oleh pengguna
            num1 = Double.parseDouble(lblDisplay.getText());
            operator = '/';
            lblDisplay.setText("");
        } else if(event.getSource() == btnDot) { // Membuat penanganan ketika button Koma dipencet oleh pengguna
            if(lblDisplay.getText().isEmpty()) {
                lblDisplay.setText("0.");
            } else if(!lblDisplay.getText().isEmpty() && !lblDisplay.getText().contains(".")) {
                lblDisplay.setText(lblDisplay.getText().concat("."));
            }
        } else if(event.getSource() == btnPersent) { // Membuat penanganan ketika button Persen dipencet oleh pengguna
            double temp = Double.parseDouble(lblDisplay.getText());
            temp = temp / 100.0;
            lblDisplay.setText(String.valueOf(temp));
        } else if(event.getSource() == btnMinus) { // Membuat penanganan ketika button Minus dipencet oleh pengguna
            if(lblDisplay.getText().contains("-")) {
                String str = lblDisplay.getText();
                lblDisplay.setText(str.substring(1, str.length()));
            } else {
                lblDisplay.setText("-".concat(lblDisplay.getText()));
            }
        } else if(event.getSource() == btnResult) { // Membuat penanganan ketika button Sama Dengan dipencet oleh pengguna
            num2 = Double.parseDouble(lblDisplay.getText());
            
            switch(operator) {
                case '+' :
                    operator = '\u0000';
                    result = num1 + num2;
                    lblDisplay.setText(String.valueOf(result));
                    break;
                case '-' :
                    operator = '\u0000';
                    result = num1 - num2;
                    lblDisplay.setText(String.valueOf(result));
                    break;
                case '*' :
                    operator = '\u0000';
                    result = num1 * num2;
                    lblDisplay.setText(String.valueOf(result));
                    break;
                case '/' :
                    operator = '\u0000';
                    result = num1 / num2;
                    lblDisplay.setText(String.valueOf(result));
                    break;
                default :
                    break;
            }
        }
    }
}
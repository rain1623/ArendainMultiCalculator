package com.example.arendainmulticalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView InputText,OutputText;

    private String input ,output , newOutput;

    private Button button0, button1,  button2,  button3,  button4, button5, button6, button7, button8,  button9,
            buttonadd,  buttonmultiply,  buttonsubs,  buttondivide,  buttonpoint,  buttonpercent, buttonpower,
            ButtonEqual, Buttonclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputText  =  findViewById(R.id.inputText);
        OutputText = findViewById(R.id.outputText);

        button0 = findViewById(R.id.Btn0);
        button1 = findViewById(R.id.Btn1);
        button2 = findViewById(R.id.Btn2);
        button3 = findViewById(R.id.Btn3);
        button4 = findViewById(R.id.Btn4);
        button5 = findViewById(R.id.Btn5);
        button6 = findViewById(R.id.Btn6);
        button7 = findViewById(R.id.Btn7);
        button8 = findViewById(R.id.Btn8);
        button9 = findViewById(R.id.Btn9);
        buttonadd = findViewById(R.id.additionBtn);
        buttonmultiply = findViewById(R.id.multiplyBtn);
        buttonsubs = findViewById(R.id.substractionBtn);
        buttondivide = findViewById(R.id.DivisionBtn);
        buttonpoint = findViewById(R.id.Btnpoint);
        buttonpercent = findViewById(R.id.percentBtn);
        buttonpower = findViewById(R.id.PowerBtn);
        ButtonEqual = findViewById(R.id.equalBtn);
        Buttonclear = findViewById(R.id.ClearBtn);
    }
    public void  onButtonClicked(View view) {

        Button button = (Button) view;
        String data  = button.getText().toString();
        switch (data) {
            case "C":
                input=null;
                output=null;
                newOutput=null;
                OutputText.setText("");
                break;

            case "^":
                solve();
                input+="^";
                break;
            case "*":
                solve();
                input+="*";
                break;

            case"=":
                solve();
                break;
            case"%":
                input+="%";
                double d = Double.parseDouble(InputText.getText().toString()) /100;
                OutputText.setText(String.valueOf(d));
                break;

            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")) {
                    solve();
                }
                input +=data;
        }
        InputText.setText(input);
    }
    private void solve(){
        if (input.split("\\+").length== 2){
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                OutputText.setText(newOutput);
                input = d + "   ";
            }catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length== 2){
            String numbers[] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                OutputText.setText(newOutput);
                input = d + "   ";
            }catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\/").length== 2){
            String numbers[] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                OutputText.setText(newOutput);
                input = d + "   ";
            }catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\^").length== 2){
            String numbers[] = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                OutputText.setText(newOutput);
                input = d + "   ";
            }catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length== 2){
            String numbers[] = input.split("\\-");
            try {
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    OutputText.setText(newOutput);
                    input = d + "";

                }
                else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    OutputText.setText("-" + newOutput);
                    input = d + "";
                }
            }catch (Exception e) {
                OutputText.setError(e.getMessage().toString());
            }
        }
    }
    private String cutDecimal(String number) {
        String n [] = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0"));
            number = n[0];
        }
        return number;
    }


}
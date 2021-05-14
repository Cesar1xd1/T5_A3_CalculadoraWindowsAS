package com.example.calculadorawindows;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView consola;
    String buffer = "";
    int operator = 0;
    String memo = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consola = findViewById(R.id.consola);

    }

    public void b0(View v){
        consola.setText(consola.getText()+"0");
    }
    public void b1(View v){
        consola.setText(consola.getText()+"1");
    }
    public void b2(View v){
        consola.setText(consola.getText()+"2");
    }
    public void b3(View v){
        consola.setText(consola.getText()+"3");
    }
    public void b4(View v){
        consola.setText(consola.getText()+"4");
    }
    public void b5(View v){
        consola.setText(consola.getText()+"5");
    }
    public void b6(View v){
        consola.setText(consola.getText()+"6");
    }
    public void b7(View v){
        consola.setText(consola.getText()+"7");
    }
    public void b8(View v){
        consola.setText(consola.getText()+"8");
    }
    public void b9(View v){
        consola.setText(consola.getText()+"9");
    }
    public void bpunto(View v){
        if(!consola.getText().toString().contains(".")){
            consola.setText(consola.getText()+".");
        }

    }
    public void CrearMemo(View v){
        if(consola.getText().toString().equals("")){
            memo = "0";
        }else{
            memo = consola.getText().toString();
        }
        consola.setText("");
    }
    public void masMemo(View v){
        if(consola.getText().toString().equals("")){

        }else{
            double x = Double.parseDouble(consola.getText().toString());
            double r = x + Double.parseDouble(memo);
            memo = String.valueOf(r);
            consola.setText("");
        }

    }
    public void menosMemo(View v){
        if(consola.getText().toString().equals("")){

        }else{
            double x = Double.parseDouble(consola.getText().toString());
            double r =  Double.parseDouble(memo)-x;
            memo = String.valueOf(r);
            consola.setText("");
        }

    }
    public void recuperarMemo(View v){
        consola.setText(memo);
    }
    public void clearMemo(View v){
        memo = "";
        consola.setText("");
    }

    public void bDel(View v){
        if (consola.getText().toString().length()>0) {
            consola.setText(consola.getText().toString().substring(0,consola.getText().toString().length()-1));
        }
    }
    public void masmenos(View v){
        if(consola.getText().toString().charAt(0)=='-' ){

            consola.setText(consola.getText().toString().replace("-","+"));
        }else if(Character.isDigit(consola.getText().toString().charAt(0)) ){
            consola.setText("-"+consola.getText().toString());
        }else if( consola.getText().toString().charAt(0)=='+'){
            consola.setText(consola.getText().toString().replace("+","-"));
        }
    }
    public void clear(View v){
        consola.setText("");
    }

    public void bResi(View v){
        operator = 1;
        buffer = consola.getText().toString();
        consola.setText("");
    }
    public void bDivi(View v){
        operator = 2;
        buffer = consola.getText().toString();
        consola.setText("");
    }
    public void bRaiz(View v){
        if (consola.getText().toString().length()>0) {
            Double resul =Double.parseDouble(consola.getText().toString());
            if (resul>0) {
                resul = Math.sqrt(resul);
                consola.setText(String.valueOf(resul));
            }
        }
    }
    public void bCuadrado(View v){
        if (consola.getText().toString().length()>0) {
            Double resul=Double.parseDouble(consola.getText().toString());
            resul = Math.pow(resul, 2);
            consola.setText(String.valueOf(resul));
        }
    }
    public void sobreX(View v){
        if (consola.getText().toString().length()>0) {
            double resul=Double.parseDouble(consola.getText().toString());
            if (resul!=0) {
                resul=1/resul;
                consola.setText(String.valueOf(resul));
            }
        }
    }
    public void bMulti(View v){
        buffer = consola.getText().toString();
        operator = 3;
        consola.setText("");
    }
    public void bResta(View v){
        buffer = consola.getText().toString();
        operator = 4;
        consola.setText("");
    }
    public void bSuma(View v){
        buffer = consola.getText().toString();
        operator = 5;
        consola.setText("");
    }
    public void igual(View v){
        if(operator!=0) {
            double n1 = Double.parseDouble(buffer);
            double n2 = 0.0;
           int x = 0;

            if(consola.getText().toString().equals("")){
                x = 1;
            }else{
                n2 = Double.parseDouble(consola.getText().toString());
            }
            double r = 0;
            switch (operator) {
                case 5:
                    if(x==1){
                        n2 = 0;
                    }
                    r=n1+n2;
                    break;
                case 4:
                    if(x==1){
                        n2 = 0;
                    }
                    r=n1-n2;
                    break;
                case 3:
                    if(x==1){
                        n2 = 1;
                    }
                    r=n1*n2;
                    break;
                case 2:
                    if(x==1){
                        n2 = 1;
                    }
                    r=n1/n2;
                    break;
                case 1:
                    if(x==1){
                        n2 = 1;
                    }
                    r=n1%n2;
                    break;
                default:
                    break;
            }
            consola.setText(String.valueOf(r));
        }
    }

}
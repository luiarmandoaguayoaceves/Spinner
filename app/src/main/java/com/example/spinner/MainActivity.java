package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner1 = (Spinner) findViewById(R.id.spinner);
        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);
        tv1 = (TextView) findViewById(R.id.tv_resultado);

        //Se crea un arreglo
        String [] opciones = {"sumar","restar", "multiplicar", "dividir"};

        //Para motar el arreglo en la vista del diseño se llama: adapter
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_luis, opciones);
        //Se le asigna el arreglo de arriba de nombre adaptar a el spinner con el metodo setAdapter y el nombre del ArrayAdapter este caso: adapter
        spinner1.setAdapter(adapter);
    }
    //Metodo del boton
    public void Calcular(View view){
    String valor1_String = et1.getText().toString();
    String valor2_String = et2.getText().toString();

    int valor1_int = Integer.parseInt(valor1_String);
    int valor2_int = Integer.parseInt(valor2_String);

    //Para saber que a seleccionado y se almasena como texto
    String seleccion = spinner1.getSelectedItem().toString();
    if (seleccion.equals("sumar")){
        int suma = valor1_int+valor2_int;
        String resultado = String.valueOf(suma);
        tv1.setText(resultado);
    }else if (seleccion.equals("restar")){
        int resta = valor1_int-valor2_int;
        String resultado = String.valueOf(resta);
        tv1.setText(resultado);
    }else if (seleccion.equals("multiplicar")){
        int multiplicacion = valor1_int*valor2_int;
        String resultado = String.valueOf(multiplicacion);
        tv1.setText(resultado);
    }else if (seleccion.equals("dividir")){
        if (valor2_int != 0){
            int divicion = valor1_int/valor2_int;
            String resultado = String.valueOf(divicion);
            tv1.setText(resultado);
        }else{
            Toast.makeText(this, "El valor 2 debe ser mayor a cero", Toast.LENGTH_LONG).show();
        }
    }

    }
}
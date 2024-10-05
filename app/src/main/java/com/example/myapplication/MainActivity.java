package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextEdad;
    private RadioGroup radioGroupSexo;
    private RadioButton radioButtonHombre, radioButtonMujer;
    private Button buttonCalcularCalorias, buttonBoston;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazamos los elementos de la interfaz
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEdad = findViewById(R.id.editTextEdad);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
        radioButtonHombre = findViewById(R.id.radioButtonHombre);
        radioButtonMujer = findViewById(R.id.radioButtonMujer);
        buttonCalcularCalorias = findViewById(R.id.buttonCalcularCalorias);
        buttonBoston = findViewById(R.id.buttonBoston);

        // Configuramos el botón de calcular calorías
        buttonCalcularCalorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCalorias();
            }
        });

        // Configuramos el botón para el tiempo de clasificación al maratón de Boston
        buttonBoston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTiempoBoston();
            }
        });
    }

    // Función para calcular las calorías diarias basales y abrir el CaloriasActivity
    private void calcularCalorias() {
        String nombre = editTextNombre.getText().toString();
        String edadStr = editTextEdad.getText().toString();

        if (nombre.isEmpty() || edadStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese todos los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        int edad = Integer.parseInt(edadStr);
        String sexo = radioButtonHombre.isChecked() ? "Hombre" : "Mujer";

        // Crear un Intent para iniciar el CaloriasActivity y enviar los datos
        Intent intent = new Intent(MainActivity.this, CaloriasActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("edad", edad);
        intent.putExtra("sexo", sexo);
        startActivity(intent);
    }

    // Función para calcular el tiempo requerido para clasificar al maratón de Boston 2020
    private void calcularTiempoBoston() {
        String nombre = editTextNombre.getText().toString();
        String edadStr = editTextEdad.getText().toString();

        if (nombre.isEmpty() || edadStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese todos los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        int edad = Integer.parseInt(edadStr);
        String sexo = radioButtonHombre.isChecked() ? "Hombre" : "Mujer";

        // Crear un Intent para iniciar el BostonActivity y enviar los datos
        Intent intent = new Intent(MainActivity.this, BostonActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("edad", edad);
        intent.putExtra("sexo", sexo);
        startActivity(intent);
    }
}

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CaloriasActivity extends AppCompatActivity {

    private TextView textViewNombre, textViewEdad, textViewSexo;
    private EditText editTextPeso, editTextEstatura;
    private Button buttonCalcular, buttonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorias);

        // Enlazar los elementos de la interfaz
        textViewNombre = findViewById(R.id.textViewNombre);
        textViewEdad = findViewById(R.id.textViewEdad);
        textViewSexo = findViewById(R.id.textViewSexo);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextEstatura = findViewById(R.id.editTextEstatura);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonSalir = findViewById(R.id.buttonSalir);

        // Obtener los datos desde MainActivity
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        int edad = intent.getIntExtra("edad", 0);
        String sexo = intent.getStringExtra("sexo");

        // Mostrar los datos en los TextView
        textViewNombre.setText("Nombre: " + nombre);
        textViewEdad.setText("Edad: " + edad);
        textViewSexo.setText("Sexo: " + sexo);

        // Configurar el botón de calcular
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTMB(edad, sexo);
            }
        });

        // Configurar el botón de salir
        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finaliza el activity y regresa al MainActivity
            }
        });
    }

    // Función para calcular la TMB (Tasa Metabólica Basal)
    private void calcularTMB(int edad, String sexo) {
        String pesoStr = editTextPeso.getText().toString();
        String estaturaStr = editTextEstatura.getText().toString();

        if (pesoStr.isEmpty() || estaturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese peso y estatura", Toast.LENGTH_SHORT).show();
            return;
        }

        double peso = Double.parseDouble(pesoStr);
        int estatura = Integer.parseInt(estaturaStr);

        double tmb;
        if (sexo.equals("Hombre")) {
            tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) + 5;
        } else {
            tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) - 161;
        }

        // Mostrar el resultado
        TextView textViewResultado = findViewById(R.id.textViewResultado);
        textViewResultado.setText("Tu Tasa Metabólica Basal es: " + tmb + " calorías diarias.");
    }
}

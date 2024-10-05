package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BostonActivity extends AppCompatActivity {

    private TextView textViewNombre, textViewEdad, textViewSexo, textViewResultado;
    private Button buttonTiempoRequerido, buttonSalir;
    private String nombre, sexo;
    private int edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boston);

        // Enlazamos los elementos de la interfaz
        textViewNombre = findViewById(R.id.textViewNombre);
        textViewEdad = findViewById(R.id.textViewEdad);
        textViewSexo = findViewById(R.id.textViewSexo);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonTiempoRequerido = findViewById(R.id.buttonTiempoRequerido);
        buttonSalir = findViewById(R.id.buttonSalir);

        // Obtenemos los datos del Intent
        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        sexo = intent.getStringExtra("sexo");
        edad = intent.getIntExtra("edad", 0);

        // Mostrar datos
        textViewNombre.setText("Nombre: " + nombre);
        textViewEdad.setText("Edad: " + edad);
        textViewSexo.setText("Sexo: " + sexo);

        // Configurar botón de tiempo requerido
        buttonTiempoRequerido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarTiempoRequerido();
            }
        });

        // Botón para salir y regresar a la actividad principal
        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cerrar la actividad actual y volver a la anterior
            }
        });
    }

    // Función para mostrar el tiempo requerido para clasificar al maratón
    private void mostrarTiempoRequerido() {
        String tiempoRequerido = calcularTiempoMaraton(edad, sexo);

        if (tiempoRequerido == null) {
            Toast.makeText(BostonActivity.this, "Edad no permitida para clasificar al Maratón", Toast.LENGTH_SHORT).show();
        } else {
            textViewResultado.setText("Tiempo requerido para el Maratón: " + tiempoRequerido + " minutos");
        }
    }

    // Función para calcular el tiempo de clasificación según la edad y sexo
    private String calcularTiempoMaraton(int edad, String sexo) {
        if (edad < 18 || edad > 80) {
            return null; // Edad fuera del rango permitido
        }

        if (sexo.equals("Hombre")) {
            if (edad >= 18 && edad <= 34) return "3:00";
            if (edad >= 35 && edad <= 39) return "3:05";
            if (edad >= 40 && edad <= 44) return "3:10";
            if (edad >= 45 && edad <= 49) return "3:20";
            if (edad >= 50 && edad <= 54) return "3:25";
            if (edad >= 55 && edad <= 59) return "3:35";
            if (edad >= 60 && edad <= 64) return "3:50";
            if (edad >= 65 && edad <= 69) return "4:05";
            if (edad >= 70 && edad <= 74) return "4:20";
            if (edad >= 75 && edad <= 79) return "4:35";
            if (edad >= 80) return "4:50";
        } else if (sexo.equals("Mujer")) {
            if (edad >= 18 && edad <= 34) return "3:30";
            if (edad >= 35 && edad <= 39) return "3:35";
            if (edad >= 40 && edad <= 44) return "3:40";
            if (edad >= 45 && edad <= 49) return "3:50";
            if (edad >= 50 && edad <= 54) return "3:55";
            if (edad >= 55 && edad <= 59) return "4:05";
            if (edad >= 60 && edad <= 64) return "4:20";
            if (edad >= 65 && edad <= 69) return "4:35";
            if (edad >= 70 && edad <= 74) return "4:50";
            if (edad >= 75 && edad <= 79) return "5:05";
            if (edad >= 80) return "5:20";
        }
        return null; // Si algo sale mal
    }
}
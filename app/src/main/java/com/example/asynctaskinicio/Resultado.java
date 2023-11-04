package com.example.asynctaskinicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
/////Juan Gallegos Suazo/////
public class Resultado extends AppCompatActivity {

    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Resultado = findViewById(R.id.et_resultado); //se inicializa el textview llamado resultado mediante su identificador ID
        String nombreUsuario = getIntent().getStringExtra("Usuario"); // se obtiene el valor extra del usuario del inten que inicio la actividad
        Resultado.setText("Bienvenido" + nombreUsuario); // se utiliza el valor obtenido del extra para construir un mensaje de bienvenida que se mostrara
        // en el textview, el mensaje se crea contatenando "Bienvenido: " con el nombre del usuario recuperado
    }
}
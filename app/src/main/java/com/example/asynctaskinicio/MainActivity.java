package com.example.asynctaskinicio;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
/////Juan Gallegos Suazo/////
public class MainActivity extends AppCompatActivity {

    private Button iniciar;
    private EditText Usuario, Password;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.btn_inicio);
        Usuario = findViewById(R.id.et_usuario);
        Password = findViewById(R.id.et_password);
        pb = findViewById(R.id.progressBar3);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute(Usuario.getText().toString());
            }
        });
    }

     class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
            iniciar.setEnabled(false);// Mostrar barra de progreso antes de la ejecución
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            return strings[0];
        }
        @Override
        protected void onPostExecute(String s) {
            pb.setVisibility(View.VISIBLE);
            iniciar.setEnabled(true);
            Intent intent = new Intent(MainActivity.this, Resultado.class);
            intent.putExtra("Usuario", Usuario.getText().toString());
            startActivity(intent);
        }
    }}
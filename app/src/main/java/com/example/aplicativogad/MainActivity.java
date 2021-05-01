package com.example.aplicativogad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creamos un hilo que permite mantener la pantalla por cierto tiempo
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                //Se crea un intente para pasar de la pantalla splash a la pantalla de inicio
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },2000); //tiempo en el que permanece la pantalla
    }
}


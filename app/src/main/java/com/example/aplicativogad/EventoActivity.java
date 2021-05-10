package com.example.aplicativogad;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.aplicativogad.entidades.Turistico;

public class EventoActivity extends AppCompatActivity {

    Toolbar toolbar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        toolbarConfig();
        intent = getIntent();
    }

    private void toolbarConfig() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_atras);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
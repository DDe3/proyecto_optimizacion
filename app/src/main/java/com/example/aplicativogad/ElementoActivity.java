package com.example.aplicativogad;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ElementoActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemento);
        toolbarConfig();
    }

    private void toolbarConfig() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_atras);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
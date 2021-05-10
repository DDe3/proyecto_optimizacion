package com.example.aplicativogad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.aplicativogad.database.AppDatabase;
import com.example.aplicativogad.entidades.Evento;
import com.example.aplicativogad.interfaces.EntityDao;
import com.example.aplicativogad.menu.ContactosActivity;
import com.example.aplicativogad.menu.InformacionActivity;
import com.example.aplicativogad.recycler_adapter.EventoAdapter;
import com.example.aplicativogad.recycler_adapter.TuristicoAdapter;
import com.example.aplicativogad.entidades.Turistico;
import com.example.aplicativogad.repository.EventoRepository;
import com.example.aplicativogad.repository.EventoRepositoryImpl;
import com.example.aplicativogad.repository.TuristicoRepository;
import com.example.aplicativogad.repository.TuristicoRepositoryImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;
    List<Turistico> listaTuristico;
    List<Evento> listaEvento;

    // DB variables
    AppDatabase db;
    EntityDao dao;
    EventoRepository er;
    TuristicoRepository tr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        /*------------- Hooks ----------------*/

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar2 = findViewById(R.id.toolbar2);



        /*-------------- Toolbar -------------*/

        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle(getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Reproducir video", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        /* ----------- Navegacion en Menu Drawer ------------ */
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar2,
                R.string.open,
                R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        try {
            recyclerInicio();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.inicio:
                // Solo se cierra el drawer
//                intent = new Intent(HomeActivity.this, InicioActivity.class);
//                startActivity(intent);

                break;

            case R.id.mapa:
                intent = new Intent(HomeActivity.this, MapsActivity.class);
                startActivity(intent);
                break;

            case R.id.info:
                intent = new Intent(HomeActivity.this, InformacionActivity.class);
                startActivity(intent);
                break;

            case R.id.contacto:
                intent = new Intent(HomeActivity.this, ContactosActivity.class);
                startActivity(intent);
                break;
            case R.id.juego:
                Toast.makeText(this,"JUEGO AUN NO IMPLEMENTADO", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cuento:
                Toast.makeText(this,"CUENTO AUN NO IMPLEMENTADO", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    // METODO PARA SABER SI LA IMAGEN DEL MENU PRINCIPAL ES TOCADA.
    public void handleSelection(View view){
        Toast.makeText(this, "Tocaste la imagen", Toast.LENGTH_LONG).show();

    }


    private void recyclerInicio() throws ExecutionException, InterruptedException {

        databaseInit();

        listaTuristico = tr.getAll();
        listaEvento = er.getAll();

        TuristicoAdapter turisticoAdapter = new TuristicoAdapter(listaTuristico,this);
        RecyclerView recyclerViewTuristico = findViewById(R.id.turisticoReciclerView);
        recyclerViewTuristico.setHasFixedSize(true);
        ViewCompat.setNestedScrollingEnabled(recyclerViewTuristico, false);
        LinearLayoutManager horizontalLayout = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTuristico.setLayoutManager(horizontalLayout);
        recyclerViewTuristico.setAdapter(turisticoAdapter);

        EventoAdapter eventoAdapter = new EventoAdapter(listaEvento,this);
        RecyclerView recyclerViewEvento = findViewById(R.id.eventoReciclerView);
        recyclerViewEvento.setHasFixedSize(true);
        ViewCompat.setNestedScrollingEnabled(recyclerViewEvento, false);
        LinearLayoutManager horizontalLayout2 = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewEvento.setLayoutManager(horizontalLayout2);
        recyclerViewEvento.setAdapter(eventoAdapter);

    }

    public void databaseInit() throws InterruptedException {
        db = AppDatabase.getInstance(this);
        dao = db.entityDao();
        er = new EventoRepositoryImpl(dao);
        tr = new TuristicoRepositoryImpl(dao);
    }


}
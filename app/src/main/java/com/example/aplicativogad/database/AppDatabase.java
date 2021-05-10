package com.example.aplicativogad.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aplicativogad.config.Constantes;
import com.example.aplicativogad.entidades.Evento;
import com.example.aplicativogad.entidades.Turistico;
import com.example.aplicativogad.interfaces.EntityDao;



@Database(entities = {Evento.class, Turistico.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    @SuppressWarnings("WeakerAccess")
    // Permisos
    public abstract EntityDao entityDao();

    private static AppDatabase sInstance;


    public static AppDatabase getInstance(Context context) throws InterruptedException {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance==null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, Constantes.BD_NOMBRE)
                            .build();
                    sInstance.llenarDBPorPrimeraVez();
                }
            }
        }
        return sInstance;
    }

    private void llenarDBPorPrimeraVez() throws InterruptedException {

        Thread myT = new Thread(() -> runInTransaction(() -> {
            if (entityDao().count() == 0) {
                Evento evento1 = new Evento();
                evento1.setImgPath("file:///android_asset/imagenes/llamadas.png");
                evento1.setTitulo("Titulo 1");
                evento1.setDescripcion("Descripcion 1");

                Evento evento2 = new Evento();
                evento2.setImgPath("file:///android_asset/imagenes/llamadas.png");
                evento2.setTitulo("Titulo 2");
                evento2.setDescripcion("Descripcion 2");

                Evento evento3 = new Evento();
                evento3.setImgPath("file:///android_asset/imagenes/llamadas.png");
                evento3.setTitulo("Titulo 3");
                evento3.setDescripcion("Descripcion 3");

                Turistico t1 = new Turistico();
                t1.setImgPath("file:///android_asset/imagenes/ubicacion.png");
                t1.setTitulo("Titulo 1");
                t1.setDescripcion("Descripcion 1");

                Turistico t2 = new Turistico();
                t2.setImgPath("file:///android_asset/imagenes/ubicacion.png");
                t2.setTitulo("Titulo 2");
                t2.setDescripcion("Descripcion 2");

                Turistico t3 = new Turistico();
                t3.setImgPath("file:///android_asset/imagenes/ubicacion.png");
                t3.setTitulo("Titulo 3");
                t3.setDescripcion("Descripcion 3");

                entityDao().insert(evento1);
                entityDao().insert(evento2);
                entityDao().insert(evento3);

                entityDao().insert(t1);
                entityDao().insert(t2);
                entityDao().insert(t3);
            }
        }));
        myT.start();
        myT.join();
    }





}

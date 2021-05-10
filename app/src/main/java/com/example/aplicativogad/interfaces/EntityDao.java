package com.example.aplicativogad.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.aplicativogad.entidades.Evento;
import com.example.aplicativogad.entidades.Turistico;

import java.util.List;

@Dao
public interface EntityDao {

    @Query("SELECT * FROM " + Turistico.TABLA_NOMBRE + " WHERE " + Turistico.COLUMNA_ID + " = :id")
    Turistico getTuristico(int id);

    @Query("SELECT * FROM " + Turistico.TABLA_NOMBRE)
    List<Turistico> getAllTuristico();

    @Query("SELECT * FROM " + Evento.TABLA_NOMBRE)
    List<Evento> getAllEvento();

    @Query("SELECT * FROM " + Evento.TABLA_NOMBRE + " WHERE " + Evento.COLUMNA_ID + " = :id")
    Evento getEvento(int id);


    @Insert
    void insert(Evento evento);

    @Insert
    void insert(Turistico turistico);

    @Delete
    void delete(Evento evento);

    @Delete
    void delete(Turistico turistico);

    @Query("SELECT COUNT(*) FROM " + Turistico.TABLA_NOMBRE)
    int count();

}

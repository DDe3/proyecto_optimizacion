package com.example.aplicativogad.repository;

import com.example.aplicativogad.entidades.Evento;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface EventoRepository {

    List<Evento> getAll() throws ExecutionException, InterruptedException;
    Evento findEventoById(int id) throws ExecutionException, InterruptedException;
    void insertEvento(Evento evento);
    void delete(Evento evento);

}

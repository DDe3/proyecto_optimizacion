package com.example.aplicativogad.repository;


import com.example.aplicativogad.entidades.Turistico;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface TuristicoRepository {

    List<Turistico> getAll() throws ExecutionException, InterruptedException;
    Turistico findEventoById(int id) throws ExecutionException, InterruptedException;
    void insertTuristico(Turistico evento);
    void delete(Turistico evento);

}

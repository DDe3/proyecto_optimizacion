package com.example.aplicativogad.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.aplicativogad.entidades.Evento;
import com.example.aplicativogad.interfaces.EntityDao;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class EventoRepositoryImpl implements EventoRepository {


    EntityDao dao;

    public EventoRepositoryImpl(EntityDao dao) {
        this.dao = dao;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Evento> getAll() throws ExecutionException, InterruptedException {

        CompletableFuture<List<Evento>> ret = new CompletableFuture<>();
        new Thread( () -> {
            List<Evento> aux = dao.getAllEvento();
            ret.complete(aux);
        }).start();
        return ret.get();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Evento findEventoById(int id) throws ExecutionException, InterruptedException {
        CompletableFuture<Evento> ret = new CompletableFuture<>();
        new Thread( () -> {
            Evento e = dao.getEvento(id);
            ret.complete(e);
        }).start();
        return ret.get();
    }

    @Override
    public void insertEvento(Evento evento) {
        dao.insert(evento);
    }

    @Override
    public void delete(Evento evento) {
        dao.delete(evento);
    }
}

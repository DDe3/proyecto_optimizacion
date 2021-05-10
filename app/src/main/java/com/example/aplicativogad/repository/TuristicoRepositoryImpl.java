package com.example.aplicativogad.repository;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.aplicativogad.entidades.Turistico;
import com.example.aplicativogad.interfaces.EntityDao;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TuristicoRepositoryImpl implements TuristicoRepository {

    EntityDao dao;

    public TuristicoRepositoryImpl(EntityDao dao) {
        this.dao = dao;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Turistico> getAll() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Turistico>> ret = new CompletableFuture<>();
        new Thread( () -> {
            List<Turistico> aux = dao.getAllTuristico();
            ret.complete(aux);
        }).start();
        return ret.get();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Turistico findEventoById(int id) throws ExecutionException, InterruptedException {
        CompletableFuture<Turistico> ret = new CompletableFuture<>();
        new Thread( () -> {
            Turistico t = dao.getTuristico(id);
            ret.complete(t);
        }).start();
        return ret.get();
    }

    @Override
    public void insertTuristico(Turistico t) {
        dao.insert(t);
    }

    @Override
    public void delete(Turistico t) {
        dao.delete(t);
    }

}

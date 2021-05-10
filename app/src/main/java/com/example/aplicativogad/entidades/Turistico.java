package com.example.aplicativogad.entidades;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Turistico.TABLA_NOMBRE)
public class Turistico {


    public static final String TABLA_NOMBRE = "turistico";
    public static final String COLUMNA_NOMBRE = "nombre";
    public static final String COLUMNA_ID = BaseColumns._ID;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMNA_ID)
    private long id;

    @ColumnInfo(name = "img")
    private String imgPath;

    @ColumnInfo(name = "titulo")
    private String titulo;

    @ColumnInfo(name = "descripcion")
    private String descripcion;

    protected Turistico(Parcel in) {
        id = in.readLong();
        imgPath = in.readString();
        titulo = in.readString();
        descripcion = in.readString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Turistico(long id, String imgPath, String titulo, String descripcion) {
        this.id = id;
        this.imgPath = imgPath;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Turistico() {
    }
}

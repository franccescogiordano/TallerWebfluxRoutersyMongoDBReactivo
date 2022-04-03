package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.model;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recursos")
public class Recurso {
    @Id
    private String id = UUID.randomUUID().toString().substring(0,6);

    private String fechaPrestacion;
    private boolean estaPrestado;
    private String titulo;
    private String tipo;
    private String areaTematica;

    public Recurso(String fechaPrestacion, String titulo, String tipo,String areaTematica){
        this.fechaPrestacion = Objects.requireNonNull(fechaPrestacion);
        this.titulo = Objects.requireNonNull(titulo);
        this.tipo = Objects.requireNonNull(tipo);
        this.setEstaPrestado(false);
        this.areaTematica=Objects.requireNonNull(areaTematica);
    }

    
    public Recurso(){
    
    }
    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }

    public boolean isEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfechaPrestacion() {
        return fechaPrestacion;
    }


    public String getTipo() {
        return tipo;
    }

    

    public void setfechaPrestacion(String fechaPrestacion) {
        this.fechaPrestacion = fechaPrestacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

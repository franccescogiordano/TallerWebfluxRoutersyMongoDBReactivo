package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.UUID;

public class RecursoDTO {

    private String id;
    @NotBlank
    private String fechaPrestacion;
    @NotBlank
    private boolean estaPrestado;
    @NotBlank
    private String titulo;
    @NotBlank
    private String tipo;
    @NotBlank
    private String areaTematica;


    public RecursoDTO(String id, String fechaPrestacion, boolean estaPrestado, String titulo, String tipo, String areaTematica) {
        this.id = id;
        this.fechaPrestacion = fechaPrestacion;
        this.estaPrestado = estaPrestado;
        this.titulo = titulo;
        this.tipo = tipo;
        this.areaTematica = areaTematica;
    }

    public RecursoDTO(String fechaPrestacion, boolean estaPrestado, String titulo, String tipo, String areaTematica) {
        this.fechaPrestacion = fechaPrestacion;
        this.estaPrestado = estaPrestado;
        this.titulo = titulo;
        this.tipo = tipo;
        this.areaTematica = areaTematica;
    }
    public RecursoDTO(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaPrestacion() {
        return fechaPrestacion;
    }

    public void setFechaPrestacion(String fechaPrestacion) {
        this.fechaPrestacion = fechaPrestacion;
    }

    public boolean isEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoDTO that = (RecursoDTO) o;
        return estaPrestado == that.estaPrestado && Objects.equals(id, that.id) && Objects.equals(fechaPrestacion, that.fechaPrestacion) && Objects.equals(titulo, that.titulo) && Objects.equals(tipo, that.tipo) && Objects.equals(areaTematica, that.areaTematica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaPrestacion, estaPrestado, titulo, tipo, areaTematica);
    }

    @Override
    public String toString() {
        return "RecursoDTO{" +
                "id='" + id + '\'' +
                ", fechaPrestacion='" + fechaPrestacion + '\'' +
                ", estaPrestado=" + estaPrestado +
                ", titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", areaTematica='" + areaTematica + '\'' +
                '}';
    }
}

package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.mapper;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.model.Recurso;

import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {
    public Function<RecursoDTO, Recurso> mapperToDato(String id) {
        return updateDato -> {
            var dato = new Recurso();
            dato.setId(id);
            dato.setTitulo(updateDato.getTitulo());
            dato.setAreaTematica(updateDato.getAreaTematica());
            dato.setTipo(updateDato.getTipo());
            dato.setEstaPrestado(updateDato.isEstaPrestado());
            dato.setfechaPrestacion(updateDato.getFechaPrestacion());
            return dato;
        };
    }

    public Function<Recurso, RecursoDTO> mapDatoToDTO() {
        return entity -> new RecursoDTO(
                entity.getId(),
                entity.getfechaPrestacion(),
                entity.isEstaPrestado(),
                entity.getTitulo(),
                entity.getTipo(),
                entity.getAreaTematica()
        );
    }
}
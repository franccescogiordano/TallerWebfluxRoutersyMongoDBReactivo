package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.mapper.MapperUtils;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.model.Recurso;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository.RecursoRepository;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.GuardarDato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrear implements GuardarDato {
    private final RecursoRepository repositorio;
    private final MapperUtils mapperUtils;
    @Autowired
    public UseCaseCrear(MapperUtils mapperUtils, RecursoRepository repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(RecursoDTO datoDTO) {
        return repositorio.save(mapperUtils.mapperToDato(null).apply(datoDTO)).map(Recurso::getId).thenReturn(datoDTO.toString());
    }
}
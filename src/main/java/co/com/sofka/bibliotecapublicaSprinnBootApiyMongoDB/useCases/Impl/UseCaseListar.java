package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.mapper.MapperUtils;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository.RecursoRepository;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class UseCaseListar implements Supplier<Flux<RecursoDTO>> {
    private final RecursoRepository repositorio;
    private final MapperUtils mapperUtils;
    public UseCaseListar(MapperUtils mapperUtils, RecursoRepository repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<RecursoDTO> get() {
        return repositorio.findAll().map(mapperUtils.mapDatoToDTO());
    }
}
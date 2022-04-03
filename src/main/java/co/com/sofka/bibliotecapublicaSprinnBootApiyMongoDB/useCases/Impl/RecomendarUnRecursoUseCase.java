package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.mapper.MapperUtils;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository.RecursoRepository;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.UseCaseRecomendarPorTipoYArea;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class RecomendarUnRecursoUseCase implements UseCaseRecomendarPorTipoYArea {

    private final RecursoRepository repository;
    private final MapperUtils mapper;
    public RecomendarUnRecursoUseCase(RecursoRepository repositorioRecurso, MapperUtils mapper) {
        this.repository = repositorioRecurso;
        this.mapper = mapper;
    }
    @Override
    public Flux<RecursoDTO> apply(String tipo, String area) {
        return this.repository.findByTipo(tipo).map(recurso -> {
                    return recurso;
                }
        ).filter(recurso -> recurso.getAreaTematica().equals(area)).map(recurso -> mapper.mapDatoToDTO().apply(recurso));
    }
}

package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.mapper.MapperUtils;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository.RecursoRepository;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.GuardarDato;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.GuardarRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;
import java.util.Objects;
@Service
@Validated
public class UpdateRecursoUseCase implements GuardarDato {
    private final RecursoRepository repository;
    private final MapperUtils mapper;

    public UpdateRecursoUseCase(RecursoRepository repositorioRecurso, MapperUtils mapper) {
        this.repository = repositorioRecurso;
        this.mapper = mapper;
    }

    @Override
    public Mono<String> apply(RecursoDTO recursoDTO) {
        String id = Objects.requireNonNull(recursoDTO.getId(), "Se requiere Ingresar el id del recurso");
        return this.repository.findById(id)
                .flatMap(recurso1 -> {
                    recursoDTO.setId(id);
                    return this.repository.save(mapper.mapperToDato(null).apply(recursoDTO))
                            .map(recurso -> mapper.mapDatoToDTO().apply(recurso));
                })
                .switchIfEmpty(Mono.empty()).thenReturn(recursoDTO.toString());

    }
}

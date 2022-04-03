package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository.RecursoRepository;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.EliminarRecurso;
import org.springframework.stereotype.Service;

import java.util.Objects;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;
@Service
@Validated
public class EliminarRecursoUseCase implements EliminarRecurso {
    private final RecursoRepository repository;

    public EliminarRecursoUseCase(RecursoRepository repositorioRecurso) {
        this.repository = repositorioRecurso;
    }
    @Override
    public Mono<Void> get(String id) {
        if (Objects.isNull(id)){
            return Mono.empty();
        }
        return repository.deleteById(id);
    }

}

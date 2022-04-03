package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository.RecursoRepository;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.ConsultarDisponibilidad;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;


@Service
@Validated
public class DevolverRecursoUseCase  implements ConsultarDisponibilidad {
    private final RecursoRepository repository;

    public DevolverRecursoUseCase(RecursoRepository repositorioRecurso) {
        this.repository = repositorioRecurso;
    }

    @Override
    public Mono<String> estaraDisponible(String id) {
        return repository.findById(id).flatMap(recurso-> {
            if(!recurso.isEstaPrestado() ) { //si no esta prestado, no lo puedo devolver
                return Mono.just("el recurso ya esta devuelto no se puede devolver");
            }else{
                recurso.setEstaPrestado(false);
                return repository.save(recurso).thenReturn("Recurso devuelvo con exito!");
            }
        } );
    }
}

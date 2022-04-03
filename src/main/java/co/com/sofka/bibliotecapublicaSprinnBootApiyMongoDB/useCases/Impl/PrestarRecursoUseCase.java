package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository.RecursoRepository;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.ConsultarDisponibilidad;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.UseCaseWithMonoObject;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
@Service
@Validated
public class PrestarRecursoUseCase implements ConsultarDisponibilidad {

    private final RecursoRepository repository;

    public PrestarRecursoUseCase(RecursoRepository repositorioRecurso) {
        this.repository = repositorioRecurso;
    }

    @Override
    public Mono<String> estaraDisponible(String id) {
        return repository.findById(id).flatMap(recurso-> {
            if(recurso.isEstaPrestado() ) {
                return Mono.just("El recurso esta prestado, lo sentimos :_(");
            }else{
                recurso.setEstaPrestado(true);
                LocalDate today = LocalDate.now();
                recurso.setfechaPrestacion(today.toString());
               return repository.save(recurso).thenReturn("El recurso fue prestado con exito!");
            }
        } );
    }
}

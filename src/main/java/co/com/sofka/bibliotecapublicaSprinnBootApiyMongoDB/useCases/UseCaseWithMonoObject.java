package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UseCaseWithMonoObject {
    public Mono<Object> apply( String id);
}

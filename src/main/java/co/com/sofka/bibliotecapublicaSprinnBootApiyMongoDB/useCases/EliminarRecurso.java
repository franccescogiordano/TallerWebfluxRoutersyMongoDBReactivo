package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface EliminarRecurso {
    Mono<Void> get(String id);
}

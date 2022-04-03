package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases;

import reactor.core.publisher.Mono;


@FunctionalInterface
public interface ConsultarDisponibilidad {
    Mono<String> estaraDisponible(String id);


}

package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarDato {
    public Mono<String> apply(RecursoDTO datoDTO);
}

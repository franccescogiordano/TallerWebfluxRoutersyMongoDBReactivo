package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import reactor.core.publisher.Flux;


@FunctionalInterface
public interface UseCaseRecomendarPorTipoYArea {
    public Flux<RecursoDTO> apply(String tipo, String area);
}

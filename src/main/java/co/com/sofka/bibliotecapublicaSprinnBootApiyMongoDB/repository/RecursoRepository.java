package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.model.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
public interface RecursoRepository extends  ReactiveMongoRepository<Recurso, String> {
    public Flux<Recurso> findByTipo(String tipo);
}

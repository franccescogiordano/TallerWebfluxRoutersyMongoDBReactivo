package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.service;
import java.util.concurrent.ExecutionException;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.model.Recurso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface RecursoService {
    public Mono<Recurso> findOne(String id);
    public Mono<String> estaraDisponible(String id);
    public  Mono<String> preconsultar(Mono<Recurso> recurso)  throws InterruptedException, ExecutionException;
    public Mono<Object> prestar(String id);
    public Flux<Recurso> findAll();
    public Mono<Void> delete(String id);
    public Mono<Recurso> save(Recurso Recurso);
    public Mono<Recurso> update(String id, Recurso recurso);
    public Flux<Recurso> recomendarPorTipoyArea(String tipo,String area);
    public Mono<Object> devolver(String id);
}
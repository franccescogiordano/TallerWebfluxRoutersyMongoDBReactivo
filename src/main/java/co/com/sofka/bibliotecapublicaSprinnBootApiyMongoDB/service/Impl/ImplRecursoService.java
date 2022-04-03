package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.service.Impl;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.model.Recurso;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository.RecursoRepository;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.service.RecursoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ImplRecursoService implements RecursoService {

    @Autowired
    RecursoRepository repository;

    @Override
    public Mono<Recurso> findOne(String id) { 
        return this.repository.findById(id);
    }

    @Override
    public Mono<String> estaraDisponible(String id) {
        Mono<Recurso> x = repository.findById(id);
        try {
            return preconsultar(x);
        } catch (InterruptedException e) {
    
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         return Mono.just("null");
    }

    @Override
    public  Mono<String> preconsultar(Mono<Recurso> recurso) throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
       return recurso.map(libro -> {
        var dispo = libro.isEstaPrestado() ? "El recurso NO esta disponible desde la fecha " + libro.getfechaPrestacion() : "Esta Disponible";
        return Mono.just(dispo);
    }).toFuture().get();

    }

    @Override
    public Mono<Object> prestar(String id) {
            return repository.findById(id).flatMap(recurso-> {
                if(recurso.isEstaPrestado() ) {
                    return Mono.just("El rercurso esta prestado, lo sentimos :_(");
                }else{
                    recurso.setEstaPrestado(true);
                    LocalDate today = LocalDate.now();
                    recurso.setfechaPrestacion(today.toString());
                    return repository.save(recurso); 
                } 
             } );
    }

    @Override
    public Mono<Void> delete(String id) {
     return this.repository.deleteById(id);
    }

    @Override
    public Mono<Recurso> save(Recurso Recurso) {
        
       return this.repository.save(Recurso);
    }

    @Override
    public Flux<Recurso> recomendarPorTipoyArea(String tipo,String area) {
        return this.repository.findByTipo(tipo).map(recurso -> {
            return recurso;
        }
            ).filter(recurso -> recurso.getAreaTematica().equals(area));
    }

    @Override
    public Mono<Object> devolver(String id) {
        return repository.findById(id).flatMap(recurso-> {
            if(!recurso.isEstaPrestado() ) { //si no esta prestado, no lo puedo devolver
                return Mono.just("el recurso ya esta devuelto no se puede devolver");
            }else{
                recurso.setEstaPrestado(false);
                return repository.save(recurso); 
            } 
         } );
    }

    @Override
    public Flux<Recurso> findAll() {
        return this.repository.findAll();
    }
    @Override
    public Mono<Recurso> update(String id, Recurso recurso) {
        return this.repository.findById(id)
                .flatMap(recurso1 -> {
                    recurso.setId(id);
                    return save(recurso);
                })
                .switchIfEmpty(Mono.empty());
    }
}

package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.model.Recurso;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.repository.RecursoRepository;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.ConsultarDisponibilidad;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;
@Service
@Validated
public class ImplConsultarDisponible implements ConsultarDisponibilidad {
    private final RecursoRepository repositorioRecurso;

    public ImplConsultarDisponible(RecursoRepository repositorioRecurso) {
        this.repositorioRecurso = repositorioRecurso;
    }

    @Override

    public Mono<String> estaraDisponible(String id) {
        Mono<Recurso> x = repositorioRecurso.findById(id);

        try {
            return x.map(libro -> {
                var dispo = libro.isEstaPrestado() ? "El recurso NO esta disponible desde la fecha " + libro.getfechaPrestacion() : "Esta Disponible";
                return Mono.just(dispo);
            }).toFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Mono.just("null");

    }
}




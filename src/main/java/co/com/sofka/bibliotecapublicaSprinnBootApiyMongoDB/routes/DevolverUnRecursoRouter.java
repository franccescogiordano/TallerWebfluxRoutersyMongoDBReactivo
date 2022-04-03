package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.routes;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl.DevolverRecursoUseCase;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl.PrestarRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class DevolverUnRecursoRouter {
    @Bean
    public RouterFunction<ServerResponse> devolver(DevolverRecursoUseCase devolver){

        return route(PUT("/recurso/devolver/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(devolver.estaraDisponible(request.pathVariable("id")), String.class))
                        .onErrorResume(error -> ServerResponse.badRequest().build()));
    }
}

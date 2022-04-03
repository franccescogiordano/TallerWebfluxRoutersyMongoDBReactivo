package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.routes;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl.ImplConsultarDisponible;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class ConsultarDisponibilidadRecurso {
    @Bean
    public RouterFunction<ServerResponse> disponibilidadRecurso(ImplConsultarDisponible disponibilidadRecursoCasoUso){
        return route(GET("/recurso/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(disponibilidadRecursoCasoUso.estaraDisponible(request.pathVariable("id")), String.class))
                        .onErrorResume(error -> ServerResponse.badRequest().build()));
    }
}

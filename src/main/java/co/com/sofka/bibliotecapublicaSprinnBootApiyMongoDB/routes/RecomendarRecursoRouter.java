package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.routes;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl.RecomendarUnRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class RecomendarRecursoRouter {
    @Bean
    public RouterFunction<ServerResponse> recomendarRecurso(RecomendarUnRecursoUseCase recomendar){

        return route(GET("/recurso/recomendar/{tipo}/{area}")
                .and(accept(MediaType.APPLICATION_JSON)), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(recomendar
                        .apply(request.pathVariable("tipo"), request.pathVariable("area")), RecursoDTO.class)));
    }
}

package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.routes;


import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.dtos.RecursoDTO;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.useCases.Impl.UpdateRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class UpdateRecursoRouter {
    @Bean
    public RouterFunction<ServerResponse> update(UpdateRecursoUseCase updateRecurso){
        return route(PUT("/recurso/update")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request
                        .bodyToMono(RecursoDTO.class)
                        .flatMap(recursoDTO -> updateRecurso.apply(recursoDTO)
                                .flatMap(resultado -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(resultado))));
    }
}

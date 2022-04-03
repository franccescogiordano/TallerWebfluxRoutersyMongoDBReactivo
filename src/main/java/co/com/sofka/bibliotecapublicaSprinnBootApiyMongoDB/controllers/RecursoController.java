package co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.model.Recurso;
import co.com.sofka.bibliotecapublicaSprinnBootApiyMongoDB.service.RecursoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/recurso")
//@CrossOrigin(origins = "*")

public class RecursoController {
/*
    @Autowired
    RecursoService recurso_service;

   @GetMapping ("/{id}")
    public  Mono<String> is_esta_prestado(@PathVariable("id") String id){
        var taDispo = recurso_service.estaraDisponible(id);
        return taDispo;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Recurso> save(@RequestBody Recurso recurso ){
        return this.recurso_service.save(recurso);
    }

    @PutMapping("/prestar/{id}")
    public Mono<Object> prestar(@PathVariable("id") String id){
        return this.recurso_service.prestar(id);
    }

    @PutMapping("/devolver/{id}")
    public Mono<Object> devolver(@PathVariable("id") String id){
        return this.recurso_service.devolver(id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> eliminarRecurso(@PathVariable("id") String id){
       return this.recurso_service.delete(id);
    }

    @GetMapping("/recomendar/{tipo}/{area}")
    public Flux<Recurso> recomendar(@PathVariable("tipo") String tipo, @PathVariable("area") String area){
        return this.recurso_service.recomendarPorTipoyArea(tipo,area);
    }

    @GetMapping(value = "/all")
    public Flux<Recurso> findAll() {
        return this.recurso_service.findAll();
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<ResponseEntity<Recurso>> updateRecurso(@PathVariable("id") String id, @RequestBody Recurso recurso) {
        return this.recurso_service.update(id, recurso)
                .flatMap(recurso1 -> Mono.just(ResponseEntity.ok(recurso1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }
*/
}

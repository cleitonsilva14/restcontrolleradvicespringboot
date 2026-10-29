package io.dev.restcontrolleradvicespringboot.controller;

import io.dev.restcontrolleradvicespringboot.dto.CursoRequest;
import io.dev.restcontrolleradvicespringboot.model.Curso;
import io.dev.restcontrolleradvicespringboot.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        return ResponseEntity.ok(cursoService.findAll());
    }


    @PostMapping
    public ResponseEntity<List<Curso>> saveAll(@RequestBody @Valid List<CursoRequest> cursosRequest) {
        var cursos = cursosRequest.stream()
                .map(curso -> Curso.builder()
                        .nome(curso.nome())
                        .descricao(curso.descricao())
                        .categoria(curso.categoria())
                        .idioma(curso.idioma())
                        .preco(curso.preco())
                        .nivel(curso.nivel())
                        .build())
                .toList();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cursoService.saveAll(cursos));
    }




}

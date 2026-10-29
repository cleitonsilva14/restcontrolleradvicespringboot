package io.dev.restcontrolleradvicespringboot.service;

import io.dev.restcontrolleradvicespringboot.model.Curso;
import io.dev.restcontrolleradvicespringboot.repository.CursoRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    @Transactional(readOnly = true)
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public List<Curso> saveAll(List<Curso> cursos) {
        return cursoRepository.saveAll(cursos);
    }


}

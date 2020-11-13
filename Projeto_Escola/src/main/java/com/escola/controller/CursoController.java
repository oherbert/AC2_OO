package com.escola.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.escola.dto.CursoDTO;
import com.escola.model.Curso;
import com.escola.services.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService servico;


    @GetMapping
    public List<Curso> getCursos() {
        return servico.getCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable int id) {
        Curso curso = servico.getCursoById(id);     
        return ResponseEntity.ok(curso);
    }


    @PostMapping
    public ResponseEntity<Curso> salvar(@RequestBody CursoDTO cursoDTO,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder
                                           ) {
         Curso curso = servico.fromDTO(cursoDTO);
         curso = servico.save(curso);
         UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+curso.getCodigo()).build();
         return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id){
        servico.removerById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@RequestBody CursoDTO cursoDTO, @PathVariable int id){ 
        Curso curso = servico.fromDTO(cursoDTO);
        curso.setCodigo(id);
        curso = servico.update(curso);
        return ResponseEntity.ok(curso);
    }

}

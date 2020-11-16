package com.escola.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;

import com.escola.dto.CursoDTO;
import com.escola.dto.EscolaDTO;
import com.escola.model.Curso;
import com.escola.model.Escola;
import com.escola.services.CursoService;
import com.escola.services.EscolaService;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public List<Escola> getEscolas() {
        return escolaService.getAllEscolas();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo) {
        escolaService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Escola> atualizar(@RequestBody EscolaDTO escolaDTO, @PathVariable int codigo) {
        Escola escola = escolaService.fromDTO(escolaDTO);
        escola.setCodigo(codigo);
        escola = escolaService.update(escola);
        return ResponseEntity.ok(escola);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Escola> getEscolaByCodigo(@PathVariable int codigo) {
        Escola escola = escolaService.getEscolaByCodigo(codigo);
        return ResponseEntity.ok(escola);
    }

    @PostMapping()
    public ResponseEntity<Escola> salvar(@RequestBody EscolaDTO escolaDTO, HttpServletRequest request,
            UriComponentsBuilder builder
    ) {

        Escola escola = escolaService.fromDTO(escolaDTO);
        Escola novoEscola = escolaService.save(escola);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + novoEscola.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PostMapping("/{idEscola}/cursos")
    public ResponseEntity<Curso> salvar(@PathVariable int idEscola, @RequestBody Curso curso,
            HttpServletRequest request, UriComponentsBuilder builder

    ) {
        curso = cursoService.salvar(curso, idEscola);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + curso.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("/{idEscola}/cursos")
    public List<CursoDTO> getCursosEscola(@PathVariable int idEscola) {
        Escola escola = escolaService.getEscolaByCodigo(idEscola);
        return cursoService.toListDTO(escola.getCursos());
    }

}

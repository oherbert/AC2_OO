package com.escola.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.escola.dto.CursoDTO;
import com.escola.model.Curso;
import com.escola.model.Escola;
import com.escola.repository.CursoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {

    @Autowired
	private CursoRepo repository;
	
	@Autowired
    private EscolaService escolaService;

    public Curso fromDTO(CursoDTO objDTO){
		Curso curso = new Curso();
		curso.setNome(objDTO.getNome());
		curso.setDuracao(objDTO.getDuracao());
		curso.setAnoCriacao(objDTO.getAnoCriacao());
		curso.setMaxAluno(objDTO.getMaxAluno());
		curso.setEscola(objDTO.getEscola());
        return curso;
    }

	public List<Curso> getCursos() {
		return repository.getCursos();
	}

	public Curso getCursoById(int id) {
        Optional<Curso> op = repository.getCursoById(id);
        return op.orElseThrow( () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado!"));
	}

	public Curso salvar(Curso curso, int idEscola){

        Escola escola = escolaService.getEscolaByCodigo(idEscola);
        curso.setEscola(escola);
        escola.addCurso(curso);

        return repository.salvar(curso);
        
    }

	public void removerById(int id) { 
         Escola escola = escolaService.getEscolaByCodigo(id);
         escola.deleteCurso(getCursoById(id));
         repository.delete(getCursoById(id));
	}

	public Curso update(Curso curso) {
        getCursoById(curso.getCodigo()); 
		return repository.update(curso);
	}

	public CursoDTO toDTO(Curso curso){
        CursoDTO dto = new CursoDTO();

        dto.setNome(curso.getNome());
        dto.setDuracao(curso.getDuracao());
        dto.setAnoCriacao(curso.getAnoCriacao());
		dto.setMaxAluno(curso.getMaxAluno());
		        
        return dto;
    }


	public List<CursoDTO> toListDTO(List<Curso> cursos) {
		ArrayList<CursoDTO> listDTO = new ArrayList<>();

        for(Curso c: cursos){
            listDTO.add(toDTO(c));
        }
        return listDTO;
	}
    
}

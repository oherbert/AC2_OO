package com.escola.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.escola.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoRepo {

    private List <Curso> cursos = new ArrayList<>();
    private int cod = 0;

    public List<Curso> getCursos() {
        return cursos;
    }

    public Optional<Curso> getCursoById(int id) {
        for (Curso curso : cursos) {
            if (curso.getCodigo() == id) {
                return Optional.of(curso);
            }
        }
        return Optional.empty();
    }

    public Curso salvar(Curso curso) {
        curso.setCodigo(nextCod());
        cursos.add(curso);
        return curso;
    }

	public void delete(Curso curso) {
        cursos.remove(curso);
	}

	public Curso update(Curso curso) {
        
        Curso aux = getCursoById(curso.getCodigo()).get();
        if(aux != null){
            aux.setMaxAluno(curso.getMaxAluno());
        }
        return aux;
        
    }
    
    private Integer nextCod(){
        cod++;
        return cod;
    }


}
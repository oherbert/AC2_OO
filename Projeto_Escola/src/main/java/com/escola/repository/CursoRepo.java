package com.escola.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.escola.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoRepo {

    private List <Curso> cursos = new ArrayList<>();
    int cod = 0;

    @PostConstruct
    private void criarCurso(){
        cursos.add(new Curso(nextCod(),"Comunicação",40,2020,40));
        cursos.add(new Curso(nextCod(),"Prog OO",80,2020,40));
        cursos.add(new Curso(nextCod(),"Calculo",80,2020,60));
    }

    public Curso save(Curso curso) {
        curso.setCodigo(nextCod());
        cursos.add(curso);
        return curso;
    }

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
package com.escola.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.escola.model.Curso;
import com.escola.model.Escola;

import org.springframework.stereotype.Component;

@Component
public class EscolaRepo {
    
    private List<Escola> escolas = new ArrayList<>();
    private int cod = 0;

    @PostConstruct
    private void criarEscolas(){
        escolas.add(new Escola(nextCod(),"Senai","Bairro Brasil",4000L,"1962"));
        escolas.add(new Escola(nextCod(),"Fatec","Av. Getulio Vargas",8000L,"2007"));
        escolas.add(new Escola(nextCod(),"Facens","Dom Gabriel",16000L,"1971"));

    }


    public List<Escola> getAllEscolas() {
        return escolas;
    }

    public Optional<Escola> getEscolaByCodigo(int codigo) {
        for (Escola aux : escolas) {
            if (aux.getCodigo() == codigo) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Escola save(Escola escola) {
        escola.setCodigo(nextCod());
        escolas.add(escola);
        return escola;
    }

	public void remove(Escola escola) {
        if(escola.getCursos().isEmpty()) escolas.remove(escola);
	}

	public Escola update(Escola escola) {

        Escola aux = getEscolaByCodigo(escola.getCodigo()).get();

        if(aux != null){
            aux.setEndereco(escola.getEndereco());
            aux.setNome(escola.getNome());
        }

        return aux;
    }

    //Retorna os cursos por Id
    public Optional<List<Curso>> getCursosEscolaById(int codigo) {
        for (Escola aux : escolas) {
            if (aux.getCodigo() == codigo) {
                return Optional.of(aux.getCursos());
            }
        }
        return Optional.empty();
    }

    
    private Integer nextCod(){
        cod++;
        return cod;
    }


}

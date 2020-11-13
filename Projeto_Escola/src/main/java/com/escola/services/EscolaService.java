package com.escola.services;

import java.util.List;
import java.util.Optional;

import com.escola.dto.EscolaDTO;
import com.escola.model.Escola;
import com.escola.repository.EscolaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService {
    @Autowired
    private EscolaRepo repository;
    
    public Escola fromDTO(EscolaDTO dto){
        Escola escola = new Escola();
        escola.setNome(dto.getNome());
        escola.setEndereco(dto.getEndereco());
        escola.setNumeroDeAlunos(dto.getNumeroDeAlunos());
        escola.setAnoFundacao(dto.getAnoFundacao());

        return escola;
    }

	public List<Escola> getAllEscolas() {
		return repository.getAllEscolas();
	}

	public void removeByCodigo(int codigo) {
         repository.remove(getEscolaByCodigo(codigo));
	}

	public Escola update(Escola escola) {
        getEscolaByCodigo(escola.getCodigo());
        return repository.update(escola);
	}

	public Escola getEscolaByCodigo(int codigo) {
        Optional<Escola> op = repository.getEscolaByCodigo(codigo);
         return op.orElseThrow( () -> 
                   new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Escola não encontrada"
                   )
                );
	}
	public Escola save(Escola escola) {
		return repository.save(escola);
	}
}

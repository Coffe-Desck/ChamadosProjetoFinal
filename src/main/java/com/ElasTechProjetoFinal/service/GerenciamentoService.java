package com.ElasTechProjetoFinal.service;


import com.ElasTechProjetoFinal.model.EnumSetor;
import com.ElasTechProjetoFinal.model.Prioridade;
import com.ElasTechProjetoFinal.repository.PrioridadeRepository;
import com.ElasTechProjetoFinal.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class GerenciamentoService {
    @Autowired
    private SetorRepository setorRepository;


    public EnumSetor save(EnumSetor enumSetor) {
        Optional<EnumSetor> setorExistente = setorRepository.findByNome(enumSetor.getAuthority());
        if(setorExistente.isPresent()) {
            throw new RuntimeException("O Setor já foi cadastrado");
        } else {
            setorRepository.save(enumSetor);
            return enumSetor;
        }

//        Optional<Setor> setorExistente = setorRepository.findByNomeContainingIgnoreCase(setor.getNome());
//        if (setorExistente.isPresent()) {
//            throw new RuntimeException("O Setor ja foi cadastrado");
//        }else {
//            return setorRepository.save(setor);
//        }
    }

    public List<EnumSetor> findAll() {
        return Arrays.asList(EnumSetor.values());
    }

    public EnumSetor findByName(String nome) {
        Optional<EnumSetor> setor = this.setorRepository.findByNome(nome);
       return setor.orElseThrow(() -> new RuntimeException("O Setor ja foi cadastrado"));
    }

    public EnumSetor deleteByName(String nome) {
        EnumSetor setor = findByName(nome);
        this.setorRepository.delete(setor);
        return setor;
    }

    public EnumSetor updateByName(String nome, EnumSetor enumSetor) {
        findByName(nome);
        setorRepository.save(enumSetor);
        return enumSetor;
    }

    @Autowired
    private PrioridadeRepository prioridadeRepository;

    public Prioridade save(Prioridade prioridade) {

        Optional<Prioridade> prioridadeExistente = prioridadeRepository.findByNameContainingIgnoreCase(prioridade.getNome());
        if (prioridadeExistente.isPresent()) {
            throw new RuntimeException("A prioridade ja foi cadastrado");
        }else {
            return prioridadeRepository.save(prioridade);
        }
    }

    public Prioridade findByIdPrioridade(Long id) {
        Optional<Prioridade> prioridade = this.prioridadeRepository.findById(id);
        if (prioridade.isPresent()) {
            return prioridade.get();
        }else{
            throw new RuntimeException("A prioridade não foi encontado");
        }
    }

    public Prioridade deleteByIdprioridade(Long id) {
        Prioridade prioridade = findByIdPrioridade(id);
        this.prioridadeRepository.delete(prioridade);
        return prioridade;
    }

    public Prioridade updateByIdPrioridade(Long id, Prioridade prioridade) {
        this.findByIdPrioridade(id);
        prioridade.setId(id);
        Optional<Prioridade> prioridadeExistente = prioridadeRepository.findByNameContainingIgnoreCase(prioridade.getNome());
        if (prioridadeExistente.isPresent() && (prioridadeExistente.get().getId() != prioridade.getId())) {
            throw new RuntimeException("Prioridade ja foi cadastrado");
        } else {
            return prioridadeRepository.save(prioridade);
        }

    }
    public List<Prioridade> findAllPrioridade() {
        List<Prioridade> prioridades = prioridadeRepository.findAll();
        return prioridades;
    }
}

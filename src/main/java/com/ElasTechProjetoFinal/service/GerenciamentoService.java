package com.ElasTechProjetoFinal.service;


import com.ElasTechProjetoFinal.model.Prioridade;
import com.ElasTechProjetoFinal.model.Setor;
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

    @Autowired
    private PrioridadeRepository prioridadeRepository;


    public Setor save(Setor setor) {
       Optional<Setor> setorExistente = setorRepository.findByNomeContainingIgnoreCase(setor.getNome());
        if (setorExistente.isPresent()) {
            throw new RuntimeException("O Setor ja foi cadastrado");
       }else {
            return setorRepository.save(setor);
       }
   }

    public List<Setor> findAll() {
       List<Setor> setor = setorRepository.findAll();
       return setor;
    }

    public Setor findByIdSetor(Long id) {
        Optional<Setor> setor = this.setorRepository.findById(id);
        if (setor.isPresent()) {
            return setor.get();
        }else{
            throw new RuntimeException("O setor não foi encontado");
        }
    }

    public Setor updateById(Long id, Setor setor) {
        this.findByIdSetor(id);
        setor.setId(id);
        Optional<Setor> setorExistente = setorRepository.findByNomeContainingIgnoreCase(setor.getNome());
        if (setorExistente.isPresent() && (setorExistente.get().getId() != setor.getId())) {
            throw new RuntimeException("O Setor ja foi cadastrado");
        } else {
            return setorRepository.save(setor);
        }

    }

    public Setor deleteById(Long id) {
        Setor setor = findByIdSetor(id);
        this.setorRepository.delete(setor);
        return setor;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public Prioridade save(Prioridade prioridade) {

        Optional<Prioridade> prioridadeExistente = prioridadeRepository.findByNameContainingIgnoreCase(prioridade.getNome());
        if (prioridadeExistente.isPresent()) {
            throw new RuntimeException("A prioridade ja foi cadastrado");
        }else {
            return prioridadeRepository.save(prioridade);
        }
    }

    public List<Prioridade> findAllPrioridade() {
        List<Prioridade> prioridades = prioridadeRepository.findAll();
        return prioridades;
    }

    public Prioridade findByIdPrioridade(Long id) {
        Optional<Prioridade> prioridade = this.prioridadeRepository.findById(id);
        if (prioridade.isPresent()) {
            return prioridade.get();
        }else{
            throw new RuntimeException("A prioridade não foi encontado");
        }
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

    public Prioridade deleteByIdprioridade(Long id) {
        Prioridade prioridade = findByIdPrioridade(id);
        this.prioridadeRepository.delete(prioridade);
        return prioridade;
    }

}

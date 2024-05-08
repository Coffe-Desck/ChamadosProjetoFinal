package com.ElasTechProjetoFinal.service;

import com.ElasTechProjetoFinal.model.Prioridade;
import com.ElasTechProjetoFinal.model.Setor;
import com.ElasTechProjetoFinal.repository.PrioridadeRepository;
import com.ElasTechProjetoFinal.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenciamentoService {
    @Autowired
    private SetorRepository setorRepository;


    public Setor save(Setor setor) {

        Optional<Setor> setorExistente = setorRepository.findBySetorContainingIgnoreCase(setor.getSetor());
        if (setorExistente.isPresent()) {
            throw new RuntimeException("O Setor ja foi cadastrado");
        }else {
            return setorRepository.save(setor);
        }
    }

    public List<Setor> findAll() {
        List<Setor> setors = setorRepository.findAll();
        return setors;
    }

    public Setor findById(Long id) {
        Optional<Setor> setor = this.setorRepository.findById(id);
        if (setor.isPresent()) {
            return setor.get();
        }else{
            throw new RuntimeException("O setor não foi encontado");
        }
    }

    public Setor deleteById(Long id) {
        Setor setor = findById(id);
        this.setorRepository.delete(setor);
        return setor;
    }

    public Setor updateById(Long id, Setor setor) {
        this.findById(id);
        setor.setId(id);
        Optional<Setor> setorExistente = setorRepository.findBySetorContainingIgnoreCase(setor.getSetor());
        if (setorExistente.isPresent() && (setorExistente.get().getId() != setor.getId())) {
            throw new RuntimeException("O Setor ja foi cadastrado");
        } else {
            return setorRepository.save(setor);
        }

    }

    @Autowired
    private PrioridadeRepository prioridadeRepository;

    public Prioridade save(Prioridade prioridade) {

        Optional<Prioridade> prioridadeExistente = prioridadeRepository.findByPrioridadeContainingIgnoreCase(prioridade.getPrioridade());
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
        Optional<Prioridade> prioridadeExistente = prioridadeRepository.findByPrioridadeContainingIgnoreCase(prioridade.getPrioridade());
        if (prioridadeExistente.isPresent() && (prioridadeExistente.get().getId() != prioridade.getId())) {
            throw new RuntimeException("Prioridade ja foi cadastrado");
        } else {
            return prioridadeRepository.save(prioridade);
        }

    }




}

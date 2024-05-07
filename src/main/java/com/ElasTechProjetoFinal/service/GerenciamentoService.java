package com.ElasTechProjetoFinal.service;

import com.ElasTechProjetoFinal.model.Setor;
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
}

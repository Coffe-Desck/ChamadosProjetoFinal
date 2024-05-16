package com.ElasTechProjetoFinal.service;

import com.ElasTechProjetoFinal.model.Status;
import com.ElasTechProjetoFinal.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public Status save(Status status) {

        Optional<Status> setorExistente = statusRepository.findByNomeContainingIgnoreCase(status.getNome());
        if (setorExistente.isPresent()) {
            throw new RuntimeException("O Setor ja foi cadastrado");
        }else {
            return statusRepository.save(status);
        }
    }

    public List<Status> findAll() {
        List<Status> status = statusRepository.findAll();
        return status;
    }

    public Status findByIdStatus(Long id) {
        Optional<Status> status = this.statusRepository.findById(id);
        if (status.isPresent()) {
            return status.get();
        }else{
            throw new RuntimeException("O setor não foi encontado");
        }
    }

    public Status updateById(Long id,Status status) {
        this.findByIdStatus(id);
        status.setId(id);
        Optional<Status> statusExistente = statusRepository.findByNomeContainingIgnoreCase(status.getNome());
        if (statusExistente.isPresent() && (statusExistente.get().getId() != status.getId())) {
            throw new RuntimeException("O Setor ja foi cadastrado");
        } else {
            return statusRepository.save(status);
        }
    }

    public Status deleteById(Long id) {
        Status status = findByIdStatus(id);
        this.statusRepository.delete(status);
        return status;
    }
}

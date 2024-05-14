package com.ElasTechProjetoFinal.service;

import com.ElasTechProjetoFinal.model.Chamado;
import com.ElasTechProjetoFinal.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public Chamado created (Chamado chamado) {
        return this.chamadoRepository.save(chamado);
    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    public Chamado findById(UUID id) {
        Optional<Chamado> resultado = this.chamadoRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new RuntimeException(" O chamado não foi encontrado");
        } else {
            return resultado.get();
        }
    }

    public Chamado update (UUID id, Map<String, Object> params) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O chamado não foi encontrado"));

        if(params.containsKey("titulo")) {
            chamado.setTitulo((String) params.get("titulo"));
        }
        if (params.containsKey("descricao")) {
            chamado.setDescricao((String) params.get("descricao"));
        }
        if(params.containsKey("setor")) {
            chamado.setSetor((String) params.get("setor"));
        }
        if(params.containsKey("prioridade")) {
            chamado.setPrioridade((String) params.get("prioridade"));
        }

        return chamadoRepository.save(chamado);
    }

    public Chamado deleteById(UUID id) {
        Chamado chamado = findById(id);
        this.chamadoRepository.delete(chamado);
        return chamado;
    }
}

package com.example.agropescajacare.Service;

import com.example.agropescajacare.Repository.LinhaRepository;
import com.example.agropescajacare.entity.Linha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinhaService {

    @Autowired
    private LinhaRepository linhaRepository;

    public List<Linha> getAllLinhas() {
        return linhaRepository.findAll();
    }

    public Optional<Linha> getLinhaById(Long id) {
        return linhaRepository.findById(id);
    }

    public Linha saveOrUpdateLinha(Linha linha) {
        return linhaRepository.save(linha);
    }

    public boolean deleteLinhaById(Long id) {
        if (linhaRepository.existsById(id)) {
            linhaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public void deleteAllLinhas() {
        linhaRepository.deleteAll();
    }
}

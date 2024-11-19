package com.example.agropescajacare.Controller;

import com.example.agropescajacare.Service.LinhaService;
import com.example.agropescajacare.entity.Linha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/linhas")  
public class LinhaController {

    @Autowired
    private LinhaService linhaService;

    @GetMapping
    public List<Linha> getAllLinhas() {
        return linhaService.getAllLinhas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Linha> getLinhaById(@PathVariable Long id) {
        Optional<Linha> linha = linhaService.getLinhaById(id);
        return linha.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Linha> createLinha(@RequestBody Linha linha) {
        if (linha.getLineMark() == null || linha.getMmLine() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Linha savedLinha = linhaService.saveOrUpdateLinha(linha);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Linha> updateLinha(@PathVariable Long id, @RequestBody Linha linha) {
        if (!linhaService.getLinhaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        linha.setId(id);
        Linha updatedLinha = linhaService.saveOrUpdateLinha(linha);
        return ResponseEntity.ok(updatedLinha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLinha(@PathVariable Long id) {
        if (linhaService.deleteLinhaById(id)) {
            return ResponseEntity.ok("Linha deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Linha não encontrada.");
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllLinhas() {
        linhaService.deleteAllLinhas();
        return ResponseEntity.ok("Todas as linhas foram deletadas com sucesso.");
    }
}

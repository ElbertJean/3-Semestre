package com.example.agropescajacare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agropescajacare.entity.Linha;

public interface LinhaRepository extends JpaRepository<Linha, Long> {
    
}

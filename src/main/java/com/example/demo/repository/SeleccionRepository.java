package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Seleccion;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, Integer>{
	List<Seleccion> findByGrupo(String grupo);
}

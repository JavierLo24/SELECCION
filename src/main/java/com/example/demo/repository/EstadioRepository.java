package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Estadio;


@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Integer>{

}

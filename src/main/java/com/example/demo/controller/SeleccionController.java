package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Seleccion;
import com.example.demo.repository.ContinenteRepository;
import com.example.demo.repository.EstadioRepository;
import com.example.demo.repository.PartidoRepository;
import com.example.demo.repository.ResultadoRepository;
import com.example.demo.repository.SeleccionRepository;


@Controller
@RequestMapping("/seleccion")
public class SeleccionController {

	@Autowired
	EstadioRepository estadiorepository;
	
	@Autowired
	ResultadoRepository resultadorepository;
	
	@Autowired
	PartidoRepository partidorepository;
	
	@Autowired
	ContinenteRepository continenterepository;
	
	@Autowired
	SeleccionRepository seleccionrepository;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Seleccion> seleccion = seleccionrepository.findAll();
		model.addAttribute("seleccion", seleccion);
		return "index";
	}
	
	
}

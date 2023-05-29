package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Continente;
import com.example.demo.entity.Resultado;
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
	
	@GetMapping("/listar/{id}")
	public String listarById(@PathVariable("id") Integer id, Model model) {
		Seleccion seleccion = seleccionrepository.findById(id).orElse(null);
		model.addAttribute("seleccion", seleccion);
		return "index";
	}
	
	@GetMapping("/new")
    public String newSelecc(Model model) {
		Optional<Seleccion> seleccion = Optional.empty();
		//Seleccion seleccion = new Seleccion();
	    model.addAttribute("seleccion", seleccion);
	    List<Continente> continente = continenterepository.findAll();
	    model.addAttribute("continente", continente); // agregamos la lista de categorías al modelo
	    return "form";
    }

    @PostMapping("")
    public String createSelecc(@ModelAttribute("seleccion") Seleccion seleccion, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
    	seleccionrepository.save(seleccion);
        return "redirect:/seleccion/listar";
    }

    @GetMapping("/edit/{id}")
    public String editSelecc(@PathVariable("id") Integer id, Model model) {
    	Optional<Seleccion> seleccion = seleccionrepository.findById(id);
        model.addAttribute("seleccion", seleccion);
        List<Continente> continente = continenterepository.findAll();
        model.addAttribute("continente", continente);
        return "form";
    }

    @PutMapping("/{id}")
    public String updateSelecc(@PathVariable("id") Integer id, @ModelAttribute("seleccion") Seleccion seleccion, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        seleccionrepository.save(seleccion);
        return "redirect:/seleccion/listar";
    }

    @GetMapping("/delete/{id}")
    public String deleteSelecc(@PathVariable("id") Integer id) {
    	// Obtener la selección a eliminar
      /*  Seleccion seleccion = seleccionrepository.findById(id).orElse(null);

        if (seleccion != null) {
            // Obtener los resultados asociados a la selección
            List<Resultado> resultados = resultadorepository.findBySeleccion(seleccion);

            // Eliminar los resultados asociados
            resultadorepository.deleteAll(resultados);

            // Eliminar la selección*/
            seleccionrepository.deleteById(id);
        //}

        return "redirect:/seleccion/listar";
    }
    
    @PostMapping("/grupo")
    public String listarSeleccionesPorGrupo(@ModelAttribute("grupo") String grupo, Model model) {
        List<Seleccion> seleccion = seleccionrepository.findByGrupo(grupo);
        model.addAttribute("seleccion", seleccion);
        return "index";
    }
	
	
}

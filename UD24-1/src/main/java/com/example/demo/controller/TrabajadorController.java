package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Trabajador;
import com.example.demo.service.TrabajadorServiceImpl;

@RestController
@RequestMapping("/api")
public class TrabajadorController {
	
	@Autowired
	TrabajadorServiceImpl TrabajadorServideImpl;
	
	@GetMapping("/trabajador")
	public List<Trabajador> listarTrabajadores(){
		return TrabajadorServideImpl.listarTrabajadores();
	}
	
	//listar Trabajadors por campo nombre
	@GetMapping("/trabajador/nombre/{nombre}")
	public List<Trabajador> listarTrabajadorNombre(@PathVariable(name="nombre") String nombre) {
	    return TrabajadorServideImpl.listarTrabajadorNomnbre(nombre);
	}
	
	
	@PostMapping("/trabajador")
	public Trabajador salvarTrabajador(@RequestBody Trabajador trabajador) {
		
		return TrabajadorServideImpl.guardarTrabajador(trabajador);
	}
	
	
	@GetMapping("/trabajador/{id}")
	public Trabajador trabajadorXID(@PathVariable(name="id") long id) {
		
		Trabajador trabajador_xid= new Trabajador();
		
		trabajador_xid=TrabajadorServideImpl.trabajadorXID(id);
		
		System.out.println("Trabajador XID: "+trabajador_xid);
		
		return trabajador_xid;
	}
	
	@PutMapping("/trabajador/{id}")
	public Trabajador actualizarTrabajador(@PathVariable(name="id")long id,@RequestBody Trabajador trabajador) {
		
		Trabajador Trabajador_seleccionado= new Trabajador();
		Trabajador Trabajador_actualizado= new Trabajador();
		
		Trabajador_seleccionado= TrabajadorServideImpl.trabajadorXID(id);
		
		Trabajador_seleccionado.setNombre(trabajador.getNombre());
		Trabajador_seleccionado.setTrabajo(trabajador.getTrabajo());		
		
		
		Trabajador_actualizado = TrabajadorServideImpl.actualizarTrabajador(Trabajador_seleccionado);
		
		System.out.println("El Trabajador actualizado es: "+ Trabajador_actualizado);
		
		return Trabajador_actualizado;
	}
	
	@DeleteMapping("/trabajador/{id}")
	public void eleiminarTrabajador(@PathVariable(name="id")long id) {
		TrabajadorServideImpl.eliminarTrabajador(id);
	}
	
	

}

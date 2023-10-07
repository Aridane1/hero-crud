package com.actividad.superhero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.actividad.superhero.entity.models.SuperHero;
import com.actividad.superhero.entity.services.SuperHeroServicelmpl;

@RestController
@CrossOrigin(origins = "*")
public class SuperHeroController {

	@Autowired
	SuperHeroServicelmpl superHeroService;
	
	@GetMapping("/heros")
	public List<SuperHero> getAllSuperHero(){
		return superHeroService.getAll();
	}
	
	@GetMapping("/heros/{id}")
	public SuperHero getOne(@PathVariable(value = "id") long id) {
		return superHeroService.get(id);
	}
	
	@PostMapping("/heros")
	public void post(@RequestBody SuperHero superHero) {
		superHeroService.post(superHero);
	}
	
	@PutMapping("/heros/{id}")
	public void  put(@RequestBody SuperHero superHero, @PathVariable(value = "id") long id) {
		
		superHeroService.put(superHero, id);
		
	}
	
	@DeleteMapping("/heros/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		superHeroService.delete(id);
	}
	
	@DeleteMapping("/heros")
	public void deleteAll() {
		superHeroService.deleteAll();
	}

}

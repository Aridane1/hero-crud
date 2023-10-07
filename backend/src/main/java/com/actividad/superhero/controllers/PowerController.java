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

import com.actividad.superhero.entity.models.Power;
import com.actividad.superhero.entity.services.PowerServicelmpl;

@RestController
@CrossOrigin(origins = "*")
public class PowerController {
	
	@Autowired
	PowerServicelmpl powerService;
	
	@GetMapping("/powers")
	public List<Power> getAllPowerHero(){
		return powerService.getAll();
	}
	
	@GetMapping("/powers/{id}")
	public Power getOne(@PathVariable(value = "id") long id){
		return powerService.get(id);
	}
	
	@PostMapping("/powers")
	public void post(@RequestBody Power power) {
		powerService.post(power);
	}
	
	@PutMapping("/powers/{id}")
	public void put(@RequestBody Power power, @PathVariable(value = "id") long id) {
		powerService.put(power, id);
	}

	@DeleteMapping("/powers/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		powerService.delete(id);
	}
	
	@DeleteMapping("/powers")
	public void deleteAll() {
		powerService.deleteAll();
	}
}

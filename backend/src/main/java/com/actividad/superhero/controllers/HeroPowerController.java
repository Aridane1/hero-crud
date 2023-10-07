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

import com.actividad.superhero.entity.models.HeroPower;
import com.actividad.superhero.entity.models.SuperHeroKey;
import com.actividad.superhero.entity.services.HeroPowerImpl;


@RestController
@CrossOrigin(origins = "*")
public class HeroPowerController {
	
	@Autowired
	HeroPowerImpl heroPowerService;

	
	@GetMapping("/heros_powers")
	public List<HeroPower> getAllSuperHero(){
		return heroPowerService.getAll();
	}
	
	@GetMapping("/heros_powers/{id_hero}/{id_power}")
	public HeroPower get(@PathVariable("id_hero") Long idHero, @PathVariable("id_power") Long idPower) {
	    SuperHeroKey id = new SuperHeroKey(idHero, idPower);
	    return heroPowerService.get(id);
	}
	

	 @PostMapping("/heros_powers/data_names")
	 public void createTienen2(@RequestBody HeroPower tienen) {
		String nameHero = tienen.getNameHero();
		String namePower = tienen.getNamePower();
		long powerLevel = tienen.getPowerLevel();
		System.out.println("Hola"+nameHero);
		heroPowerService.post(tienen,nameHero,namePower,powerLevel);
		
    }
	
	@PutMapping("/heros_powers/update_data_names")
	public void put(@RequestBody HeroPower tienen) {
		heroPowerService.put(tienen);
	}
	
	@DeleteMapping("/heros_powers/{id_hero}/{id_power}")
	public void delete(@PathVariable("id_hero") Long idHero, @PathVariable("id_power") Long idPower) {
		System.out.println(idHero+" "+idPower);
		SuperHeroKey id = new SuperHeroKey(idHero,idPower);
		heroPowerService.delete(id);
	}

}

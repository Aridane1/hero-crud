package com.actividad.superhero.entity.services;

import java.util.List;

import com.actividad.superhero.entity.models.SuperHero;

public interface ISuperHeroService {
	public SuperHero get(long id);
	public List<SuperHero> getAll();
	public void post(SuperHero superHero);
	public void put(SuperHero superHero, long id);
	public void delete(long id);
	public void deleteAll();
}

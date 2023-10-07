package com.actividad.superhero.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.actividad.superhero.entity.models.SuperHero;

public interface ISuperHeroDao extends CrudRepository<SuperHero, Long> {
	public SuperHero findSuperHeroByName(String name);
}

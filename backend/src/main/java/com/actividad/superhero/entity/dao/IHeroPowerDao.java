package com.actividad.superhero.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.actividad.superhero.entity.models.SuperHeroKey;
import com.actividad.superhero.entity.models.HeroPower;

public interface IHeroPowerDao extends CrudRepository<HeroPower, SuperHeroKey> {

}

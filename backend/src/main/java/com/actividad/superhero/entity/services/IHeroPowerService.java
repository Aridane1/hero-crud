package com.actividad.superhero.entity.services;

import java.util.List;

import com.actividad.superhero.entity.models.SuperHeroKey;
import com.actividad.superhero.entity.models.HeroPower;

public interface IHeroPowerService {
	public HeroPower get(SuperHeroKey id);
	public List<HeroPower> getAll();
	public void post(HeroPower tienen,String nameHero,String namePower,long powerLevel);
	public void put(HeroPower tienen);
	public void delete(SuperHeroKey id);
}

package com.actividad.superhero.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad.superhero.entity.dao.ISuperHeroDao;
import com.actividad.superhero.entity.models.SuperHero;

@Service
public class SuperHeroServicelmpl implements ISuperHeroService {
	
	@Autowired
	private ISuperHeroDao superHeroDao;

	@Override
	public SuperHero get(long id) {
		// TODO Auto-generated method stub
		
		return superHeroDao.findById(id).get();
	}

	@Override
	public List<SuperHero> getAll() {
		// TODO Auto-generated method stub
		return (List<SuperHero>) superHeroDao.findAll();
	}

	@Override
	public void post(SuperHero superHero) {
		// TODO Auto-generated method stub
		SuperHero foundHero = superHeroDao.findSuperHeroByName(superHero.getName());
		
		if(foundHero == null && superHero.getName()!="") {
			superHeroDao.save(superHero);
		}
	}

	@Override
	public void put(SuperHero superHero, long id) {
		// TODO Auto-generated method stub
		superHeroDao.findById(id).ifPresent((x) -> {
			superHero.setId(id);
			superHeroDao.save(superHero);
		});
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		superHeroDao.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		superHeroDao.deleteAll();
	}

}

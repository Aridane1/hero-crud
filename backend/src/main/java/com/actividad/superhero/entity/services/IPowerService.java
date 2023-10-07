package com.actividad.superhero.entity.services;

import java.util.List;

import com.actividad.superhero.entity.models.Power;

public interface IPowerService {
	public Power get(long id);
	public List<Power> getAll();
	public void post(Power power);
	public void put(Power power, long id);
	public void delete(long id);
	public void deleteAll();
}

package com.actividad.superhero.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad.superhero.entity.dao.IPowerDao;
import com.actividad.superhero.entity.models.Power;

@Service
public class PowerServicelmpl implements IPowerService{
	@Autowired
	private IPowerDao powerDao;

	@Override
	public Power get(long id) {
		// TODO Auto-generated method stub
		return powerDao.findById(id).get();
	}

	@Override
	public List<Power> getAll() {
		// TODO Auto-generated method stub
		return (List<Power>) powerDao.findAll();
	}

	@Override
	public void post(Power power) {
		// TODO Auto-generated method stub
		Power foundPower = powerDao.findPowerByName(power.getName());

		if(foundPower == null && power.getName() != "") {
			System.out.println(power.getName());
			powerDao.save(power);
		}
		


	}

	@Override
	public void put(Power power, long id) {
		// TODO Auto-generated method stub
		powerDao.findById(id).ifPresent((x)->{
			power.setId(id);
			powerDao.save(power);
		});
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		powerDao.deleteById(id);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		powerDao.deleteAll();
	}

	

}

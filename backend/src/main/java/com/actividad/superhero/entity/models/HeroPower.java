package com.actividad.superhero.entity.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "heros_powers")
public class HeroPower  {
	
	@EmbeddedId
	SuperHeroKey id;
	
	@ManyToOne
	@MapsId("idHero")
	@JoinColumn(name = "id_hero")
	SuperHero heros ;
	
	@ManyToOne
	@MapsId("idPower")
	@JoinColumn(name = "id_power")
	Power powers ;
	
	@JsonProperty("name_hero")
	@Transient
    String nameHero;
	
	@JsonProperty("name_power")
	@Transient
	String namePower;
	
	@JsonProperty("power_level")
	long powerLevel;

	public SuperHeroKey getId() {
		return id;
	}

	public void setId(SuperHeroKey id) {
		this.id = id;
	}

	public SuperHero getHeroes() {
		return heros;
	}

	public void setHeroes(SuperHero heros) {
		this.heros = heros;
	}
	
	public Power getPowers() {
		return powers;
	}

	public void setPowers(Power powers) {
		this.powers = powers;
	}
	
	public String getNameHero() {
		return nameHero;
	}

	public void setNameHero(String nameHero) {
		this.nameHero = nameHero;
	}

	public String getNamePower() {
		return namePower;
	}

	public void setNamePower(String namePower) {
		this.namePower = namePower;
	}

	public long getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(long powerLevel) {
		this.powerLevel = powerLevel;
	}
	
	public HeroPower(SuperHeroKey id, SuperHero heroes, Power powers, long powerLevel) {
		super();
		this.id = id;
		this.heros = heroes;
		this.powers = powers;
		this.powerLevel = powerLevel;
	}

	public HeroPower() {
	}

	
}

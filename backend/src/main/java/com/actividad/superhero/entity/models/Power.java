package com.actividad.superhero.entity.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="powers")
public class Power implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
		
    @Column(name = "name", length = 45)
    private String name;
    
    @OneToMany(mappedBy = "powers")
    Set<HeroPower> have = new HashSet<HeroPower>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Power(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Power() {
	}

}
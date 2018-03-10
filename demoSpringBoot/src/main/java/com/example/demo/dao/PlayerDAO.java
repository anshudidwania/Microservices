package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.domain.Players;

@RestResource(path="players",rel="players")
public interface PlayerDAO extends CrudRepository<Players, Long>{

	
	List<Players> findAll();
	Players findByName(String name);
}

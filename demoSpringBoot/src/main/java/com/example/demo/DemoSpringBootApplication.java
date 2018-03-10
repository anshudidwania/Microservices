package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.example.demo.dao.TeamDAO;
import com.example.demo.domain.Players;
import com.example.demo.domain.Team;

@SpringBootApplication
public class DemoSpringBootApplication extends SpringBootServletInitializer{

	/**
	 * Used when runing as a jar
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
	}
	
	/**
	 * Used when runing as a war
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoSpringBootApplication.class);
	}
	
	@Autowired
	TeamDAO teamDAO;
	
	@PostConstruct
	public void init(){
		Set<Players> p = new HashSet<>();
		p.add(new Players("ansh", "pitch")); 
		p.add(new Players("anky", "boal")); 
		Team team = new Team("cric","india",p);
		teamDAO.save(team);
	}
	
	
}

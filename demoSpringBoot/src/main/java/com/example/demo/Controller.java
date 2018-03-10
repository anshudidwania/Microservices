package com.example.demo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TeamDAO;
import com.example.demo.domain.Players;
import com.example.demo.domain.Team;

@org.springframework.stereotype.Controller
//@RestController
public class Controller {
	
	private Team team;
	
	@Autowired
	TeamDAO teamDAO;

	@RequestMapping("/sayHix")
	public @ResponseBody String sayHi(){
		return "hello world!";
	}
	
	@RequestMapping("/sayHi/{name}")
	public String sayThyme(Map model, @PathVariable String name){
		model.put("name", name);
		return "hello";
	}
	
//	@PostConstruct
//	public void init(){
//		Set<Players> p = new HashSet<>();
//		p.add(new Players("ansh", "pitch")); 
//		p.add(new Players("anky", "boal")); 
//		team = new Team("cric","india",p);
//	}
	
	@RequestMapping("/domain")
	public @ResponseBody Team domain(){
		return team;
	}
	
	@RequestMapping("/team/{name}")
	public @ResponseBody Team getTeam(@PathVariable String name){
		return teamDAO.findByName(name);
	}
	
//	@RequestMapping("/domain")
//	public Team domain(){
//		return team;
//	}
}

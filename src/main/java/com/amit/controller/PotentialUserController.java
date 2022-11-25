package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amit.exception.UserAlreadyExistException;
import com.amit.model.PotentialUser;
import com.amit.service.PotentialUserService;

@RestController
@RequestMapping("/potentialusers")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class PotentialUserController {
	
	@Autowired
	PotentialUserService potentialUserService;
	
	@PostMapping("/add")
	public PotentialUser addPotentialUser(@RequestBody PotentialUser potentialUser) throws UserAlreadyExistException {
		potentialUserService.registerPotentialUser(potentialUser);
		return potentialUser;
	}
	
	@GetMapping("/get")
	public String getAllPotentialUser(){
		potentialUserService.getAllPotentialUser();
		return "got all potential users";
	}
}

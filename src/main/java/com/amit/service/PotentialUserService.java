package com.amit.service;

import java.util.List;

import com.amit.exception.UserAlreadyExistException;
import com.amit.exception.UserNotFoundException;
import com.amit.model.PotentialUser;
import com.amit.model.Users;


public interface PotentialUserService {

	public PotentialUser registerPotentialUser(PotentialUser potentialUser) throws UserAlreadyExistException; //post request - save a user record
	public PotentialUser findPotentialUserbyemail(String email) throws UserNotFoundException; // get request - retrieve a record
	public List<PotentialUser> getAllPotentialUser(); 
	public Users deleteAllPotentialUser(String email) throws UserNotFoundException ; //delete request
	public Users updateAllPotentialUser(Users Users) throws UserNotFoundException ; // PUT - PATCH request
	
}

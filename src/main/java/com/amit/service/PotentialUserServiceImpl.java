package com.amit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.exception.UserAlreadyExistException;
import com.amit.exception.UserNotFoundException;
import com.amit.model.PotentialUser;
import com.amit.model.Users;
import com.amit.repository.PotentialUserRepository;

@Service
public class PotentialUserServiceImpl implements PotentialUserService {
	
	@Autowired
	private PotentialUserRepository PRepo;
	
	@Override
	public PotentialUser registerPotentialUser(PotentialUser potentialUser) throws UserAlreadyExistException {
		System.out.println(potentialUser);
		return PRepo.save(potentialUser);	
	}

	@Override
	public PotentialUser findPotentialUserbyemail(String email) throws UserNotFoundException {
		PotentialUser PUserFound = null;
		PUserFound = PRepo.findById(email).get();
		return PUserFound;
		
	}

	@Override
	public List<PotentialUser> getAllPotentialUser() {
		return PRepo.findAll();
	}
	

	@Override
	public Users deleteAllPotentialUser(String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateAllPotentialUser(Users Users) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	
}

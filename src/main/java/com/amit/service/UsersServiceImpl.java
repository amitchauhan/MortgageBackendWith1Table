package com.amit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.exception.UserAlreadyExistException;
import com.amit.exception.UserNotFoundException;
import com.amit.model.Users;
import com.amit.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository URepo;
	
	@Override
	public Users registerUser(Users Users) throws UserAlreadyExistException {
		return URepo.save(Users);
	}

	@Override
	public Users findUserbyemail(String email) throws UserNotFoundException {
		Users UserFound = null;
		UserFound = URepo.findById(email).get();
		return UserFound;
	}

	@Override
	public List<Users> getAllUser() {
		return URepo.findAll();
	}

	@Override
	public Users deleteAUser(String email) throws UserNotFoundException {
		Users Userdeleted = null;
		Optional optional = URepo.findById(email);
		if (optional.isPresent()) {
			Userdeleted = URepo.findById(email).get();
			URepo.deleteById(email);
		}
		return Userdeleted;
	}

	@Override
	public Users updateAUser(Users Users) throws UserNotFoundException {
		Users UserUpdate = null;
		Optional optional = URepo.findById(Users.getEmail());
		if (optional.isPresent()) {
			Users getuser = URepo.findById(Users.getEmail()).get();
			getuser.setNewPassword(Users.getPassword());
			UserUpdate = URepo.save(getuser);
		}

		return UserUpdate;
	}

}

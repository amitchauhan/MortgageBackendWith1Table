package com.amit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.model.Users;



@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}

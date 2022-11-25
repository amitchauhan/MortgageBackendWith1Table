package com.amit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.model.PotentialUser;

@Repository
public interface PotentialUserRepository extends JpaRepository<PotentialUser, String> {

}

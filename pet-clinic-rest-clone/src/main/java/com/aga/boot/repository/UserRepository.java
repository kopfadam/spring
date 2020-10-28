package com.aga.boot.repository;

import com.aga.boot.model.Owner;
import com.aga.boot.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

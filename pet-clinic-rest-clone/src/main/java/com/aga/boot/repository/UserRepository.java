package com.aga.boot.repository;

import com.aga.boot.model.User;
import org.springframework.dao.DataAccessException;

public interface UserRepository {

    void save(User user) throws DataAccessException;
}

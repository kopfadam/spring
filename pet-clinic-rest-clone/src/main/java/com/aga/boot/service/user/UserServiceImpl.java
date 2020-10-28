package com.aga.boot.service.user;

import com.aga.boot.model.Role;
import com.aga.boot.model.User;
import com.aga.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) throws Exception {
        if (user.getRoles() == null || user.getRoles().isEmpty()){
            throw new Exception("User must have at least a role set");
        }

        for(Role role : user.getRoles()){
            if(!role.getName().startsWith("ROLE_"))
                role.setName("ROLE_" + role.getName());

            if (role.getUser() == null)
                role.setUser(user);
        }

        userRepository.save(user);
    }
}

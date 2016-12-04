package com.iot.services.account;

import com.iot.domain.account.User;
import com.iot.repositories.account.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lyerox on 16-11-2.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username){
        return userRepository.findByName(username);
    }
}

package com.iot.services.account;

import com.iot.domain.account.User;

/**
 * Created by lyerox on 16-11-2.
 */
public interface UserService {

    public User findByUsername(String username);
}

package com.pan.service;

import com.pan.pojo.User;

public interface UserService {
    User findByUsername(String username);
    void register(String username, String password);

    void updateUserInfo(User user);

    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}

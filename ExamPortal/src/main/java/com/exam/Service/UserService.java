package com.exam.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRole) throws Exception;
    public User getUser(String username);
    public void deleteUser(Long userId);
//    public void updateUser(Long userId);
}

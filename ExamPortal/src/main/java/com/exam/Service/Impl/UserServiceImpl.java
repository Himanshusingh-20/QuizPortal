package com.exam.Service.Impl;

import com.exam.Repo.RoleRepository;
import com.exam.Repo.UserRepository;
import com.exam.Service.UserService;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.helper.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User is Already here");
            throw new UserFoundException();
        }else{
            for(UserRole ur:userRole){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRole);
            local = this.userRepository.save(user);

        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

//    @Override
//    public void updateUser(Long userId) {
//        this.userRepository.updateById(userId);
//    }
}

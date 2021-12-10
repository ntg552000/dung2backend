package com.dung2_backend.servive.implement;

import com.dung2_backend.entity.User;
import com.dung2_backend.repository.UserRepository;
import com.dung2_backend.servive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) throws Exception{
        return userRepository.save(user);
    }

    @Override
    public User get(Integer id) throws Exception {
        return userRepository.getById(id);
    }

    @Override
    public void delete(Integer id) throws Exception {
        userRepository.deleteById(id);
    }

    @Override
    public boolean login() throws Exception {
        return true;
    }
}

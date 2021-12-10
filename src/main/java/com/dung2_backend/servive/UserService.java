package com.dung2_backend.servive;

import com.dung2_backend.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User create(User user) throws Exception;
    User get(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
    boolean login() throws Exception;
}
